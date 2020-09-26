package common.utils;

import java.util.TimeZone;

public class TimeTest {

	public static void main(String[] args) {

		// 查看某个时区的offset
		TimeZone tz = TimeZone.getTimeZone("GMT-12:00");
		System.out.println(tz);


	}

}
