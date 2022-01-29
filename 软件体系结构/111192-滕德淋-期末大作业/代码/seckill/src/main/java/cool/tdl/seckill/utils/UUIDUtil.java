package cool.tdl.seckill.utils;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author tdl
 * @since 1.0.0
 */
public class UUIDUtil {

   public static String uuid() {
      return UUID.randomUUID().toString().replace("-", "");
   }

}