package com.qlbh.controller.danhmuc;

import java.util.List;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.NhacungcapHome;
import com.qlbh.controller.common.CheckValid;
import com.qlbh.model.KhuvucHome;
import com.qlbh.pojo.Nhacungcap;
import com.qlbh.pojo.Khuvuc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SuaNhaCungCapController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtMa, txtTen, txtNguoiLienHe, txtDiaChi, txtDienThoai, txtFax, txtEmail, txtWebsite;

	@FXML
	private JFXComboBox<Khuvuc> cmbKhuVuc;

	final static Logger logger = Logger.getLogger(SuaNhaCungCapController.class);

	private Nhacungcap ncc;

	private ObservableList<Khuvuc> getDSKhuVuc() {
		KhuvucHome kvh = new KhuvucHome();
		List<Khuvuc> lkv = kvh.getKhuVucList();
		Khuvuc kv = new Khuvuc();
		kv.setId(0);
		kv.setTen("-- Chọn khu vực --");
		lkv.add(0, kv);
		ObservableList<Khuvuc> oListKV = FXCollections.observableList(lkv);
		return oListKV;
	}

	@FXML
	protected void initialize() {
		cmbKhuVuc.setItems(getDSKhuVuc());
		cmbKhuVuc.getSelectionModel().select(0);
	}

	public void setNhaCungCap(Nhacungcap ncc) {
		this.ncc = ncc;
		txtMa.setText(ncc.getMa());
		txtTen.setText(ncc.getTen());
		cmbKhuVuc.getSelectionModel().select(ncc.getKhuvuc());
		txtNguoiLienHe.setText(ncc.getManguoilienhe());
		txtDiaChi.setText(ncc.getDiachi());
		txtDienThoai.setText(ncc.getTel());
		txtFax.setText(ncc.getFax());
		txtEmail.setText(ncc.getEmail());
		txtWebsite.setText(ncc.getWebsite());
	}

	@FXML
	void btnSaveClick() {
		if (txtMa.getLength() == 0 || txtTen.getLength() == 0 || cmbKhuVuc.getValue().getId() == 0) {
			lbValidate.setText("Vui lòng nhập Mã, Tên và chọn Khu vực");
			return;
		}
		
		if (txtDienThoai.getText().isEmpty() == false && CheckValid.isValidPhoneNumber(txtDienThoai.getText()) == true) {
			lbValidate.setText("Số điện thoại không hợp lệ");
			return;
		}

		if (txtFax.getText().isEmpty() == false && CheckValid.isValidPhoneNumber(txtFax.getText()) == true) {
			lbValidate.setText("Số fax không hợp lệ");
			return;
		}

		if (txtEmail.getText().isEmpty() == false && CheckValid.isValidEmailAddress(txtEmail.getText()) == false) {
			lbValidate.setText("Email không hợp lệ");
			return;
		}
		
		ncc.setMa(txtMa.getText());
		ncc.setTen(txtTen.getText());
		ncc.setKhuvuc(cmbKhuVuc.getValue());
		ncc.setManguoilienhe(txtNguoiLienHe.getText());
		ncc.setDiachi(txtDiaChi.getText());
		ncc.setTel(txtDienThoai.getText());
		ncc.setFax(txtFax.getText());
		ncc.setEmail(txtEmail.getText());
		ncc.setWebsite(txtWebsite.getText());
		NhacungcapHome ncch = new NhacungcapHome();
		try {
			ncch.update(ncc);
			QuanLyNhaCungCapController.quanLyNhaCungCapController.closeSua();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}

	}

	@FXML
	void btnCancelClick() {
		QuanLyNhaCungCapController.quanLyNhaCungCapController.closeSua();
	}
}
