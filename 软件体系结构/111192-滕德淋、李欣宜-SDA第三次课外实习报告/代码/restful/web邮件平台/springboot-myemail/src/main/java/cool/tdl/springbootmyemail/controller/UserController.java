package cool.tdl.springbootmyemail.controller;

import cool.tdl.springbootmyemail.service.UserService;
import cool.tdl.springbootmyemail.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author administrator
 * @Description
 * @create 2021-12-23 下午1:59
 */
@Controller
public class UserController {
    private final String filedir = "/home/admin/tdl/upload/";
    //    private final String filedir = "C:/Users/tdl/upload/";
//    private final String filedir = "/home/administrator/upload/";

    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    UserService userService;

    @Autowired
    MD5Util md5Util;

    @GetMapping({"/", "/index"})
    public String toIndex() {
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/user/toguestPage")
    public String toguestPage() {
        return "user/guestPage";
    }

    @GetMapping("/user/tovipPage")
    public String tovipPage() {
        return "user/vipPage";
    }

    @GetMapping("/permissions")
    public String permissions() {
        return "permissions";
    }

    @GetMapping("/user/openVIP")
    public String openVIP() {
        return "user/openVipPage";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        //获取当前登录对象
        Subject subject = SecurityUtils.getSubject();
        //生成登录令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            model.addAttribute("username", username);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "账号错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        } catch (AuthenticationException e) {
            model.addAttribute("msg", "帐号密码错误");
            return "login";
        }
    }

    @PostMapping("/register")
    public String register(String username, String password, Model model) {
        //如果直接使用接口进行注册，进行md5加密
        if (password.length() <= 10) {
            password = md5Util.getMD5Str(password);
        }
        int i = userService.insertUser(username, password);
        if (i > 0) {
            model.addAttribute("msg", "注册成功");
            return "login";
        } else {
            model.addAttribute("msg", "注册失败");
            return "login";
        }
    }

    @GetMapping("/user/guestSendEmail")
    public String guestSendEmail(String title, String acount, String content, Model model) {
        if (sendEmailUtils1(title, acount, content)) {
            model.addAttribute("msg", "发送成功");
        } else {
            model.addAttribute("msg", "发送失败");
        }
        return "user/guestPage";
    }

    @PostMapping("/user/vipSendEmail")
    public String vipSendEmail(@RequestParam("file") MultipartFile[] files, String title, String acount, String content, Model model) throws Exception {
        ArrayList<String> filenameList = new ArrayList<>();
        try {
            for (MultipartFile f : files) {
                if (!Objects.equals(f.getOriginalFilename(), "")) {
                    saveFile(f);
                    filenameList.add(f.getOriginalFilename());
                }
            }
            //没有附件
            if (filenameList.size() == 0) {
                if (sendEmailUtils1(title, acount, content)) {
                    model.addAttribute("msg", "发送成功");
                } else {
                    model.addAttribute("msg", "发送失败");
                }
                return "user/vipPage";
            }
        } catch (Exception e) {
            System.out.println("保存文件出错了！");
        }

        boolean flag = sendEmailUtils(title, acount, content, filenameList);

        if (flag) {
            model.addAttribute("msg", "发送成功");
        } else {
            model.addAttribute("msg", "发送失败");
        }
        return "user/vipPage";
    }

    private Object saveFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "未选择文件";
        }
        String filename = file.getOriginalFilename(); //获取上传文件原来的名称
        File temp = new File(filedir);
        if (!temp.exists()) {
            temp.mkdirs();
        }
        File localFile = new File(filedir + filename);
        try {
            file.transferTo(localFile); //把上传的文件保存至本地
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "ok";
    }

    public boolean sendEmailUtils(String title, String acount, String content, ArrayList<String> filenameList) throws MessagingException {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject(title);
            helper.setText(content, true);
            for (String s : filenameList) {
                helper.addAttachment(s, new File(filedir + s));
            }
            helper.setTo(acount);
            helper.setFrom("1357388630@qq.com");
            mailSender.send(mimeMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean sendEmailUtils1(String title, String acount, String content) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject(title);
            mailMessage.setText(content);
            mailMessage.setTo(acount);
            mailMessage.setFrom("1357388630@qq.com");
            mailSender.send(mailMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
