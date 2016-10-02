package com.qlbh.controller.danhmuc;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.DonvitinhHome;
import com.qlbh.pojo.Donvitinh;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThemDonViTinhController {

	@FXML
	private JFXButton btnCancel;

	@FXML
	private JFXButton btnSave;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtGhiChu;

	@FXML
	private JFXTextField txtMa;

	@FXML
	private JFXTextField txtTen;

	final static Logger logger = Logger.getLogger(ThemDonViTinhController.class);

	@FXML
	void btnSaveClick(ActionEvent event) {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}
		Donvitinh dvt = new Donvitinh();
		dvt.setMa(txtMa.getText());
		dvt.setTen(txtTen.getText());
		dvt.setGhichu(txtGhiChu.getText());

		DonvitinhHome dvth = new DonvitinhHome();
		try {
			dvth.create(dvt);
			txtMa.clear();
			txtTen.clear();
			txtGhiChu.clear();
			lbValidate.setText("");
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick(ActionEvent event) {
		
	}

}
