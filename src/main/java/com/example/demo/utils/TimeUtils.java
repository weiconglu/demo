package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

	/**
	 * 传入表示GMT时区的字符串，得到这个时区的时间
	 * 
	 * @param GMT+8:00或GMT+08:00 GMT+9:00或GMT+09:00 如果输入的字符串格式不对不能识别，则返回UTC时间
	 * @return
	 */
	public static Date getLocalTime(String GMTString) {

		Calendar cal = Calendar.getInstance(); // 获得当前默认时间

		int offset = 0; // 时间偏移量
		switch (GMTString) {
		case "GMT-12:00": // 西十二区(东西12区是一个区)
			offset = -43200000;
			break;
		case "GMT-11:00":
			offset = -39600000;
			break;
		case "GMT-10:00":
			offset = -36000000;
			break;
		case "GMT-09:00":
			offset = 32400000;
			break;
		case "GMT-9:00":
			offset = 32400000;
			break;
		case "GMT-08:00":
			offset = -28800000;
			break;
		case "GMT-8:00":
			offset = -28800000;
			break;
		case "GMT-07:00":
			offset = -25200000;
			break;
		case "GMT-7:00":
			offset = -25200000;
			break;
		case "GMT-06:00":
			offset = -21600000;
			break;
		case "GMT-6:00":
			offset = -21600000;
			break;
		case "GMT-05:00":
			offset = -18000000;
			break;
		case "GMT-5:00":
			offset = -18000000;
			break;
		case "GMT-04:00":
			offset = -14400000;
			break;
		case "GMT-4:00":
			offset = -14400000;
			break;
		case "GMT-03:00":
			offset = -10800000;
			break;
		case "GMT-3:00":
			offset = -10800000;
			break;
		case "GMT-02:00":
			offset = -7200000;
			break;
		case "GMT-2:00":
			offset = -7200000;
			break;
		case "GMT-01:00":
			offset = -3600000;
			break;
		case "GMT-1:00":
			offset = -3600000;
			break;
		case "GMT-00:00":
			break;
		case "GMT-0:00":
			break;
		case "GMT+00:00":
			break;
		case "GMT+0:00":
			break;
		case "GMT+01:00":
			offset = 3600000;
			break;
		case "GMT+1:00":
			offset = 3600000;
			break;
		case "GMT+02:00":
			offset = 7200000;
			break;
		case "GMT+2:00":
			offset = 7200000;
			break;
		case "GMT+03:00":
			offset = 10800000;
			break;
		case "GMT+3:00":
			offset = 10800000;
			break;
		case "GMT+04:00":
			offset = 14400000;
			break;
		case "GMT+4:00":
			offset = 14400000;
			break;
		case "GMT+05:00":
			offset = 18000000;
			break;
		case "GMT+5:00":
			offset = 18000000;
			break;
		case "GMT+06:00":
			offset = 21600000;
			break;
		case "GMT+6:00":
			offset = 21600000;
			break;
		case "GMT+07:00":
			offset = 25200000;
			break;
		case "GMT+7:00":
			offset = 25200000;
			break;
		case "GMT+08:00":
			offset = 28800000;
			break;
		case "GMT+8:00":
			offset = 28800000;
			break;
		case "GMT+09:00":
			offset = 32400000;
			break;
		case "GMT+9:00":
			offset = 32400000;
			break;
		case "GMT+10:00":
			offset = 36000000;
			break;
		case "GMT+11:00":
			offset = 39600000;
			break;
		case "GMT+12:00":// 东十二区(东西12区是一个区)
			offset = 43200000;
			break;
		default:
			break;
		}

		// 减去默认时区偏移量及夏令时，获得UTC时间
		cal.add(Calendar.MILLISECOND, -(cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)));
		// 加上当地时区的偏移量，获得当地时区的时间
		cal.add(Calendar.MILLISECOND, offset);

		return cal.getTime();
	}

	/**
	 * 将传入的UTC时间转化成某个时区的时间
	 * 
	 * @param utcDate
	 * @param GMTString "GMT+08:00" "GMT+09:00"
	 * @return
	 */
	public static Date getLocalTime(Date utcDate, String GMTString) {

		if (null == utcDate) {
			return null;
		}

		Calendar cal = Calendar.getInstance(); // 获得当前默认时间
		cal.setTime(utcDate);

		int offset = 0; // 时间偏移量
		switch (GMTString) {
		case "GMT-12:00": // 西十二区(东西12区是一个区)
			offset = -43200000;
			break;
		case "GMT-11:00":
			offset = -39600000;
			break;
		case "GMT-10:00":
			offset = -36000000;
			break;
		case "GMT-09:00":
			offset = 32400000;
			break;
		case "GMT-9:00":
			offset = 32400000;
			break;
		case "GMT-08:00":
			offset = -28800000;
			break;
		case "GMT-8:00":
			offset = -28800000;
			break;
		case "GMT-07:00":
			offset = -25200000;
			break;
		case "GMT-7:00":
			offset = -25200000;
			break;
		case "GMT-06:00":
			offset = -21600000;
			break;
		case "GMT-6:00":
			offset = -21600000;
			break;
		case "GMT-05:00":
			offset = -18000000;
			break;
		case "GMT-5:00":
			offset = -18000000;
			break;
		case "GMT-04:00":
			offset = -14400000;
			break;
		case "GMT-4:00":
			offset = -14400000;
			break;
		case "GMT-03:00":
			offset = -10800000;
			break;
		case "GMT-3:00":
			offset = -10800000;
			break;
		case "GMT-02:00":
			offset = -7200000;
			break;
		case "GMT-2:00":
			offset = -7200000;
			break;
		case "GMT-01:00":
			offset = -3600000;
			break;
		case "GMT-1:00":
			offset = -3600000;
			break;
		case "GMT-00:00":
			break;
		case "GMT-0:00":
			break;
		case "GMT+00:00":
			break;
		case "GMT+0:00":
			break;
		case "GMT+01:00":
			offset = 3600000;
			break;
		case "GMT+1:00":
			offset = 3600000;
			break;
		case "GMT+02:00":
			offset = 7200000;
			break;
		case "GMT+2:00":
			offset = 7200000;
			break;
		case "GMT+03:00":
			offset = 10800000;
			break;
		case "GMT+3:00":
			offset = 10800000;
			break;
		case "GMT+04:00":
			offset = 14400000;
			break;
		case "GMT+4:00":
			offset = 14400000;
			break;
		case "GMT+05:00":
			offset = 18000000;
			break;
		case "GMT+5:00":
			offset = 18000000;
			break;
		case "GMT+06:00":
			offset = 21600000;
			break;
		case "GMT+6:00":
			offset = 21600000;
			break;
		case "GMT+07:00":
			offset = 25200000;
			break;
		case "GMT+7:00":
			offset = 25200000;
			break;
		case "GMT+08:00":
			offset = 28800000;
			break;
		case "GMT+8:00":
			offset = 28800000;
			break;
		case "GMT+09:00":
			offset = 32400000;
			break;
		case "GMT+9:00":
			offset = 32400000;
			break;
		case "GMT+10:00":
			offset = 36000000;
			break;
		case "GMT+11:00":
			offset = 39600000;
			break;
		case "GMT+12:00":// 东十二区(东西12区是一个区)
			offset = 43200000;
			break;
		default:
			break;
		}

		// 加上当地时区的偏移量，获得当地时区的时间
		cal.add(Calendar.MILLISECOND, offset);
		return cal.getTime();
	}

	/**
	 * 将时间转化为"yyyy-MM-dd HH:mm:ss"格式的字符串，例：2008-08-08 08:08:08
	 * 
	 * @param date
	 * @return
	 */
	public static String getBeautifulString(Date date) {
		if (null == date) {
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 将形如"yyyy-MM-dd HH:mm:ss"格式的字符串转化为Date
	 * 
	 * @param beautifulTimeString
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String beautifulTimeString) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beautifulTimeString);
	}

	/**
	 * 将形如"yyyy-MM-ddTHH:mm:ss.000Z"格式的字符串转化为Date
	 * 
	 * @param utcStr
	 * @param isUtcString 是否是形如"2020-12-06T01:28:00.000Z"的字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String utcStr, boolean isUtcString) throws ParseException {
		String regex = "\\d{4}-\\d{1,2}-\\d{1,2}T\\d{1,2}:\\d{1,2}:\\d{1,2}.000Z";
		if (null == utcStr || !utcStr.matches(regex)) {
			return null;
		}

		// 将传入的字符串转换成 yyyy-MM-dd HH:mm:ss 的格式
		String dateString = utcStr.substring(0, utcStr.lastIndexOf(".")).replace("T", " ");

		return getDate(dateString);
	}

}
