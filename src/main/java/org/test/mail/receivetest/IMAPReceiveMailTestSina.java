package org.test.mail.receivetest;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.test.mail.mymail.MailHelper;

public class IMAPReceiveMailTestSina {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.setProperty("mail.debug", "true");

		Session session = Session.getInstance(props);

		Store store = session.getStore("imap");
		store.connect("imap.sina.com", "ireed@sina.com", "3869277270ca307a");

		Folder folder = store.getFolder("INBOX");
		MailHelper.openFolderRW(folder);

		Message[] msgs = folder.getMessages();

		if (null != msgs && msgs.length != 0) {
			System.out.println("有"+msgs.length+"封邮件");
			
			for (int i = 0; i < msgs.length; i++) {
				Message msg = msgs[i];
				System.out.println("这封邮件的状态是"+msg.getFlags());
			}
			
		}

		MailHelper.closeFolder(folder, false);
		MailHelper.closeStore(store);

	}
}