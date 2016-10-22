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

public class ThemKhachHangController {
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
		this.setTestData();
	}
	private void setTestData() {
		txtMa.setText("KH0000");
		txtTen.setText("Trần Văn Khánh");
		txtNguoiLienHe.setText("Nguyễn Văn A");
		txtDiaChi.setText("227, Nguyễn Văn Cừ, Phường 9, Quận 5, TP.HCM");
		numDienThoai.setText("0986543345");
		txtEmail.setText("vana@gmail.com");
		txtNganHang.setText("VietcomBank");
		txtSoTaiKhoan.setText("KHONGBIET0021");
		txtMaSoThue.setText("THUE0098EF");
		txtSkype.setText("nickSkypeNè");
		numChietKhau.setText("12");
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
		
		String textNoHienTai = numNoHienTai.getText();
		if ( textNoHienTai == null || textNoHienTai.trim().isEmpty()) {
			khachHang.setNohientai(BigDecimal.valueOf(0));
		} else {
			khachHang.setNohientai(BigDecimal.valueOf(Float.valueOf(textNoHienTai)));
		}
		
		String textGioiHanNo = numGioiHanNo.getText();
		if ( textGioiHanNo == null || textGioiHanNo.trim().isEmpty()) {
			khachHang.setGioihanno(BigDecimal.valueOf(0));
		} else {
			khachHang.setGioihanno(BigDecimal.valueOf(Float.valueOf(textGioiHanNo)));
		}
		
		khachHang.setNganhang(txtNganHang.getText());
		khachHang.setTaikhoan(txtSoTaiKhoan.getText());
		khachHang.setMasothue(txtMaSoThue.getText());
		khachHang.setSkype(txtSkype.getText());
		khachHang.setKhuvuc(cbxKhuVuc.getValue());
		khachHang.setLoaikhachhang(cbxLoaiKhachHang.getValue());
		khachHang.setActivity(true);
		
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
