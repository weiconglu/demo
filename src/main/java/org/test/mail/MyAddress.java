package org.test.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;

public class MyAddress extends InternetAddress {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param address mail address
	 * @param personal 邮件显示发/收件人名称，而不是邮件地址@前面的名称
	 * @throws UnsupportedEncodingException
	 */
	public MyAddress(String address, String personal) throws UnsupportedEncodingException {
		this.address = address;
		setPersonal(personal, "utf-8");
	}


}
