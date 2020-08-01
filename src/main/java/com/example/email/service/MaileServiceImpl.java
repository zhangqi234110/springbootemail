package com.example.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class MaileServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender; //框架自带的功能类

    @Value("${spring.mail.username}")  //发送人的邮箱
    private String from;

    @Override
    public void sendMail(String title, String url, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); // 发送人的邮箱
        message.setSubject(title); //标题
        message.setTo(email); //发给谁  对方邮箱
        message.setText(url); //内容
        mailSender.send(message); //发送

    }


}
