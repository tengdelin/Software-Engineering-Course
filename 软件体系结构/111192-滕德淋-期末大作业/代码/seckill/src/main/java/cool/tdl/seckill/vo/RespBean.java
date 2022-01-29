package cool.tdl.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 *
 * @author tdl
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    private long code;
    private String message;
    private Object obj;

    /**
     * 功能描述: 成功返回结果
     *
     * @param:
     * @return:
     * @since: 1.0.0
     * @Author: tdl
     */
    public static RespBean success() {
        return new RespBean(cool.tdl.seckill.vo.RespBeanEnum.SUCCESS.getCode(), cool.tdl.seckill.vo.RespBeanEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 功能描述: 成功返回结果
     *
     * @param:
     * @return:
     * @since: 1.0.0
     * @Author: tdl
     */
    public static RespBean success(Object obj) {
        return new RespBean(cool.tdl.seckill.vo.RespBeanEnum.SUCCESS.getCode(), RespBean.success().getMessage(), obj);
    }


    /**
     * 功能描述: 失败返回结果
     *
     * @param:
     * @return:
     * @since: 1.0.0
     * @Author: tdl
     */
    public static RespBean error(cool.tdl.seckill.vo.RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }


    /**
     * 功能描述: 失败返回结果
     *
     * @param:
     * @return:
     * @since: 1.0.0
     * @Author: tdl
     */
    public static RespBean error(cool.tdl.seckill.vo.RespBeanEnum respBeanEnum, Object obj) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), obj);
    }

}