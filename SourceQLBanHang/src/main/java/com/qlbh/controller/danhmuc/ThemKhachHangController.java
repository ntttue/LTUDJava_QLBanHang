package com.qlbh.controller.danhmuc;

import java.util.List;

import com.jfoenix.controls.JFXRadioButton;
import com.qlbh.model.KhuvucHome;
import com.qlbh.pojo.Khuvuc;

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
	private TextField txtMa, txtTen, txtDiaChi, numDienThoai, txtEmail, numNoHienTai, numGioiHanNo,
	numFax, txtWebsite, txtNganHang, txtMaSoThue, txtSkype, numChietKhau;
	@FXML
	private ComboBox<Khuvuc> cbxKhuVuc;
	@FXML
	protected void initialize() {
		final ToggleGroup group = new ToggleGroup();
		this.radioButtonKhachLe.setToggleGroup(group);
		this.radioButtonDaiLy.setToggleGroup(group);
		this.setcbxKhuVuc();
	}
	@FXML
	public void onButtonLuuClick() {
		
	}
	@FXML
	public void onButtonDongClick() {
		
	}
	@SuppressWarnings("unchecked")
	private ObservableList<Khuvuc> getDSKhuVuc() {
		KhuvucHome khuvucHome = new KhuvucHome();
		List<Khuvuc> khuvucs = khuvucHome.findAll();
		ObservableList<Khuvuc> oListKhuVuc = FXCollections.observableList(khuvucs);
		return oListKhuVuc;
	}
	private void setcbxKhuVuc() {
		cbxKhuVuc.setItems(this.getDSKhuVuc());
	}
}
