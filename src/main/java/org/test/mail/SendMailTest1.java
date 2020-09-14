package org.test.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTest1 {

	public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {

		// 获得邮件配置文件mail.properties
		Properties mailConfigProperties = MailHelper.getMailConfigProperties("mail-reception.properties");

		// 创建邮件会话
		Session session = Session.getInstance(mailConfigProperties);

		Message msg = new MimeMessage(session);

		msg.setSubject("Test mail");
		msg.setContent("这是一封测试邮件，请勿回复", "text/html;charset=utf-8");
		
//		msg.setSentDate(new Date());

		msg.setFrom(new InternetAddress(mailConfigProperties.getProperty("mail.from")));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mailConfigProperties.getProperty("mail.to"),"lu_weicong_to","utf-8"));
//		msg.setRecipient(Message.RecipientType.CC, new InternetAddress(mailConfigProperties.getProperty("mail.cc"),"lu_weicong_cc","utf-8"));
//		msg.setRecipient(Message.RecipientType.BCC, new InternetAddress(mailConfigProperties.getProperty("mail.bcc"),"lu_weicong_bcc","utf-8"));

//		msg.saveChanges();

		// 发送邮件
		MailHelper.sendMail(session, mailConfigProperties, msg);

	}

}
