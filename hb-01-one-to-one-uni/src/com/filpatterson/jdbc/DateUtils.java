package com.filpatterson.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * transform string into date
	 * @param dateToParse	string-formatted date to parse
	 * @return	obtained date
	 * @throws ParseException	if parsing works incorrect
	 */
	public static Date parseDate(String dateToParse) throws ParseException {
		return formatter.parse(dateToParse);
	}
	
	/**
	 * transform date into string
	 * @param theDate date that must be edited
	 * @return	obtained string
	 */
	public static String formatDate(Date theDate) {
		if(theDate != null)
			return formatter.format(theDate);
		else
			return null;
	}
}
