package cool.tdl.seckill.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author tdl
 * @Date 2022/1/9 19:52
 * @description 消息队列发送、生产者
 * @Version 1.0
 */
@Component
public class MQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendSeckillMessage(String message){
        rabbitTemplate.convertAndSend("seckillExchange","seckill.message",message);
    }
}
