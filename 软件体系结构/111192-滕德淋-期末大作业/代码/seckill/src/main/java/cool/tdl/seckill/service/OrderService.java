package cool.tdl.seckill.service;

import cool.tdl.seckill.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import cool.tdl.seckill.entity.User;
import cool.tdl.seckill.vo.GoodsVo;
import cool.tdl.seckill.vo.OrderDetailVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author tdl
 * @since 2022-01-08
 */
@Service
public interface OrderService extends IService<Order> {

    Order seckill(User user, GoodsVo goods);

    OrderDetailVo detail(Long orderId);

    String createPath(User user, Long goodsId);

    boolean checkPath(User user, Long goodsId, String path);

    boolean checkCaptcha(User user, Long goodsId, String captcha);
}
