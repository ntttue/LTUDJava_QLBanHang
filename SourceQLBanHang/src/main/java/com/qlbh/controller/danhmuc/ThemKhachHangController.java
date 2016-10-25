package com.qlbh.controller.danhmuc;

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
import javafx.scene.text.Text;

public class ThemKhachHangController {
	private KhachhangHome khachHangHome = new KhachhangHome();
	@FXML
	private JFXRadioButton radioButtonKhachLe, radioButtonDaiLy;
	@FXML
	private TextField txtMa, txtTen, txtNguoiLienHe, txtDiaChi, numDienThoai, txtEmail, numNoHienTai, numGioiHanNo,
	txtNganHang, txtSoTaiKhoan, txtMaSoThue, txtSkype;
	@FXML
	private Text txtInputValidate;
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
		this.setTestData();
	}
	private void setTestData() {
		txtMa.setText(khachHangHome.getNewID());
		txtTen.setText("Trần Văn Khánh");
		txtNguoiLienHe.setText("Nguyễn Văn A");
		txtDiaChi.setText("227, Nguyễn Văn Cừ, Phường 9, Quận 5, TP.HCM");
		numDienThoai.setText("0986543345");
		txtEmail.setText("vana@gmail.com");
		txtNganHang.setText("VietcomBank");
		txtSoTaiKhoan.setText("KHONGBIET0021");
		txtMaSoThue.setText("THUE0098EF");
		txtSkype.setText("nickSkypeNè");
	}
	@FXML
	public void onButtonLuuClick() {
		// Check validate
		if (DataInputUtils.isEmpty(txtMa) || DataInputUtils.isEmpty(txtTen)) {
			txtInputValidate.setText("Vui lòng điền đủ thông tin trong các mục (*)");
			return;
		}
		txtInputValidate.setText("");
		Khachhang khachHang = new Khachhang();
		khachHang.setMa(DataInputUtils.getStringFromTextField(txtMa));
		khachHang.setTen(DataInputUtils.getStringFromTextField(txtTen));
		khachHang.setNguoilienhe(DataInputUtils.getStringFromTextField(txtNguoiLienHe));
		khachHang.setDiachi(DataInputUtils.getStringFromTextField(txtDiaChi));
		khachHang.setDienthoai(DataInputUtils.getStringFromTextField(numDienThoai));
		khachHang.setEmail(DataInputUtils.getStringFromTextField(txtEmail));		
		khachHang.setNganhang(DataInputUtils.getStringFromTextField(txtNganHang));
		khachHang.setTaikhoan(DataInputUtils.getStringFromTextField(txtSoTaiKhoan));
		khachHang.setMasothue(DataInputUtils.getStringFromTextField(txtMaSoThue));
		khachHang.setSkype(DataInputUtils.getStringFromTextField(txtSkype));

		khachHang.setGioihanno(DataInputUtils.getBigDecimalFromTextField(numGioiHanNo));
		khachHang.setNohientai(DataInputUtils.getBigDecimalFromTextField(numNoHienTai));
		
		khachHang.setKhuvuc(cbxKhuVuc.getValue());
		khachHang.setLoaikhachhang(cbxLoaiKhachHang.getValue());
		
		khachHang.setActivity(true);
		
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
		cbxKhuVuc.getSelectionModel().select(0);
	}
	private void setcbxLoaiKhachHang() {
		cbxLoaiKhachHang.setItems(this.getDSLoaiKhachHang());
		cbxLoaiKhachHang.getSelectionModel().select(0);
	}
}
