package com.example.demo.utils.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.InternetAddress;

/**
 * 
 * @author lu_weicong
 */
public class MyAddress extends InternetAddress {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param address mail address
	 * @param personal 邮件显示发/收件人名称，而不是邮件地址@前面的名称
	 * @throws UnsupportedEncodingException
	 */
	public MyAddress(String address, String personal) {
		this.address = address;
		try {
			setPersonal(personal, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param address
	 */
	public MyAddress(String address) {
		this.address = address;
	}


}
