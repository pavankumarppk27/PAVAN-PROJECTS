package com.rto.utility;

import org.springframework.stereotype.Service;

@Service
public class VehicleRegistrationNumberUtility {

	
	public static String generateRegisterNumber() {
		String str = "VHL"+getAlphaNumericString(2) + "" + (int) (10 + (Math.random() * 89)) + ""
				+ getAlphaNumericString(3);
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
