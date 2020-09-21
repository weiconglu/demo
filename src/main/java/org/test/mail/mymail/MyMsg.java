package org.test.mail.mymail;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class MyMsg extends MimeMessage {

	public MyMsg(Session session) {
		super(session);
	}

	@Override
	public void setFrom(Address address) {
		try {
			super.setFrom(address);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发给单一收件人
	 * 
	 * @param address
	 * @throws MessagingException
	 */
	public void setTo(Address address) {
		try {
			super.setRecipient(Message.RecipientType.TO, address);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送给多个收件人
	 * 
	 * @param addresses
	 * @throws MessagingException
	 */
	public void setTo(Address[] addresses) {
		try {
			super.setRecipients(Message.RecipientType.TO, addresses);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发给单一抄送
	 * 
	 * @param address
	 * @throws MessagingException
	 */
	public void setCc(Address address) {
		try {
			super.setRecipient(Message.RecipientType.CC, address);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送给多个抄送人
	 * 
	 * @param addresses
	 * @throws MessagingException
	 */
	public void setCc(Address[] addresses) {
		try {
			super.setRecipients(Message.RecipientType.CC, addresses);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setSubject(String subject) {
		try {
			super.setSubject(subject, "utf-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setText(String text) {
		try {
			super.setText(text, "utf-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setContent(Multipart mp) {
		try {
			super.setContent(mp);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加HTML内容
	 * @param string
	 */
	public void setHTMLContent(String string) {
		try {
			super.setContent(string, "text/html;charset=utf-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
