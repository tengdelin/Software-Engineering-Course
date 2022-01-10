package cool.tdl.server;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailServiceImp implements EmailService {

    String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    Pattern regex = Pattern.compile(check);

    @Override
    public String sendEmail(String _url, String _payload) {
        return sendMsg(_url, _payload);
    }

    @Override
    public String sendEmailBatch(String[] _url, String _payload) {
        String result = "Y";
        for (String address : _url) {
            String a = sendMsg(address, _payload);
            if (a == "N")
                result = "N";
        }
        return result;
    }

    @Override
    public String validateEmailAddress(String _url) {
        Matcher matcher = regex.matcher(_url);
        boolean isMatched = matcher.matches();
        System.out.println(isMatched);
        if (isMatched)
            return "Y";
        else
            return "N";
    }

    public String sendMsg(String name, String con) {
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
            ms.setSubject("topic");
            ms.setText(con);
            ms.saveChanges();

            Transport ts = session.getTransport();
            ts.connect(username, password);
            ts.sendMessage(ms, ms.getAllRecipients());
            ts.close();
            return "Y";
        } catch (Exception e) {
            e.printStackTrace();
            return "N";
        }


    }

}
