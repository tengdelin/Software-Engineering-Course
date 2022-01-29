package cool.tdl.seckill.service;

import cool.tdl.seckill.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import cool.tdl.seckill.vo.LoginVo;
import cool.tdl.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author tdl
 * @since 2022-01-05
 */
public interface UserService extends IService<User> {
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);

    RespBean updatePassword(String userTicket, String password, HttpServletRequest request,
                            HttpServletResponse response);
}
