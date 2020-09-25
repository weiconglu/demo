package common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeTest {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
		
		// 查看某个时区的offset
//		TimeZone tz = TimeZone.getTimeZone("GMT+9:00");
//		System.out.println(tz);

		Calendar cal = Calendar.getInstance();
		int jpOffset = 32400000;
		cal.add(Calendar.MILLISECOND, -(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET))); // UTC时间
		cal.add(Calendar.MILLISECOND, jpOffset);

		System.out.println(sdf.format(cal.getTime()));

	}

}
