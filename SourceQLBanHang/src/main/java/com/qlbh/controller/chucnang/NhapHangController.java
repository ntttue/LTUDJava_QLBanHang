package com.qlbh.controller.chucnang;


import java.util.List;

import com.qlbh.model.KhohangHome;
import com.qlbh.model.NhacungcapHome;
import com.qlbh.model.NhanvienHome;
import com.qlbh.pojo.Chitietphieunhap;
import com.qlbh.pojo.Hanghoa;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Chitietphieunhap> tableChiTiet;
    private ObservableList<Chitietphieunhap> modelTableChiTiet;
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
		initTableView();
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
		//Load ten nha cung cap
		cmbModelTenNCC = FXCollections.observableArrayList(nhacungcaps);
		cmbTenNCC.setItems(cmbModelTenNCC);
		cmbTenNCC.setButtonCell(new TenNhaCungCapListCell());
		cmbTenNCC.setCellFactory(new Callback<ListView<Nhacungcap>, ListCell<Nhacungcap>>() {
			
			public ListCell<Nhacungcap> call(ListView<Nhacungcap> param) {
				return new TenNhaCungCapListCell();
			}
		});
		cmbTenNCC.setPromptText("Chọn tên nhà cung cấp");
	}
	
	private void initTableView(){
		//STT
		TableColumn colSTT = new TableColumn<>("STT");
		//Ma hang
		TableColumn<Chitietphieunhap, Hanghoa> colMaHang = new TableColumn<>("Mã hàng");
		colMaHang.setCellValueFactory(new PropertyValueFactory<>(Chitietphieunhap.MA_HANG_HOA));
		//Ten hang
		TableColumn<Chitietphieunhap, Hanghoa> colTenHang = new TableColumn<>("Tên hàng");
		colTenHang.setCellValueFactory(new PropertyValueFactory<>(Chitietphieunhap.TEN_HANG_HOA));
		//Don vi
		TableColumn<Chitietphieunhap, String> colDonVi = new TableColumn<>("Đơn vị");
		colDonVi.setCellValueFactory(new PropertyValueFactory<>(Chitietphieunhap.DON_VI));
		//So luong
		TableColumn<Chitietphieunhap, Integer> colSoLuong = new TableColumn<>("Số lượng");
		colSoLuong.setCellValueFactory(new PropertyValueFactory<>(Chitietphieunhap.SO_LUONG));
		//Don gia
		TableColumn<Chitietphieunhap, Double> colDonGia = new TableColumn<>("Đơn giá");
		colDonGia.setCellValueFactory(new PropertyValueFactory<>(Chitietphieunhap.DON_GIA));
		//Thanh tien
		TableColumn<Chitietphieunhap, Double> colThanhTien = new TableColumn<>("Thành tiền");
		colThanhTien.setCellValueFactory(new PropertyValueFactory<>(Chitietphieunhap.THANH_TIEN));
		//Ghi chu
		TableColumn<Chitietphieunhap, String> colGhiChu = new TableColumn<>("Ghi chú");
		colGhiChu.setCellValueFactory(new PropertyValueFactory<>(Chitietphieunhap.GHI_CHU));
		//Add column
		tableChiTiet.getColumns().addAll(colMaHang, colTenHang, colSoLuong, colDonGia, colThanhTien, colGhiChu);
		//set data
		Hanghoa hanghoa = new Hanghoa();
		hanghoa.setMa("MH00001");
		hanghoa.setTen("Máy đông lạnh");
		Hanghoa hanghoa2 = new Hanghoa();
		hanghoa2.setMa("MH00010");
		hanghoa2.setTen("Máy khoan");
		Hanghoa hanghoa3 = new Hanghoa();
		hanghoa3.setMa("MH00020");
		hanghoa3.setTen("Máy sấy");
		Chitietphieunhap chitietphieunhap = new Chitietphieunhap(hanghoa, new Phieunhap(), 1, 1000000d, 1000000d, "", true, "002");
		Chitietphieunhap chitietphieunhap2 = new Chitietphieunhap(hanghoa2, new Phieunhap(), 3, 1000000d, 3000000d, "", true, "003");
		Chitietphieunhap chitietphieunhap3 = new Chitietphieunhap(hanghoa3, new Phieunhap(), 1, 2000000d, 2000000d, "", true, "004");
		modelTableChiTiet = FXCollections.observableArrayList(chitietphieunhap, chitietphieunhap2, chitietphieunhap3);
		tableChiTiet.setItems(modelTableChiTiet);
	}

}
