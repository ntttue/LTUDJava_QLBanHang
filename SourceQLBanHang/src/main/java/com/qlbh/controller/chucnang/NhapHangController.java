package com.qlbh.controller.chucnang;

import java.util.List;

import com.qlbh.model.HanghoaHome;
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
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.value.ChangeListener;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class NhapHangController {

	private NhanvienHome nhanVienHome;
	private KhohangHome khoHangHome;
	private NhacungcapHome nhaCungCapHome;
	private HanghoaHome hangHoaHome;
	private List<Hanghoa> hangHoaList;
	private ObservableList<Hanghoa> cmbModelHangHoa;

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
		initListener();
		initTableView();
	}

	private void loadData() {
		nhanVienHome = new NhanvienHome();
		khoHangHome = new KhohangHome();
		nhaCungCapHome = new NhacungcapHome();
		hangHoaHome = new HanghoaHome();
		// Load hàng hóa
		hangHoaList = hangHoaHome.getHangHoaList();
		// Load nhan vien
		cmbModelNhanVien = FXCollections.observableArrayList(nhanVienHome.getNhanVienList());
		cmbNhanVien.setItems(cmbModelNhanVien);
		cmbNhanVien.setPromptText("Chọn nhân viên");
		// load kho
		cmbModelKhoHang = FXCollections.observableArrayList(khoHangHome.getKhoHangList());
		cmbKho.setItems(cmbModelKhoHang);
		cmbKho.setPromptText("Chọn kho");
		// Load ma nha cc
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
		// Load ten nha cung cap
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

	private void initListener() {
		cmbMaNCC.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Nhacungcap>() {

			@Override
			public void changed(ObservableValue<? extends Nhacungcap> arg0, Nhacungcap arg1, Nhacungcap arg2) {
				cmbTenNCC.setValue(arg2);
			}
		});

		cmbTenNCC.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Nhacungcap>() {

			@Override
			public void changed(ObservableValue<? extends Nhacungcap> arg0, Nhacungcap arg1, Nhacungcap arg2) {
				cmbMaNCC.setValue(arg2);
			}
		});
	}

	private void initTableView() {
		cmbModelHangHoa = FXCollections.observableArrayList(hangHoaList);
		// STT
		TableColumn<Chitietphieunhap, Number> colSTT = new TableColumn<Chitietphieunhap, Number>("STT");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(
				column -> new ReadOnlyObjectWrapper<Number>(tableChiTiet.getItems().indexOf(column.getValue()) + 1));
		// Ma hang
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

		colMaHang.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Chitietphieunhap, Hanghoa>, ObservableValue<Hanghoa>>() {

					@Override
					public ObservableValue<Hanghoa> call(CellDataFeatures<Chitietphieunhap, Hanghoa> param) {
						try {
							JavaBeanObjectPropertyBuilder<Hanghoa> builder = new JavaBeanObjectPropertyBuilder<>();
							builder.bean(param.getValue());
							builder.name("Hanghoa");
							return (ObservableValue<Hanghoa>) builder.build();
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						}
						return null;
					}
				});

		colMaHang.setCellFactory(ComboBoxTableCell.forTableColumn(converterMa, cmbModelHangHoa));

		colMaHang.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap, Hanghoa>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieunhap, Hanghoa> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setHanghoa(event.getNewValue());
				if(event.getTablePosition().getRow() == modelTableChiTiet.size() -1 ){
					addRowTable();
				}
				tableChiTiet.refresh();
			}
		});

		// Ten hang
		TableColumn<Chitietphieunhap, Hanghoa> colTenHang = new TableColumn<>("Tên hàng");
		colTenHang.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Chitietphieunhap, Hanghoa>, ObservableValue<Hanghoa>>() {

					@Override
					public ObservableValue<Hanghoa> call(CellDataFeatures<Chitietphieunhap, Hanghoa> param) {
						try {
							JavaBeanObjectPropertyBuilder<Hanghoa> builder = new JavaBeanObjectPropertyBuilder<>();
							builder.bean(param.getValue());
							builder.name("Hanghoa");
							return (ObservableValue<Hanghoa>) builder.build();
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
		colTenHang.setCellFactory(ComboBoxTableCell.forTableColumn(converterTen, cmbModelHangHoa));
		colTenHang.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap, Hanghoa>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieunhap, Hanghoa> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setHanghoa(event.getNewValue());
				if(event.getTablePosition().getRow() == modelTableChiTiet.size() -1 ){
					addRowTable();
				}
				tableChiTiet.refresh();
			}
		});
		// Don vi
		TableColumn<Chitietphieunhap, String> colDonVi = new TableColumn<>("Đơn vị");
		colDonVi.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getDonvitinh().getTen()));
		// So luong
		TableColumn<Chitietphieunhap, String> colSoLuong = new TableColumn<>("Số lượng");
		colSoLuong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSoluong().toString()));
		colSoLuong.setCellFactory(TextFieldTableCell.forTableColumn());
		colSoLuong.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap, String>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieunhap, String> event) {
				Chitietphieunhap chitiet = event.getTableView().getItems().get(event.getTablePosition().getRow());
				chitiet.setSoluong(Integer.parseInt(event.getNewValue().trim()));
				double dongia = chitiet.getDongia();
				chitiet.setThanhtien(dongia * chitiet.getSoluong());
				tableChiTiet.refresh();
			}
		});
		// Don gia
		TableColumn<Chitietphieunhap, String> colDonGia = new TableColumn<>("Đơn giá");
		colDonGia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDongia().toString()));
		colDonGia.setCellFactory(TextFieldTableCell.forTableColumn());
		colDonGia.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap, String>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieunhap, String> event) {
				Chitietphieunhap chitiet = event.getTableView().getItems().get(event.getTablePosition().getRow());
				chitiet.setDongia(Double.parseDouble(event.getNewValue().trim()));
				int soLuong = chitiet.getSoluong();
				chitiet.setThanhtien(soLuong * chitiet.getDongia());
				tableChiTiet.refresh();
			}
		});
		// Thanh tien
		TableColumn<Chitietphieunhap, String> colThanhTien = new TableColumn<>("Thành tiền");
		colThanhTien.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getThanhtien().toString()));
		// Ghi chu
		TableColumn<Chitietphieunhap, String> colGhiChu = new TableColumn<>("Ghi chú");
		colGhiChu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));
		colGhiChu.setCellFactory(TextFieldTableCell.forTableColumn());
		colGhiChu.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap, String>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieunhap, String> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow())
						.setGhichu(event.getNewValue().trim());
			}
		});
		// Add column
		tableChiTiet.getColumns().addAll(colSTT, colMaHang, colTenHang, colSoLuong, colDonGia, colThanhTien, colGhiChu);
		tableChiTiet.setEditable(true);
		modelTableChiTiet = FXCollections.observableArrayList();
		tableChiTiet.setItems(modelTableChiTiet);
		addRowTable();
	}
	
	private void addRowTable() {
		Hanghoa hanghoa = new Hanghoa();
		hanghoa.setMa("");
		hanghoa.setTen("");
		Chitietphieunhap chitietphieunhap = new Chitietphieunhap(hanghoa, new Phieunhap(), 0, 0d, 0d, "...", true,"");
		tableChiTiet.getItems().add(chitietphieunhap);
	}

}
