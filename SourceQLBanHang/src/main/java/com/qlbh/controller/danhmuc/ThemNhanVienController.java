package com.qlbh.controller.danhmuc;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.qlbh.controller.common.CheckValid;
import com.qlbh.controller.common.DialogController;
import com.qlbh.model.BophanHome;
import com.qlbh.model.NhanvienHome;
import com.qlbh.pojo.Bophan;
import com.qlbh.pojo.Nhanvien;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ThemNhanVienController {
	@FXML
	private AnchorPane root;
	@FXML
	private JFXButton btnDong;
	@FXML
	private JFXRadioButton radioButtonNam, radioButtonNu;
	@FXML
	private TextField txtMa, txtTen, txtDiaChi, numDienThoai, numLuong, txtEmail, txtChucVu;
	@FXML
	private ComboBox<Bophan> cbxBoPhan;
	@FXML
	private ComboBox<Nhanvien> cbxNhanVienQL;
	@FXML
	private Label lblError;

	final ToggleGroup group = new ToggleGroup();
	private NhanvienHome nhanVienHome = new NhanvienHome();
	private BophanHome boPhanHome = new BophanHome();

	@FXML
	protected void initialize() {
		this.setcbxBoPhan();
		this.setcbxNhanVienQL();
		this.initRadio();
	}

	@FXML
	public void onButtonLuuClick() {
		this.saveNhanVien();
	}

	@FXML
	public void onButtonDongClick() {
		this.closeStage();
	}

	@FXML
	void onKeyAction(KeyEvent e) {
		if (e.getCode().toString().equals("ENTER")) {
			this.saveNhanVien();
		}
		if (e.getCode().toString().equals("ESCAPE")) {
			this.closeStage();
		}
	}

	@SuppressWarnings("unchecked")
	private ObservableList<Bophan> getDSBoPhan() {
		List<Bophan> boPhans = boPhanHome.findAll();
		ObservableList<Bophan> oListBoPhan = FXCollections.observableList(boPhans);
		return oListBoPhan;
	}

	@SuppressWarnings("unchecked")
	private ObservableList<Nhanvien> getDSNhanVien() {
		List<Nhanvien> nhanViens = nhanVienHome.findAll();
		Nhanvien nv = new Nhanvien();
		nv.setId(0);
		nv.setTen("-- Chọn nhân viên quản lý --");
		nhanViens.add(0, nv);
		ObservableList<Nhanvien> oListNhanVien = FXCollections.observableList(nhanViens);
		return oListNhanVien;
	}

	private void setcbxBoPhan() {

		this.cbxBoPhan.setItems(this.getDSBoPhan());
		cbxBoPhan.getSelectionModel().select(0);
	}

	private void setcbxNhanVienQL() {
		this.cbxNhanVienQL.setItems(this.getDSNhanVien());
		cbxNhanVienQL.getSelectionModel().select(0);
	}

	private void initRadio() {
		this.radioButtonNam.setToggleGroup(group);
		this.radioButtonNu.setToggleGroup(group);
		this.radioButtonNam.setSelected(true);
	}

	private void closeStage() {
		Stage stage = (Stage) btnDong.getScene().getWindow();
		stage.close();
	}

	private void saveNhanVien() {
		if (this.txtMa.getText().trim().length() == 0 || this.txtTen.getText().trim().length() == 0) {
			this.lblError.setText("Vui lòng điền đủ thông tin trong các mục (*)");
			return;
		}
		if (nhanVienHome.findByMa(this.txtMa.getText()) != null) {
			this.lblError.setText("Mã nhân viên đã tồn tại. Vui lòng nhập lại.");
			return;
		}
		if (this.numDienThoai.getText().trim().length() != 0
				&& !CheckValid.isValidPhoneNumber(this.numDienThoai.getText())) {
			this.lblError.setText("SDT nhập không đúng định dạng.");
			return;
		}
		if (this.txtEmail.getText().trim().length() != 0 && !CheckValid.isValidEmailAddress(this.txtEmail.getText())) {
			System.out.println(this.txtEmail.getText().trim());
			this.lblError.setText("Email nhập không đúng định dạng.");
			return;
		}
		if (this.numLuong.getText().trim().length() != 0 && !CheckValid.isNumeric(this.numLuong.getText())) {
			this.lblError.setText("Lương nhập không phải là số.");
			return;
		}
		Nhanvien nv = this.getDataFromForm();
		nv.setActivity(true);

		if (nhanVienHome.saveReturnObj(nv)) {
			DanhSachNhanVienController.nhanVienController.onNhanVienAdded();
		} else {
			DialogController.show(root, null, "Thông báo", "Thêm nhân viên không thành công. Vui lòng thử lại.", false);
		}

	}

	private Nhanvien getDataFromForm() {
		Nhanvien nv = new Nhanvien();
		nv.setMa(this.txtMa.getText());
		nv.setTen(this.txtTen.getText());
		nv.setGioiTinh(this.radioButtonNam.isSelected() == true ? true : false);
		nv.setDiaChi(this.txtDiaChi.getText());
		nv.setDienThoai(this.numDienThoai.getText());
		nv.setEmail(this.txtEmail.getText());
		nv.setChucVu(this.txtChucVu.getText());
		nv.setLuong(this.getLuong());
		if (this.cbxNhanVienQL.getValue().getId() != 0)
			nv.setNhanvien(this.cbxNhanVienQL.getValue());
		nv.setBophan(this.cbxBoPhan.getValue());
		return nv;
	}

	private Double getLuong() {
		Double luong = 0.0;
		if (this.numLuong.getText().trim().length() != 0 && this.numLuong.getText() != null) {
			luong = Double.valueOf(this.numLuong.getText());
		}
		return luong;
	}

}
