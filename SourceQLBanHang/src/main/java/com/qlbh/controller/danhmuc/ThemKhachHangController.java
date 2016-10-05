package com.qlbh.controller.danhmuc;

import com.jfoenix.controls.JFXRadioButton;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ThemKhachHangController {
	@FXML
	private JFXRadioButton radioButtonKhachLe, radioButtonDaiLy;
	@FXML
	private TextField txtMa, txtTen, txtDiaChi, numDienThoai, txtEmail, numNoHienTai, numGioiHanNo,
	numFax, txtWebsite, txtNganHang, txtMaSoThue, txtSkype, numChietKhau;
	@FXML
	protected void initialize() {
		final ToggleGroup group = new ToggleGroup();
		this.radioButtonKhachLe.setToggleGroup(group);
		this.radioButtonDaiLy.setToggleGroup(group);
	}
	@FXML
	public void onButtonLuuClick() {
		
	}
	@FXML
	public void onButtonDongClick() {
		
	}
	/*
	 * // force the field to be numeric only
    textField.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
    });
	 */
}
