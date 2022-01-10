package com.example.rabbitmqall.service;

/**
 * @Author tdl
 * @Date 2021/12/9 20:55
 * @description 微信消费者
 * @Version 1.0
 */


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// bindings其实就是用来确定队列和交换机绑定关系
@RabbitListener(queues = {"weixin.fanout.queue"})

@Component
public class WeixinService {
    // @RabbitHandler 代表此方法是一个消息接收的方法。该不要有返回值
    @RabbitHandler
    public void messagerevice(String message) {
        // 此处省略发邮件的逻辑
//        System.out.println("发送微信-------------->" + message);
    }
}
