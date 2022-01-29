package cool.tdl.seckill.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author tdl
 * @Date 2022/1/9 19:45
 * @description 消息队列配置文件
 * @Version 1.0
 */

@Configuration
public class RabbitMQConfig {

    private static final String QUEUE = "seckillQueue";
    private static final String EXCHANGE = "seckillExchange";

    /**
     * 创建队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    /**
     * 创建交换机
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE);
    }

    /**
     * 交换机与队列绑定
     *
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with("seckill.#");
    }

}
