package cool.tdl.seckill.config;

import cool.tdl.seckill.entity.User;
import cool.tdl.seckill.service.UserService;
import cool.tdl.seckill.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author tdl
 * @Date 2022/1/8 16:12
 * @description 用户自定义参数
 * @Version 1.0
 */
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == User.class;
    }

    //    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
//                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
//        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
//
//        String ticket = CookieUtil.getCookieValue(request, "userTicket");
//        if (StringUtils.isEmpty(ticket)) {
//            return null;
//        }
//
//        return userService.getUserByCookie(ticket, request, response);
//    }
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return UserContext.getUser();
    }
}
