package org.test.mail.sendtest;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.naming.NamingException;

import org.test.mail.mymail.MailHelper;
import org.test.mail.mymail.MyAddress;
import org.test.mail.mymail.MyBodyPart;
import org.test.mail.mymail.MyMsg;
import org.test.mail.mymail.MyMultiPart;

import common.utils.PropertisUtil;

public class SendHTMLWithPicMailTest {

	public static void main(String[] args) throws NamingException, MessagingException {

		// 获得mail配置文件
		Properties mailProperties = PropertisUtil.getProperties("mail.properties");

		// 初始化mail session
		Session session = Session.getInstance(mailProperties);

		// 创建消息并初始化
		MyMsg msg = new MyMsg(session);
		msg.setFrom(new MyAddress(mailProperties.getProperty("mail.from")));
		msg.setTo(new MyAddress(mailProperties.getProperty("mail.to")));
//		msg.setCc(MailHelper.getAddresses(mailProperties.getProperty("mail.cc")));
		msg.setSubject("测试邮件");

		MyMultiPart multipart = new MyMultiPart();

		MyBodyPart messageBodyPart = new MyBodyPart();
		String htmlText = "<H1>这是一头小狮子</H1><img src='cid:img'>"; // ------------------------------与下面的setHeader里的<img>对应
		messageBodyPart.setHTMLContent(htmlText);

		multipart.addBodyPart(messageBodyPart);

		messageBodyPart = new MyBodyPart();
		DataSource fds = new FileDataSource("./vue/card/1.jpg");

		messageBodyPart.setDataHandler(new DataHandler(fds));
		messageBodyPart.setHeader("Content-ID", "<img>"); // ------------------------------与上面的cid:img对应

		multipart.addBodyPart(messageBodyPart);

		msg.setContent(multipart);

		MailHelper.sendMail(session, mailProperties, msg);

	}

}
