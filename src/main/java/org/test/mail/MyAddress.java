package org.test.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;

public class MyAddress extends InternetAddress {
	
	private static final long serialVersionUID = 1L;

	public MyAddress(String address, String personal) throws UnsupportedEncodingException {
		this.address = address;
		setPersonal(personal, "utf-8");
	}


}
