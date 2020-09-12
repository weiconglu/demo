package org.test.mail;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class MyMsg extends MimeMessage {

	public MyMsg(Session session) {
		super(session);
	}

	@Override
	public void setFrom(Address address) throws MessagingException {
		super.setFrom(address);
	}

	/**
	 * 发给单一收件人
	 * @param address
	 * @throws MessagingException
	 */
	public void setTo(Address address) throws MessagingException {
		super.setRecipient(Message.RecipientType.TO, address);
	}
	
	/**
	 * 发送给多个收件人
	 * @param addresses
	 * @throws MessagingException
	 */
	public void setTo(Address[] addresses) throws MessagingException {
		super.setRecipients(Message.RecipientType.TO, addresses);
	}

	@Override
	public void setSubject(String subject) throws MessagingException {
		super.setSubject(subject,"utf-8");
	}

	@Override
	public void setText(String text) throws MessagingException {
		super.setText(text,"utf-8");
	}

}
