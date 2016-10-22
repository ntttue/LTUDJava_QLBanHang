package com.qlbh.controller.hethong;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.qlbh.app.MainApp;
import com.qlbh.model.NguoidungHome;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DoiMatKhauController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXPasswordField txtMatKhauCu, txtNhapLaiMatKhau, txtMatKhauMoi;
	private NguoidungHome nguoiDungHome = new NguoidungHome();

	final static Logger logger = Logger.getLogger(DoiMatKhauController.class);

	@FXML
	void btnSaveClick() {
		if (txtMatKhauCu.getLength() == 0 || txtMatKhauMoi.getLength() == 0 || txtNhapLaiMatKhau.getLength() == 0) {
			lbValidate.setText("Vui lòng điền đủ thông tin trong các mục (*)");
			return;
		}
		if (txtMatKhauMoi.getLength() < 4) {
			lbValidate.setText("Mật khẩu phải nhiều hơn 4 ký tự.");
			return;
		}
		if (!txtMatKhauMoi.getText().equals(txtNhapLaiMatKhau.getText())) {
			System.out.println(txtMatKhauMoi.getText());
			System.out.println(txtNhapLaiMatKhau.getText());
			lbValidate.setText("Mật khẩu mới nhập lại không giống nhau.");
			return;
		}
		if (!MainApp.loginUser.getMatkhau().equals(txtMatKhauCu.getText())) {
			System.out.println(MainApp.loginUser.getMatkhau());
			System.out.println(txtMatKhauCu.getText());
			lbValidate.setText("Mật khẩu cũ nhập không đúng.");
			return;
		}

		try {
			MainApp.loginUser.setMatkhau(txtMatKhauMoi.getText());
			nguoiDungHome.saveOrUpdate(MainApp.loginUser);
			lbValidate.setText("");
			// JFXDialog dialog = new JFXDialog(stackPane, new Label("Cập nhật
			// mật khẩu thành công."),
			// JFXDialog.DialogTransition.CENTER);
			// dialog.show();

		} catch (Exception ex) {
			logger.error("Cập nhật mật khẩu người dùng bị lỗi : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		// QuanLyDonViTinhController.quanLyDonViTinhController.closeThem();
	}

}
