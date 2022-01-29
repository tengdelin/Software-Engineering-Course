package cool.tdl.seckill.utils;


import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author tdl
 * @Date 2022/1/6 22:26
 * @description 手机号码验证
 * @Version 1.0
 */
public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("[1]([3-9])[0-9]{9}$");

    public static boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();
    }

}
