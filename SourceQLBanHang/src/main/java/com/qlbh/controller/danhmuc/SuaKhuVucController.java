package com.qlbh.controller.danhmuc;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.KhuvucHome;
import com.qlbh.pojo.Khuvuc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SuaKhuVucController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtGhiChu;

	final static Logger logger = Logger.getLogger(SuaKhuVucController.class);

	private Khuvuc kv;

	public void setKhuVuc(Khuvuc kv) {
		this.kv = kv;
		txtMa.setText(kv.getMa());
		txtTen.setText(kv.getTen());
		txtGhiChu.setText(kv.getGhichu());
	}

	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}
		kv.setMa(txtMa.getText());
		kv.setTen(txtTen.getText());
		kv.setGhichu(txtGhiChu.getText());
		KhuvucHome kvh = new KhuvucHome();
		try {
			kvh.update(kv);
			QuanLyKhuVucController.quanLyKhuVucController.closeSua();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyKhuVucController.quanLyKhuVucController.closeSua();
	}
}
