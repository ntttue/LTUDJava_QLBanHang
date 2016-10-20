package com.qlbh.controller.danhmuc;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.LoaihangHome;
import com.qlbh.pojo.Loaihang;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SuaLoaiHangController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtGhiChu;

	final static Logger logger = Logger.getLogger(SuaLoaiHangController.class);

	private Loaihang lh;
	
	public void setLoaiHang(Loaihang lh) {
		this.lh = lh;
		txtMa.setText(lh.getMa());
		txtTen.setText(lh.getTen());
		txtGhiChu.setText(lh.getGhichu());
	}
	
	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}
		lh.setMa(txtMa.getText());
		lh.setTen(txtTen.getText());
		lh.setGhichu(txtGhiChu.getText());
		LoaihangHome lhh = new LoaihangHome();
		try {
			lhh.update(lh);
			QuanLyLoaiHangController.quanLyLoaiHangController.closeSua();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyLoaiHangController.quanLyLoaiHangController.closeSua();
	}
}
