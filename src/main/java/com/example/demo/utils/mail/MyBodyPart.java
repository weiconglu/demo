package com.example.demo.utils.mail;

import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

/**
 * 
 * @author lu_weicong
 */
public class MyBodyPart extends MimeBodyPart {

	@Override
	public void setFileName(String filename) {
		try {
			super.setFileName(filename);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setHeader(String name, String value) {
		try {
			super.setHeader(name, value);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setDataHandler(DataHandler dh) {
		try {
			super.setDataHandler(dh);
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

	@Override
	public void setText(String text) {
		try {
			super.setText(text, "utf-8");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
