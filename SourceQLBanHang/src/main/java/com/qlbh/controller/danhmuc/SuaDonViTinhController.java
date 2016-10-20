package com.qlbh.controller.danhmuc;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.DonvitinhHome;
import com.qlbh.pojo.Donvitinh;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SuaDonViTinhController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtGhiChu;

	final static Logger logger = Logger.getLogger(SuaDonViTinhController.class);

	private Donvitinh dvt;
	
	public void setDonViTinh(Donvitinh dvt) {
		this.dvt = dvt;
		txtMa.setText(dvt.getMa());
		txtTen.setText(dvt.getTen());
		txtGhiChu.setText(dvt.getGhichu());
	}
	
	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}
		dvt.setMa(txtMa.getText());
		dvt.setTen(txtTen.getText());
		dvt.setGhichu(txtGhiChu.getText());
		DonvitinhHome dvth = new DonvitinhHome();
		try {
			dvth.update(dvt);
			QuanLyDonViTinhController.quanLyDonViTinhController.closeSua();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyDonViTinhController.quanLyDonViTinhController.closeSua();
	}
}
