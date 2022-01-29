package cool.tdl.seckill.controller;


import cool.tdl.seckill.entity.User;
import cool.tdl.seckill.service.OrderService;
import cool.tdl.seckill.vo.OrderDetailVo;
import cool.tdl.seckill.vo.RespBean;
import cool.tdl.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tdl
 * @since 2022-01-08
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 订单静态化
     * @param user
     * @param orderId
     * @return
     */
    @RequestMapping("/detail")
    @ResponseBody
    public RespBean detail(User user, Long orderId) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        OrderDetailVo detail = orderService.detail(orderId);
        return RespBean.success(detail);
    }
}

