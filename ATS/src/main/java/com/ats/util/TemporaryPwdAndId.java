package com.ats.util;

public class TemporaryPwdAndId {
	
	
	public static String generateTempPwd() {
		String str = getAlphaNumericString(3) + "" + (int) (10 + (Math.random() * 89)) + ""
				+ getAlphaNumericString(3);
		return str;
	}
	public static String generateTempTagId() {
		String str =  "TAGID" + (int) (10 + (Math.random() * 89)) + ""
				+ getAlphaNumericString(5);
		return str;
	}

	// function to generate a random string of length n
	private static String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
}
