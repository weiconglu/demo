package org.test.mail.receivetest;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;

import org.test.mail.mymail.MailHelper;

import common.utils.PropertisUtil;

public class CheckMailTest {

	public static void main(String[] args) {

		Properties mailProperties = PropertisUtil.getProperties("mail.properties");
		Store store = MailHelper.getPOP3Store(mailProperties);

		Folder folder = MailHelper.getInboxFolder(store);
		MailHelper.openFolderRO(folder);

		Message[] msgs = MailHelper.getMessages(folder);
		System.out.println("收件箱中共有" + msgs.length + "封邮件。");

		for (int i = 0; i < msgs.length; i++) {
			Message msg = msgs[i];
			System.out.println("---------------------------------");
			System.out.println("Email Number " + (i + 1));
			try {
				System.out.println("Subject: " + msg.getSubject());
				System.out.println("From: " + msg.getFrom()[0]);
				System.out.println("Text: " + msg.getContent().toString());
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		MailHelper.closeFolder(folder, false);
		MailHelper.closeStore(store);

	}

}
