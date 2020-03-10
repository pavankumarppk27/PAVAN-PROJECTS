package com.ats.util;

import java.io.BufferedReader;
import java.io.FileReader;

import com.ats.user.entity.UserEntity;

public class EmailForgotPwdFileReader {

	public static String readMailBody(UserEntity userEntity) throws Exception {

		FileReader fr = new FileReader("email_forgotpwd.txt");
		BufferedReader bf = new BufferedReader(fr);

		String readLine = bf.readLine();
		StringBuffer sb = new StringBuffer();
		while (readLine != null) {

			if (readLine.contains("{FIRST_NAME}")) {
				readLine = readLine.replace("{FIRST_NAME}", userEntity.getFirstName());
			}

			if (readLine.contains("{LAST_NAME}")) {
				readLine = readLine.replace("{LAST_NAME}",userEntity.getLastName());
			}

			if (readLine.contains("{PASSWORD}")) {
				readLine = readLine.replace("{PASSWORD}", userEntity.getPassword());
			}
			
			sb.append(readLine);
			sb.append(System.lineSeparator());
			readLine = bf.readLine();
		}

		bf.close();
		return sb.toString();
	}
}
