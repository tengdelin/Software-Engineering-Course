package cool.tdl.seckill.controller;

import cool.tdl.seckill.service.UserService;
import cool.tdl.seckill.vo.LoginVo;
import cool.tdl.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Author tdl
 * @Date 2022/1/6 21:03
 * @description 登录
 * @Version 1.0
 */

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到登录页
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 处理登录请求
     *
     * @param loginVo
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        return userService.doLogin(loginVo, request, response);
    }

}
