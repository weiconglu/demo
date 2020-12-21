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

}
