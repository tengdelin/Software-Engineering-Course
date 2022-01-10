package com.example.rabbitmqall.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author tdl
 * @Date 2021/12/6 19:47
 * @description 发送消息
 * @Version 1.0
 */

@Component
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    // 1: 定义交换机
    private String exchangeName1 = "fanout_order_exchange";
    private String exchangeName2 = "fanout_email_exchange";
    private String exchangeName3 = "ttl_exchange";
    // 2: 路由key
    private String routeKey = "";


    public void makeOrder(String desc) {
        // 发送订单信息给RabbitMQ fanout
        rabbitTemplate.convertAndSend(exchangeName1, routeKey, desc);
    }

    public void makeEmail(String num) {
        // 发送订单信息给RabbitMQ fanout
        rabbitTemplate.convertAndSend(exchangeName2, routeKey, num);
    }





    public void ttlService(int userId, String desc) {
        System.out.println("用户" + userId + ",发送： " + desc);
        rabbitTemplate.convertAndSend(exchangeName3, routeKey, desc);
    }

    public void ttlMessage(String desc) {
        // 发送订单信息给RabbitMQ fanout
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setContentEncoding("utf-8");
                message.getMessageProperties().setExpiration("5000");
                return message;
            }
        };
        rabbitTemplate.convertAndSend(exchangeName1, routeKey, desc, messagePostProcessor);
    }
}
