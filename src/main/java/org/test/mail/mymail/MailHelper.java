package org.test.mail.mymail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * 
 * @author lu_weicong
 *
 */
public class MailHelper {

	/**
	 * 用于获取mail的配置文件
	 * 
	 * @param mailConfigProperties 放在resources目录下的mail配置文件（推荐此文件命名为mail.properties）
	 * @return Properties properties
	 */
	public static Properties getMailConfigProperties(String mailConfigProperties) {

		Properties properties = new Properties();
		InputStream in = MailHelper.class.getClassLoader().getResourceAsStream(mailConfigProperties);
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	/**
	 * 从一串字符串中获取email地址，email地址之间用"/"隔开， 注意email地址必须是正确的地址，且该字符串必须包含一个正确的email地址，
	 * 注意：此方法不做email地址的排错 例：abc@test.com abc@test.com/def@test.com
	 * 
	 * @param addrString
	 * @return Address[]
	 */
	public static Address[] getAddresses(String addrString) {
		Address[] addresses = null;
		String[] addrStrings = addrString.split("/");
		addresses = new Address[addrStrings.length];
		for (int i = 0; i < addrStrings.length; i++) {
			try {
				addresses[i] = new InternetAddress(addrStrings[i]);
				// 如果要在地址前加上收件人的名称，将上面代码注释掉，并将下面代码取消注释
//				addresses[i] = new InternetAddress(addrStrings[i],addrStrings[i].split("@")[0]);
			} catch (AddressException e) {
				e.printStackTrace();
			}
		}
		return addresses;
	}

	/**
	 * 用于发送mail 不知道为啥，密送不能用！
	 * 
	 * @param session              该邮件会话session
	 * @param mailConfigProperties mail的配置文件，其中此方法用到mail.host，mail.from，mail.password
	 * @param msg                  MimeMessage实例
	 */
	public static void sendMail(Session session, Properties mailConfigProperties, Message msg) {
		Transport transport = null;
		try {
			transport = session.getTransport("smtp");
			transport.connect(mailConfigProperties.getProperty("mail.host"),
					mailConfigProperties.getProperty("mail.from"), mailConfigProperties.getProperty("mail.password"));

			// 若收件人/抄送/密送不为空，分别发送
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
	 * 获取POP3 Store，需要用到properties文件中的 mail.pop mail.from mail.password
	 * @param mailProperties
	 * @return
	 */
	public static Store getPOP3Store(Properties mailProperties) {
		Session session = Session.getInstance(mailProperties);
		Store store = null;
		try {
			store = session.getStore("pop3s");
			store.connect(mailProperties.getProperty("mail.pop"), mailProperties.getProperty("mail.from"), mailProperties.getProperty("mail.password"));
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return store;
	}
	
	/**
	 * 获得INBOX文件夹
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
	 * 以只读方式打开一个folder
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
	 * 以读写方式打开一个folder
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
	 * 获取folder中的邮件
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
	 * 关闭folder
	 * @param folder
	 * @param expungeFlag expunges all deleted messages if this flag is true
	 */
	public static void closeFolder(Folder folder,boolean expungeFlag) {
		try {
			folder.close(expungeFlag);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭store
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
