package com.qlbh.controller.hethong;

import java.util.List;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.NguoidungHome;
import com.qlbh.model.NhanvienHome;
import com.qlbh.model.QuyenHome;
import com.qlbh.pojo.Nguoidung;
import com.qlbh.pojo.Nhanvien;
import com.qlbh.pojo.Quyen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThemNguoiDungController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtTen, txtGhiChu;

	@FXML
	private JFXPasswordField txtMatKhau, txtNhapLaiMatKhau;

	@FXML
	private JFXComboBox<Nhanvien> cmbNhanVien;

	@FXML
	private JFXComboBox<Quyen> cmbQuyen;

	final static Logger logger = Logger.getLogger(ThemNguoiDungController.class);

	private ObservableList<Nhanvien> getDSNhanVien() {
		NhanvienHome nvh = new NhanvienHome();
		List<Nhanvien> lnv = nvh.getNhanVienList();
		Nhanvien nv = new Nhanvien();
		nv.setId(0);
		nv.setTen("-- Chọn nhân viên --");
		lnv.add(0, nv);
		ObservableList<Nhanvien> oListNV = FXCollections.observableList(lnv);
		return oListNV;
	}

	private ObservableList<Quyen> getDSQuyen() {
		QuyenHome qh = new QuyenHome();
		List<Quyen> lq = qh.getQuyenList();
		Quyen q = new Quyen();
		q.setId(0);
		q.setTen("-- Chọn quyền --");
		lq.add(0, q);
		ObservableList<Quyen> oListQ = FXCollections.observableList(lq);
		return oListQ;
	}

	@FXML
	protected void initialize() {
		cmbNhanVien.setItems(getDSNhanVien());
		cmbNhanVien.getSelectionModel().select(0);
		cmbQuyen.setItems(getDSQuyen());
		cmbQuyen.getSelectionModel().select(0);
	}

	@FXML
	void btnSaveClick() {
		if (txtTen.getLength() == 0 || cmbNhanVien.getValue().getId() == 0 || cmbQuyen.getValue().getId() == 0) {
			lbValidate.setText("Vui lòng nhập Tên, chọn Nhân viên và Quyền");
			return;
		}

		if (!txtNhapLaiMatKhau.getText().equals(txtMatKhau.getText())) {
			lbValidate.setText("Nhập lại mật khẩu không đúng");
			return;
		}

		Nguoidung nd = new Nguoidung();
		nd.setNhanvien(cmbNhanVien.getValue());
		nd.setTennd(txtTen.getText());
		nd.setMatkhau(txtMatKhau.getText());
		nd.setQuyen(cmbQuyen.getValue());
		nd.setDiengiai(txtGhiChu.getText());
		nd.setActivity(true);
		NguoidungHome ndh = new NguoidungHome();
		try {
			ndh.create(nd);
			cmbNhanVien.getSelectionModel().select(0);
			txtTen.clear();
			txtMatKhau.clear();
			txtNhapLaiMatKhau.clear();
			cmbQuyen.getSelectionModel().select(0);
			txtGhiChu.clear();
			lbValidate.setText("");
			QuanLyNguoiDungController.quanLyNguoiDungController.reload();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyNguoiDungController.quanLyNguoiDungController.closeThem();
	}

}
