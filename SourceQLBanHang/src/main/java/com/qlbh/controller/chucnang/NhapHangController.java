package com.qlbh.controller.chucnang;


import java.util.List;

import com.qlbh.model.KhohangHome;
import com.qlbh.model.NhacungcapHome;
import com.qlbh.model.NhanvienHome;
import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Nhacungcap;
import com.qlbh.pojo.Nhanvien;
import com.qlbh.pojo.Phieunhap;
import com.qlbh.render.combobox.MaNhaCungCapListCell;
import com.qlbh.render.combobox.TenNhaCungCapListCell;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class NhapHangController {
	
	private NhanvienHome nhanVienHome;
	private KhohangHome khoHangHome;
	private NhacungcapHome nhaCungCapHome;
	
	@FXML
    private Button btnLuu;
    @FXML
    private ComboBox<Nhanvien> cmbNhanVien;
    private ObservableList<Nhanvien> cmbModelNhanVien;
    @FXML
    private ComboBox<Khohang> cmbKho;
    private ObservableList<Khohang> cmbModelKhoHang;
    @FXML
    private ComboBox<Nhacungcap> cmbTenNCC;
    private ObservableList<Nhacungcap> cmbModelTenNCC;
    @FXML
    private ComboBox<Nhacungcap> cmbMaNCC;
    private ObservableList<Nhacungcap> cmbModelMaNhaCC;
    @FXML
    private TextField txtThanhToan;
    @FXML
    private Button btnTaoMoi;
    @FXML
    private TableView<Phieunhap> tablePhieuNhap;
    @FXML
    private TextArea txtGhiChu;
    @FXML
    private TextField txtDiaChi;
    @FXML
    private TextField txtMaPhieu;
    @FXML
    private Button btnNapLai;
    @FXML
    private DatePicker datePickerNhap;

	public NhapHangController() {
		super();
	}
	
	@FXML
    public void initialize() {
		loadData();
    }
	
	
    
	private void loadData(){
		nhanVienHome = new NhanvienHome();
		khoHangHome = new KhohangHome();
		nhaCungCapHome = new NhacungcapHome();
		//Load nhan vien
		cmbModelNhanVien = FXCollections.observableArrayList(nhanVienHome.getNhanVienList());
		cmbNhanVien.setItems(cmbModelNhanVien);
		cmbNhanVien.setPromptText("Chọn nhân viên");
		//load kho
		cmbModelKhoHang = FXCollections.observableArrayList(khoHangHome.getKhoHangList());
		cmbKho.setItems(cmbModelKhoHang);
		cmbKho.setPromptText("Chọn kho");
		//Load ma nha cc
		List<Nhacungcap> nhacungcaps = nhaCungCapHome.getNhaCungCapList();
		cmbModelMaNhaCC = FXCollections.observableArrayList(nhacungcaps);
		cmbMaNCC.setItems(cmbModelMaNhaCC);
		cmbMaNCC.setButtonCell(new MaNhaCungCapListCell());
		cmbMaNCC.setCellFactory(new Callback<ListView<Nhacungcap>, ListCell<Nhacungcap>>() {
			
			public ListCell<Nhacungcap> call(ListView<Nhacungcap> param) {
				return new MaNhaCungCapListCell();
			}
		});
		cmbMaNCC.setPromptText("Chọn mã nhà cung cấp");
		//Load ten nha cc
		cmbModelTenNCC = FXCollections.observableArrayList(nhacungcaps);
		cmbTenNCC.setItems(cmbModelMaNhaCC);
		cmbTenNCC.setButtonCell(new TenNhaCungCapListCell());
		cmbTenNCC.setCellFactory(new Callback<ListView<Nhacungcap>, ListCell<Nhacungcap>>() {
			
			public ListCell<Nhacungcap> call(ListView<Nhacungcap> param) {
				return new TenNhaCungCapListCell();
			}
		});
		cmbTenNCC.setPromptText("Chọn tên nhà cung cấp");
	}

}
