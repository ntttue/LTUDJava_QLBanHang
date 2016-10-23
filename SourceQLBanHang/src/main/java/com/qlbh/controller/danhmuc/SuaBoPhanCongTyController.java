package com.qlbh.controller.danhmuc;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.common.DialogController;
import com.qlbh.model.BophanHome;
import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Bophan;
import com.qlbh.pojo.Tygia;
import com.qlbh.util.DataInputUtils;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SuaBoPhanCongTyController {
	@FXML
	private AnchorPane root;
	@FXML
	private TextField txtMa, txtTen, txtGhiChu;
	@FXML
	private JFXButton btnDong;
	@FXML
	private Label lblError;
	BophanHome boPhanHome = new BophanHome();
	Bophan bophan = new Bophan();

	@FXML
	void onEnter(KeyEvent e) {
		if (e.getCode().toString().equals("ENTER")) {
			this.SuaBoPhan();
		}
		if (e.getCode().toString().equals("ESCAPE")) {
			this.closeStage();
		}
	}

	@FXML
	public void onButtonLuuClick() {
		this.SuaBoPhan();
	}

	private void SuaBoPhan() {
		if (this.txtMa.getLength() == 0 || this.txtTen.getLength() == 0) {
			this.lblError.setText("Vui lòng điền đủ thông tin trong các mục (*)");
			return;
		}
		bophan.setTen(this.txtTen.getText());
		bophan.setGhichu(this.txtGhiChu.getText());
		if (boPhanHome.update(bophan)) {
			DanhSachBoPhanController.boPhanController.onBophanUpdated();
		} else {
			DialogController.show(root, null, "Thông báo", "Sửa bộ phận không thành công, vui lòng thử lại.", false);
		}
	}

	public void setBophan(Bophan obj) {
		this.bophan = obj;
		this.txtMa.setText(bophan.getMa());
		this.txtTen.setText(bophan.getTen());
		this.txtGhiChu.setText(bophan.getGhichu());
	}

	@FXML
	public void onButtonDongClick() {
		this.closeStage();
	}

	private void closeStage() {
		Stage stage = (Stage) btnDong.getScene().getWindow();
		stage.close();
	}
}
