package com.ats.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date addYears(Date date) {

		Date tagEndDate = date;
		Calendar calender = Calendar.getInstance();
		calender.setTime(tagEndDate);
		calender.add(Calendar.YEAR, 3);

		return calender.getTime();
	}

	public static Date toDayDate() throws Exception {

		DateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Calendar cal = Calendar.getInstance();
		String format = sdf.format(cal.getTime());
		Date parse = sdf.parse(format);
		cal.setTime(parse);

		return cal.getTime();
	}
}
