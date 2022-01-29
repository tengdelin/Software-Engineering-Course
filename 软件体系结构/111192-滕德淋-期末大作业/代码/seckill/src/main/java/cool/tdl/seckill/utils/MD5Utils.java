package cool.tdl.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author tdl
 * @Date 2022/1/5 23:05
 * @description 二次md5加密工具类
 * @Version 1.0
 */
public class MD5Utils {
    //md5加密
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    //盐,第一次加密使用，第二次加密使用的盐是自己输入的，同时也需要存入数据库
    private static final String salt = "1a2b3c4d";


    /**
     * 第一次加密，从前端密码加密成后端密码
     *
     * @param inputPass
     * @return
     */
    public static String inputPassToFromPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * 第二次加密，从后端代码加密成数据库密码
     *
     * @param fromPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String fromPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + fromPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * 从前端密码到数据库密码，一般直接调用这个方法
     *
     * @param inputPass
     * @param salt
     * @return
     */
    public static String inputPassToDBPass(String inputPass, String salt) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass, salt);
        return dbPass;
    }


    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("123456"));
        System.out.println(formPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456", "1a2b3c4d"));
    }


}
