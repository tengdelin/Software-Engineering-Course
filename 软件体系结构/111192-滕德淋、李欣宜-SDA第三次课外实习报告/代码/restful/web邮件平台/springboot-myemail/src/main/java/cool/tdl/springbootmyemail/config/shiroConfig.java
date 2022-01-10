package cool.tdl.springbootmyemail.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class shiroConfig {
    //    ShiroFilterFactoryBean(用户)
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(manager);

        /*
        anon:无需认证就能访问
        authc: 必须认证才能访问
        user: 必须拥有记住我功能 才能用
        perms： 必须拥有某个资源权限才能访问
        role：必须拥有某个角色权限才能访问
        logout: 注销
        */
        Map<String, String> filterMap = new LinkedHashMap<>();
        //注销用户
        filterMap.put("/logOut", "logout");
        //登录认证
        filterMap.put("/user/toguestPage", "perms[guest]");
        filterMap.put("/user/tovipPage", "perms[vip]");
        filterMap.put("/user/*", "authc");

        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/permissions");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //设置登录请求
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        return shiroFilterFactoryBean;
    }

    //    DefaultWebSecurityManager(安全管理)
    @Bean("manager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getRealm") cool.tdl.springbootmyemail.config.MyRealm realm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    //    在config中，将自定义的Myrealm添加到ioc容器中
    @Bean(name = "getRealm")
    public cool.tdl.springbootmyemail.config.MyRealm getRealm() {
        return new cool.tdl.springbootmyemail.config.MyRealm();
    }

    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
