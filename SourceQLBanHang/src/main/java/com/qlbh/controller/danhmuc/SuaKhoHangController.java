package com.qlbh.controller.danhmuc;

import java.util.List;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.KhohangHome;
import com.qlbh.model.NhanvienHome;
import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Nhanvien;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SuaKhoHangController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtNguoiLienHe, txtDiaChi, txtDienThoai, txtFax, txtEmail, txtGhiChu;

	@FXML
	private JFXComboBox<Nhanvien> cmbNguoiQuanLy;

	final static Logger logger = Logger.getLogger(SuaKhoHangController.class);

	private Khohang kh;

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

	public void setKhoHang(Khohang kh) {
		this.kh = kh;
		txtMa.setText(kh.getMa());
		txtTen.setText(kh.getTen());
		if (kh.getNhanvien() != null) {
			cmbNguoiQuanLy.getSelectionModel().select(kh.getNhanvien());
		}
		txtNguoiLienHe.setText(kh.getNguoilienhe());
		txtDiaChi.setText(kh.getDiachi());
		txtDienThoai.setText(kh.getDienthoai());
		txtFax.setText(kh.getFax());
		txtEmail.setText(kh.getEmail());
		txtGhiChu.setText(kh.getDiengiai());
	}

	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0) {
			lbValidate.setText("Vui lòng nhập Mã và Tên");
			return;
		}
		kh.setMa(txtMa.getText());
		kh.setTen(txtTen.getText());
		if (cmbNguoiQuanLy.getValue().getId() == 0) {
			kh.setNhanvien(null);
		} else {
			kh.setNhanvien(cmbNguoiQuanLy.getValue());
		}
		kh.setNguoilienhe(txtNguoiLienHe.getText());
		kh.setDiachi(txtDiaChi.getText());
		kh.setDienthoai(txtDienThoai.getText());
		kh.setFax(txtFax.getText());
		kh.setEmail(txtEmail.getText());
		kh.setDiengiai(txtGhiChu.getText());
		KhohangHome khh = new KhohangHome();
		try {
			khh.update(kh);
			QuanLyKhoHangController.quanLyKhoHangController.closeSua();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyKhoHangController.quanLyKhoHangController.closeSua();
	}
}
