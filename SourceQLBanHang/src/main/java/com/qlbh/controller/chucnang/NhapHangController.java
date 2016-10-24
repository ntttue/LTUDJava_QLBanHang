package com.qlbh.controller.chucnang;

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
import com.qlbh.model.HanghoaHome;
import com.qlbh.model.KhohangHome;
import com.qlbh.model.NhacungcapHome;
import com.qlbh.model.NhanvienHome;
import com.qlbh.model.PhieunhapHome;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class NhapHangController {

	private NhanvienHome nhanVienHome;
	private KhohangHome khoHangHome;
	private NhacungcapHome nhaCungCapHome;
	private HanghoaHome hangHoaHome;
	private PhieunhapHome phieunhapHome;
	private List<Hanghoa> hangHoaList;
	private ChitietphieunhapHome chitietphieunhapHome;
	private ObservableList<Hanghoa> cmbModelHangHoa;
	private Phieunhap phieunhap;

	@FXML
	private JFXButton btnLuu;
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
	private JFXButton btnTaoMoi;
	@FXML
	private JFXButton btnDong;
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
	private JFXButton btnNapLai;
	@FXML
	private DatePicker datePickerNhap;
	@FXML
	private JFXTextField txtDienThoai;

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
		phieunhapHome = new PhieunhapHome();
		chitietphieunhapHome = new ChitietphieunhapHome();
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
		StringConverter<Nhacungcap> converterMaNCC = new StringConverter<Nhacungcap>() {

			@Override
			public Nhacungcap fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String toString(Nhacungcap object) {
				// TODO Auto-generated method stub
				return object.getMa();
			}
		};
		cmbMaNCC.setConverter(converterMaNCC);
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
		StringConverter<Nhacungcap> converterTenNCC = new StringConverter<Nhacungcap>() {

			@Override
			public Nhacungcap fromString(String string) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String toString(Nhacungcap object) {
				// TODO Auto-generated method stub
				return object.getTen();
			}
		};
		cmbTenNCC.setConverter(converterTenNCC);
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
				saveInputBill();
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
				if (event.getTablePosition().getRow() == modelTableChiTiet.size() - 1) {
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
				if (event.getTablePosition().getRow() == modelTableChiTiet.size() - 1) {
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
		colSoLuong
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSoluong().toString()));
		colSoLuong.setCellFactory(TextFieldTableCell.forTableColumn());
		colSoLuong.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietphieunhap, String>>() {

			@Override
			public void handle(CellEditEvent<Chitietphieunhap, String> event) {
				Chitietphieunhap chitiet = event.getTableView().getItems().get(event.getTablePosition().getRow());
				chitiet.setSoluong(Integer.parseInt(event.getNewValue().trim()));
				double dongia = chitiet.getDongia();
				chitiet.setThanhtien(dongia * chitiet.getSoluong());
				tableChiTiet.refresh();
				updateTotal();
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
				updateTotal();
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

	private void updateTotal() {
		double total = 0;
		for (Chitietphieunhap chitietphieunhap : modelTableChiTiet) {
			total += chitietphieunhap.getThanhtien();
		}
		txtThanhToan.setText(total + "");
	}

	private void addRowTable() {
		Hanghoa hanghoa = new Hanghoa();
		hanghoa.setMa("");
		hanghoa.setTen("");
		Chitietphieunhap chitietphieunhap = new Chitietphieunhap(hanghoa, new Phieunhap(), 0, 0d, 0d, "", true, "");
		tableChiTiet.getItems().add(chitietphieunhap);
	}

	private void createNew() {
		phieunhap = null;
		cmbKho.setValue(null);
		cmbMaNCC.setValue(null);
		cmbNhanVien.setValue(null);
		cmbTenNCC.setValue(null);
		txtDiaChi.setText("");
		txtGhiChu.setText("");
		txtThanhToan.setText("0");
		txtDienThoai.setText("");
		txtMaPhieu.setText("");

		modelTableChiTiet.clear();
		addRowTable();
		tableChiTiet.refresh();
	}

	private void refresh() {
		phieunhap = null;
		cmbKho.setValue(null);
		cmbMaNCC.setValue(null);
		cmbNhanVien.setValue(null);
		cmbTenNCC.setValue(null);
		txtDiaChi.setText("");
		txtGhiChu.setText("");
		txtThanhToan.setText("0");
		txtDienThoai.setText("");
		txtMaPhieu.setText("");
		if (!modelTableChiTiet.get(modelTableChiTiet.size() - 1).getHanghoa().getTen().isEmpty()) {
			addRowTable();
		}
	}

	private void saveInputBill() {
		LocalDate localDate = datePickerNhap.getValue();
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date ngayNhap = Date.from(instant);
		if(phieunhap == null){
			phieunhap = new Phieunhap();
			phieunhap.setId(0);
		}
		phieunhap.setKhohang(cmbKho.getValue());
		phieunhap.setNhanvien(cmbNhanVien.getValue());
		phieunhap.setNhacungcap(cmbTenNCC.getValue());
		phieunhap.setDiachi(txtDiaChi.getText());
		phieunhap.setMa(txtMaPhieu.getText());
		phieunhap.setDienthoai(txtDienThoai.getText());
		phieunhap.setGhichu(txtGhiChu.getText());
		phieunhap.setNgaynhap(ngayNhap);
		phieunhap.setTongtien(Double.parseDouble(txtThanhToan.getText().trim()));
		phieunhap.setActivity(true);
		phieunhap.setChitietphieunhaps(getChiTietPhieuNhapList());
		if (phieunhap.getId() == 0) {
			phieunhapHome.save(phieunhap);
			// Save chi tiet
			for (Chitietphieunhap chitietphieunhap : modelTableChiTiet) {
				chitietphieunhap.setPhieunhap(phieunhap);
				chitietphieunhapHome.save(chitietphieunhap);
				hangHoaHome.themSoLuongHangHoa(chitietphieunhap.getHanghoa() , phieunhap.getKhohang().getId(), chitietphieunhap.getSoluong());
			}
		} else {
			updatePhieuNhap(phieunhap);
		}

	}

	private Set<Chitietphieunhap> getChiTietPhieuNhapList() {
		modelTableChiTiet.remove(modelTableChiTiet.size() - 1);
		Set<Chitietphieunhap> chitietphieunhaps = new HashSet<>();
		chitietphieunhaps.addAll(modelTableChiTiet);
		return chitietphieunhaps;
	}

	private void updatePhieuNhap(Phieunhap phieunhap) {
		phieunhapHome.update(phieunhap);
		for (Chitietphieunhap chitietphieunhap : modelTableChiTiet) {
			chitietphieunhapHome.update(chitietphieunhap);
			Chitietphieunhap chitiet = chitietphieunhapHome.findById(chitietphieunhap.getId());
			int newValue = chitietphieunhap.getSoluong();
			int oldValue = chitiet.getSoluong();
			if (chitiet != null) {
				if (newValue >= oldValue) {
					hangHoaHome.themSoLuongHangHoa(chitietphieunhap.getHanghoa() , phieunhap.getKhohang().getId(), newValue - oldValue);
				} else {
					hangHoaHome.giamSoLuongHangHoa(chitietphieunhap.getHanghoa() , phieunhap.getKhohang().getId(), newValue - oldValue);
				}
			}
		}
	}

}
