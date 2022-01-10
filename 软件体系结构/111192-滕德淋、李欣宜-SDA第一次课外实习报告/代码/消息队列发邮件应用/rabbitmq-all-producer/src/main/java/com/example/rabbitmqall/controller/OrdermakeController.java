package com.example.rabbitmqall.controller;


import com.example.rabbitmqall.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author tdl
 * @Date 2021/12/10 15:55
 * @description 生产者
 * @Version 1.0
 */

@Controller
public class OrdermakeController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/orderproduce")
    public String ordermake() {
        return "orderproduce";
    }

    @RequestMapping("/send")
    public ModelAndView send(String num, String desc,String email) throws InterruptedException {
        int a = Integer.parseInt(num);
        for (int i = 0; i < a; i++) {
            orderService.makeOrder(desc);
            orderService.makeEmail(email);
        }
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/orderproduce");
        return view;
    }

    @RequestMapping("/sendttl")
    public String sendttl() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            orderService.ttlService(i, "ttl");
        }
        return "index";
    }

}
