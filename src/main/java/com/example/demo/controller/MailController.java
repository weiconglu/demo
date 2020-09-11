package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendmail")
public class MailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/toSecretary")
	public String toSecretary() {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setFrom("receptionmail@163.com");
		msg.setTo("lu_weicong@purvar.co.jp");
		msg.setSubject("Test springboot mail sender");
		msg.setText("这是一封测试邮件，请不要回复");
		
		try {
			javaMailSender.send(msg);
			logger.info("邮件发送成功");
			return "邮件发送成功";
		} catch (Exception e) {
			logger.info("邮件发送失败");
			return "邮件发送失败";
		}
		
	}

}
