package com.qlbh.controller.danhmuc;

import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataInputUtils;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SuaTyGiaController {
	@FXML
	private TextField txtMa, txtTen, numTyGiaQuyDoi;
	private Tygia tygia;
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
		this.tygia.setMa(DataInputUtils.getStringFromTextField(txtMa));
		this.tygia.setTen(DataInputUtils.getStringFromTextField(txtTen));
		this.tygia.setTygiaquydoi(DataInputUtils.getFloatFromTextField(numTyGiaQuyDoi));
		
		TygiaHome tyGiaHome = new TygiaHome();
		tyGiaHome.update(this.tygia);
		TyGiaController.tyGiaController.onTyGiaUpdated();
	}
	public void setTyGia(Tygia tygia) {
		this.tygia = tygia;
		this.txtMa.setText(tygia.getMa());
		this.txtTen.setText(tygia.getTen());
		this.numTyGiaQuyDoi.setText(tygia.getTygiaquydoi().toString());
	}
	@FXML
	public void onButtonDongClick() {
		TyGiaController.tyGiaController.closeManHinhSuaTyGia();
	}
}
