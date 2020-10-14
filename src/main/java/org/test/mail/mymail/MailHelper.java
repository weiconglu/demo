package org.test.mail.mymail;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;

/**
 * メール受送信ヘルパークラス
 * @author lu_weicong
 *
 */
public class MailHelper {

	/**
	 * メールを送信する
	 * 転入されたmailPropertiesファイルには３つの認証用セッティングが必要です： mail.smtp.host mail.user mail.password
	 * 
	 * @param session
	 * @param mailConfigProperties
	 * @param msg
	 */
	public static void sendMail(Session session, Properties mailProperties, Message msg) {
		Transport transport = null;
		try {
			transport = session.getTransport("smtp");
			transport.connect(mailProperties.getProperty("mail.smtp.host"),
					mailProperties.getProperty("mail.user"), mailProperties.getProperty("mail.password"));

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
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * POP3 Storeを取得する
	 * 転入されたmailPropertiesファイルには３つの認証用セッティングが必要です： mail.pop3.host mail.user mail.password
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
	 * IMAP Storeを取得する
	 * 転入されたmailPropertiesファイルには３つの認証用セッティングが必要です： mail.imap.host mail.user mail.password
	 * 
	 * @param mailProperties
	 * @return
	 */
	public static Store getIMAPStore(Properties mailProperties) {
		Session session = Session.getInstance(mailProperties);
		Store store = null;
		try {
			store = session.getStore("imap");
			store.connect(mailProperties.getProperty("mail.imap.host"), mailProperties.getProperty("mail.user"),
					mailProperties.getProperty("mail.password"));
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return store;
	}

	/**
	 * INBOXを取得する
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
	 * RO権限でfolderを開く
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
	 * RW権限でfolderを開く
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
	 * folderにあるメールを取得する
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
	 * folderを閉じる
	 * 
	 * @param folder
	 * @param expungeFlag expunges all deleted messages if this flag is true
	 */
	public static void closeFolder(Folder folder, boolean expungeFlag) {
		try {
			folder.close(expungeFlag);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * storeを閉じる
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
