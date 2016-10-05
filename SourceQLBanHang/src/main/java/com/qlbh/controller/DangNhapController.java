package com.qlbh.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.app.MainApp;
import com.qlbh.model.NguoidungHome;
import com.qlbh.pojo.Nguoidung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class DangNhapController {
	@FXML
	private AnchorPane mainAnchor;
	@FXML
	private JFXButton btnDangNhap;
	@FXML
	private JFXTextField txtTenDangNhap;
	@FXML
	private JFXPasswordField txtMatKhau;
	@FXML
	private StackPane stackPane;
	@FXML
	private Label lblError;

	@FXML
	void btnDangNhapClick(ActionEvent event) {
		this.checkLogin();
	}

	@FXML
	void onEnter(KeyEvent e) {
		if (e.getCode().toString().equals("ENTER")) {
			this.checkLogin();
		}
	}

	private void checkLogin() {
		String tenDangNhap = this.txtTenDangNhap.getText();
		String matKhau = this.txtMatKhau.getText();
		Nguoidung nd = new Nguoidung();
		NguoidungHome ndHome = new NguoidungHome();
		nd = ndHome.findByUsenamePass(tenDangNhap, matKhau);

		if (nd != null) {
			MainApp.setUserLogin(nd);
		} else {
			this.lblError.setText("Tên đăng nhập hoặc mật khẩu không đúng.");
		}
	}
}
