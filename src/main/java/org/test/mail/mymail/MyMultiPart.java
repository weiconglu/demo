package org.test.mail.mymail;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;

public class MyMultiPart extends MimeMultipart {

	@Override
	public synchronized void addBodyPart(BodyPart part) {
		try {
			super.addBodyPart(part);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
