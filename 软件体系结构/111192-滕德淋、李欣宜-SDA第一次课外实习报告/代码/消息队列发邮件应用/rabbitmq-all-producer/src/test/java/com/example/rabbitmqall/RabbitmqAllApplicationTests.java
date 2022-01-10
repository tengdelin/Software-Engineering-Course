package com.example.rabbitmqall;


import com.example.rabbitmqall.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqAllApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    public void test(){
//        orderService.ttlService(10,"ttl");
        orderService.ttlMessage("hello");
    }
}
