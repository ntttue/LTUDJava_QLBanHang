package com.qlbh.controller.danhmuc;

import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataInputUtils;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ThemTyGiaController {
	@FXML
	private TextField txtMa, txtTen, numTyGiaQuyDoi;
	@FXML
	private Text txtInputValidate;
	@FXML
	protected void initialize() {
		DataInputUtils.setFloatOnlyForTextField(this.numTyGiaQuyDoi);
	}
	@FXML
	public void onButtonLuuClick() {
		// Check validate
		if ( DataInputUtils.isEmpty(txtMa) || DataInputUtils.isEmpty(txtTen) || DataInputUtils.isEmpty(numTyGiaQuyDoi) ) {
			txtInputValidate.setText("Vui lòng điền đủ các mục (*)");
			return;
		}
		txtInputValidate.setText("");
		Tygia tyGia = new Tygia();
		tyGia.setMa(DataInputUtils.getStringFromTextField(txtMa));
		tyGia.setTen(DataInputUtils.getStringFromTextField(txtTen));
		tyGia.setTygiaquydoi(DataInputUtils.getFloatFromTextField(numTyGiaQuyDoi));
		tyGia.setActivity(true);
		
		TygiaHome tyGiaHome = new TygiaHome();
		tyGiaHome.save(tyGia);
		
		TyGiaController.tyGiaController.onTyGiaAdded();
	}
	@FXML
	public void onButtonDongClick() {
		TyGiaController.tyGiaController.closeManHinhThemTyGia();
	}
}
