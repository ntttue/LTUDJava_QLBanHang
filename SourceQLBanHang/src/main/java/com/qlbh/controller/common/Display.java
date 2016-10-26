package com.qlbh.controller.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Display {
	public static DecimalFormat dFormat = new DecimalFormat("####,###,###");

	public static String formatMoney(Double number) {
		if (number != null || number != 0.0) {
			return dFormat.format(number);
		}
		return "0";
	}
	
	public static String formatMoney(BigDecimal number) {
		if (number == null || number.equals(0) ) {
			return "0";
		}
		return dFormat.format(number);
	}

	/**
	 * @NTN
	 * Reference link:
	 * http://stackoverflow.com/questions/2379221/java-currency-number-format
	 * @param number
	 * @return
	 */
	public static String formatDecimal(Double number) {
		float epsilon = 0.004f; // 4 tenths of a cent
		if (Math.abs(Math.round(number) - number) < epsilon) {
			return String.format("%10.0f", number); // sdb
		} else {
			return String.format("%10.2f", number); // dj_segfault
		}
	}
}
