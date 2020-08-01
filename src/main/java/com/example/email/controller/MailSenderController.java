package com.example.email.controller;

import com.example.email.service.MailService;
import com.example.email.service.MaileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailSenderController {

    @Autowired
    private MailService maileService;
    @Value("${spring.mail.username}")  //发送人的邮箱  比如155156641XX@163.com
    private String from;

    @RequestMapping("/sendmail")
    public String sendMail(String title, String content, String email) {
        maileService.sendMail(title, content, email);
       return "sendsuccess";
    }

    @RequestMapping("/sendfilemail")
    public String sendMail(String title, String content, String filePath,String email) {
       maileService.sendFileMail(title, content, filePath, email);
        return "sendsuccess";
    }

}
