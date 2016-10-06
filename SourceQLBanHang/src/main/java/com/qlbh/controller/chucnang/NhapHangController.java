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

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
		TableColumn<Chitietphieunhap, Number> colSTT = new TableColumn<Chitietphieunhap, Number>("#");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableChiTiet.getItems().indexOf(column.getValue()) + 1));
		//Ma hang
		TableColumn<Chitietphieunhap, String> colMaHang = new TableColumn<>("Mã hàng");
		colMaHang.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));
		//Ten hang
		TableColumn<Chitietphieunhap, String> colTenHang = new TableColumn<>("Tên hàng");
		colTenHang.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getTen()));
		//Don vi
		TableColumn<Chitietphieunhap, String> colDonVi = new TableColumn<>("Đơn vị");
		colDonVi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getDonvi()));
		//So luong
		TableColumn<Chitietphieunhap, String> colSoLuong = new TableColumn<>("Số lượng");
		colSoLuong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSoluong().toString()));
		//Don gia
		TableColumn<Chitietphieunhap, String> colDonGia = new TableColumn<>("Đơn giá");
		colDonGia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDongia().toString()));
		//Thanh tien
		TableColumn<Chitietphieunhap, String> colThanhTien = new TableColumn<>("Thành tiền");
		colThanhTien.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getThanhtien().toString()));
		//Ghi chu
		TableColumn<Chitietphieunhap, String> colGhiChu = new TableColumn<>("Ghi chú");
		colGhiChu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));
		//Add column
		tableChiTiet.getColumns().addAll(colSTT, colMaHang, colTenHang, colSoLuong, colDonGia, colThanhTien, colGhiChu);
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
		Chitietphieunhap chitietphieunhap = new Chitietphieunhap(hanghoa, new Phieunhap(), 1, 1000000d, 1000000d, "Ghi chú 1", true, "002");
		Chitietphieunhap chitietphieunhap2 = new Chitietphieunhap(hanghoa2, new Phieunhap(), 3, 1000000d, 3000000d, "Ghi chú 2", true, "003");
		Chitietphieunhap chitietphieunhap3 = new Chitietphieunhap(hanghoa3, new Phieunhap(), 1, 2000000d, 2000000d, "Ghi chú 3", true, "004");
		modelTableChiTiet = FXCollections.observableArrayList(chitietphieunhap, chitietphieunhap2, chitietphieunhap3);
		tableChiTiet.setItems(modelTableChiTiet);
	}

}
