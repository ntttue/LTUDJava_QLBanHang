package com.qlbh.controller.chucnang;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.Display;
import com.qlbh.model.ChitietchuyenkhoHome;
import com.qlbh.model.ChitietphieunhapHome;
import com.qlbh.model.ChuyenkhoHome;
import com.qlbh.model.HanghoaHome;
import com.qlbh.model.KhohangHome;
import com.qlbh.model.NhanvienHome;
import com.qlbh.pojo.Chitietchuyenkho;
import com.qlbh.pojo.Chitietphieunhap;
import com.qlbh.pojo.Chuyenkho;
import com.qlbh.pojo.Donvitinh;
import com.qlbh.pojo.Hanghoa;
import com.qlbh.pojo.Khohang;
import com.qlbh.pojo.Nhanvien;
import com.qlbh.util.DataInputUtils;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class PhieuChuyenKhoController {
	@FXML
	private ComboBox<Khohang> cbxKhoXuatHang, cbxKhoNhapHang;
	@FXML
	private ComboBox<Nhanvien> cbxNguoiNhan, cbxNguoiChuyen;
	@FXML
	private TextField txtGhiChu, txtPhieuCK, txtPhieuChuyenTay, numSoLuong, numThanhTien;
	@FXML
	private TableView<Chitietchuyenkho> tableDSHangHoa;
	@FXML
	private Text txtValidate;
	@FXML
	private DatePicker datePickerNgay;
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
	private ObservableList<Chitietchuyenkho> listChitietchuyenkho;
	private final DecimalFormat doubleFormat = new DecimalFormat("#");
	
	@SuppressWarnings("unchecked")
	private ObservableList<Khohang> getListKhoHang() {
		KhohangHome khHome = new KhohangHome();
		List<Khohang> listKH = khHome.findAll();
		ObservableList<Khohang> oListKhoHang = FXCollections.observableList(listKH);
		return oListKhoHang;
	}
	
	@SuppressWarnings("unchecked")
	private ObservableList<Nhanvien> getDSNhanVien() {
		NhanvienHome nhanVienHome = new NhanvienHome();
		List<Nhanvien> nhanViens = nhanVienHome.findAll();
		return FXCollections.observableList(nhanViens);
	}
	
	private ObservableList<Hanghoa> getDSHangHoa() {
		HanghoaHome hangHoaHome = new HanghoaHome();
		List<Hanghoa> hangHoas = hangHoaHome.getHangHoaList();
		return FXCollections.observableList(hangHoas);
	}
	
	private void setcbxKhoXuat() {
		cbxKhoXuatHang.setItems(this.getListKhoHang());
		cbxKhoXuatHang.getSelectionModel().select(0);
	}
	
	private void setcbxKhoNhap() {
		cbxKhoNhapHang.setItems(this.getListKhoHang());
		cbxKhoNhapHang.getSelectionModel().select(0);
	}
	
	private void setcbxNguoiNhan() {
		cbxNguoiNhan.setItems(this.getDSNhanVien());
		cbxNguoiNhan.getSelectionModel().select(0);
	}
	
	private void setcbxNguoiChuyen() {
		cbxNguoiChuyen.setItems(this.getDSNhanVien());
		cbxNguoiChuyen.getSelectionModel().select(0);
	}
	
	private void addRowTable() {
		Donvitinh donvitinh = new Donvitinh();
		donvitinh.setTen("");
		Hanghoa hanghoa = new Hanghoa();
		hanghoa.setMa("(Chọn)");
		hanghoa.setTen("(Click vào đây)");
		hanghoa.setDonvitinh(donvitinh);
		Chitietchuyenkho ctCK = new Chitietchuyenkho(new Chuyenkho(), hanghoa, "CTCK00001", 0, 0d, 0d, true);
		tableDSHangHoa.getItems().add(ctCK);
	}
	
	private void loadTable() {
		TableColumn<Chitietchuyenkho, Number> colSTT = new TableColumn<>("#");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableDSHangHoa.getItems().indexOf(column.getValue()) + 1));
		
		// Ma hang
		TableColumn<Chitietchuyenkho, Hanghoa> colMaHang = new TableColumn<>("Mã hàng");
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
			new Callback<TableColumn.CellDataFeatures<Chitietchuyenkho, Hanghoa>, ObservableValue<Hanghoa>>() {
				@Override
				public ObservableValue<Hanghoa> call(CellDataFeatures<Chitietchuyenkho, Hanghoa> param) {
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
		colMaHang.setCellFactory(ComboBoxTableCell.forTableColumn(converterMa, this.getDSHangHoa()));

		colMaHang.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietchuyenkho, Hanghoa>>() {
			@Override
			public void handle(CellEditEvent<Chitietchuyenkho, Hanghoa> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setHanghoa(event.getNewValue());
				if (event.getTablePosition().getRow() == listChitietchuyenkho.size() - 1) {
					addRowTable();
				}
				tableDSHangHoa.refresh();
			}
		});
		// Ten hang
		TableColumn<Chitietchuyenkho, Hanghoa> colTenHang = new TableColumn<>("Tên hàng");
		colTenHang.setCellValueFactory(
			new Callback<TableColumn.CellDataFeatures<Chitietchuyenkho, Hanghoa>, ObservableValue<Hanghoa>>() {
				@Override
				public ObservableValue<Hanghoa> call(CellDataFeatures<Chitietchuyenkho, Hanghoa> param) {
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
		colTenHang.setCellFactory(ComboBoxTableCell.forTableColumn(converterTen, this.getDSHangHoa()));
		colTenHang.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietchuyenkho, Hanghoa>>() {
			@Override
			public void handle(CellEditEvent<Chitietchuyenkho, Hanghoa> event) {
				event.getTableView().getItems().get(event.getTablePosition().getRow()).setHanghoa(event.getNewValue());
				if (event.getTablePosition().getRow() == listChitietchuyenkho.size() - 1) {
					addRowTable();
				}
				tableDSHangHoa.refresh();
			}
		});
		// Don vi
		TableColumn<Chitietchuyenkho, String> colDonVi = new TableColumn<>("Đơn vị");
		colDonVi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getDonvitinh().getTen()));
		// So luong
		TableColumn<Chitietchuyenkho, String> colSoLuong = new TableColumn<>("Số lượng");
		colSoLuong
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSoluong().toString()));
		colSoLuong.setCellFactory(TextFieldTableCell.forTableColumn());
		colSoLuong.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietchuyenkho, String>>() {
			@Override
			public void handle(CellEditEvent<Chitietchuyenkho, String> event) {
				Chitietchuyenkho chitiet = event.getTableView().getItems().get(event.getTablePosition().getRow());
				chitiet.setSoluong(Integer.parseInt(event.getNewValue().trim()));
				double dongia = chitiet.getDongia();
				chitiet.setThanhtien(dongia * chitiet.getSoluong());
				tableDSHangHoa.refresh();
				updateTotal();
			}
		});
		// Don gia
		TableColumn<Chitietchuyenkho, String> colDonGia = new TableColumn<>("Đơn giá");
		colDonGia.setCellValueFactory(
				cellData -> new SimpleStringProperty(doubleFormat.format(cellData.getValue().getDongia())));
		colDonGia.setCellFactory(TextFieldTableCell.forTableColumn());
		colDonGia.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Chitietchuyenkho, String>>() {
	
			@Override
			public void handle(CellEditEvent<Chitietchuyenkho, String> event) {
				Chitietchuyenkho chitiet = event.getTableView().getItems().get(event.getTablePosition().getRow());
				chitiet.setDongia(Double.parseDouble(event.getNewValue().trim()));
				int soLuong = chitiet.getSoluong();
				chitiet.setThanhtien(soLuong * chitiet.getDongia());
				tableDSHangHoa.refresh();
				updateTotal();
			}
		});
		// Thanh tien
		TableColumn<Chitietchuyenkho, String> colThanhTien = new TableColumn<>("Thành tiền");
		colThanhTien.setCellValueFactory(cellData -> new SimpleStringProperty(
				doubleFormat.format(cellData.getValue().getThanhtien())));
		// Add column
		tableDSHangHoa.getColumns().addAll(colSTT, colMaHang, colTenHang, colDonVi, colSoLuong, colDonGia, colThanhTien);
		tableDSHangHoa.setEditable(true);
		listChitietchuyenkho = FXCollections.observableArrayList();
		tableDSHangHoa.setItems(listChitietchuyenkho);
		addRowTable();
	}
	private void updateTotal() {
		double tongTien = 0;
		double tongSoluong = 0;
		for (Chitietchuyenkho chitietchuyenkho : listChitietchuyenkho) {
			tongSoluong += chitietchuyenkho.getSoluong();
			tongTien    += chitietchuyenkho.getThanhtien();
		}
		numThanhTien.setText(Display.formatMoney(tongTien));
		numSoLuong.setText(doubleFormat.format(tongSoluong));
	}
	@FXML
	void initialize() {
		DataInputUtils.formatDatePicker(datePickerNgay, "dd/MM/yyyy");
		datePickerNgay.setValue((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		datePickerNgay.setShowWeekNumbers(false);
		this.setcbxKhoNhap();
		this.setcbxKhoXuat();
		this.setcbxNguoiChuyen();
		this.setcbxNguoiNhan();
		listChitietchuyenkho = FXCollections.observableArrayList();
		this.loadTable();
	}
	@FXML
	void onButtonTaoMoiClick(ActionEvent event) {
		listChitietchuyenkho = FXCollections.observableArrayList();
		tableDSHangHoa.setItems(listChitietchuyenkho);
		addRowTable();
	}

	@FXML
	void onButtonLuuClick(ActionEvent event) {
		// Check validate
		if (DataInputUtils.isEmpty(txtPhieuCK) || cbxKhoNhapHang.getValue() == null
				|| cbxKhoXuatHang.getValue() == null || cbxNguoiChuyen.getValue() == null
				|| cbxNguoiNhan.getValue() == null) {
			txtValidate.setText("Vui lòng điền đủ thông tin trong các mục (*)");
			return;
		}
		txtValidate.setText("");
		
		Chuyenkho phieuChuyenkho = new Chuyenkho();
		phieuChuyenkho.setMa(DataInputUtils.getStringFromTextField(txtPhieuCK));
		phieuChuyenkho.setPhieuchuyentay(DataInputUtils.getStringFromTextField(txtPhieuChuyenTay));
		if ( datePickerNgay.getValue() != null ) {
			Date ngayLap = Date.from(datePickerNgay.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			phieuChuyenkho.setNgay(ngayLap);
		} else {
			phieuChuyenkho.setNgay(new Date());
		}
		
		phieuChuyenkho.setKhohangByKhonhanid(cbxKhoNhapHang.getValue());
		phieuChuyenkho.setKhohangByKhochuyenid(cbxKhoXuatHang.getValue());
		
		phieuChuyenkho.setNhanvienByNguoichuyenid(cbxNguoiChuyen.getValue());
		phieuChuyenkho.setNhanvienByNguoinhanid(cbxNguoiNhan.getValue());
		
		phieuChuyenkho.setGhichu(DataInputUtils.getStringFromTextField(txtGhiChu));
		
		phieuChuyenkho.setActivity(true);
		
		phieuChuyenkho.setChitietchuyenkhos(this.getChiTietChuyenKhoList());
		
		ChuyenkhoHome chuyenKhoHome = new ChuyenkhoHome();
		ChitietchuyenkhoHome ctckHome = new ChitietchuyenkhoHome();
		
		chuyenKhoHome.save(phieuChuyenkho);
		// Save chi tiet
		for (Chitietchuyenkho chitietchuyenkho : listChitietchuyenkho) {
			chitietchuyenkho.setChuyenkho(phieuChuyenkho);
			ctckHome.save(chitietchuyenkho);
		}
		this.resetView();
	}
	
	private Set<Chitietchuyenkho> getChiTietChuyenKhoList() {
		listChitietchuyenkho.remove(listChitietchuyenkho.size() - 1);
		Set<Chitietchuyenkho> chitietchuyenkhos = new HashSet<>();
		chitietchuyenkhos.addAll(listChitietchuyenkho);
		return chitietchuyenkhos;
	}
	
	private void resetView() {
		txtGhiChu.setText("");
		txtPhieuCK.setText("");
		txtPhieuChuyenTay.setText("");
		LocalDate dateNow = (new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		datePickerNgay.setValue(dateNow);
		cbxKhoNhapHang.getSelectionModel().select(0);
		cbxKhoXuatHang.getSelectionModel().select(0);
		cbxNguoiChuyen.getSelectionModel().select(0);
		cbxNguoiNhan.getSelectionModel().select(0);
		listChitietchuyenkho = FXCollections.observableArrayList();
		tableDSHangHoa.setItems(listChitietchuyenkho);
		addRowTable();
	}

	@FXML
	void onButtonNapLaiClick(ActionEvent event) {
		this.resetView();
	}

	@FXML
	void onButtonExitClick(ActionEvent event) {
		ManHinhChinhController.tabChuyenKho.getTabPane().getTabs().remove(ManHinhChinhController.tabChuyenKho);
		ManHinhChinhController.tabChuyenKho = null;
	}
}
