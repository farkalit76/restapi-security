package com.farkalit.webdemo.utils;

import java.util.Base64;


public class AuthUtils {

	
	private static final String username="Orchestrator";

	
	private static final String password="service@123";

	/**
	 * Encoding string ( with username & password ) with string encoder. 
	 * This encoded password is used to call the payment transaction with "Credential" header value.
	 * 
	 */
	public static String encodeCredential() {
		String credentials = username + ":" + password;
		String encodedStr = Base64.getEncoder().encodeToString(credentials.getBytes());
		System.out.println("Encoded string: " + encodedStr);
		// Decoding string with Getting decoder
		/**
		 * String deocdedStr = new String(Base64.getDecoder().decode(encodedStr));
		 */
		return encodedStr;
	}
	
//	public static void main(String[] args) {
//		encodeCredential();
//	}
}
