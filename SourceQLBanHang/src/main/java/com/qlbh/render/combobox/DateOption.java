package com.qlbh.render.combobox;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DateOption {
	static final Integer HOM_NAY = 1;
	static final Integer TUAN_NAY = 2;
	static final Integer THANG_NAY = 3;
	private Date beginDate, endDate;
	private String name;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
	private Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
	public DateOption(String name, Date beginDate, Date endDate) {
		this.name = name;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	public DateOption() {}
	public DateOption getDateOption(Integer id) {
		switch(id) {
			case 1:
				return new DateOption("Hôm nay", calendar.getTime(), calendar.getTime());
			case 2:
				return new DateOption("Tuần này", calendar.getTime(), calendar.getTime());
			case 3:
				return new DateOption("Tháng này", calendar.getTime(), calendar.getTime());
		}
		return null;
	}
	@Override
	public String toString() {
		return this.name;
	}
	public static ObservableList<DateOption> getDateOptions() {
		List<DateOption> dateOptions = Arrays.asList(
			new DateOption().getDateOption(DateOption.HOM_NAY),
			new DateOption().getDateOption(DateOption.TUAN_NAY),
			new DateOption().getDateOption(DateOption.THANG_NAY)
		);
		ObservableList<DateOption> oDateOptions = FXCollections.observableList(dateOptions);
		return oDateOptions;
	}
}
