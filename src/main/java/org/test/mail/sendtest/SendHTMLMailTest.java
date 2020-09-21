package org.test.mail.sendtest;

import java.util.Properties;

import javax.mail.Session;
import javax.naming.NamingException;

import org.test.mail.mymail.MailHelper;
import org.test.mail.mymail.MyAddress;
import org.test.mail.mymail.MyMsg;

public class SendHTMLMailTest {

	public static void main(String[] args) throws NamingException {

		// 获得mail配置文件
		Properties mailProperties = MailHelper.getMailConfigProperties("mail.properties");

		// 初始化mail session
		Session session = Session.getInstance(mailProperties);

		// 创建消息并初始化
		MyMsg msg = new MyMsg(session);
		msg.setFrom(new MyAddress(mailProperties.getProperty("mail.from")));
		msg.setTo(new MyAddress(mailProperties.getProperty("mail.to")));
		msg.setCc(MailHelper.getAddresses(mailProperties.getProperty("mail.cc")));
		msg.setSubject("测试邮件");
		msg.setHTMLContent("<h1>这是一个标题</h1>");

		MailHelper.sendMail(session, mailProperties, msg);

	}

}
