package com.qlbh.controller.danhmuc;

import java.math.BigDecimal;
import java.util.List;

import com.jfoenix.controls.JFXRadioButton;
import com.qlbh.model.KhachhangHome;
import com.qlbh.model.KhuvucHome;
import com.qlbh.model.LoaikhachhangHome;
import com.qlbh.pojo.Khachhang;
import com.qlbh.pojo.Khuvuc;
import com.qlbh.pojo.Loaikhachhang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ThemKhachHangController {
	@FXML
	private JFXRadioButton radioButtonKhachLe, radioButtonDaiLy;
	@FXML
	private TextField txtMa, txtTen, txtNguoiLienHe, txtDiaChi, numDienThoai, txtEmail, numNoHienTai, numGioiHanNo,
	txtNganHang, txtMaSoThue, txtSkype, numChietKhau;
	@FXML
	private ComboBox<Khuvuc> cbxKhuVuc;
	private ToggleGroup groupLoaiKhachHang;
	@FXML
	protected void initialize() {
		this.setGroupCheckBoxLoaiKH();
		this.setcbxKhuVuc();
	}
	@FXML
	public void onButtonLuuClick() {
		Khachhang khachHang = new Khachhang();
		khachHang.setMa(txtMa.getText());
		khachHang.setTen(txtTen.getText());
		khachHang.setNguoilienhe(txtNguoiLienHe.getText());
		khachHang.setDiachi(txtDiaChi.getText());
		khachHang.setDienthoai(numDienThoai.getText());
		khachHang.setEmail(txtEmail.getText());
		khachHang.setNohientai(BigDecimal.valueOf(Float.valueOf(numNoHienTai.getText())));
		khachHang.setGioihanno(BigDecimal.valueOf(Float.valueOf(numGioiHanNo.getText())));
		khachHang.setNganhang(txtNganHang.getText());
		khachHang.setMasothue(txtMaSoThue.getText());
		khachHang.setSkype(txtSkype.getText());
		khachHang.setKhuvuc(cbxKhuVuc.getValue());
		
		
		LoaikhachhangHome lkhHome = new LoaikhachhangHome();
		Loaikhachhang lkh = null;
		if ( radioButtonKhachLe.isSelected() ) {
			lkh = lkhHome.findById(1);
		}
		if ( radioButtonDaiLy.isSelected() ) {
			lkh = lkhHome.findById(2);
		}
		khachHang.setLoaikhachhang(lkh);
		KhachhangHome khachHangHome = new KhachhangHome();
		khachHangHome.save(khachHang);
		KhachHangController.khachHangController.onKhachHangAdded();
	}
	@FXML
	public void onButtonDongClick() {
		KhachHangController.khachHangController.closeManHinhThemKhachHang();
	}
	@SuppressWarnings("unchecked")
	private ObservableList<Khuvuc> getDSKhuVuc() {
		KhuvucHome khuvucHome = new KhuvucHome();
		List<Khuvuc> khuvucs = khuvucHome.findAll();
		ObservableList<Khuvuc> oListKhuVuc = FXCollections.observableList(khuvucs);
		return oListKhuVuc;
	}
	private void setGroupCheckBoxLoaiKH() {
		this.groupLoaiKhachHang = new ToggleGroup();
		this.radioButtonKhachLe.setToggleGroup(this.groupLoaiKhachHang);
		this.radioButtonDaiLy.setToggleGroup(this.groupLoaiKhachHang);
	}
	private void setcbxKhuVuc() {
		cbxKhuVuc.setItems(this.getDSKhuVuc());
		//cbxKhuVuc.getSelectionModel().select(1);
	}
}
