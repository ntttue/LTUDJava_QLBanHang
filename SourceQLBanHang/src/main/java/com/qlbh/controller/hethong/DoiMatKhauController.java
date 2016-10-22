package com.qlbh.controller.hethong;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.qlbh.app.MainApp;
import com.qlbh.controller.common.DialogController;
import com.qlbh.model.NguoidungHome;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
			Stage stage = (Stage) btnCancel.getScene().getWindow();
			MainApp.loginUser.setMatkhau(txtMatKhauMoi.getText());
			nguoiDungHome.saveOrUpdate(MainApp.loginUser);
			lbValidate.setText("");
			stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

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
