package com.example.security;

import java.math.BigInteger;
import java.security.MessageDigest;

public class StudyMessageDigest {

	public static void main(String[] args) throws Exception {
		MessageDigest md= MessageDigest.getInstance("SHA1");
		md.reset();
		// e: 1561482c1292222496d39bb43eb61619184a51c9
		// f: 3c072fd6d4024309c884dce0b6d3dbf5a54a63cf
		md.update("Secrft123".getBytes());
		byte[] bytes= md.digest();
		BigInteger bi= new BigInteger(1,bytes);
		System.out.println(bi.toString(16));
	}

}
