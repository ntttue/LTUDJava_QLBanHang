package com.qlbh.controller.chucnang;

import java.time.LocalDate;
import java.time.ZoneId;

import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.render.combobox.DateOption;
import com.qlbh.util.DataInputUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class ThuTienController {
	@FXML
	ComboBox<DateOption> cbxTuyChonNgay;
	@FXML
	DatePicker dateNgayBatDau, dateNgayKetThuc;

	@FXML
	public void initialize() {
		// Set data for comboBox
		cbxTuyChonNgay.setItems(DateOption.getDateOptions());
		// Select first option
		cbxTuyChonNgay.getSelectionModel().select(0);
		// Set format of date for two DatePicker
		DataInputUtils.formatDatePicker(dateNgayBatDau, "dd/MM/yyyy");
		DataInputUtils.formatDatePicker(dateNgayKetThuc, "dd/MM/yyyy");
		// Set initial date as a first option
		this.setDatePeriod();
	}

	@FXML
	void onSelectedItemChange(ActionEvent event) {
		System.out.println("DateOption change");
		this.setDatePeriod();
	}

	private void setDatePeriod() {
		DateOption selectedDateOption = cbxTuyChonNgay.getValue();
		LocalDate localdateBegin = selectedDateOption.getBeginDate().toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		LocalDate localdateEnd = selectedDateOption.getEndDate().toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		dateNgayBatDau.setValue(localdateBegin);
		dateNgayKetThuc.setValue(localdateEnd);
	}

	@FXML
	void onButtonDSPhieuThuClick(ActionEvent event) {

	}

	@FXML
	void onButtonDSPhieuCongNoClick(ActionEvent event) {

	}

	@FXML
	void onButtonDSPhieuTraNgayClick(ActionEvent event) {

	}

	@FXML
	void onButtonTheoDoiCongNoClick(ActionEvent event) {

	}

	@FXML
	void onButtonTongHopCongNoClick(ActionEvent event) {

	}

	@FXML
	void onButtonXemClick(ActionEvent event) {

	}

	@FXML
	void onButtonLapPhieuThuClick(ActionEvent event) {

	}

	@FXML
	void onButtonExitClick(ActionEvent event) {
		ManHinhChinhController.tabThuTien.getTabPane().getTabs().remove(ManHinhChinhController.tabThuTien);
		ManHinhChinhController.tabThuTien = null;
	}
}
