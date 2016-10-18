package com.qlbh.controller.danhmuc;

import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataInputUtils;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ThemTyGiaController {
	@FXML
	private TextField txtMa, txtTen, numTyGiaQuyDoi;
	@FXML
	protected void initialize() {
		DataInputUtils.setFloatOnlyForTextField(this.numTyGiaQuyDoi);
	}
	@FXML
	public void onButtonLuuClick() {
		System.out.println("ThemTyGiaScreen: Clicked on button Lưu");
		Tygia tyGia = new Tygia();
		tyGia.setMa(this.txtMa.getText());
		tyGia.setTen(this.txtTen.getText());
		tyGia.setTygiaquydoi(Float.parseFloat(this.numTyGiaQuyDoi.getText()));
		tyGia.setActivite(true);
		
		TygiaHome tyGiaHome = new TygiaHome();
		tyGiaHome.save(tyGia);
		
		TyGiaController.tyGiaController.onTyGiaAdded();
	}
	@FXML
	public void onButtonDongClick() {
		System.out.println("ThemTyGiaScreen: Clicked on button Đóng");
		TyGiaController.tyGiaController.closeManHinhThemTyGia();
	}
}
