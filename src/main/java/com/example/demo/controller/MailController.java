package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.utils.ResourceUtils;
import common.utils.mail.MailHelper;

/**
 * 
 * @author lu_weicong
 *
 */

@RestController
@RequestMapping("/sendmail")
public class MailController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/toSecretary")
	public String toSecretary() {
		
		Properties mailProperties = ResourceUtils.getProperties("mail.properties");
		Session session = Session.getInstance(mailProperties);
		
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setFrom(new InternetAddress(mailProperties.getProperty("mail.from")));
			msg.setSubject("from mailcontroller");
			msg.setContent("nothing", "text/html;charset=utf-8");
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("luweicong580@gmail.com", "lwc_gmail", "utf-8"));
		} catch (MessagingException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			MailHelper.sendMail(session, mailProperties, msg);
			logger.info("邮件发送成功");
			return "邮件发送成功";
		} catch (Exception e) {
			logger.info("邮件发送失败");
			return "邮件发送失败";
		}
		
	}

}
