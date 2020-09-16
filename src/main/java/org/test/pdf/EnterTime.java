package org.test.pdf;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class EnterTime {
	
	@Override
	public String toString() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH時mm分");
		return sdf.format(calendar.getTime());
	}
	
}
