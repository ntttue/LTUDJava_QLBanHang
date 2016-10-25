package com.qlbh.controller.danhmuc;

import java.util.List;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.controller.common.CheckValid;
import com.qlbh.model.KhohangHome;
import com.qlbh.model.NhanvienHome;
import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Nhanvien;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThemKhoHangController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtNguoiLienHe, txtDiaChi, txtDienThoai, txtFax, txtEmail, txtGhiChu;

	@FXML
	private JFXComboBox<Nhanvien> cmbNguoiQuanLy;

	final static Logger logger = Logger.getLogger(ThemKhoHangController.class);

	private ObservableList<Nhanvien> getDSNhanVien() {
		NhanvienHome nvh = new NhanvienHome();
		List<Nhanvien> lnv = nvh.getNhanVienList();
		Nhanvien nv = new Nhanvien();
		nv.setId(0);
		nv.setTen("-- Chọn nhân viên quản lý --");
		lnv.add(0, nv);
		ObservableList<Nhanvien> oListNV = FXCollections.observableList(lnv);
		return oListNV;
	}

	@FXML
	protected void initialize() {
		cmbNguoiQuanLy.setItems(getDSNhanVien());
		cmbNguoiQuanLy.getSelectionModel().select(0);
	}

	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}

		if (txtDienThoai.getText().isEmpty() == false && CheckValid.isValidPhoneNumber(txtDienThoai.getText()) == true) {
			lbValidate.setText("Số điện thoại không hợp lệ");
			return;
		}

		if (txtFax.getText().isEmpty() == false && CheckValid.isValidPhoneNumber(txtFax.getText()) == true) {
			lbValidate.setText("Số fax không hợp lệ");
			return;
		}

		if (txtEmail.getText().isEmpty() == false && CheckValid.isValidEmailAddress(txtEmail.getText()) == false) {
			lbValidate.setText("Email không hợp lệ");
			return;
		}

		Khohang kh = new Khohang();
		kh.setMa(txtMa.getText());
		kh.setTen(txtTen.getText());
		if (cmbNguoiQuanLy.getValue().getId() != 0)
			kh.setNhanvien(cmbNguoiQuanLy.getValue());
		kh.setNguoilienhe(txtNguoiLienHe.getText());
		kh.setDiachi(txtDiaChi.getText());
		kh.setDienthoai(txtDienThoai.getText());
		kh.setFax(txtFax.getText());
		kh.setEmail(txtEmail.getText());
		kh.setDiengiai(txtGhiChu.getText());
		kh.setActivity(true);
		KhohangHome khh = new KhohangHome();
		try {
			khh.save(kh);
			txtMa.clear();
			txtTen.clear();
			cmbNguoiQuanLy.getSelectionModel().select(0);
			txtNguoiLienHe.clear();
			txtDiaChi.clear();
			txtDienThoai.clear();
			txtFax.clear();
			txtEmail.clear();
			txtGhiChu.clear();
			lbValidate.setText("");
			QuanLyKhoHangController.quanLyKhoHangController.reload();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyKhoHangController.quanLyKhoHangController.closeThem();
	}

}
