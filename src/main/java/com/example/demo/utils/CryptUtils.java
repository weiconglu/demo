package com.example.demo.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 根据设定的key加/解密字符串
 * 
 * @author lu_weicong
 */
public class CryptUtils {

	private static final String KEY = "reception"; // 密码、钥匙
	private static final String TRANSFORMATION_STRING = "AES/CBC/PKCS5Padding"; // 加密使用的transformation name
	private static final String ALGORITHM = "AES"; // 加密算法

	private static byte[] saltKey = null; // salt key 加盐
	private static IvParameterSpec iv = null; // vector key 向量
	private static Cipher cipher = null;
	private static SecretKey secretKey = null;

	static {
		try {
			saltKey = Arrays.copyOf(KEY.getBytes("utf-8"), 16); // 把KEY变成16字节的saltKey
			iv = new IvParameterSpec("0000000000000000".getBytes("utf-8")); // default vector key 16 bytes
			cipher = Cipher.getInstance(TRANSFORMATION_STRING); // cipher初始化
			secretKey = new SecretKeySpec(saltKey, ALGORITHM); // secret key初始化
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密字符串
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String content) {
		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
			byte[] encrypted = cipher.doFinal(content.getBytes("utf-8"));
			encryptedString = Base64.getEncoder().encodeToString(encrypted);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	/**
	 * 解密字符串
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String content) {
		String decryptedString = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
			byte[] contentByte = Base64.getDecoder().decode(content); // 先将加密的内容格式化成Base64的格式
			byte[] decrypted = cipher.doFinal(contentByte);
			decryptedString = new String(decrypted);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return decryptedString;
	}

}
