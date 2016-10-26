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
import com.qlbh.model.PhieuxuatHome;
import com.qlbh.pojo.Phieuxuat;
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

public class ThuTienController {
	@FXML
	ComboBox<DateOption> cbxTuyChonNgay;
	@FXML
	DatePicker dateNgayBatDau, dateNgayKetThuc;
	@FXML
	TableView<Phieuxuat> tableThuTien;
	
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
	PhieuxuatHome phieuxuatHome = new PhieuxuatHome();
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
		// Load table PhieuXuat
		this.loadTableThuTien();
	}

	@FXML
	void onDateOptionChange(ActionEvent event) {
		this.setDatePeriod();
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

	@SuppressWarnings("unchecked")
	private ObservableList<Phieuxuat> getDSPhieuXuat() {
		List<Phieuxuat> phieuxuats = phieuxuatHome.findAll();
		ObservableList<Phieuxuat> oListPhieuXuat = FXCollections.observableList(phieuxuats);
		return oListPhieuXuat;
	}
	@SuppressWarnings("unchecked")
	private ObservableList<Phieuxuat> getDSPhieuXuat(Date beginDay, Date enđDay) {
		List<Phieuxuat> phieuxuats = phieuxuatHome.getDataInPeriodTime(beginDay, enđDay);
		ObservableList<Phieuxuat> oListPhieuXuat = FXCollections.observableList(phieuxuats);
		return oListPhieuXuat;
	}
	@SuppressWarnings("unchecked")
	private void loadTableThuTien() {
		TableColumn<Phieuxuat, Number> colSTT = new TableColumn<>("#");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableThuTien.getItems().indexOf(column.getValue()) + 1));
		
		TableColumn<Phieuxuat, String> colMa = new TableColumn<>("Phiếu");
		colMa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));
		
		TableColumn<Phieuxuat, String> colNgayLap = new TableColumn<>("Ngày lập");
		colNgayLap.setCellValueFactory(cellData -> new SimpleStringProperty(df.format(cellData.getValue().getNgaylap())));
		
		TableColumn<Phieuxuat, String> colNgayGiao = new TableColumn<>("Ngày giao");
		colNgayGiao.setCellValueFactory(cellData -> new SimpleStringProperty(df.format(cellData.getValue().getNgaygiao())));
		
		TableColumn<Phieuxuat, String> colMaNV = new TableColumn<>("Mã NV bán");
		colMaNV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNhanvien().getMa()));
		
		TableColumn<Phieuxuat, String> colTenNV = new TableColumn<>("Tên NV bán");
		colTenNV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNhanvien().getTen()));
		
		TableColumn<Phieuxuat, String> colMaKH = new TableColumn<>("Mã KH");
		colMaKH.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhachhang().getMa()));
		
		TableColumn<Phieuxuat, String> colTenKH = new TableColumn<>("Tên KH");
		colTenKH.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhachhang().getTen()));
		
		TableColumn<Phieuxuat, String> colMaKho = new TableColumn<>("Mã Kho");
		colMaKho.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhohang().getMa()));
		
		TableColumn<Phieuxuat, String> colTenKho = new TableColumn<>("Tên Kho");
		colTenKho.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhohang().getTen()));
		
		TableColumn<Phieuxuat, String> colTongTien = new TableColumn<>("Tổng tiền");
		colTongTien.setCellValueFactory(cellData -> new SimpleStringProperty(Display.formatMoney(cellData.getValue().getTongtien())));
		
		TableColumn<Phieuxuat, String> colGhiChu = new TableColumn<>("Ghi chú");
		colGhiChu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));
		
		if ( dateNgayBatDau.getValue() == null || dateNgayKetThuc.getValue() == null ) {
			this.tableThuTien.setItems(this.getDSPhieuXuat());
		} else {
			Date beginDate = Date.from(dateNgayBatDau.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date endDate = Date.from(dateNgayKetThuc.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			this.tableThuTien.setItems(this.getDSPhieuXuat(beginDate, endDate));
		}
		
		this.tableThuTien.getColumns().addAll(colSTT, colMa, colNgayLap, colNgayGiao, colMaNV, colTenNV, colMaKH, colTenKH, colMaKho, colTenKho, colTongTien, colGhiChu);
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
			this.tableThuTien.setItems(this.getDSPhieuXuat());
		} else {
			Date beginDate = Date.from(dateNgayBatDau.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date endDate = Date.from(dateNgayKetThuc.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			this.tableThuTien.setItems(this.getDSPhieuXuat(beginDate, endDate));
		}
	}
	
	@FXML
	void onButtonXoaClick(ActionEvent event) {

	}

	@FXML
	void onButtonExitClick(ActionEvent event) {
		ManHinhChinhController.tabThuTien.getTabPane().getTabs().remove(ManHinhChinhController.tabThuTien);
		ManHinhChinhController.tabThuTien = null;
	}
}
