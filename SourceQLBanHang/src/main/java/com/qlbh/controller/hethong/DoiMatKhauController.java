package com.qlbh.controller.hethong;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.qlbh.app.MainApp;
import com.qlbh.model.NguoidungHome;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DoiMatKhauController {
	@FXML
	private StackPane stackPane = new StackPane();
	@FXML
	private JFXButton btnSave, btnCancel;
	@FXML
	private Label lbValidate;
	@FXML
	private AnchorPane root;
	@FXML
	private JFXPasswordField txtMatKhauCu, txtNhapLaiMatKhau, txtMatKhauMoi;
	
	private NguoidungHome nguoiDungHome = new NguoidungHome();
	final static Logger logger = Logger.getLogger(DoiMatKhauController.class);

	@FXML
	void btnSaveClick() {
		System.out.println("save click");
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
			Stage stage = (Stage) btnCancel.getScene().getWindow();
			stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
			// DialogController.show(root, null, "Thông báo", "Đổi mật khẩu
			// thành công.", true);

		} catch (Exception ex) {
			logger.error("Cập nhật mật khẩu người dùng bị lỗi : \n" + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		System.out.println("click cancel");
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		// do what you have to do
		stage.close();
	}

}
