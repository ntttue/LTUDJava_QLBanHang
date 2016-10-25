package com.qlbh.controller.hethong;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.qlbh.app.MainApp;
import com.qlbh.model.NguoidungHome;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
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
	private boolean doiMatKhauThanhCong = false;

	@FXML
	void btnSaveClick() {
		this.savePass();
	}

	private void savePass() {
		this.setDoiMatKhauThanhCong(false);
		if (txtMatKhauCu.getLength() == 0 || txtMatKhauMoi.getLength() == 0 || txtNhapLaiMatKhau.getLength() == 0) {
			lbValidate.setText("Vui lòng điền đủ thông tin trong các mục (*)");
			return;
		}
		if (txtMatKhauMoi.getLength() < 4) {
			lbValidate.setText("Mật khẩu phải nhiều hơn 4 ký tự.");
			return;
		}
		if (!txtMatKhauMoi.getText().equals(txtNhapLaiMatKhau.getText())) {
			lbValidate.setText("Mật khẩu mới nhập lại không giống nhau.");
			return;
		}
		if (!MainApp.loginUser.getMatkhau().equals(txtMatKhauCu.getText())) {
			lbValidate.setText("Mật khẩu cũ nhập không đúng.");
			return;
		}

		try {
			MainApp.loginUser.setMatkhau(txtMatKhauMoi.getText());
			nguoiDungHome.update(MainApp.loginUser);
			lbValidate.setText("");
			this.setDoiMatKhauThanhCong(true);
			Stage stage = (Stage) btnCancel.getScene().getWindow();
			stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

		} catch (Exception ex) {
			logger.error("Cập nhật mật khẩu người dùng bị lỗi : \n" + ex.getMessage());
		}
	}

	@FXML
	void onKeyAction(KeyEvent e) {
		if (e.getCode().toString().equals("ENTER")) {
			this.savePass();
		}
		if (e.getCode().toString().equals("ESCAPE")) {
			this.closeStage();
		}
	}

	private void closeStage() {
		System.out.println("click cancel");
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btnCancelClick() {
		this.closeStage();
	}

	public boolean isDoiMatKhauThanhCong() {
		return doiMatKhauThanhCong;
	}

	private void setDoiMatKhauThanhCong(boolean doiMatKhauThanhCong) {
		this.doiMatKhauThanhCong = doiMatKhauThanhCong;
	}

}
