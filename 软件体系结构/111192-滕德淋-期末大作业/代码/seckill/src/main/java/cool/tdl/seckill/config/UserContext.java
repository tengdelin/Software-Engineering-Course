package cool.tdl.seckill.config;

import cool.tdl.seckill.entity.User;

/**
 * @Author tdl
 * @Date 2022/1/8 16:12
 * @description 线程参数绑定
 * @Version 1.0
 */
public class UserContext {

    private static ThreadLocal<User> userHolder = new ThreadLocal<User>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }
}
