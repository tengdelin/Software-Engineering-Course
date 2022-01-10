package com.example.rabbitmqall.utils;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Author tdl
 * @Date 2021/12/10 21:07
 * @description 发送邮件
 * @Version 1.0
 */
public class SendEmail {
    public void send(String name, String topic, String con) {
        String username = "cugmail@163.com";
        String password = "KBTOSBJJAZRRFZRF";

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.host", "smtp.163.com");
        properties.put("mail.smtp.auth", true);

        //阿里云服务器禁用25端口，所以服务器上改为465端口
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", "465");

        Session session = Session.getInstance(properties);
        MimeMessage ms = new MimeMessage(session);
        try {
            InternetAddress internetAddress = new InternetAddress(username);
            ms.setFrom(internetAddress);

            ms.setRecipients(Message.RecipientType.TO, name);
            ms.setSubject(topic);
            ms.setText(con);
            ms.saveChanges();

            Transport ts = session.getTransport();
            ts.connect(username, password);
            ts.sendMessage(ms, ms.getAllRecipients());
            ts.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
