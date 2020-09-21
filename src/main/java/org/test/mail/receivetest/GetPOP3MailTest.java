package org.test.mail.receivetest;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

import org.test.mail.mymail.MailHelper;

import com.sun.mail.pop3.POP3Folder;
import com.sun.mail.pop3.POP3Store;

public class GetPOP3MailTest {

	public static void main(String[] args) throws MessagingException, IOException {

		// 获得邮件配置文件mail.properties
		Properties mailConfigProperties = MailHelper.getMailConfigProperties("mail.properties");

		// 创建邮件会话
		Session session = Session.getInstance(mailConfigProperties);
		
		// 获取POP3Store
		POP3Store pop3Store = (POP3Store) session.getStore("pop3");

		pop3Store.connect(mailConfigProperties.getProperty("mail.address"),
				mailConfigProperties.getProperty("mail.password"));

		POP3Folder folder = (POP3Folder) pop3Store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);
		
		Message[] msgs = folder.getMessages();

		if (null == msgs || msgs.length == 0) {
			System.out.println("no mails found");
			return;
		}
		for (int i=0;i<msgs.length;i++) {
			Message msg = msgs[i];
			Flags flags = msg.getFlags();
			System.out.println("msg.getFlags(): "+flags);  // pop3邮件没有此属性
		}

	}

}
