package com.qlbh.controller.hethong;

import java.util.List;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.model.NguoidungHome;
import com.qlbh.model.QuyenHome;
import com.qlbh.pojo.Nguoidung;
import com.qlbh.pojo.Quyen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SuaNguoiDungController {

	@FXML
	private JFXButton btnSave, btnCancel;

	@FXML
	private Label lbValidate;

	@FXML
	private JFXTextField txtNhanVien, txtTen, txtGhiChu;

	@FXML
	private JFXComboBox<Quyen> cmbQuyen;

	final static Logger logger = Logger.getLogger(SuaNguoiDungController.class);

	private Nguoidung nd;

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
		cmbQuyen.setItems(getDSQuyen());
		cmbQuyen.getSelectionModel().select(0);
	}

	public void setNguoiDung(Nguoidung nd) {
		this.nd = nd;
		txtNhanVien.setText(nd.getNhanvien().getTen());
		txtTen.setText(nd.getTennd());
		cmbQuyen.getSelectionModel().select(nd.getQuyen());
		txtGhiChu.setText(nd.getDiengiai());
	}

	@FXML
	void btnSaveClick() {
		if (cmbQuyen.getValue().getId() == 0) {
			lbValidate.setText("Vui lòng chọn Quyền");
			return;
		}
		nd.setQuyen(cmbQuyen.getValue());
		nd.setDiengiai(txtGhiChu.getText());
		NguoidungHome ndh = new NguoidungHome();
		try {
			ndh.update(nd);
			QuanLyNguoiDungController.quanLyNguoiDungController.closeSua();
		} catch (Exception ex) {
			logger.error("This is error : " + ex.getMessage());
		}
	}

	@FXML
	void btnCancelClick() {
		QuanLyNguoiDungController.quanLyNguoiDungController.closeSua();
	}
}
