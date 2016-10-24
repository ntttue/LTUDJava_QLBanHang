package com.qlbh.controller.common;

import java.text.DecimalFormat;

public class Display {
	public static DecimalFormat dFormat = new DecimalFormat("####,###,###");

	public static String formatMoney(Double number) {
		if (number != null || number != 0.0) {
			return dFormat.format(number);
		}
		return "0";
	}
}
