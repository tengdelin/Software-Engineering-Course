package cool.tdl.rabbitmq.fanout;

import com.rabbitmq.client.*;
import cool.tdl.rabbitmq.utils.RabbitmqUtils;

import java.io.IOException;

/**
 * @Author tdl
 * @Date 2021/12/6 18:24
 * @description fanout消费者
 * @Version 1.0
 */
public class Consumer {
    private static Runnable runnable = () -> {
        //1.创建连接
        Connection connection = RabbitmqUtils.getConnection();
        Channel channel = null;
        //2.获取队列的名称
        final String queueName = Thread.currentThread().getName();
        try {
            //3.从连接中获取通道
            channel = connection.createChannel();
            // 4.申明队列queue存储消息
            /*
             *  如果队列不存在，则会创建
             *  Rabbitmq不允许创建两个相同的队列名称，否则会报错。
             *
             *  @params1： queue 队列的名称
             *  @params2： durable 队列是否持久化
             *  @params3： exclusive 是否排他，即是否私有的，如果为true,会对当前队列加锁，其他的通道不能访问，并且连接自动关闭
             *  @params4： autoDelete 是否自动删除，当最后一个消费者断开连接之后是否自动删除消息。
             *  @params5： arguments 可以设置队列附加参数，设置队列的有效期，消息的最大长度，队列的消息生命周期等等。
             * */
            // 这里如果queue已经被创建过一次了，可以不需要定义
            //channel.queueDeclare("queue1", false, false, false, null);
            // 5.定义接受消息的回调
            Channel finalChannel = channel;
            finalChannel.basicConsume(queueName, true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                    System.out.println(queueName + "：收到消息是：" + new String(delivery.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                }
            });
            System.out.println(queueName + "：开始接受消息");
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            //6.关闭连接
            RabbitmqUtils.closeConnection(connection,channel);
        }
    };
    public static void main(String[] args) {
        // 启动三个线程去执行
        new Thread(runnable, "queue1").start();
        new Thread(runnable, "queue2").start();
        new Thread(runnable, "queue3").start();
    }
}
