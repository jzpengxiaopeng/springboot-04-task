package com.atguigu.task.test;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

	@Autowired
	JavaMailSender mailSender;
	
	@Test
	public void test01() {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		
		simpleMessage.setTo("njpengxiaopeng@163.com");
		simpleMessage.setFrom("740678919@qq.com");
		simpleMessage.setSubject("测试邮件-标题");
		simpleMessage.setText("测试邮件-内容");
		
		mailSender.send(simpleMessage);
	}
	
	@Test
	public void test02() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		helper.setTo("njpengxiaopeng@163.com");
		helper.setFrom("740678919@qq.com");
		helper.setSubject("测试邮件-标题");
		helper.setText("<b style='color:blue'>测试邮件-内容</b>", true);
		
		helper.addAttachment("test.png", new File("C:\\\\Users\\\\Administrator\\\\Desktop\\\\test.png"));
		helper.addAttachment("test2.png", new File("C:\\\\Users\\\\Administrator\\\\Desktop\\\\test2.png"));
		
		mailSender.send(mimeMessage);
	}
	
}
