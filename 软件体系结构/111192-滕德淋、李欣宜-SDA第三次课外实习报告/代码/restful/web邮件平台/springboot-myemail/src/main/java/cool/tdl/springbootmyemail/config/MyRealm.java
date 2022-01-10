package cool.tdl.springbootmyemail.config;

import cool.tdl.springbootmyemail.pojo.User;
import cool.tdl.springbootmyemail.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal(); //想要获得当前的登录对象，需要在认证中传入当前对象
        //return new SimpleAuthenticationInfo(student,student.getPassword(),"");
        //设置权限
        if (user.getPerm().equals("vip")){
            info.addStringPermission("guest");
        }
        info.addStringPermission(user.getPerm()); //想要从数据中拿取真实数据，直接注入对应的service
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("认证");
        //转为UsernamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryStuByname(token.getUsername());
        //验证账号
        if (!token.getUsername().equals(user.getUsername())) {
            return null;  // 相当于抛出UnknownAccountException
        }
        //密码shiro自行验证
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
