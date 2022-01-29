package cool.tdl.seckill.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import cool.tdl.seckill.entity.Order;
import cool.tdl.seckill.entity.SeckillGoods;
import cool.tdl.seckill.entity.SeckillOrder;
import cool.tdl.seckill.entity.User;
import cool.tdl.seckill.exception.GlobalException;
import cool.tdl.seckill.mapper.OrderMapper;
import cool.tdl.seckill.service.GoodsService;
import cool.tdl.seckill.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.tdl.seckill.service.SeckillGoodsService;
import cool.tdl.seckill.service.SeckillOrderService;
import cool.tdl.seckill.utils.JsonUtil;
import cool.tdl.seckill.utils.MD5Utils;
import cool.tdl.seckill.utils.UUIDUtil;
import cool.tdl.seckill.vo.GoodsVo;
import cool.tdl.seckill.vo.OrderDetailVo;
import cool.tdl.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tdl
 * @since 2022-01-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private SeckillGoodsService seckillGoodsService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SeckillOrderService seckillOrderService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public OrderDetailVo detail(Long orderId) {
        if (null == orderId) {
            throw new GlobalException(RespBeanEnum.ORDER_NOT_EXIST);
        }
        Order order = orderMapper.selectById(orderId);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(order.getGoodsId());
        OrderDetailVo detail = new OrderDetailVo();
        detail.setGoodsVo(goodsVo);
        detail.setOrder(order);
        return detail;
    }

    @Override
    @Transactional
    public Order seckill(User user, GoodsVo goods) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //秒杀商品表减库存
        SeckillGoods seckillGoods = seckillGoodsService.getOne(
                new QueryWrapper<SeckillGoods>()
                        .eq("goods_id", goods.getId()));
        seckillGoods.setStockCount(seckillGoods.getStockCount() - 1);
        boolean seckillGoodsResult = seckillGoodsService.update(
                new UpdateWrapper<SeckillGoods>()
                        .setSql("stock_count = " + "stock_count-1")
                        .eq("goods_id", goods.getId())
                        .gt("stock_count", 0));
        if (seckillGoods.getStockCount() < 1) {
            valueOperations.set("isStockEmpty:" + goods.getId(), "0");
            return null;
        }
        //生成订单
        Order order = new Order();
        order.setUserId(user.getId());
        order.setGoodsId(goods.getId());
        order.setDeliveryAddrId(0L);
        order.setGoodsName(goods.getGoodsName());
        order.setGoodsCount(1);
        order.setGoodsPrice(seckillGoods.getSeckillPrice());
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        orderMapper.insert(order);
        //生成秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setUserId(user.getId());
        seckillOrder.setGoodsId(goods.getId());
        seckillOrderService.save(seckillOrder);
        redisTemplate.opsForValue().set("order:" + user.getId() + ":" + goods.getId(), JsonUtil.object2JsonStr(seckillOrder));
        return order;
    }

    @Override
    public String createPath(User user, Long goodsId) {
        String str = MD5Utils.md5(UUIDUtil.uuid() + "123456");
        redisTemplate.opsForValue().set("seckillPath:" + user.getId() + ":" + goodsId, str, 60, TimeUnit.SECONDS);
        return str;
    }

    @Override
    public boolean checkPath(User user, Long goodsId, String path) {
        if (user == null || StringUtils.isEmpty(path)) {
            return false;
        }
        String redisPath = (String) redisTemplate.opsForValue().get("seckillPath:" +
                user.getId() + ":" + goodsId);
        return path.equals(redisPath);
    }

    @Override
    public boolean checkCaptcha(User user, Long goodsId, String captcha) {
        if (StringUtils.isEmpty(captcha) || null == user || goodsId < 0) {
            return false;
        }
        String redisCaptcha = (String) redisTemplate.opsForValue().get("captcha:" + user.getId() + ":" + goodsId);
        return redisCaptcha.equals(captcha);
    }
}
