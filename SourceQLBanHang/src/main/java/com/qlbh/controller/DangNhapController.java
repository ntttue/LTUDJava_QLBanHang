package com.qlbh.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.NguoidungHome;
import com.qlbh.pojo.Nguoidung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class DangNhapController implements Initializable {

	@FXML
	private JFXButton btnDangNhap;

	@FXML
	private JFXTextField txtTenDangNhap;

	@FXML
	private JFXPasswordField txtMatKhau;

	@FXML
	private StackPane stackPane;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	void btnDangNhapClick(ActionEvent event) {
		System.out
				.println("com.qlbh.controller.DangNhapController.btnDangNhapClick()");
		String tenDangNhap = this.txtTenDangNhap.getText();
		String matKhau = this.txtMatKhau.getText();
		Nguoidung nd = new Nguoidung();
		NguoidungHome ndHome = new NguoidungHome();
		nd = ndHome.findByUsenamePass(tenDangNhap, matKhau);

		if (nd != null) {
//			JFXDialog dialog = new JFXDialog(stackPane, new Label("Hello"),
//					JFXDialog.DialogTransition.CENTER);
//			dialog.show();
	}
	}

}
