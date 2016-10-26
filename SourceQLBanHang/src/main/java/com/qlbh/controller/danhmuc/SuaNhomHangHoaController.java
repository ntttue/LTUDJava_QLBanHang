package com.qlbh.controller.danhmuc;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.NhomhanghoaHome;
import com.qlbh.pojo.Nhomhanghoa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SuaNhomHangHoaController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtGhiChu;

	final static Logger logger = Logger.getLogger(SuaNhomHangHoaController.class);

	private Nhomhanghoa nhh;

	public void setNhomHangHoa(Nhomhanghoa nhh) {
		this.nhh = nhh;
		txtMa.setText(nhh.getMa());
		txtTen.setText(nhh.getTen());
		txtGhiChu.setText(nhh.getGhichu());
	}

	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}
		nhh.setMa(txtMa.getText());
		nhh.setTen(txtTen.getText());
		nhh.setGhichu(txtGhiChu.getText());
		NhomhanghoaHome nhhh = new NhomhanghoaHome();
		try {
			nhhh.update(nhh);
			QuanLyNhomHangHoaController.quanLyNhomHangHoaController.closeSua();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyNhomHangHoaController.quanLyNhomHangHoaController.closeSua();
	}
}
