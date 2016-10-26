package com.qlbh.controller.chucnang;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.model.ChitietphieunhapHome;
import com.qlbh.model.ChitietphieuxuatHome;
import com.qlbh.model.HanghoaHome;
import com.qlbh.model.KhachhangHome;
import com.qlbh.model.KhohangHome;
import com.qlbh.model.NhacungcapHome;
import com.qlbh.model.NhanvienHome;
import com.qlbh.model.PhieunhapHome;
import com.qlbh.model.PhieuxuatHome;
import com.qlbh.pojo.Chitietphieunhap;
import com.qlbh.pojo.Chitietphieuxuat;
import com.qlbh.pojo.Donvitinh;
import com.qlbh.pojo.Hanghoa;
import com.qlbh.pojo.Khachhang;
import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Nhacungcap;
import com.qlbh.pojo.Nhanvien;
import com.qlbh.pojo.Phieunhap;
import com.qlbh.pojo.Phieuxuat;
import com.qlbh.render.combobox.MaKhachHangListCell;
import com.qlbh.render.combobox.MaNhaCungCapListCell;
import com.qlbh.render.combobox.TenKhachHangListCell;
import com.qlbh.render.combobox.TenNhaCungCapListCell;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class XuatHangController {
	private NhanvienHome nhanVienHome;
	private KhohangHome khoHangHome;
	private KhachhangHome khachHangHome;
	private HanghoaHome hangHoaHome;
	private PhieuxuatHome phieuxuatHome;
	private List<Hanghoa> hangHoaList;
	private ChitietphieuxuatHome chitietphieuxuatHome;
	private ObservableList<Hanghoa> cmbModelHangHoa;
	private Phieuxuat phieuxuat;
	private final DecimalFormat doubleFormat = new DecimalFormat("#");

	@FXML
	private JFXButton btnLuu;
	@FXML
	private ComboBox<Nhanvien> cmbNhanVien;
	private ObservableList<Nhanvien> cmbModelNhanVien;
	@FXML
	private ComboBox<Khohang> cmbKho;
	private ObservableList<Khohang> cmbModelKhoHang;
	@FXML
	private ComboBox<Khachhang> cmbTenKH;
	private ObservableList<Khachhang> cmbModelTenKH;
	@FXML
	private ComboBox<Khachhang> cmbMaKH;
	private ObservableList<Khachhang> cmbModelMaKH;
	@FXML
	private TextField txtThanhToan;
	@FXML
	private JFXButton btnTaoMoi;
	@FXML
	private JFXButton btnDong;
	@FXML
	private TableView<Chitietphieuxuat> tableChiTiet;
	private ObservableList<Chitietphieuxuat> modelTableChiTiet;
	@FXML
	private TextArea txtGhiChu;
	@FXML
	private TextField txtDiaChi;
	@FXML
	private TextField txtMaPhieu;
	@FXML
	private JFXButton btnNapLai;
	@FXML
	private DatePicker datePickerNhap;
	@FXML
	private JFXTextField txtDienThoai;
	@FXML
	private Text txtInputValidate;

	public XuatHangController() {
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
		khachHangHome = new KhachhangHome();
		hangHoaHome = new HanghoaHome();
		phieuxuatHome = new PhieuxuatHome();
		chitietphieuxuatHome = new ChitietphieuxuatHome();
		txtMaPhieu.setText(phieuxuatHome.getMaPhieu());
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
		// Load ma khach hang
		List<Khachhang> khachhangs = khachHangHome.findAll();
		cmbModelMaKH = FXCollections.observableArrayList(khachhangs);
		cmbMaKH.setItems(cmbModelMaKH);
		StringConverter<Khachhang> converterMaNCC = new StringConverter<Khachhang>() {

			@Override
			public Khachhang fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String toString(Khachhang object) {
				// TODO Auto-generated method stub
				return object.getMa();
			}
		};
		cmbMaKH.setConverter(converterMaNCC);
		cmbMaKH.setButtonCell(new MaKhachHangListCell());
		cmbMaKH.setCellFactory(new Callback<ListView<Khachhang>, ListCell<Khachhang>>() {

			public ListCell<Khachhang> call(ListView<Khachhang> param) {
				return new MaKhachHangListCell();
			}
		});
		cmbMaKH.setPromptText("Chọn mã khách hàng");
		// Load ten khach hang
		cmbModelTenKH = FXCollections.observableArrayList(khachhangs);
		cmbTenKH.setItems(cmbModelTenKH);
		cmbTenKH.setButtonCell(new TenKhachHangListCell());
		cmbTenKH.setCellFactory(new Callback<ListView<Khachhang>, ListCell<Khachhang>>() {

			public ListCell<Khachhang> call(ListView<Khachhang> param) {
				return new TenKhachHangListCell();
			}
		});
		StringConverter<Khachhang> converterTenNCC = new StringConverter<Khachhang>() {

			@Override
			public Khachhang fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String toString(Khachhang object) {
				// TODO Auto-generated method stub
				return object.getTen();
			}
		};
		cmbTenKH.setConverter(converterTenNCC);
		cmbTenKH.setPromptText("Chọn tên khách hàng");
	}

	private void initListener() {
		cmbMaKH.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Khachhang>() {

			@Override
			public void changed(ObservableValue<? extends Khachhang> arg0, Khachhang arg1, Khachhang arg2) {
				cmbTenKH.setValue(arg2);
			}
		});

		cmbTenKH.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Khachhang>() {

			@Override
			public void changed(ObservableValue<? extends Khachhang> arg0, Khachhang arg1, Khachhang arg2) {
				cmbMaKH.setValue(arg2);
			}
		});

		// listener button
		btnTaoMoi.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				createNew();
			}
		});

		btnLuu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				saveOutputBill();
			}
		});

		btnNapLai.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				refresh();
			}
		});

		btnDong.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ManHinhChinhController.tabNhapHang.getTabPane().getTabs().remove(ManHinhChinhController.tabNhapHang);
				ManHinhChinhController.tabNhapHang = null;
			}
		});
	}

	private void initTableView() {
		cmbModelHangHoa = FXCollections.observableArrayList(hangHoaList);
		// STT
		TableColumn<Chitietphieuxuat, Number> colSTT = new TableColumn<Chitietphieuxuat, Number>("STT");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(
				column -> new ReadOnlyObjectWrapper<Number>(tableChiTiet.getItems().indexOf(column.getValue()) + 1));
		// Ma hang
		TableColumn<Chitietphieuxuat, Hanghoa> colMaHang = new TableColumn<>("Mã hàng");
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
				new Callback<TableColumn.CellDataFeatures<Chitietphieuxuat, Hanghoa>, ObservableValue<Hanghoa>>() {

					@Override
					public ObservableValue<Hanghoa> call(CellDataFeatures<Chitietphieuxuat, Hanghoa> param) {
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

		colMaHang.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieuxuat, Hanghoa>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieuxuat, Hanghoa> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setHanghoa(event.getNewValue());
				if (event.getTablePosition().getRow() == modelTableChiTiet.size() - 1) {
					addRowTable();
				}
				tableChiTiet.refresh();
			}
		});

		// Ten hang
		TableColumn<Chitietphieuxuat, Hanghoa> colTenHang = new TableColumn<>("Tên hàng");
		colTenHang.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Chitietphieuxuat, Hanghoa>, ObservableValue<Hanghoa>>() {

					@Override
					public ObservableValue<Hanghoa> call(CellDataFeatures<Chitietphieuxuat, Hanghoa> param) {
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
		colTenHang.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieuxuat, Hanghoa>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieuxuat, Hanghoa> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setHanghoa(event.getNewValue());
				if (event.getTablePosition().getRow() == modelTableChiTiet.size() - 1) {
					addRowTable();
				}
				tableChiTiet.refresh();
			}
		});
		// Don vi
		TableColumn<Chitietphieuxuat, String> colDonVi = new TableColumn<>("Đơn vị");
		colDonVi.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getDonvitinh().getTen()));
		// So luong
		TableColumn<Chitietphieuxuat, String> colSoLuong = new TableColumn<>("Số lượng");
		colSoLuong
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSoluong().toString()));
		colSoLuong.setCellFactory(TextFieldTableCell.forTableColumn());
		colSoLuong.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieuxuat, String>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieuxuat, String> event) {
				Chitietphieuxuat chitiet = event.getTableView().getItems().get(event.getTablePosition().getRow());
				int soluong = Integer.parseInt(event.getNewValue().trim());
				if(soluong > chitiet.getHanghoa().getTonkho()){
					tableChiTiet.refresh();
					return;
				}
				chitiet.setSoluong(soluong);
				double dongia = chitiet.getDongia();
				chitiet.setThanhtien(dongia * chitiet.getSoluong());
				tableChiTiet.refresh();
				updateTotal();
			}
		});
		// Don gia
		TableColumn<Chitietphieuxuat, String> colDonGia = new TableColumn<>("Đơn giá");
		colDonGia.setCellValueFactory(
				cellData -> new SimpleStringProperty(doubleFormat.format(cellData.getValue().getDongia())));
		colDonGia.setCellFactory(TextFieldTableCell.forTableColumn());
		colDonGia.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieuxuat, String>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieuxuat, String> event) {
				Chitietphieuxuat chitiet = event.getTableView().getItems().get(event.getTablePosition().getRow());
				chitiet.setDongia(Double.parseDouble(event.getNewValue().trim()));
				int soLuong = chitiet.getSoluong();
				chitiet.setThanhtien(soLuong * chitiet.getDongia());
				tableChiTiet.refresh();
				updateTotal();
			}
		});
		// Thanh tien
		TableColumn<Chitietphieuxuat, String> colThanhTien = new TableColumn<>("Thành tiền");
		colThanhTien.setCellValueFactory(cellData -> new SimpleStringProperty(
				doubleFormat.format(cellData.getValue().getThanhtien())));
//		// Ghi chu
//		TableColumn<Chitietphieuxuat, String> colGhiChu = new TableColumn<>("Ghi chú");
//		colGhiChu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));
//		colGhiChu.setCellFactory(TextFieldTableCell.forTableColumn());
//		colGhiChu.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieuxuat, String>>() {
//
//			@Override
//			public void handle(CellEditEvent<Chitietphieuxuat, String> event) {
//				event.getTableView().getItems().get(event.getTablePosition().getRow())
//						.setGhichu(event.getNewValue().trim());
//			}
//		});
		// Add column
		tableChiTiet.getColumns().addAll(colSTT, colMaHang, colTenHang, colDonVi, colSoLuong, colDonGia, colThanhTien);
		tableChiTiet.setEditable(true);
		modelTableChiTiet = FXCollections.observableArrayList();
		tableChiTiet.setItems(modelTableChiTiet);
		addRowTable();
	}

	private void updateTotal() {
		double total = 0;
		for (Chitietphieuxuat chitietphieunhap : modelTableChiTiet) {
			total += chitietphieunhap.getThanhtien();
		}
		txtThanhToan.setText(doubleFormat.format(total));
	}

	private void addRowTable() {
		Donvitinh donvitinh = new Donvitinh();
		donvitinh.setTen("");
		Hanghoa hanghoa = new Hanghoa();
		hanghoa.setMa("Chọn mã");
		hanghoa.setTen("Chọn tên");
		hanghoa.setDonvitinh(donvitinh);
		Chitietphieuxuat chitietphieunhap = new Chitietphieuxuat(hanghoa, new Phieuxuat(), "", 0, 0d, 0d, true);
		tableChiTiet.getItems().add(chitietphieunhap);
	}

	private void createNew() {
		phieuxuat = null;
		cmbKho.setValue(null);
		cmbMaKH.setValue(null);
		cmbNhanVien.setValue(null);
		cmbTenKH.setValue(null);
		txtDiaChi.setText("");
		txtGhiChu.setText("");
		txtThanhToan.setText("0");
		txtDienThoai.setText("");
		txtMaPhieu.setText(phieuxuatHome.getMaPhieu());

		modelTableChiTiet.clear();
		addRowTable();
		tableChiTiet.refresh();
	}

	private void refresh() {
		phieuxuat = null;
		cmbKho.setValue(null);
		cmbMaKH.setValue(null);
		cmbNhanVien.setValue(null);
		cmbTenKH.setValue(null);
		txtDiaChi.setText("");
		txtGhiChu.setText("");
		txtThanhToan.setText("0");
		txtDienThoai.setText("");
		txtMaPhieu.setText(phieuxuatHome.getMaPhieu());
		if (!modelTableChiTiet.get(modelTableChiTiet.size() - 1).getHanghoa().getTen().equalsIgnoreCase("Chọn tên")) {
			addRowTable();
		}
	}

	private void saveOutputBill() {
		if(txtMaPhieu.getText().isEmpty() || cmbKho.getValue() == null || cmbMaKH.getValue() == null
				|| cmbNhanVien.getValue() == null || datePickerNhap.getValue() == null) {
			txtInputValidate.setText("Phải chọn đầy đủ thông tin phiếu nhập");
			return;
		}else{
			txtInputValidate.setText("");
		}
		LocalDate localDate = datePickerNhap.getValue();
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date ngayNhap = Date.from(instant);
		if (phieuxuat == null) {
			phieuxuat = new Phieuxuat();
			phieuxuat.setId(0);
		}
		phieuxuat.setKhohang(cmbKho.getValue());
		phieuxuat.setNhanvien(cmbNhanVien.getValue());
		phieuxuat.setKhachhang(cmbTenKH.getValue());
		phieuxuat.setDiachi(txtDiaChi.getText());
		phieuxuat.setMa(txtMaPhieu.getText());
		phieuxuat.setDienthoai(txtDienThoai.getText());
		phieuxuat.setGhichu(txtGhiChu.getText());
		phieuxuat.setNgaylap(ngayNhap);
		phieuxuat.setTongtien(Double.parseDouble(txtThanhToan.getText().trim()));
		phieuxuat.setActivity(true);
		if (phieuxuat.getId() == 0) {
			phieuxuatHome.save(phieuxuat);
			// Save chi tiet
			for (Chitietphieuxuat chitietphieuxuat : modelTableChiTiet) {
				chitietphieuxuat.setPhieuxuat(phieuxuat);
				chitietphieuxuatHome.save(chitietphieuxuat);
				hangHoaHome.giamSoLuongHangHoa(chitietphieuxuat.getHanghoa(), chitietphieuxuat.getSoluong());
			}
		} else {
			updatePhieuXuat(phieuxuat);
		}

	}

	private Set<Chitietphieuxuat> getChiTietPhieuNhapList() {
		modelTableChiTiet.remove(modelTableChiTiet.size() - 1);
		Set<Chitietphieuxuat> chitietphieunhaps = new HashSet<>();
		chitietphieunhaps.addAll(modelTableChiTiet);
		return chitietphieunhaps;
	}

	private void updatePhieuXuat(Phieuxuat phieuxuat) {
		phieuxuatHome.update(phieuxuat);
		for (Chitietphieuxuat chitietphieuxuat : modelTableChiTiet) {
			chitietphieuxuatHome.update(chitietphieuxuat);
			Chitietphieuxuat chitiet = chitietphieuxuatHome.findById(chitietphieuxuat.getId());
			int newValue = chitietphieuxuat.getSoluong();
			int oldValue = chitiet.getSoluong();
			if (chitiet != null) {
				if (newValue >= oldValue) {
					hangHoaHome.giamSoLuongHangHoa(chitietphieuxuat.getHanghoa(),newValue - oldValue);
				} else {
					hangHoaHome.themSoLuongHangHoa(chitietphieuxuat.getHanghoa(), newValue - oldValue);
				}
			}
		}
	}

}
