package com.example.rabbitmqall.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;


/**
 * @Author tdl
 * @Date 2021/12/6 19:49
 * @description Fanout模式 交换机创建、队列创建、绑定
 * @Version 1.0
 */

@Configuration
public class FanoutRabbitConfig {
    //交换机 起名：fanout_order_exchange
    @Bean
    public FanoutExchange fanoutOrderExchange() {
        return new FanoutExchange("fanout_order_exchange", true, false);
    }

    //交换机 起名：ttl_exchange
    @Bean
    public FanoutExchange ttlOrderExchange() {
        return new FanoutExchange("ttl_exchange", true, false);
    }

    //交换机 起名：fanout_email_exchange
    @Bean
    public FanoutExchange fanoutEmailExchange() {
        return new FanoutExchange("fanout_email_exchange", true, false);
    }

    //交换机 起名：fanout_dead_exchange
    @Bean
    public FanoutExchange fanoutdeadExchange() {
        return new FanoutExchange("fanout_dead_exchange", true, false);
    }


    //队列 起名：
    @Bean
    public Queue emailQueue() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        //   return new Queue("TestDirectQueue",true,true,false);
        //一般设置一下队列的持久化就好,其余两个就是默认false
        return new Queue("email.fanout.queue", true);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue("sms.fanout.queue", true);
    }

    @Bean
    public Queue weixinQueue() {
        return new Queue("weixin.fanout.queue", true);
    }

    @Bean
    public Queue ttlQueue() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);
        args.put("x-dead-letter-exchange","fanout_dead_exchange");
        return new Queue("ttl.fanout.queue", true, false, false, args);
    }

    @Bean
    public Queue EmailnumQueue() {
        return new Queue("emailnum.fanout.queue", true);
    }

    @Bean
    public Queue deadQueue() {
        return new Queue("dead.fanout.queue", true);
    }


    //绑定  将队列和交换机绑定 fanout_order_exchange
    @Bean
    public Binding emailbinding() {
        return BindingBuilder.bind(emailQueue()).to(fanoutOrderExchange());
    }

    @Bean
    public Binding weixinbinding() {
        return BindingBuilder.bind(weixinQueue()).to(fanoutOrderExchange());
    }

    @Bean
    public Binding smsbinding() {
        return BindingBuilder.bind(smsQueue()).to(fanoutOrderExchange());
    }

    @Bean
    public Binding ttlbinding() {
        return BindingBuilder.bind(ttlQueue()).to(ttlOrderExchange());
    }

    @Bean
    public Binding emailnumbinding() {
        return BindingBuilder.bind(EmailnumQueue()).to(fanoutEmailExchange());
    }

    @Bean
    public Binding deadbinding() {
        return BindingBuilder.bind(deadQueue()).to(fanoutdeadExchange());
    }

}
