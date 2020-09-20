package org.test.mail;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class GetMailTest {

	public static void main(String[] args) {
		
		Properties mailProperties = MailHelper.getMailConfigProperties("mail.properties");
		Session session = Session.getInstance(mailProperties);
		try {
			Store store = session.getStore("pop3");
			store.connect(mailProperties.getProperty("mail.pop"), mailProperties.getProperty("mail.from"), mailProperties.getProperty("mail.password"));
			
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);
			
			Message[] msgs = folder.getMessages();
			System.out.println("INBOX中共有"+msgs.length+ "封邮件");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
