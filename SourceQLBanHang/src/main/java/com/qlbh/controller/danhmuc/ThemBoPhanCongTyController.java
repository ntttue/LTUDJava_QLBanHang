package com.qlbh.controller.danhmuc;

import com.jfoenix.controls.JFXButton;
import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Tygia;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ThemBoPhanCongTyController {
	@FXML
	private TextField txtMa, txtTen, txtGhiChu;
	@FXML
	private JFXButton btnDong;
	@FXML
	private Label lblError;

	@FXML
	public void onButtonLuuClick() {
		if(this.txtMa.getLength() == 0 || this.txtTen.getLength()==0){
			this.lblError.setText("Vui lòng điền đủ thông tin trong các mục (*)");
		}
		Tygia tyGia = new Tygia();
		tyGia.setMa(this.txtMa.getText());
		tyGia.setTen(this.txtTen.getText());
		tyGia.setActivity(true);

		TygiaHome tyGiaHome = new TygiaHome();
		tyGiaHome.save(tyGia);

		TyGiaController.tyGiaController.onTyGiaAdded();
	}

	@FXML
	public void onButtonDongClick() {
		Stage stage = (Stage) btnDong.getScene().getWindow();
		stage.close();
	}
}
