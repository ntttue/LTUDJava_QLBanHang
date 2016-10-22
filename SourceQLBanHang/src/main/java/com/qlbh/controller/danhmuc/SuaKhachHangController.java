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
import com.qlbh.util.DataInputUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SuaKhachHangController {
	private Khachhang khachHang;
	@FXML
	private JFXRadioButton radioButtonKhachLe, radioButtonDaiLy;
	@FXML
	private TextField txtMa, txtTen, txtNguoiLienHe, txtDiaChi, numDienThoai, txtEmail, numNoHienTai, numGioiHanNo,
	txtNganHang, txtSoTaiKhoan, txtMaSoThue, txtSkype, numChietKhau;
	@FXML
	private ComboBox<Khuvuc> cbxKhuVuc;
	@FXML
	private ComboBox<Loaikhachhang> cbxLoaiKhachHang;
	@FXML
	protected void initialize() {
		this.setcbxKhuVuc();
		this.setcbxLoaiKhachHang();
		DataInputUtils.setFloatOnlyForTextField(this.numNoHienTai);
		DataInputUtils.setFloatOnlyForTextField(this.numGioiHanNo);
		DataInputUtils.setIntegerOnlyForTextField(this.numChietKhau);
	}
	public void setKhachhang(Khachhang kh) {
		this.khachHang = kh;
		this.setKhachHangData(kh);
	}
	private void setKhachHangData(Khachhang kh) {
		txtMa.setText(kh.getMa());
		txtTen.setText(kh.getTen());
		txtNguoiLienHe.setText(kh.getNguoilienhe());
		txtDiaChi.setText(kh.getDiachi());
		numDienThoai.setText(kh.getDienthoai());
		txtEmail.setText(kh.getEmail());
		txtNganHang.setText(kh.getNganhang());
		txtSoTaiKhoan.setText(kh.getTaikhoan());
		txtMaSoThue.setText(kh.getMasothue());
		txtSkype.setText(kh.getSkype());
		numNoHienTai.setText(String.valueOf(kh.getNohientai()));
		numGioiHanNo.setText(kh.getGioihanno().toString());
		cbxLoaiKhachHang.getSelectionModel().select(kh.getLoaikhachhang());
		if ( kh.getKhuvuc() != null ) {
			cbxKhuVuc.getSelectionModel().select(kh.getKhuvuc());
		}
	}
	@FXML
	public void onButtonLuuClick() {
		this.khachHang.setMa(txtMa.getText());
		this.khachHang.setTen(txtTen.getText());
		this.khachHang.setNguoilienhe(txtNguoiLienHe.getText());
		this.khachHang.setDiachi(txtDiaChi.getText());
		this.khachHang.setDienthoai(numDienThoai.getText());
		this.khachHang.setEmail(txtEmail.getText());
		
		String textNoHienTai = numNoHienTai.getText();
		if ( textNoHienTai == null || textNoHienTai.trim().isEmpty()) {
			this.khachHang.setNohientai(BigDecimal.valueOf(0.0));
		} else {
			this.khachHang.setNohientai(BigDecimal.valueOf(Float.valueOf(textNoHienTai)));
		}
		
		String textGioiHanNo = numGioiHanNo.getText();
		if ( textGioiHanNo == null || textGioiHanNo.trim().isEmpty()) {
			this.khachHang.setGioihanno(BigDecimal.valueOf(0.0));
		} else {
			this.khachHang.setGioihanno(BigDecimal.valueOf(Float.valueOf(textGioiHanNo)));
		}
		
		this.khachHang.setNganhang(txtNganHang.getText());
		this.khachHang.setTaikhoan(txtSoTaiKhoan.getText());
		this.khachHang.setMasothue(txtMaSoThue.getText());
		this.khachHang.setSkype(txtSkype.getText());
		this.khachHang.setKhuvuc(cbxKhuVuc.getValue());
		this.khachHang.setLoaikhachhang(cbxLoaiKhachHang.getValue());
		
		KhachhangHome khachHangHome = new KhachhangHome();
		khachHangHome.update(this.khachHang);
		KhachHangController.khachHangController.onKhachHangUpdated();
	}
	@FXML
	public void onButtonDongClick() {
		KhachHangController.khachHangController.closeManHinhSuaKhachHang();
	}
	@SuppressWarnings("unchecked")
	private ObservableList<Khuvuc> getDSKhuVuc() {
		KhuvucHome khuvucHome = new KhuvucHome();
		List<Khuvuc> khuvucs = khuvucHome.findAll();
		ObservableList<Khuvuc> oListKhuVuc = FXCollections.observableList(khuvucs);
		return oListKhuVuc;
	}
	@SuppressWarnings("unchecked")
	private ObservableList<Loaikhachhang> getDSLoaiKhachHang() {
		LoaikhachhangHome lkhHome = new LoaikhachhangHome();
		List<Loaikhachhang> lkhs = lkhHome.findAll();
		ObservableList<Loaikhachhang> oListLKH = FXCollections.observableList(lkhs);
		return oListLKH;
	}
	private void setcbxKhuVuc() {
		cbxKhuVuc.setItems(this.getDSKhuVuc());
		//cbxKhuVuc.getSelectionModel().select(1);
	}
	private void setcbxLoaiKhachHang() {
		cbxLoaiKhachHang.setItems(this.getDSLoaiKhachHang());
		cbxLoaiKhachHang.getSelectionModel().select(0);
	}
}
