package org.test.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

public class SendMailTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {

		// 获得邮件配置文件mail.properties
		Properties mailConfigProperties = MailHelper.getMailConfigProperties("mail-reception.properties");

		// 创建邮件会话
		Session session = Session.getInstance(mailConfigProperties);

		MyMsg msg = new MyMsg(session);

		MyAddress from = new MyAddress(mailConfigProperties.getProperty("mail.from"), "from新浪邮箱");
		MyAddress to = new MyAddress(mailConfigProperties.getProperty("mail.to"), "to方正邮箱");
		
		msg.setFrom(from);
		msg.setTo(to);
		msg.setSubject("Test mail");
		msg.setText("这是一封测试邮件，请勿回复");

		// 发送邮件
		MailHelper.sendMail(session, mailConfigProperties, msg);

	}

}
