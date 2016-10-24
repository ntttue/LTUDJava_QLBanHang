package com.qlbh.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class DataInputUtils {
	/**
	 * Set text input only is float value, switch split character between dot and comma by set value of useDot
	 * Allow format: 123,45 or 123.45
	 * TODO: Have some error, not use this
	 * @param textField
	 * @param useDot
	 */
	public static void setFloatOnlyForTextField(TextField textField, boolean useDot) {
		// Force the field to be float only
	    textField.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	        	int countOccurrences = 0;
	        	if ( useDot ) {
	        		countOccurrences = newValue.length() - newValue.replace(".", "").length();
	        	} else {
	        		countOccurrences = newValue.length() - newValue.replace(",", "").length();
	        	}
	        	if ( countOccurrences > 1 ) {
	        		textField.setText(oldValue);
	        		return;
	        	}
	            if ( useDot && ! newValue.matches("(\\d*\\.)?\\d")) {
	                textField.setText(newValue.replaceAll("[^(\\d*\\.)?\\d]", ""));
	                return;
	            }
	            if ( ! newValue.matches("(\\d*\\,)?\\d")) {
	            	textField.setText(newValue.replaceAll("[^(\\d*\\,)?\\d]", ""));
	            }
	        }
	    });
	}
	/**
	 * Set text input only is float value
	 * Allow format: 123.45
	 * @param textField
	 */
	public static void setFloatOnlyForTextField(TextField textField) {
		// Force the field to be float only
	    textField.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	        	int countOccurrences = 0;
        		countOccurrences = newValue.length() - newValue.replace(".", "").length();
	        	if ( countOccurrences > 1 ) {
	        		textField.setText(oldValue);
	        		return;
	        	}
	            if ( ! newValue.matches("(\\d*\\.)?\\d")) {
	                textField.setText(newValue.replaceAll("[^(\\d*\\.)?\\d]", ""));
	            }
	        }
	    });
	}
	/**
	 * Set text input only is positive integer number
	 * Allow format: 12344455
	 * @param textField
	 */
	public static void setIntegerOnlyForTextField(TextField textField) {
		// Force the field to be numeric only
		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if ( ! newValue.matches("\\d*")) {
					textField.setText(newValue.replaceAll("[^\\d*]", ""));
				}
			}
		});
	}
	/**
	 * Set text input for phone number, allow format: +84-655-8872-22
	 * @param textField
	 */
	public static void setTextFieldPhoneNumber(TextField textField) {
		// Force the field for phone number
	    textField.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if ( ! newValue.matches("\\+?(\\d*\\-)?\\d")) {
	                textField.setText(newValue.replaceAll("[^\\+?(\\d*\\-)?\\d]", ""));
	            }
	        }
	    });
	}
	
	/**
	 * 
	 * @param datePicker
	 * @param format
	 */
	public static void formatDatePicker(DatePicker datePicker, String format) {
		datePicker.setConverter(new StringConverter<LocalDate>() {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
			@Override
			public String toString(LocalDate localDate) {
				if (localDate == null)
					return "";
				return dateTimeFormatter.format(localDate);
			}
			@Override
			public LocalDate fromString(String dateString) {
				if (dateString == null || dateString.trim().isEmpty()) {
					return null;
				}
				return LocalDate.parse(dateString, dateTimeFormatter);
			}
		});
	}
}
