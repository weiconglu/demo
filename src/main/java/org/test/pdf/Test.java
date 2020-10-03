package org.test.pdf;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		long time = date.getTime();
		time = time + 24*60*60*1000;
		date.setTime(time);
		System.out.println(date);

	}

}
