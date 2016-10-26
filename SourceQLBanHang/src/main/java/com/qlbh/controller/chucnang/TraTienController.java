package com.qlbh.controller.chucnang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.Display;
import com.qlbh.model.PhieunhapHome;
import com.qlbh.pojo.Phieunhap;
import com.qlbh.render.combobox.DateOption;
import com.qlbh.util.DataInputUtils;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TraTienController {
	@FXML
	ComboBox<DateOption> cbxTuyChonNgay;
	@FXML
	DatePicker dateNgayBatDau, dateNgayKetThuc;
	@FXML
	TableView<Phieunhap> tableChiTien;
	
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
	PhieunhapHome phieunhapHome = new PhieunhapHome();
	
	@FXML
	public void initialize() {
		// Set data for comboBox
		cbxTuyChonNgay.setItems(DateOption.getDateOptions());
		// Select first option
		cbxTuyChonNgay.getSelectionModel().select(0);
		// Set format of date for two DatePicker
		DataInputUtils.formatDatePicker(dateNgayBatDau, "dd/MM/yyyy");
		DataInputUtils.formatDatePicker(dateNgayKetThuc, "dd/MM/yyyy");
		dateNgayBatDau.setShowWeekNumbers(false);
		dateNgayKetThuc.setShowWeekNumbers(false);
		// Set initial date as a first option
		this.setDatePeriod();
		// Load table PhieuNhap
		this.loadTableTraTien();
	}
	
	private void setDatePeriod() {
		DateOption selectedDateOption = cbxTuyChonNgay.getValue();
		if ( selectedDateOption.getBeginDate() != null && selectedDateOption.getEndDate() != null ) {
			LocalDate localdateBegin = selectedDateOption.getBeginDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate localdateEnd = selectedDateOption.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			dateNgayBatDau.setValue(localdateBegin);
			dateNgayKetThuc.setValue(localdateEnd);
		} else {
			dateNgayBatDau.setValue(null);
			dateNgayKetThuc.setValue(null);
		}
	}

	@FXML
	void onDateOptionChange(ActionEvent event) {
		this.setDatePeriod();
	}
	
	@FXML
	void onButtonDSPhieuThuClick(ActionEvent event) {
		
	}
	@FXML
	void onButtonDSPhieuCongNoClick(ActionEvent event) {
		
	}
	@FXML
	void onButtonDSPhieuTraNgayClick(ActionEvent event) {
		
	}
	@FXML
	void onButtonTheoDoiCongNoClick(ActionEvent event) {
		
	}
	@FXML
	void onButtonTongHopCongNoClick(ActionEvent event) {
		
	}
	@FXML
	void onButtonXemClick(ActionEvent event) {
		if ( dateNgayBatDau.getValue() == null || dateNgayKetThuc.getValue() == null ) {
			this.tableChiTien.setItems(this.getDSPhieuNhap());
		} else {
			Date beginDate = Date.from(dateNgayBatDau.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date endDate = Date.from(dateNgayKetThuc.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			this.tableChiTien.setItems(this.getDSPhieuNhap(beginDate, endDate));
		}
	}
	@SuppressWarnings("unchecked")
	private ObservableList<Phieunhap> getDSPhieuNhap() {
		List<Phieunhap> phieunhaps = phieunhapHome.findAll();
		return FXCollections.observableList(phieunhaps);
	}
	@SuppressWarnings("unchecked")
	private ObservableList<Phieunhap> getDSPhieuNhap(Date beginDay, Date enđDay) {
		List<Phieunhap> phieunhaps = phieunhapHome.getDataInPeriodTime(beginDay, enđDay);
		return FXCollections.observableList(phieunhaps);
	}
	@SuppressWarnings("unchecked")
	private void loadTableTraTien() {
		TableColumn<Phieunhap, Number> colSTT = new TableColumn<>("#");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableChiTien.getItems().indexOf(column.getValue()) + 1));
		
		TableColumn<Phieunhap, String> colMa = new TableColumn<>("Phiếu");
		colMa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));
		
		TableColumn<Phieunhap, String> colNgayLap = new TableColumn<>("Ngày lập");
		colNgayLap.setCellValueFactory(cellData -> new SimpleStringProperty(df.format(cellData.getValue().getNgaynhap())));
				
		TableColumn<Phieunhap, String> colMaNV = new TableColumn<>("Mã NV");
		colMaNV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNhanvien().getMa()));
		
		TableColumn<Phieunhap, String> colTenNV = new TableColumn<>("Tên NV");
		colTenNV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNhanvien().getTen()));
		
		TableColumn<Phieunhap, String> colMaKH = new TableColumn<>("Mã NCC");
		colMaKH.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNhacungcap().getMa()));
		
		TableColumn<Phieunhap, String> colTenKH = new TableColumn<>("Tên NCC");
		colTenKH.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNhacungcap().getTen()));
		
		TableColumn<Phieunhap, String> colMaKho = new TableColumn<>("Mã Kho");
		colMaKho.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhohang().getMa()));
		
		TableColumn<Phieunhap, String> colTenKho = new TableColumn<>("Tên Kho");
		colTenKho.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhohang().getTen()));
		
		TableColumn<Phieunhap, String> colDienThoai = new TableColumn<>("Điện thoại");
		colDienThoai.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDienthoai().toString()));
		
		TableColumn<Phieunhap, String> colTongTien = new TableColumn<>("Tổng tiền");
		colTongTien.setCellValueFactory(cellData -> new SimpleStringProperty(Display.formatMoney(cellData.getValue().getTongtien())));
		
		TableColumn<Phieunhap, String> colGhiChu = new TableColumn<>("Ghi chú");
		colGhiChu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));
		
		
		if ( dateNgayBatDau.getValue() == null || dateNgayKetThuc.getValue() == null ) {
			this.tableChiTien.setItems(this.getDSPhieuNhap());
		} else {
			Date beginDate = Date.from(dateNgayBatDau.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date endDate = Date.from(dateNgayKetThuc.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			this.tableChiTien.setItems(this.getDSPhieuNhap(beginDate, endDate));
		}
		this.tableChiTien.getColumns().addAll(colSTT, colMa, colNgayLap, colMaNV, colTenNV, colMaKH, colTenKH, colMaKho, colTenKho, colDienThoai, colTongTien, colGhiChu);
	}
	@FXML
	void onButtonXoaClick(ActionEvent event) {
		
	}
	@FXML
	void onButtonExitClick(ActionEvent event) {
		ManHinhChinhController.tabTraTien.getTabPane().getTabs().remove(ManHinhChinhController.tabTraTien);
		ManHinhChinhController.tabTraTien = null;
	}
}
