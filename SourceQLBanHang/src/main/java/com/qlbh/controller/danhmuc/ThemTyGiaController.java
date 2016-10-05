package com.qlbh.controller.danhmuc;

import com.jfoenix.controls.JFXCheckBox;
import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Tygia;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ThemTyGiaController {
	@FXML
	private TextField txtMa, txtTen, numTyGiaQuyDoi;
	@FXML
	private JFXCheckBox checkBoxConQuanLy;
	@FXML
	protected void initialize() {
		this.setNumberOnlyForTextField(this.numTyGiaQuyDoi);
	}
	@FXML
	public void onButtonLuuClick() {
		System.out.println("ThemTyGiaScreen: Clicked on button Lưu");
		String ma = this.txtMa.getText();
		String ten = this.txtTen.getText();
		String tyGiaQuyDoi = this.numTyGiaQuyDoi.getText();
		Boolean conQuanLy = checkBoxConQuanLy.isSelected();
		Tygia tyGia = new Tygia();
		tyGia.setMa(ma);
		tyGia.setTen(ten);
		tyGia.setTygiaquydoi(Float.parseFloat(tyGiaQuyDoi));
		tyGia.setActivite(conQuanLy);
		TygiaHome tyGiaHome = new TygiaHome();
		tyGiaHome.saveOrUpdate(tyGia);
		TyGiaController.refreshTyGiaTableData();
		TyGiaController.closeManHinhThemTyGia();
	}
	@FXML
	public void onButtonDongClick() {
		System.out.println("ThemTyGiaScreen: Clicked on button Đóng");
		TyGiaController.closeManHinhThemTyGia();
	}
	private void setNumberOnlyForTextField(TextField textField) {
		// force the field to be numeric only
	    textField.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("\\d*")) {
	                textField.setText(newValue.replaceAll("[^\\d]", ""));
	            }
	        }
	    });
	}
}
