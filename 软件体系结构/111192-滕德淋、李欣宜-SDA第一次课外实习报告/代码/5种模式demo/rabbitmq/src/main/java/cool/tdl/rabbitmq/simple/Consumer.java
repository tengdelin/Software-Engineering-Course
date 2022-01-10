package cool.tdl.rabbitmq.simple;

import com.rabbitmq.client.*;
import cool.tdl.rabbitmq.utils.RabbitmqUtils;

import java.io.IOException;

/**
 * @Author tdl
 * @Date 2021/12/6 13:28
 * @description 简单队列消费者
 * @Version 1.0
 */
public class Consumer {
    public static void main(String[] args) throws IOException {
        //1.创建连接
        Connection connection= RabbitmqUtils.getConnection();
        //2.从连接中获取通道
        Channel channel = connection.createChannel();
        //3.定义接收信息的回调
        channel.basicConsume("queue1", true, new DeliverCallback() {
            @Override
            public void handle(String s, Delivery delivery) throws IOException {
                System.out.println(new String(delivery.getBody(), "utf-8"));
            }
        }, new CancelCallback() {
            @Override
            public void handle(String s) throws IOException {
                System.out.println("error");
            }
        });
        //4.关闭连接
        RabbitmqUtils.closeConnection(connection,channel);
    }
}
