package com.qlbh.controller.danhmuc;

import com.jfoenix.controls.JFXRadioButton;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class ThemKhachHangController {
	@FXML
	private JFXRadioButton radioButtonKhachLe, radioButtonDaiLy;
	@FXML
	protected void initialize() {
		final ToggleGroup group = new ToggleGroup();
		this.radioButtonKhachLe.setToggleGroup(group);
		this.radioButtonDaiLy.setToggleGroup(group);
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
