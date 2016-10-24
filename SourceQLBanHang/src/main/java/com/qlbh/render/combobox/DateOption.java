package com.qlbh.render.combobox;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DateOption {
	static final Integer HOM_NAY = 1;
	static final Integer TUAN_NAY = 2;
	static final Integer THANG_NAY = 3;
	private Date beginDate, endDate;
	private String name;
	public DateOption(String name, Date beginDate, Date endDate) {
		this.name = name;
		this.setBeginDate(beginDate);
		this.setEndDate(endDate);
	}
	public DateOption() {}
	public DateOption getDateOption(Integer id) {
		switch(id) {
			case 1:
				return new DateOption("Hôm nay", new Date(), new Date());
			case 2:
				return this.getThisWeekOption();
			case 3:
				return new DateOption("Tháng này", new Date(), new Date());
		}
		return null;
	}
	public DateOption getThisWeekOption() {
		// Get calendar set to current date and time
        Calendar c = GregorianCalendar.getInstance();
        // Set the calendar to Monday of the current week
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        System.out.println("Current week = " + Calendar.DAY_OF_WEEK);
        // Get dates of the current week starting on Monday
        Date beginDate = c.getTime();
        c.add(Calendar.DATE, 6);
        Date endDate = c.getTime();
        return new DateOption("Tuần này", beginDate, endDate);
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
	public Date getBeginDate() {
		return beginDate;
	}
	private void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	private void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
