package cool.tdl.seckill.service;

import cool.tdl.seckill.entity.SeckillOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import cool.tdl.seckill.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tdl
 * @since 2022-01-08
 */
public interface SeckillOrderService extends IService<SeckillOrder> {

    Long getResult(User user, Long goodsId);
}
