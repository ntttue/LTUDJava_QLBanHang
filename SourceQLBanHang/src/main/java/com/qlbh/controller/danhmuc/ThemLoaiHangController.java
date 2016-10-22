package com.qlbh.controller.danhmuc;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.LoaihangHome;
import com.qlbh.pojo.Loaihang;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThemLoaiHangController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtGhiChu;

	final static Logger logger = Logger.getLogger(ThemLoaiHangController.class);

	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}
		Loaihang lh = new Loaihang();
		lh.setMa(txtMa.getText());
		lh.setTen(txtTen.getText());
		lh.setGhichu(txtGhiChu.getText());
		lh.setActivity(true);
		LoaihangHome lhh = new LoaihangHome();
		try {
			lhh.save(lh);
			txtMa.clear();
			txtTen.clear();
			txtGhiChu.clear();
			lbValidate.setText("");
			QuanLyLoaiHangController.quanLyLoaiHangController.reload();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyLoaiHangController.quanLyLoaiHangController.closeThem();
	}

}
