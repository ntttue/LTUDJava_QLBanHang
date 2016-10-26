package com.qlbh.controller.chucnang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.model.ChuyenkhoHome;
import com.qlbh.pojo.Chitietchuyenkho;
import com.qlbh.pojo.Chuyenkho;
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

public class ThongKeChuyenKhoController {
	@FXML
	ComboBox<DateOption> cbxTuyChonNgay;
	@FXML
	DatePicker dateNgayBatDau, dateNgayKetThuc;
	@FXML
	TableView<Chuyenkho> tableChuyenKho;
	
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
	ChuyenkhoHome chuyenKhoHome = new ChuyenkhoHome();
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
		// Load table ChuyenKho
		this.loadTableChuyenKho();
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
	private ObservableList<Chuyenkho> getDSChuyenkho() {
		List<Chuyenkho> chuyenkhos = chuyenKhoHome.findAll();
		ObservableList<Chuyenkho> oListChuyenKho = FXCollections.observableList(chuyenkhos);
		return oListChuyenKho;
	}
	@SuppressWarnings("unchecked")
	private ObservableList<Chuyenkho> getDSChuyenkho(Date beginDay, Date enđDay) {
		List<Chuyenkho> chuyenkhos = chuyenKhoHome.getDataInPeriodTime(beginDay, enđDay);
		ObservableList<Chuyenkho> oListChuyenKho = FXCollections.observableList(chuyenkhos);
		return oListChuyenKho;
	}
	@SuppressWarnings("unchecked")
	private void loadTableChuyenKho() {
		TableColumn<Chuyenkho, Number> colSTT = new TableColumn<>("#");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableChuyenKho.getItems().indexOf(column.getValue()) + 1));
		
		TableColumn<Chuyenkho, String> colMa = new TableColumn<>("Phiếu");
		colMa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));
		
		TableColumn<Chuyenkho, String> colNgayLap = new TableColumn<>("Ngày lập");
		colNgayLap.setCellValueFactory(cellData -> new SimpleStringProperty(df.format(cellData.getValue().getNgay())));
		
		TableColumn<Chuyenkho, String> colKhoChuyen = new TableColumn<>("Kho chuyển");
		colKhoChuyen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhohangByKhochuyenid().getTen()));

		TableColumn<Chuyenkho, String> colKhoNhan = new TableColumn<>("Kho nhận");
		colKhoNhan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhohangByKhonhanid().getTen()));
		
		TableColumn<Chuyenkho, String> colNguoiChuyen = new TableColumn<>("Người chuyển");
		colNguoiChuyen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNhanvienByNguoichuyenid().getTen()));
		
		TableColumn<Chuyenkho, String> colNguoiNhan = new TableColumn<>("Người chuyển");
		colNguoiNhan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNhanvienByNguoinhanid().getTen()));
		
		TableColumn<Chuyenkho, String> colGhiChu = new TableColumn<>("Ghi chú");
		colGhiChu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));
		
		if ( dateNgayBatDau.getValue() == null || dateNgayKetThuc.getValue() == null ) {
			this.tableChuyenKho.setItems(this.getDSChuyenkho());
		} else {
			Date beginDate = Date.from(dateNgayBatDau.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date endDate = Date.from(dateNgayKetThuc.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			this.tableChuyenKho.setItems(this.getDSChuyenkho(beginDate, endDate));
		}
		
//		this.tableChuyenKho.getColumns().addAll(colSTT, colMa, colNgayLap, colNgayGiao, colMaNV, colTenNV, colMaKH, colTenKH, colMaKho, colTenKho, colTongTien, colGhiChu);
		this.tableChuyenKho.getColumns().addAll(colSTT, colMa, colNgayLap, colKhoChuyen, colKhoNhan, colNguoiChuyen, colNguoiNhan, colGhiChu);
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
			this.tableChuyenKho.setItems(this.getDSChuyenkho());
		} else {
			Date beginDate = Date.from(dateNgayBatDau.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date endDate = Date.from(dateNgayKetThuc.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			this.tableChuyenKho.setItems(this.getDSChuyenkho(beginDate, endDate));
		}
	}
	
	@FXML
	void onButtonXoaClick(ActionEvent event) {
	}

	@FXML
	void onButtonExitClick(ActionEvent event) {
		ManHinhChinhController.tabChuyenKho.getTabPane().getTabs().remove(ManHinhChinhController.tabChuyenKho);
		ManHinhChinhController.tabChuyenKho = null;
	}
}
