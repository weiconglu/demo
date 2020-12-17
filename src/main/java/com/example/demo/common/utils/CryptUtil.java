package com.example.demo.common.utils;

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
 * stringの暗号化と復号化、キーは"reception"と固定する
 * 
 * @author lu_weicong
 */
public class CryptUtil {

	private static final String KEY = "reception"; // 暗号化キー
	private static final String TRANSFORMATION_STRING = "AES/CBC/PKCS5Padding"; // 暗号化transformation name
	private static final String ALGORITHM = "AES"; // 暗号化アルゴリズム

	private static byte[] saltKey = null; // salt key
	private static IvParameterSpec iv = null; // vector key
	private static Cipher cipher = null;
	private static SecretKey secretKey = null;

	static {
		try {
			saltKey = Arrays.copyOf(KEY.getBytes("utf-8"), 16); // salt keyは16 bytesに変更する
			iv = new IvParameterSpec("0000000000000000".getBytes("utf-8")); // default vector key 16 bytes
			cipher = Cipher.getInstance(TRANSFORMATION_STRING); // cipher初期化
			secretKey = new SecretKeySpec(saltKey, ALGORITHM); // secret key初期化
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * stringの暗号化
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
	 * stringの復号化
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String content) {
		String decryptedString = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
			byte[] contentByte = Base64.getDecoder().decode(content); // まず暗号化された内容をBase64の形に変更する
			byte[] decrypted = cipher.doFinal(contentByte);
			decryptedString = new String(decrypted);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return decryptedString;
	}

}
