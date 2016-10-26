package com.qlbh.controller.danhmuc;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.NhomhanghoaHome;
import com.qlbh.pojo.Nhomhanghoa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThemNhomHangHoaController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtGhiChu;

	final static Logger logger = Logger.getLogger(ThemNhomHangHoaController.class);

	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}
		Nhomhanghoa nhh = new Nhomhanghoa();
		nhh.setMa(txtMa.getText());
		nhh.setTen(txtTen.getText());
		nhh.setGhichu(txtGhiChu.getText());
		nhh.setActivity(true);
		NhomhanghoaHome nhhh = new NhomhanghoaHome();
		try {
			nhhh.save(nhh);
			txtMa.clear();
			txtTen.clear();
			txtGhiChu.clear();
			lbValidate.setText("");
			QuanLyNhomHangHoaController.quanLyNhomHangHoaController.reload();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyNhomHangHoaController.quanLyNhomHangHoaController.closeThem();
	}

}
