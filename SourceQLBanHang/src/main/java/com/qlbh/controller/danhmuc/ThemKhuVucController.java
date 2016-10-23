package com.qlbh.controller.danhmuc;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.KhuvucHome;
import com.qlbh.pojo.Khuvuc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThemKhuVucController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtGhiChu;

	final static Logger logger = Logger.getLogger(ThemKhuVucController.class);

	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}
		Khuvuc kv = new Khuvuc();
		kv.setMa(txtMa.getText());
		kv.setTen(txtTen.getText());
		kv.setGhichu(txtGhiChu.getText());
		kv.setActivity(true);
		KhuvucHome kvh = new KhuvucHome();
		try {
			kvh.save(kv);
			txtMa.clear();
			txtTen.clear();
			txtGhiChu.clear();
			lbValidate.setText("");
			QuanLyKhuVucController.quanLyKhuVucController.reload();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyKhuVucController.quanLyKhuVucController.closeThem();
	}

}
