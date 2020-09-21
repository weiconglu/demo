package org.test.mail;

import java.util.Properties;

import javax.mail.Session;
import javax.naming.NamingException;

public class SendMailTest {

	public static void main(String[] args) throws NamingException {
		
		// 获得mail配置文件
		Properties mailProperties = MailHelper.getMailConfigProperties("mail.properties");

		// 初始化mail session
		Session session = Session.getInstance(mailProperties);

		// 创建消息并初始化
		MyMsg msg = new MyMsg(session);
		msg.setFrom(new MyAddress(mailProperties.getProperty("mail.from"), "receptionmail"));
		msg.setTo(new MyAddress(mailProperties.getProperty("mail.to"), "メールrecipient"));
		msg.setCc(MailHelper.getAddresses(mailProperties.getProperty("mail.cc")));
		msg.setSubject("测试邮件");
		msg.setText("这是测试邮件的内容");
		
		MailHelper.sendMail(session, mailProperties, msg);
		
	}

}
