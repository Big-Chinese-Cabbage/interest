package com.interest.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String encrypt(String str) throws NoSuchAlgorithmException {

		// 确定计算方法
		MessageDigest md5;
		md5 = MessageDigest.getInstance("MD5");
		md5.update(str.getBytes());
		return new BigInteger(1, md5.digest()).toString(16);
	}
}
