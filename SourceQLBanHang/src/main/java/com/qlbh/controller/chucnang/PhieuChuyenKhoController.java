package com.qlbh.controller.chucnang;

import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Nhanvien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PhieuChuyenKhoController {
	@FXML
	private ComboBox<Khohang> cbxKhoXuatHang, cbxKhoNhapHang;
	@FXML
	private ComboBox<Nhanvien> cbxNguoiNhan, cbxNguoiChuyen;
	@FXML
	private TextField txtGhiChu, txtPhieuCK, txtPhieuChuyenTay;
	@FXML
	private DatePicker datePickerNgay;

	@FXML
	void onButtonTaoMoiClick(ActionEvent event) {
		
	}

	@FXML
	void onButtonLuuClick(ActionEvent event) {

	}

	@FXML
	void onButtonNapLaiClick(ActionEvent event) {
		
	}

	@FXML
	void onButtonExitClick(ActionEvent event) {
		ManHinhChinhController.tabChuyenKho.getTabPane().getTabs().remove(ManHinhChinhController.tabChuyenKho);
		ManHinhChinhController.tabChuyenKho = null;
	}
}
