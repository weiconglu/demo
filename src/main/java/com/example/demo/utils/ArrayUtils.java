package com.example.demo.utils;

import java.util.Arrays;

public class ArrayUtils {

	/**
	 * 在一个整型数组intArray的末尾追加一个整数i并返回追加后的数组， 如果intArray数组为null，则返回一个仅包含整数i的数组
	 * 
	 * @param intArray 原数组
	 * @param i        要追加的整数
	 * @return intArray
	 */
	public final static int[] addInt(int[] intArray, int i) {
		if (intArray == null) {
			intArray = new int[1];
			intArray[0] = i;
			return intArray;
		} else {
			intArray = Arrays.copyOf(intArray, intArray.length + 1);
			intArray[intArray.length - 1] = i;
			return intArray;
		}
	}

	/**
	 * 判断在一个整型数组中是否存在指定的整数，如果存在返回true，否则返回false
	 * 
	 * @param intArray
	 * @param i
	 * @return
	 */
	public final static boolean contains(int[] intArray, int i) {
		for (int j = 0; j < intArray.length; j++) {
			if (intArray[j] == i) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 从一个整型数组中删除其中的一个值，然后返回新的整型数组 如果intArray中不含有传入的整数值则返回的整型数组与传入的整型数组的内容一样
	 * 
	 * @param intArray
	 * @param i
	 * @return
	 */
	public final static int[] remove(int[] intArray, int i) {
		int[] newArray = null;
		for (int j = 0; j < intArray.length; j++) {
			if (intArray[j] != i) {
				newArray = addInt(newArray, intArray[j]);
			}
		}
		return newArray;
	}

	/**
	 * 传入一个整型数组，返回其平均值
	 * 
	 * @param intArray
	 * @return
	 */
	public final static int getAverage(int[] intArray) {
		int sum = 0;
		for (int i = 0; i < intArray.length; i++) {
			sum = sum + intArray[i];
		}
		return sum / intArray.length;
	}

	/**
	 * 在一个字符串数组strArray的末尾追加一个字符串str并返回追加后的数组， 如果strArray数组为null，则返回一个仅包含字符串str的数组
	 * 
	 * @param strArray原数组
	 * @param str         要追加的字符串
	 * @return strArray
	 */
	public final static String[] addString(String[] strArray, String str) {
		if (strArray == null) {
			strArray = new String[1];
			strArray[0] = str;
			return strArray;
		} else {
			strArray = Arrays.copyOf(strArray, strArray.length + 1);
			strArray[strArray.length - 1] = str;
			return strArray;
		}
	}
}
