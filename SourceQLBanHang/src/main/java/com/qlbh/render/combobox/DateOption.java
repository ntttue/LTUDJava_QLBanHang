package com.qlbh.render.combobox;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DateOption {
	static final Integer TAT_CA = 0;
	static final Integer HOM_NAY = 1;
	static final Integer TUAN_NAY = 2;
	static final Integer THANG_NAY = 3;
	static final Integer NAM_NAY = 4;
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
			case 0:
				return new DateOption("Tất cả", null, null);
			case 1:
				return new DateOption("Hôm nay", new Date(), new Date());
			case 2:
				return this.getThisWeekOption();
			case 3:
				return this.getThisMonthOption();
			case 4:
				return this.getThisYearOption();
		}
		return null;
	}
	public DateOption getThisWeekOption() {
		// Reference link: http://stackoverflow.com/questions/22890644/get-current-week-start-and-end-date-in-java-monday-to-sunday
		// Get calendar set to current date and time
        Calendar c = GregorianCalendar.getInstance();
        // Set the calendar to Monday of the current week
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        // System.out.println("Current week = " + Calendar.DAY_OF_WEEK);
        // Get dates of the current week starting on Monday        
        Date beginDate = c.getTime();
        c.add(Calendar.DATE, 6);
        Date endDate = c.getTime();
        return new DateOption("Tuần này", beginDate, endDate);
	}
	
	public DateOption getThisMonthOption() {
		// Reference link: http://stackoverflow.com/questions/3083781/start-and-end-date-of-a-current-month
		// Get calendar set to current date and time
        Calendar c = GregorianCalendar.getInstance();
        // Set the calendar to First day of the current month
        c.set(Calendar.DAY_OF_MONTH, 1);
        // Get first day of current month
        Date beginDate = c.getTime();
        c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
        // Get last day of current month
        Date endDate = c.getTime();        
        return new DateOption("Tháng này", beginDate, endDate);
	}
	
	public DateOption getThisYearOption() {
		// Get calendar set to current date and time
        Calendar c = GregorianCalendar.getInstance();
        // Set the calendar to Monday of the current week
        c.set(Calendar.DAY_OF_YEAR, 1);
        // Get dates of the current week starting on Monday
        Date beginDate = c.getTime();
        c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_YEAR) - 1);
        Date endDate = c.getTime();        
        return new DateOption("Năm nay", beginDate, endDate);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	public static ObservableList<DateOption> getDateOptions() {
		List<DateOption> dateOptions = Arrays.asList(
			new DateOption().getDateOption(DateOption.TAT_CA),
			new DateOption().getDateOption(DateOption.HOM_NAY),
			new DateOption().getDateOption(DateOption.TUAN_NAY),
			new DateOption().getDateOption(DateOption.THANG_NAY),
			new DateOption().getDateOption(DateOption.NAM_NAY)
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
