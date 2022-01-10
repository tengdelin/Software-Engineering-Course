package cool.tdl.rabbitmq.work.fair;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import cool.tdl.rabbitmq.utils.RabbitmqUtils;

/**
 * @Author tdl
 * @Date 2021/12/6 19:05
 * @description work模式的轮询分发
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
            channel.queueDeclare("queue1", false, false, false, null);
            //3.准备发送消息的内容
            for (int i = 1; i <= 20; i++) {
                //消息的内容
                String msg = "消息:" + i;
                // 4.发送消息给中间件rabbitmq-server
                // @params1: 交换机exchange
                // @params2: 队列名称/routingkey
                // @params3: 属性配置
                // @params4: 发送消息的内容
                channel.basicPublish("", "queue1", null, msg.getBytes());
            }
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
