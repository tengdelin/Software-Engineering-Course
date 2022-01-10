package cool.tdl.rabbitmq.simple;

/**
 * @Author tdl
 * @Date 2021/12/6 13:29
 * @description 简单队列生产者
 * @Version 1.0
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import cool.tdl.rabbitmq.utils.RabbitmqUtils;

import java.io.IOException;

public class Producer {
    public static void main(String[] args) throws IOException {
        //1.创建连接
        Connection connection= RabbitmqUtils.getConnection();
        //2.从连接中获取通道
        Channel channel = connection.createChannel();
        try{
            // 3.申明队列queue存储消息
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
            channel.queueDeclare("queue1", false, false, false, null);
            // 4.准备发送消息的内容
            String message = "hello world!";
            // 5.发送消息给中间件rabbitmq-server
            // @params1: 交换机exchange
            // @params2: 队列名称/routing
            // @params3: 属性配置
            // @params4: 发送消息的内容
            channel.basicPublish("", "queue1", null, message.getBytes());
            System.out.println("消息发送成功!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 6.释放连接关闭通道
            RabbitmqUtils.closeConnection(connection,channel);
        }
    }
}
