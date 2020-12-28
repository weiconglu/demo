package com.example.demo.utils.mail;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;

import com.sun.mail.imap.IMAPStore;

/**
 * 用于辅助收发邮件的MailHelper
 * 
 * @author lu_weicong
 *
 */
public class MailHelper {

	/**
	 * 发送邮件，传入的Properties文件中必须以下三个认证用的属性： mail.smtp.host mail.user mail.password
	 * 
	 * @param session
	 * @param mailConfigProperties
	 * @param msg
	 */
	public static void sendMail(Session session, Properties mailProperties, Message msg) {
		Transport transport = null;

		int times = 0; // try times
		boolean flag = false; // send mail ok flag

		while (flag == false && times < 3) {

			try {
				transport = session.getTransport("smtp");
				transport.connect(mailProperties.getProperty("mail.smtp.host"), mailProperties.getProperty("mail.user"),
						mailProperties.getProperty("mail.password"));

				if (msg.getRecipients(Message.RecipientType.TO) != null) {
					transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
				}
				if (msg.getRecipients(Message.RecipientType.CC) != null) {
					transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.CC));
				}
				if (msg.getRecipients(Message.RecipientType.BCC) != null) {
					transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.BCC));
				}

				transport.close();
				flag = true;
			} catch (MessagingException e) {
				e.printStackTrace();
				times++;
				System.out.println("邮件发送时遇到了错误，正在重试：第" + times + "次...");
			}
		}
	}

	/**
	 * 获得POP3 Store，传入的Properties文件中必须以下三个认证用的属性： mail.pop3.host mail.user
	 * mail.password
	 * 
	 * @param mailProperties
	 * @return
	 */
	public static Store getPOP3Store(Properties mailProperties) {
		Session session = Session.getInstance(mailProperties);
		Store store = null;
		try {
			store = session.getStore("pop3");
			store.connect(mailProperties.getProperty("mail.pop3.host"), mailProperties.getProperty("mail.user"),
					mailProperties.getProperty("mail.password"));
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return store;
	}

	/**
	 * 获得IMAP Store，传入的Properties文件中必须以下三个认证用的属性： mail.imap.host mail.user
	 * mail.password
	 * 
	 * @param mailProperties
	 * @return
	 */
	public static IMAPStore getIMAPStore(Properties mailProperties) {
		Session session = Session.getInstance(mailProperties);
		IMAPStore store = null;
		try {
			store = (IMAPStore) session.getStore("imap");
			store.connect(mailProperties.getProperty("mail.imap.host"), mailProperties.getProperty("mail.user"),
					mailProperties.getProperty("mail.password"));

			// -------------连接IMAP邮箱时发送给服务器的认证信息-------------
			Map<String, String> clientParams = new HashMap<String, String>();
			clientParams.put("name", "myname");
			clientParams.put("version", "1.0.0");
			clientParams.put("vendor", "myclient");
			clientParams.put("support-email", "testmail@test.com");
			store.id(clientParams);
			// -------------连接IMAP邮箱时发送给服务器的认证信息-------------

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return store;
	}

	/**
	 * 获得"INBOX"文件夹
	 * 
	 * @param store
	 * @return
	 */
	public static Folder getInboxFolder(Store store) {
		Folder folder = null;
		try {
			folder = store.getFolder("INBOX");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return folder;
	}

	/**
	 * 以只读方式打开文件夹
	 * 
	 * @param folder
	 */
	public static void openFolderRO(Folder folder) {
		try {
			folder.open(Folder.READ_ONLY);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 以读写方式打开文件夹
	 * 
	 * @param folder
	 */
	public static void openFolderRW(Folder folder) {
		try {
			folder.open(Folder.READ_WRITE);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得文件夹中的邮件
	 * 
	 * @param folder
	 * @return
	 */
	public static Message[] getMessages(Folder folder) {
		Message[] msgs = null;
		try {
			msgs = folder.getMessages();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return msgs;
	}

	/**
	 * 关闭文件夹folder
	 * 
	 * @param folder
	 * @param expungeFlag expunges all deleted messages if this flag is
	 *                    true。如果这expungeFlag为true，关闭文件夹时将删除所有带Flag.DELETED标记的邮件(仅对IMAP邮件有效)
	 */
	public static void closeFolder(Folder folder, boolean expungeFlag) {
		try {
			folder.close(expungeFlag);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭store
	 * 
	 * @param store
	 */
	public static void closeStore(Store store) {
		try {
			store.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
