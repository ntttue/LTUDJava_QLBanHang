package com.qlbh.controller.danhmuc;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.common.DialogController;
import com.qlbh.model.BophanHome;
import com.qlbh.model.NguoidungHome;
import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Bophan;
import com.qlbh.pojo.Tygia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ThemBoPhanCongTyController {
	@FXML
	private AnchorPane root;
	@FXML
	private TextField txtMa, txtTen, txtGhiChu;
	@FXML
	private JFXButton btnDong;
	@FXML
	private Label lblError;
	BophanHome boPhanHome = new BophanHome();

	@FXML
	public void onButtonLuuClick() {
		this.ThemBoPhan();
	}

	private void ThemBoPhan() {
		if (this.txtMa.getLength() == 0 || this.txtTen.getLength() == 0) {
			this.lblError.setText("Vui lòng điền đủ thông tin trong các mục (*)");
			return;
		}
		if (boPhanHome.findByMa(this.txtMa.getText()) != null) {
			this.lblError.setText("Mã bộ phận đã tồn tại. Vui lòng nhập lại.");
			return;
		}
		Bophan bophan = new Bophan();
		bophan.setTen(this.txtTen.getText());
		bophan.setGhichu(this.txtGhiChu.getText());
		bophan.setMa(this.txtMa.getText());
		bophan.setActivity(true);
		if (boPhanHome.saveReturnObj(bophan)) {
			DanhSachBoPhanController.boPhanController.onBoPhanAdded();
		} else {
			DialogController.show(root, null, "Thông báo", "Đổi mật khẩu thành công.", false);
		}
	}

	@FXML
	void onEnter(KeyEvent e) {
		if (e.getCode().toString().equals("ENTER")) {
			this.ThemBoPhan();
		}
		if (e.getCode().toString().equals("ESCAPE")) {
			this.closeStage();
		}
	}

	@FXML
	public void onButtonDongClick() {
		this.closeStage();
	}
	private void closeStage(){
		Stage stage = (Stage) btnDong.getScene().getWindow();
		stage.close();
	}
}
