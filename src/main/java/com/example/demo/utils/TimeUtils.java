package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {

	/**
	 * 获取某个GMT时区的时间增量
	 * 
	 * @param ID the ID for a TimeZone, either an abbreviation such as "PST", a full
	 *           name such as "America/Los_Angeles", or a customID such as
	 *           "GMT-8:00". Note that the support of abbreviations is for JDK 1.1.x
	 *           compatibility only and full names should be used.
	 * @return
	 */
	public static int getOffset(String ID) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(ID));
		// This field reflects the correct GMT offset value of the time + This field reflects the correct daylight saving offset value of
		return calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
	}

	/**
	 * 获取当前默认时区的时间增量
	 * 
	 * @return
	 */
	public static int getOffset() {
		Calendar calendar = Calendar.getInstance();
		// This field reflects the correct GMT offset value of the time + This field reflects the correct daylight saving offset value of
		return calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
	}

	/**
	 * 获得当前UTC的时间
	 * 
	 * @return
	 */
	public static Date getUTCTime() {
		Calendar calendar = Calendar.getInstance();
		// 默认时区时间减去默认时区的时间增量(该时区的时间增量加上该时区的夏令时增量(如果使用))
		calendar.add(Calendar.MILLISECOND, -(calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET)));
		return calendar.getTime();
	}

	/**
	 * 获得某个GMT时区的时间
	 * 
	 * @param ID the ID for a TimeZone, either an abbreviation such as "PST", a full
	 *           name such as "America/Los_Angeles", or a customID such as
	 *           "GMT-8:00". Note that the support of abbreviations is for JDK 1.1.x
	 *           compatibility only and full names should be used.
	 * @return
	 */
	public static Date getGMTTime(String ID) {
		// 先将calendar先设置为UTC时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(TimeUtils.getUTCTime());
		// 再加上这个时区的时间增量
		calendar.add(Calendar.MILLISECOND, getOffset(ID));
		return calendar.getTime();
	}

	/**
	 * 将传入的UTC时间转化成对应的某个GMT时区的时间
	 * 
	 * @param utcDate
	 * @param ID      the ID for a TimeZone, either an abbreviation such as "PST", a
	 *                full name such as "America/Los_Angeles", or a customID such as
	 *                "GMT-8:00". Note that the support of abbreviations is for JDK
	 *                1.1.x compatibility only and full names should be used.
	 * @return 如果传入的utcDate为null则返回null
	 */
	public static Date getGMTTime(Date utcDate, String ID) {
		if (null == utcDate) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(utcDate);
		// 加上当地时区的偏移量，获得当地时区的时间
		cal.add(Calendar.MILLISECOND, getOffset(ID));
		return cal.getTime();
	}

	/**
	 * 将时间转化为"yyyy-MM-dd HH:mm:ss"格式的字符串，例：2008-08-08 08:08:08
	 * 
	 * @param date
	 * @return 如果传入的date为null则返回null
	 */
	public static String getBeautifulString(Date date) {
		if (null == date) {
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	/**
	 * 将时间转化为"yyyyMMddHHmmss"格式的字符串，例：20080808080808
	 * 
	 * @param date
	 * @return 如果传入的date为null则返回null
	 */
	public static String getSimpleString(Date date) {
		if (null == date) {
			return null;
		}
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}

	/**
	 * 将形如"yyyy-MM-dd HH:mm:ss"格式的字符串转化为Date
	 * 
	 * @param beautifulTimeString
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String beautifulTimeString) throws ParseException {
		if (null == beautifulTimeString) {
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beautifulTimeString);
	}

	/**
	 * 将形如"yyyy-MM-ddTHH:mm:ss.000Z"表示UTC时间的字符串转化为Date
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

	/**
	 * 如果date1比date2靠前返回true，否则返回false
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isBefore(Date date1, Date date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		Double doubleDate1 = Double.parseDouble(sdf.format(date1));
		Double doubleDate2 = Double.parseDouble(sdf.format(date2));
		return doubleDate2 > doubleDate1;
	}
	
	/**
	 * 如果date1比date2靠后返回true，否则返回false
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isAfter(Date date1, Date date2) {
		return !isBefore(date1, date2);
	}

}
