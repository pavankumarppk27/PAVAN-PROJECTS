package com.tagtransaction.util;

import java.io.BufferedReader;
import java.io.FileReader;

import com.tagtransaction.tag.entity.PurchaseTagEntity;
import com.tagtransaction.tag.entity.TagTxRequestEntity;
import com.tagtransaction.tag.entity.UserEntity;

public class EmailFileReader {

	public static String readMailBody(UserEntity userEntity, PurchaseTagEntity tagEntity, TagTxRequestEntity tagTxReq)
			throws Exception {

		FileReader fr = new FileReader("email.txt");
		BufferedReader br = new BufferedReader(fr);

		String readLine = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (readLine != null) {

			if (readLine.contains("{FIRST_NAME}")) {
				readLine = readLine.replace("{FIRST_NAME}", userEntity.getFirstName());
			}
			if (readLine.contains("{LAST_NAME}")) {
				readLine = readLine.replace("{LAST_NAME}", userEntity.getLastName());
			}
			if (readLine.contains("{TAG_ID}")) {
				readLine = readLine.replace("{TAG_ID}", tagEntity.getTagRegId());
			}
			if (readLine.contains("{VEH_REG_NO}")) {
				readLine = readLine.replace("{VEH_REG_NO}", tagEntity.getVehicleRegNum());
			}
			if (readLine.contains("{VEH_TYPE}")) {
				readLine = readLine.replace("{VEH_TYPE}", tagEntity.getVehicleType());
			}
			if (readLine.contains("{TOLL_PLAZA_ID}")) {
				readLine = readLine.replace("{TOLL_PLAZA_ID}", tagTxReq.getTollPlazaId());
			}
			if (readLine.contains("{DEDUCTED_MONEY}")) {
				readLine = readLine.replace("{DEDUCTED_MONEY}", ""+tagTxReq.getTollAmt());
			}
			if (readLine.contains("{TAG_BALANCE}")) {
				readLine = readLine.replace("{TAG_BALANCE}", ""+(tagEntity.getTagBal()));
			}

			sb.append(readLine);
			sb.append(System.lineSeparator());
			readLine = br.readLine();
		}

		br.close();
		return sb.toString();
	}
}
