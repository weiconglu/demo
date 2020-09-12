package org.test.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailHelper {

	public static Properties getMailConfigProperties() {
		
		Properties properties = new Properties();
		InputStream in = MailHelper.class.getClassLoader().getResourceAsStream("mail.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
