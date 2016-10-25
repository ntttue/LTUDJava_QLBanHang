package com.qlbh.controller.danhmuc;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.qlbh.controller.common.CheckValid;
import com.qlbh.controller.common.DialogController;
import com.qlbh.controller.common.Display;
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

public class SuaNhanVienController {
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
	Nhanvien nhanVien = new Nhanvien();

	@FXML
	protected void initialize() {
		this.setcbxBoPhan();
		this.setcbxNhanVienQL();
		this.initRadio();
	}

	@FXML
	public void onButtonLuuClick() {
		this.updateNhanVien();
	}

	@FXML
	public void onButtonDongClick() {
		this.closeStage();
	}

	@FXML
	void onKeyAction(KeyEvent e) {
		if (e.getCode().toString().equals("ENTER")) {
			this.updateNhanVien();
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
		// this.radioButtonNam.setSelected(true);
	}

	private void closeStage() {
		Stage stage = (Stage) btnDong.getScene().getWindow();
		stage.close();
	}

	private void updateNhanVien() {
		if (this.txtMa.getText().trim().length() == 0 || this.txtTen.getText().trim().length() == 0) {
			this.lblError.setText("Vui lòng điền đủ thông tin trong các mục (*)");
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
		this.getDataFromForm();

		if (nhanVienHome.update(nhanVien)) {
			System.out.println("thành công");
			DanhSachNhanVienController.nhanVienController.onNhanVienUpdated();
		} else {
			System.out.println("thất bại");
			DialogController.show(root, null, "Thông báo", "Cập nhật nhân viên không thành công. Vui lòng thử lại.",
					false);
		}

	}

	private void getDataFromForm() {
		nhanVien.setMa(this.txtMa.getText());
		nhanVien.setTen(this.txtTen.getText());
		nhanVien.setGioiTinh(this.radioButtonNam.isSelected() == true ? true : false);
		nhanVien.setDiaChi(this.txtDiaChi.getText());
		nhanVien.setDienThoai(this.numDienThoai.getText());
		nhanVien.setEmail(this.txtEmail.getText());
		nhanVien.setChucVu(this.txtChucVu.getText());
		nhanVien.setLuong(this.getLuong());
		if (this.cbxNhanVienQL.getValue().getId() != 0)
			nhanVien.setNhanvien(this.cbxNhanVienQL.getValue());
		else {
			nhanVien.setNhanvien(null);
		}
		nhanVien.setBophan(this.cbxBoPhan.getValue());
	}

	private Double getLuong() {
		Double luong = 0.0;
		if (this.numLuong.getText().trim().length() != 0 && this.numLuong.getText() != null) {
			luong = Double.valueOf(this.numLuong.getText().replace(",", ""));
		}
		return luong;
	}

	public void setNhanVien(Nhanvien obj) {
		this.nhanVien = obj;
		this.setDataToForm();
	}

	private void setDataToForm() {
		this.txtMa.setText(this.nhanVien.getMa());
		this.txtTen.setText(nhanVien.getTen());
		if (this.nhanVien.getGioiTinh()) {
			this.radioButtonNam.setSelected(true);
		} else {
			this.radioButtonNu.setSelected(true);
		}
		this.txtDiaChi.setText(this.nhanVien.getDiaChi());
		this.numDienThoai.setText(this.nhanVien.getDienThoai());
		this.txtEmail.setText(nhanVien.getEmail());
		this.txtChucVu.setText(nhanVien.getChucVu());
		this.numLuong.setText(Display.formatMoney(nhanVien.getLuong()));
		this.cbxBoPhan.setValue(nhanVien.getBophan());
		if (nhanVien.getNhanvien() != null) {
			this.cbxNhanVienQL.setValue(nhanVien.getNhanvien());
		} else {
			this.cbxNhanVienQL.getSelectionModel().selectFirst();
		}
	}

}
