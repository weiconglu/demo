package org.test.pdf;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class EnterDate {
	
	@Override
	public String toString() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
		Calendar calendar = Calendar.getInstance();
		String[] days = {"","日","月","火","水","木","金","土"};
		int index = calendar.get(Calendar.DAY_OF_WEEK);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String str = sdf.format(calendar.getTime())+"（"+days[index]+"）";
		return str;
	}
	
}
