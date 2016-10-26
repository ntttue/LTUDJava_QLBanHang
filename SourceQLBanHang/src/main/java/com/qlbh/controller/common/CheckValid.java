package com.qlbh.controller.common;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class CheckValid {
	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	public static boolean isValidPhoneNumber(String phoneNo) {
		// validate phone numbers of format "1234567890"
		String phoneRegEx = "^[0-9\\-]*$";
		if (phoneNo.length() < 5)
			return false;
		if (phoneNo.matches(phoneRegEx))
			return true;
		// validating phone number with -, . or spaces
		else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		// validating phone number with extension length from 3 to 5
		else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
			return true;
		// validating phone number where area code is in braces ()
		else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		// return false if nothing matches the input
		else
			return false;
	}

	public static boolean isNumeric(String str) {
		str = str.replace(",", "");
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}
}
