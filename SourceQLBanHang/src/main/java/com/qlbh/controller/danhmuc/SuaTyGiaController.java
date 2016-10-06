package com.qlbh.controller.danhmuc;

import com.jfoenix.controls.JFXCheckBox;
import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataInputUtils;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SuaTyGiaController {
	@FXML
	private TextField txtMa, txtTen, numTyGiaQuyDoi;
	@FXML
	private JFXCheckBox checkBoxConQuanLy;
	@FXML
	protected void initialize() {
		DataInputUtils.setFloatOnlyForTextField(this.numTyGiaQuyDoi);
	}
	@FXML
	public void onButtonLuuClick() {
		System.out.println("SuaTyGiaController: Clicked on button Lưu");
		Tygia tyGia = new Tygia();
		tyGia.setMa(this.txtMa.getText());
		tyGia.setTen(this.txtTen.getText());
		tyGia.setTygiaquydoi(Float.parseFloat(this.numTyGiaQuyDoi.getText()));
		tyGia.setActivite(checkBoxConQuanLy.isSelected());
		
		TygiaHome tyGiaHome = new TygiaHome();
		tyGiaHome.saveOrUpdate(tyGia);
		
		TyGiaController.tyGiaController.onTyGiaAdded();
	}
	@FXML
	public void onButtonDongClick() {
		System.out.println("SuaTyGiaController: Clicked on button Đóng");
		TyGiaController.tyGiaController.closeManHinhSuaTyGia();
	}
}
