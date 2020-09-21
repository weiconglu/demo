package org.test.mail.mymail;

import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

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
	public void setDataHandler(DataHandler dh) {
		try {
			super.setDataHandler(dh);
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
