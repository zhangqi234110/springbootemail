package com.example.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Map<String, Object> sendFileMail(String title, String content, String filePath,String email) {
        System.out.println("in sendAttachmentsMail");
        System.out.println(filePath);
        MimeMessage message = mailSender.createMimeMessage();
        Map<String, Object> map = new HashMap<>();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(title);
            helper.setText(content, true);
            File file = new File(filePath);
            file = ResourceUtils.getFile(file.getAbsolutePath());
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            System.out.println(fileName);
            //添加多个附件可以使用多条 helper.addAttachment(fileName,file);
            //helper.addAttachment(fileName,file);
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            map.put("code", 1);
            map.put("message", "发送成功");
            return map;
        } catch (MessagingException e) {
            e.printStackTrace();
            map.put("code",0);
            map.put("message","发送失败");
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            map.put("code",-1);
            map.put("message","没有文件");
            return map;
        } finally {
        }

    }


}
