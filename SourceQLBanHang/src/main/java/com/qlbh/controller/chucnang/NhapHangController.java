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
import javafx.beans.property.adapter.JavaBeanObjectProperty;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

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
		//set data
		Hanghoa hanghoa = new Hanghoa();
		hanghoa.setMa("MH00001");
		hanghoa.setTen("Máy đông lạnh");
		Hanghoa hanghoa2 = new Hanghoa();
		hanghoa2.setMa("MH00002");
		hanghoa2.setTen("Máy khoan");
		Hanghoa hanghoa3 = new Hanghoa();
		hanghoa3.setMa("MH00003");
		hanghoa3.setTen("Máy sấy");
		ObservableList<Hanghoa> hanghoaList = FXCollections.observableArrayList(hanghoa, hanghoa2, hanghoa3);
		Chitietphieunhap chitietphieunhap = new Chitietphieunhap(hanghoa, new Phieunhap(), 1, 1000000d, 1000000d, "Ghi chú 1", true, "002");
		Chitietphieunhap chitietphieunhap2 = new Chitietphieunhap(hanghoa2, new Phieunhap(), 3, 1000000d, 3000000d, "Ghi chú 2", true, "003");
		Chitietphieunhap chitietphieunhap3 = new Chitietphieunhap(hanghoa3, new Phieunhap(), 1, 2000000d, 2000000d, "Ghi chú 3", true, "004");
		//STT
		TableColumn<Chitietphieunhap, Number> colSTT = new TableColumn<Chitietphieunhap, Number>("STT");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableChiTiet.getItems().indexOf(column.getValue()) + 1));
		//Ma hang
		TableColumn<Chitietphieunhap, Hanghoa> colMaHang = new TableColumn<>("Mã hàng");
		final StringConverter<Hanghoa> converterMa = new StringConverter<Hanghoa>() {
			
			@Override
			public String toString(Hanghoa object) {
				return object.getMa();
			}
			
			@Override
			public Hanghoa fromString(String string) {
				return null;
			}
		};
		
		colMaHang.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Chitietphieunhap,Hanghoa>, ObservableValue<Hanghoa>>() {

			@Override
			public ObservableValue<Hanghoa> call(CellDataFeatures<Chitietphieunhap, Hanghoa> param) {
				try {
					JavaBeanObjectPropertyBuilder<Hanghoa> builder = new JavaBeanObjectPropertyBuilder<>();
					builder.bean(param.getValue());
					builder.name("Hanghoa");
					return (ObservableValue<Hanghoa>)builder.build();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
				return null;
			}
		});
		
		colMaHang.setCellFactory(ComboBoxTableCell.forTableColumn(converterMa, hanghoaList));
		
		colMaHang.setOnEditCommit( new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap,Hanghoa>>() {
			
			@Override
			public void handle(CellEditEvent<Chitietphieunhap, Hanghoa> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setHanghoa(event.getNewValue());
			}
		});
		
		//Ten hang
		TableColumn<Chitietphieunhap, Hanghoa> colTenHang = new TableColumn<>("Tên hàng");
		colTenHang.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Chitietphieunhap,Hanghoa>, ObservableValue<Hanghoa>>() {

			@Override
			public ObservableValue<Hanghoa> call(CellDataFeatures<Chitietphieunhap, Hanghoa> param) {
				try {
					JavaBeanObjectPropertyBuilder<Hanghoa> builder = new JavaBeanObjectPropertyBuilder<>();
					builder.bean(param.getValue());
					builder.name("Hanghoa");
					return (ObservableValue<Hanghoa>)builder.build();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
				return null;
			}
		});
		
		final StringConverter<Hanghoa> converterTen = new StringConverter<Hanghoa>() {

			@Override
			public Hanghoa fromString(String string) {
				return null;
			}

			@Override
			public String toString(Hanghoa hanghoa) {
				return hanghoa.getTen();
			}
		};
		colTenHang.setCellFactory(ComboBoxTableCell.forTableColumn(converterTen, hanghoaList));
		colTenHang.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap,Hanghoa>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieunhap, Hanghoa> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setHanghoa(event.getNewValue());
				colMaHang.editableProperty();
			}
		});
		//Don vi
		TableColumn<Chitietphieunhap, String> colDonVi = new TableColumn<>("Đơn vị");
		colDonVi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getDonvitinh().getTen()));
		//So luong
		TableColumn<Chitietphieunhap, String> colSoLuong = new TableColumn<>("Số lượng");
		colSoLuong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSoluong().toString()));
		colSoLuong.setCellFactory(TextFieldTableCell.forTableColumn());
		colSoLuong.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap,String>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieunhap, String> event) {
				
			}
		});
		//Don gia
		TableColumn<Chitietphieunhap, String> colDonGia = new TableColumn<>("Đơn giá");
		colDonGia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDongia().toString()));
		colDonGia.setCellFactory(TextFieldTableCell.forTableColumn());
		colDonGia.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap,String>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieunhap, String> event) {
				
			}
		});
		//Thanh tien
		TableColumn<Chitietphieunhap, String> colThanhTien = new TableColumn<>("Thành tiền");
		colThanhTien.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getThanhtien().toString()));
		//Ghi chu
		TableColumn<Chitietphieunhap, String> colGhiChu = new TableColumn<>("Ghi chú");
		colGhiChu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));
		colGhiChu.setCellFactory(TextFieldTableCell.forTableColumn());
		colGhiChu.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap,String>>() {

					@Override
					public void handle(CellEditEvent<Chitietphieunhap, String> event) {
						
					}
		});
		//Add column
		tableChiTiet.getColumns().addAll(colSTT, colMaHang, colTenHang, colSoLuong, colDonGia, colThanhTien, colGhiChu);
		tableChiTiet.setEditable(true);
		modelTableChiTiet = FXCollections.observableArrayList(chitietphieunhap, chitietphieunhap2, chitietphieunhap3);
		tableChiTiet.setItems(modelTableChiTiet);
	}

}
