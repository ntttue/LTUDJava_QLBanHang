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
		cbxTuyChonNgay.setItems(DateOption.getDateOptions());
		DataInputUtils.formatDatePicker(dateNgayBatDau, "dd/MM/yyyy");
		DataInputUtils.formatDatePicker(dateNgayKetThuc, "dd/MM/yyyy");
		cbxTuyChonNgay.getSelectionModel().select(0);
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
		dateNgayBatDau.setValue(localdateBegin);
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
