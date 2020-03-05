package com.example.demo;

import com.peilw.child.components.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendmailApplicationTests {
    @Autowired
    MailService mailService;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("1510161612@qq.com", "1510161612@qq.com",
                "1510161612@qq.com", "测试邮件主题", "测试邮件内容");
    }

    @Test
    public void sendAttachFileMai() {
        mailService.sendAttachFileMail("1510161612@qq.com",
                "1510161612@qq.com", "测试邮件主题", "测试邮件内容", new File("E:\\邮件附件.docx"));
    }

    @Test
    public void sendMailWithimg() {
        mailService.sendMailWithirng("1510161612@qq.com",
                "584991843@qq.com",
                "测试邮件主题（图片）",
                "<div> hello , 这是一封带图片资源的邮件：" +
                        "这是图片1 : <div><img src= 'cid : pOl'/></div>" +
                        "这是图片2 : <div><img src= 'cid :p02 '/></div>" +
                        "</div>",
                new String[]{" C:\\Users\\sang\\Pictures\\pl.png",
                        "C:\\Users\\sang\\Pictures\\p2.png"},
                new String[]{"pOl", "p02"});
    }
}
