package com.example.demo.utils;

public class StringUtils {
	
	/**
	 * 传入一个字符串str，返回该字符串的回文
	 * @param str 传入一个字符串
	 * @return 返回该字符串的回文
	 */
	public final static String reverseString(String str) {
		char[] charArray = str.toCharArray();
		char[] newCharArray = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			newCharArray[i] = charArray[str.length() - i - 1];
		}
		return new String(newCharArray);
	}
	
	/**
	 * 判断传入的字符串是不是回文
	 * @param str
	 * @return 如果是回文返回true，不是回文反回false
	 */
	public final static boolean isPalindrome(String str) {
		
		// 如果str的长度为1，直接返回true
		if (str.length() == 1) {
			return true;
		}
		
		boolean flag = true;
		char[] charArray = str.toCharArray();
		for(int i=0;i<str.length()/2;i++) {
			System.out.println(i+","+str);
			if (charArray[i] != charArray[str.length() - i -1]) {
				flag = false;
			}
		}
		return flag;
	}
	
    /**
     * Check String is empty.
     * @param str
     * @return return true if it is empty.
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }

    /**
     * Check String is not empty.
     * @param str
     * @return return true if it is not empty.
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
    
	/**
	 * 将字符串转成半角
	 * 
	 * @param input
	 * @return
	 */
	public static String toHalf(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				// 全角空格为12288，半角空格为32
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				// 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	/**
	 * 将字符串转成全角
	 * 
	 * @param input
	 * @return
	 */
	public static String toFull(String input) {
		// 半角转全角：
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 32) {
				c[i] = (char) 12288;
				continue;
			}
			if (c[i] < 127)
				c[i] = (char) (c[i] + 65248);
		}
		return new String(c);
	}

}
