package com.qlbh.controller.danhmuc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.jfoenix.controls.JFXRadioButton;
import com.qlbh.controller.common.Display;
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

public class SuaKhachHangController {
	private Khachhang khachHang;
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
	}
	public void setKhachhang(Khachhang kh) {
		this.khachHang = kh;
		this.setKhachHangData(kh);
	}
	private void setKhachHangData(Khachhang kh) {
		txtMa.setText(DataInputUtils.getStringValue(kh.getMa()));
		txtTen.setText(DataInputUtils.getStringValue(kh.getTen()));
		txtNguoiLienHe.setText(DataInputUtils.getStringValue(kh.getNguoilienhe()));
		txtDiaChi.setText(DataInputUtils.getStringValue(kh.getDiachi()));
		numDienThoai.setText(DataInputUtils.getStringValue(kh.getDienthoai()));
		txtEmail.setText(DataInputUtils.getStringValue(kh.getEmail()));
		txtNganHang.setText(DataInputUtils.getStringValue(kh.getNganhang()));
		txtSoTaiKhoan.setText(DataInputUtils.getStringValue(kh.getTaikhoan()));
		txtMaSoThue.setText(DataInputUtils.getStringValue(kh.getMasothue()));
		txtSkype.setText(DataInputUtils.getStringValue(kh.getSkype()));
		
		BigDecimal noHienTai = kh.getNohientai().setScale(2, RoundingMode.HALF_UP);
		numNoHienTai.setText(Display.formatMoney(noHienTai));
		BigDecimal gioiHanNo = kh.getGioihanno().setScale(2, RoundingMode.HALF_UP);
		numGioiHanNo.setText(Display.formatMoney(gioiHanNo));
		
		if ( kh.getLoaikhachhang() != null ) {
			cbxLoaiKhachHang.getSelectionModel().select(kh.getLoaikhachhang());
		}
		if ( kh.getKhuvuc() != null ) {
			cbxKhuVuc.getSelectionModel().select(kh.getKhuvuc());
		}
	}
	@FXML
	public void onButtonLuuClick() {
		// Check validate
		if (DataInputUtils.isEmpty(txtMa) || DataInputUtils.isEmpty(txtTen)) {
			txtInputValidate.setText("Vui lòng điền đủ thông tin trong các mục (*)");
			return;
		}
		txtInputValidate.setText("");
		this.khachHang.setMa(DataInputUtils.getStringFromTextField(txtMa));
		this.khachHang.setTen(DataInputUtils.getStringFromTextField(txtTen));
		this.khachHang.setNguoilienhe(DataInputUtils.getStringFromTextField(txtNguoiLienHe));
		this.khachHang.setDiachi(DataInputUtils.getStringFromTextField(txtDiaChi));
		this.khachHang.setDienthoai(DataInputUtils.getStringFromTextField(numDienThoai));
		this.khachHang.setEmail(DataInputUtils.getStringFromTextField(txtEmail));		
		this.khachHang.setNganhang(DataInputUtils.getStringFromTextField(txtNganHang));
		this.khachHang.setTaikhoan(DataInputUtils.getStringFromTextField(txtSoTaiKhoan));
		this.khachHang.setMasothue(DataInputUtils.getStringFromTextField(txtMaSoThue));
		this.khachHang.setSkype(DataInputUtils.getStringFromTextField(txtSkype));

		this.khachHang.setGioihanno(DataInputUtils.getBigDecimalFromTextField(numGioiHanNo));
		this.khachHang.setNohientai(DataInputUtils.getBigDecimalFromTextField(numNoHienTai));
		
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
		cbxKhuVuc.getSelectionModel().select(0);
	}
	private void setcbxLoaiKhachHang() {
		cbxLoaiKhachHang.setItems(this.getDSLoaiKhachHang());
		cbxLoaiKhachHang.getSelectionModel().select(0);
	}
}
