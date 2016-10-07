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
	private Tygia tygia;
	@FXML
	protected void initialize() {
		DataInputUtils.setFloatOnlyForTextField(this.numTyGiaQuyDoi);
	}
	@FXML
	public void onButtonLuuClick() {
		System.out.println("SuaTyGiaController: Clicked on button Lưu");
		this.tygia.setMa(this.txtMa.getText());
		this.tygia.setTen(this.txtTen.getText());
		this.tygia.setTygiaquydoi(Float.parseFloat(this.numTyGiaQuyDoi.getText()));
		this.tygia.setActivite(checkBoxConQuanLy.isSelected());
		
		TygiaHome tyGiaHome = new TygiaHome();
		tyGiaHome.update(this.tygia);
		System.out.println("Luu TyGia: " + this.tygia.getId());
		TyGiaController.tyGiaController.onTyGiaUpdated();
	}
	public void setTyGia(Tygia tygia) {
		this.tygia = tygia;
		System.out.println("setTyGia");
		System.out.println("TyGia: " + tygia.getTen());
		this.txtMa.setText(tygia.getMa());
		this.txtTen.setText(tygia.getTen());
		this.numTyGiaQuyDoi.setText(tygia.getTygiaquydoi().toString());
		this.checkBoxConQuanLy.setSelected(tygia.getActivite());
	}
	@FXML
	public void onButtonDongClick() {
		System.out.println("SuaTyGiaController: Clicked on button Đóng");
		TyGiaController.tyGiaController.closeManHinhSuaTyGia();
	}
}
