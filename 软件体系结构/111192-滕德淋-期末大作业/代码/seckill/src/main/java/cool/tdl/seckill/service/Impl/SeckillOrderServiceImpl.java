package cool.tdl.seckill.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cool.tdl.seckill.entity.SeckillOrder;
import cool.tdl.seckill.entity.User;
import cool.tdl.seckill.mapper.SeckillOrderMapper;
import cool.tdl.seckill.service.SeckillOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tdl
 * @since 2022-01-08
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements SeckillOrderService {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取秒杀结果
     *
     * @param user
     * @param goodsId
     * @return
     */
    @Override
    public Long getResult(User user, Long goodsId) {
        SeckillOrder seckillOrder = seckillOrderMapper.selectOne(new
                QueryWrapper<SeckillOrder>()
                .eq("user_id", user.getId())
                .eq("goods_id", goodsId));
        if (null != seckillOrder) {
            return seckillOrder.getOrderId();
        } else {
            if (redisTemplate.hasKey("isStockEmpty:" + goodsId)) {
                return -1L;
            } else {
                return 0L;
            }
        }
    }
}
