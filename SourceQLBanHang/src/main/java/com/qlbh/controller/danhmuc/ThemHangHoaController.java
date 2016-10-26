package com.qlbh.controller.danhmuc;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.qlbh.util.DataInputUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ThemHangHoaController {

	@FXML
	private ComboBox<?> cmbKho;

	@FXML
	private JFXCheckBox checkQuanLy;

	@FXML
	private TextField txtTen;

	@FXML
	private ComboBox<?> cmbLoaiHang;

	@FXML
	private TextField txtSLTon;

	@FXML
	private TextField txtGiaBanSi;

	@FXML
	private JFXButton btnCancel;

	@FXML
	private JFXButton btnSave;

	@FXML
	private TextField txtGiaMua;

	@FXML
	private TextField txtXuatXu;

	@FXML
	private ComboBox<?> cmbDonVi;

	@FXML
	private Text txtInputValidate;

	@FXML
	private ComboBox<?> cmbNhomHang;

	@FXML
	private ComboBox<?> cmbNhaCC;

	@FXML
	private TextField txtMa;

	@FXML
	private TextField txtGiaBanLe;
	
	@FXML
	protected void initialize() {
		
	}

	@FXML
	void onButtonLuuClick(ActionEvent event) {

	}

	@FXML
	void onButtonDongClick(ActionEvent event) {

	}

}
