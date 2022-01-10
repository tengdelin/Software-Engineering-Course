package com.example.rabbitmqall.service;

/**
 * @Author tdl
 * @Date 2021/12/9 20:53
 * @description 邮件消费者
 * @Version 1.0
 */


import com.example.rabbitmqall.utils.RedisUtils;
import com.example.rabbitmqall.utils.SendEmail;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

// bindings其实就是用来确定队列和交换机绑定关系

@Component
public class EmailService {
    SendEmail sendEmail = new SendEmail();
    String name = "";
    String topic = "消息队列-测试";
    public ArrayList<String> emailList = new ArrayList<>();
    public ArrayList<String> contentList = new ArrayList<>();

    @Autowired
    private RedisUtils redisUtils;

    @RabbitListener(queues = {"emailnum.fanout.queue"})
    @RabbitHandler
    public void messagerevice1(String message) {
        name = message;
    }

    @RabbitListener(queues = {"email.fanout.queue"})
    @RabbitHandler
    public void messagerevice2(String message) {
        System.out.println(name + ": " + message);

//        emailList.add(name);
//        contentList.add(message);

        redisUtils.lSet("emaillist",name);
        redisUtils.lSet("contentlist",message);

        sendEmail.send(name, topic, message);
    }
}
