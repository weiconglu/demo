package org.test.mail;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTest {

	public static void main(String[] args) throws FileNotFoundException, MessagingException {

		// 获得邮件配置文件mail.properties
		Properties mailConfigProperties = MailHelper.getMailConfigProperties();

		// 创建邮件会话
		Session session = Session.getInstance(mailConfigProperties);

		Message msg = new MimeMessage(session);

		msg.setSubject("Test mail");
		msg.setContent("这是一封测试邮件，请勿回复", "text/html;charset=utf-8");
		msg.setSentDate(new Date());

		msg.setFrom(new InternetAddress(mailConfigProperties.getProperty("mailFrom")));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mailConfigProperties.getProperty("mailTo")));

		msg.saveChanges();

		// 建立连接发送邮件
		Transport transport = session.getTransport("smtp");
		transport.connect(mailConfigProperties.getProperty("mail.host"), mailConfigProperties.getProperty("mailFrom"),
				mailConfigProperties.getProperty("password"));
		transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
		transport.close();

	}

}
