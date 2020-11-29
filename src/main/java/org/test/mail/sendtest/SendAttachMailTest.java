package org.test.mail.sendtest;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.naming.NamingException;

import org.test.mail.mymail.MailHelper;
import org.test.mail.mymail.MyAddress;
import org.test.mail.mymail.MyBodyPart;
import org.test.mail.mymail.MyMsg;
import org.test.mail.mymail.MyMultiPart;

import common.utils.ResourceUtils;

public class SendAttachMailTest {

	public static void main(String[] args) throws NamingException {

		Properties mailProperties = ResourceUtils.getProperties("mail.properties");

		Session session = Session.getInstance(mailProperties);

		MyMsg msg = new MyMsg(session);

		msg.setFrom(new MyAddress(mailProperties.getProperty("mail.from")));
		msg.setTo(new MyAddress(mailProperties.getProperty("mail.to")));
		
		msg.setSubject("这是一封有附件的メール");
		
		MyBodyPart msgBodyPart = new MyBodyPart();
		msgBodyPart.setText("这是邮件的正文");
		
		// 添加第一个附件
		DataSource dataSource = new FileDataSource(new File("./vue/card/1.jpg"));
		MyBodyPart attachBodyPart = new MyBodyPart();
		attachBodyPart.setDataHandler(new DataHandler(dataSource));
		attachBodyPart.setFileName("card.jpg");
		// 添加第二个附件
		DataSource ds2 = new FileDataSource(new File("./vue/card/2.jpg"));
		MyBodyPart attachBodyPart2 = new MyBodyPart();
		attachBodyPart2.setDataHandler(new DataHandler(ds2));
		attachBodyPart2.setFileName("card2.jpg");
		// 将附件添加到multipart
		MyMultiPart msgMultipart = new MyMultiPart();
		msgMultipart.addBodyPart(msgBodyPart);
		msgMultipart.addBodyPart(attachBodyPart);
		msgMultipart.addBodyPart(attachBodyPart2);
		
		msg.setContent(msgMultipart);
		
		MailHelper.sendMail(session, mailProperties, msg);
		

	}

}
