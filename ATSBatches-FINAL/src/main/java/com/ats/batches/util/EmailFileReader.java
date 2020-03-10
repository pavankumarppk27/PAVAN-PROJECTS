package com.ats.batches.util;

import java.io.BufferedReader;
import java.io.FileReader;

import com.ats.batches.entity.UserMasterEntity;

public class EmailFileReader {

	public static String readMailBody(UserMasterEntity userEntity) throws Exception {

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

	
			
			
			//{unLock}

			sb.append(readLine);
			sb.append(System.lineSeparator());
			readLine = bf.readLine();
		}

		bf.close();
		return sb.toString();
	}
}
