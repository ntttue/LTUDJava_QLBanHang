package com.qlbh.controller;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.NguoidungHome;
import com.qlbh.pojo.Nguoidung;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class DangNhapController {
	final static Logger logger = Logger.getLogger(DangNhapController.class);
	@FXML
	private JFXButton btnDangNhap;
	@FXML
	private JFXTextField txtTenDangNhap;

	@FXML
	private JFXPasswordField txtMatKhau;
	@FXML
	private StackPane stackPane;

	@FXML
	void btnDangNhapClick(ActionEvent event) {
		System.out.println("You clicked me!");
		System.out.println("com.qlbh.controller.DangNhapController.btnDangNhapClick()");
		String tenDangNhap = this.txtTenDangNhap.getText();
		String matKhau = this.txtMatKhau.getText();
		Nguoidung nd = new Nguoidung();
		nd.setTennd("abc");
		nd.setMand("123");
		NguoidungHome ndHome = new NguoidungHome();
		ndHome.create(nd);
		// nd = ndHome.findByUsenamePass(tenDangNhap, matKhau);

		if (nd != null) {
			JFXDialog dialog = new JFXDialog(stackPane, new Label("Hello " + nd.getTennd()),
					JFXDialog.DialogTransition.CENTER);
			dialog.show();
		} else {
			JFXDialog dialog = new JFXDialog(stackPane, new Label("Tên đăng nhập hoặc mật khẩu không chính xác!"),
					JFXDialog.DialogTransition.CENTER);
			dialog.show();
		}
	}
}
