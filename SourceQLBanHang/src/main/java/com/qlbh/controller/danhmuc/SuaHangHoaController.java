package com.qlbh.controller.danhmuc;

import java.text.DecimalFormat;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.qlbh.model.DonvitinhHome;
import com.qlbh.model.HanghoaHome;
import com.qlbh.model.KhohangHome;
import com.qlbh.model.LoaihangHome;
import com.qlbh.model.NhacungcapHome;
import com.qlbh.model.NhomhanghoaHome;
import com.qlbh.pojo.Donvitinh;
import com.qlbh.pojo.Hanghoa;
import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Loaihang;
import com.qlbh.pojo.Nhacungcap;
import com.qlbh.pojo.Nhomhanghoa;
import com.qlbh.util.DataInputUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SuaHangHoaController {

	private KhohangHome khohangHome = new KhohangHome();
	private NhacungcapHome nhacungcapHome = new NhacungcapHome();
	private DonvitinhHome donvitinhHome = new DonvitinhHome();
	private LoaihangHome loaihangHome = new LoaihangHome();
	private NhomhanghoaHome nhomhanghoaHome = new NhomhanghoaHome();
	private HanghoaHome hanghoaHome = new HanghoaHome();
	private Hanghoa hangHoa;
	private final DecimalFormat doubleFormat = new DecimalFormat("#");
	
	public void setHangHoa(Hanghoa hanghoa){
		this.hangHoa = hanghoa;
		txtMa.setText(hanghoa.getMa());
		txtTen.setText(hanghoa.getTen());
		txtXuatXu.setText(hanghoa.getXuatxu());
		txtSLTon.setText(hanghoa.getTonkho() + "");
		txtGiaMua.setText(doubleFormat.format(hanghoa.getGiamua()));
		txtGiaBanLe.setText(doubleFormat.format(hanghoa.getGiabanle()));
		txtGiaBanSi.setText(doubleFormat.format(hanghoa.getGiabansi()));
		cmbLoaiHang.setValue(hanghoa.getLoaihang());
		cmbDonVi.setValue(hanghoa.getDonvitinh());
		cmbNhaCC.setValue(hanghoa.getNhacungcap());
		cmbKho.setValue(hanghoa.getKhohang());
		cmbNhomHang.setValue(hanghoa.getNhomhanghoa());
	}

	@FXML
	private ComboBox<Khohang> cmbKho;
	private ObservableList<Khohang> modelCmbKho;

	@FXML
	private JFXCheckBox checkQuanLy;

	@FXML
	private TextField txtTen;

	@FXML
	private ComboBox<Loaihang> cmbLoaiHang;
	private ObservableList<Loaihang> modelCmbLoaiHang;

	@FXML
	private TextField txtSLTon;

	@FXML
	private TextField txtGiaBanSi;

	@FXML
	private JFXButton btnCancel;

	@FXML
	private JFXButton btnSave;

	@FXML
	private TextField txtGiaMua;

	@FXML
	private TextField txtXuatXu;

	@FXML
	private ComboBox<Donvitinh> cmbDonVi;
	private ObservableList<Donvitinh> modelCmbDonVi;

	@FXML
	private Text txtInputValidate;

	@FXML
	private ComboBox<Nhomhanghoa> cmbNhomHang;
	private ObservableList<Nhomhanghoa> modelCmbNhomHang;

	@FXML
	private ComboBox<Nhacungcap> cmbNhaCC;
	private ObservableList<Nhacungcap> modelCmbNhaCC;

	@FXML
	private TextField txtMa;

	@FXML
	private TextField txtGiaBanLe;

	@FXML
	protected void initialize() {
		initData();
	}

	@FXML
	void onButtonLuuClick(ActionEvent event) {
		// Check validate
		if (DataInputUtils.isEmpty(txtMa) || DataInputUtils.isEmpty(txtTen) || cmbDonVi.getValue() == null || cmbKho.getValue() == null
				|| cmbLoaiHang.getValue() == null || cmbNhaCC.getValue() == null || cmbNhomHang.getValue() == null) {
			txtInputValidate.setText("Vui lòng điền đủ thông tin trong các mục (*)");
			return;
		}
		hanghoaHome.save(getHangHoa());
		QuanLyHangHoaController.controller.updateHangHoan(hangHoa);
		QuanLyHangHoaController.controller.closeManHinhSua();
	}

	@FXML
	void onButtonDongClick(ActionEvent event) {
		QuanLyHangHoaController.controller.closeManHinhThem();
	}

	private void initData() {
		modelCmbDonVi = FXCollections.observableArrayList(donvitinhHome.getDonViTinhList());
		cmbDonVi.setItems(modelCmbDonVi);
		
		modelCmbNhaCC = FXCollections.observableArrayList(nhacungcapHome.getNhaCungCapList());
		cmbNhaCC.setItems(modelCmbNhaCC);
		
		modelCmbLoaiHang = FXCollections.observableArrayList(loaihangHome.getLoaiHangList());
		cmbLoaiHang.setItems(modelCmbLoaiHang);
		
		modelCmbNhomHang = FXCollections.observableArrayList(nhomhanghoaHome.getNhomHangHoaList());
		cmbNhomHang.setItems(modelCmbNhomHang);
		
		modelCmbKho = FXCollections.observableArrayList(khohangHome.getKhoHangList());
		cmbKho.setItems(modelCmbKho);
	}

	private Hanghoa getHangHoa() {
		hangHoa.setMa(txtMa.getText().trim());
		hangHoa.setTen(txtTen.getText().trim());
		hangHoa.setXuatxu(txtXuatXu.getText().trim() == null? "": txtXuatXu.getText().trim());
		hangHoa.setTonkho(Integer.parseInt(txtSLTon.getText().trim().isEmpty()?"0": txtSLTon.getText().trim()));
		hangHoa.setGiamua(Double.parseDouble(txtGiaMua.getText().trim().isEmpty()?"0": txtGiaMua.getText().trim()));
		hangHoa.setGiabanle(Double.parseDouble(txtGiaBanLe.getText().trim().isEmpty()?"0": txtGiaBanLe.getText().trim()));
		hangHoa.setGiabansi(Double.parseDouble(txtGiaBanSi.getText().trim().isEmpty()?"0": txtGiaBanSi.getText().trim()));
		hangHoa.setLoaihang(cmbLoaiHang.getValue());
		hangHoa.setDonvitinh(cmbDonVi.getValue());
		hangHoa.setNhacungcap(cmbNhaCC.getValue());
		hangHoa.setKhohang(cmbKho.getValue());
		hangHoa.setNhomhanghoa(cmbNhomHang.getValue());
		hangHoa.setActivity(true);
		return hangHoa;
	}

}
