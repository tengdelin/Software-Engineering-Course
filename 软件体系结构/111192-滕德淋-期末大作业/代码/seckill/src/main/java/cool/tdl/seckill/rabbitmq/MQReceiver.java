package cool.tdl.seckill.rabbitmq;


import cool.tdl.seckill.entity.SeckillMessage;
import cool.tdl.seckill.entity.SeckillOrder;
import cool.tdl.seckill.entity.User;
import cool.tdl.seckill.service.GoodsService;
import cool.tdl.seckill.service.OrderService;
import cool.tdl.seckill.utils.JsonUtil;
import cool.tdl.seckill.vo.GoodsVo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author tdl
 * @Date 2022/1/9 19:53
 * @description 消息队列接收、消费者
 * @Version 1.0
 */
@Component
public class MQReceiver {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = "seckillQueue")
    public void receive(String msg) {
        SeckillMessage message = JsonUtil.jsonStr2Object(msg, SeckillMessage.class);
        Long goodsId = message.getGoodsId();
        User user = message.getUser();
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if (goods.getStockCount() < 1) {
            return;
        }
        //判断是否重复抢购
        String seckillOrderJson = (String) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodsId);
        if (!StringUtils.isEmpty(seckillOrderJson)) {
            return;
        }
        orderService.seckill(user, goods);
    }

}
