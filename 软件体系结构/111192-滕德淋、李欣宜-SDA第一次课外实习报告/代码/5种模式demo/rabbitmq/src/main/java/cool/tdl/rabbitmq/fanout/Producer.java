package cool.tdl.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import cool.tdl.rabbitmq.utils.RabbitmqUtils;

/**
 * @Author tdl
 * @Date 2021/12/6 18:19
 * @description fanout生成者
 * @Version 1.0
 */
public class Producer {
    public static void main(String[] args) {
        //1.创建连接
        Connection connection= RabbitmqUtils.getConnection();
        Channel channel = null;
        try {
            //2.从连接中获取通道
            channel = connection.createChannel();
            // 3.准备发送消息的内容
            String message = "你好，fanout模式！！！";
            String exchangeName = "exchange-fanout";
            String routingKey = "";
            // 4.发送消息给中间件rabbitmq-server
            // @params1: 交换机exchange
            // @params2: 队列名称/routingkey
            // @params3: 属性配置
            // @params4: 发送消息的内容
            channel.basicPublish(exchangeName, routingKey, null, message.getBytes());
            System.out.println("消息发送成功!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("发送消息出现异常...");
        } finally {
            // 5.释放连接关闭通道
            RabbitmqUtils.closeConnection(connection,channel);
        }
    }
}
