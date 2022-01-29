package cool.tdl.seckill.service.Impl;

import cool.tdl.seckill.entity.User;
import cool.tdl.seckill.exception.GlobalException;
import cool.tdl.seckill.mapper.UserMapper;
import cool.tdl.seckill.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.tdl.seckill.utils.CookieUtil;
import cool.tdl.seckill.utils.MD5Utils;
import cool.tdl.seckill.utils.UUIDUtil;
import cool.tdl.seckill.vo.LoginVo;
import cool.tdl.seckill.vo.RespBean;
import cool.tdl.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author tdl
 * @since 2022-01-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登录验证
     *
     * @param loginVo
     * @param request
     * @param response
     * @return
     */
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        // //参数校验
        // if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
        // 	return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        // }
        // if (!ValidatorUtil.isMobile(mobile)){
        // 	return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        // }
        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if (null == user) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //判断密码是否正确
        if (!MD5Utils.formPassToDBPass(password, user.getSalt()).equals(user.getPassword())) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //生成cookie
        String ticket = UUIDUtil.uuid();
        //将用户信息存入redis中
        redisTemplate.opsForValue().set("user:" + ticket, user);
//        request.getSession().setAttribute(ticket, user);
        CookieUtil.setCookie(request, response, "userTicket", ticket);
        user.setLoginCount(user.getLoginCount() + 1);
        user.setLastLoginDate(new Date());
        userMapper.updateById(user);
        return RespBean.success(ticket);
    }


    /**
     * 从redis中获取用户信息
     *
     * @param userTicket
     * @param request
     * @param response
     * @return
     */
    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)) {
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        if (user != null) {
            CookieUtil.setCookie(request, response, "userTicket", userTicket);
        }
        return user;
    }


    /**
     * 更新密码
     *
     * @param userTicket
     * @param password
     * @param request
     * @param response
     * @return
     */
    @Override
    public RespBean updatePassword(String userTicket, String password, HttpServletRequest request,
                                   HttpServletResponse response) {
        User user = getUserByCookie(userTicket, request, response);
        if (user == null) {
            throw new GlobalException(RespBeanEnum.MOBILE_NOT_EXIST);
        }
        user.setPassword(MD5Utils.inputPassToDBPass(password, user.getSalt()));
        int result = userMapper.updateById(user);
        if (1 == result) {
            //删除Redis
            redisTemplate.delete("user:" + userTicket);
            return RespBean.success();
        }
        return RespBean.error(RespBeanEnum.PASSWORD_UPDATE_FAIL);
    }

}
