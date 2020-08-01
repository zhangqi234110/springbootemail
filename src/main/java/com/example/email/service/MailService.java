package com.example.email.service;

import java.util.Map;

public interface MailService {
    //发送文字内容
    void sendMail(String title, String url, String email);
    //发送附件，输入附件的绝对路径加上它的文件名，如 D:\download\a.txt
    Map sendFileMail(String title, String content, String filePath,String email);
}
