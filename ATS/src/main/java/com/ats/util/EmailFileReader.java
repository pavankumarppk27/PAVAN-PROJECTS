package com.ats.util;

import java.io.BufferedReader;
import java.io.FileReader;

import com.ats.user.entity.UserEntity;

public class EmailFileReader {

	public static String readMailBody(String URL,UserEntity userEntity) throws Exception {

		FileReader fr = new FileReader("email.txt");
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

			if (readLine.contains("{TEMP_PASSWORD}")) {
				readLine = readLine.replace("{TEMP_PASSWORD}", userEntity.getPassword());
			}
			
			if (readLine.contains("{EMAIL}")) {
				readLine = readLine.replace("{EMAIL}", userEntity.getEmail());
			}
			if (readLine.contains("{unLock}")) {
				readLine = readLine.replace("{unLock}", URL);
			}
			
			//{unLock}

			sb.append(readLine);
			sb.append(System.lineSeparator());
			readLine = bf.readLine();
		}

		bf.close();
		return sb.toString();
	}
}
