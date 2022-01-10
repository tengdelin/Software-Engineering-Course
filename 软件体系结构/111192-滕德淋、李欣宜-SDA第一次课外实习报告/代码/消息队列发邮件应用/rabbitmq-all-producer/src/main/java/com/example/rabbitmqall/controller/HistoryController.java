package com.example.rabbitmqall.controller;

import com.example.rabbitmqall.service.EmailService;
import com.example.rabbitmqall.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HistoryController {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private EmailService emailService;

    @RequestMapping("/reflush")
    public ArrayList<ArrayList<String>> history() throws InterruptedException {
        //链表存储
        ArrayList<ArrayList<String>> arrayList1 = new ArrayList<>();
        //redis存储
        ArrayList<ArrayList<String>> arrayList2 = new ArrayList<>();

        ArrayList<String> contentList = emailService.contentList;
        ArrayList<String> emailList = emailService.emailList;

        ArrayList<String> contentlist = new ArrayList<>();
        ArrayList<String> emaillist = new ArrayList<>();

        long emailsize = redisUtils.lGetListSize("emaillist");
        long contentsize = redisUtils.lGetListSize("contentlist");


        for (int i = 0; i < emailsize; i++) {
            emaillist.add((String) redisUtils.lGetIndex("emaillist", i));
//            Thread.sleep(1000);
        }
        for (int i = 0; i < contentsize; i++) {
            contentlist.add((String) redisUtils.lGetIndex("contentlist", i));
//            Thread.sleep(1000);
        }

        arrayList2.add(emaillist);
        arrayList2.add(contentlist);

        return arrayList2;
    }
}
