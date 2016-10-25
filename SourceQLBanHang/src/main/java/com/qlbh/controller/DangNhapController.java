package com.qlbh.controller;

import java.util.Date;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.app.MainApp;
import com.qlbh.model.KeepLoggedHome;
import com.qlbh.model.NguoidungHome;
import com.qlbh.model.NhatkyHome;
import com.qlbh.pojo.Keeplogged;
import com.qlbh.pojo.Nguoidung;
import com.qlbh.pojo.Nhatky;

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
	private JFXCheckBox chbxNhoMatKhau;

	private KeepLoggedHome keepHome = new KeepLoggedHome();

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

	@FXML
	protected void initialize() {
		this.loadKeepLogged();
	}

	private void checkLogin() {
		String tenDangNhap = this.txtTenDangNhap.getText();
		String matKhau = this.txtMatKhau.getText();
		Nguoidung nd = new Nguoidung();
		NguoidungHome ndHome = new NguoidungHome();
		nd = ndHome.findByUsenamePass(tenDangNhap, matKhau);

		if (nd != null) {
			if (this.chbxNhoMatKhau.isSelected()) {
				Keeplogged keepLogged = new Keeplogged();
				keepLogged.setUsename(nd.getTennd());
				keepLogged.setPass(nd.getMatkhau());
				keepLogged.setActivity(true);
				keepHome.save(keepLogged);
			}
			this.saveNhatKy(nd);
			MainApp.setUserLogin(nd);
		} else {
			this.lblError.setText("Tên đăng nhập hoặc mật khẩu không đúng.");
		}
	}

	private void loadKeepLogged() {
		Keeplogged keepLogged = new Keeplogged();
		keepLogged = keepHome.findFirst();
		if (keepLogged != null) {
			this.txtTenDangNhap.setText(keepLogged.getUsename());
			this.txtMatKhau.setText(keepLogged.getPass());
		}
	}

	private void saveNhatKy(Nguoidung nd) {
		NhatkyHome nhatkyHome = new NhatkyHome();
		Nhatky nhatky = new Nhatky();
		nhatky.setActivity(true);
		nhatky.setHanhdong("Đăng nhập");
		nhatky.setNguoidung(nd.getMand() + " - " + nd.getTennd());
		nhatky.setBang("Người dùng");
		nhatky.setNgay(new Date());
		nhatkyHome.save(nhatky);
	}
}
