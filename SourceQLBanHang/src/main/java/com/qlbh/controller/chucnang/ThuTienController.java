package com.qlbh.controller.chucnang;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.qlbh.controller.ManHinhChinhController;
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
		LocalDate localdateBegin = selectedDateOption.getBeginDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localdateEnd = selectedDateOption.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateNgayBatDau.setValue(localdateBegin);
		dateNgayKetThuc.setValue(localdateEnd);
	}
	
	/**
	 * Get data for table TyGia
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ObservableList<Phieuxuat> getDSPhieuXuat() {
		PhieuxuatHome phieuxuatHome = new PhieuxuatHome();
		List<Phieuxuat> phieuxuats = phieuxuatHome.findAll();
		ObservableList<Phieuxuat> oListPhieuXuat = FXCollections.observableList(phieuxuats);
		return oListPhieuXuat;
	}
	/**
	 * Load list TyGia into tableTyGia
	 */
	@SuppressWarnings("unchecked")
	private void loadTableThuTien() {
		// Create column for table PhieuXuat
		TableColumn<Phieuxuat, Number> colSTT = new TableColumn<>("#");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableThuTien.getItems().indexOf(column.getValue()) + 1));
		
		TableColumn<Phieuxuat, String> colMa = new TableColumn<>("Mã");
		colMa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));
		
//		TableColumn<Tygia, String> colTen = new TableColumn<Tygia, String>("Tên");
//		colTen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));
//		
//		TableColumn<Tygia, String> colTyGiaQuyDoi = new TableColumn<Tygia, String>("Tỷ giá quy đổi");
//		colTyGiaQuyDoi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTygiaquydoi().toString()));
//		colTyGiaQuyDoi.setStyle( "-fx-alignment: CENTER-RIGHT;"); // Set text align right for number
		
		this.tableThuTien.setItems(this.getDSPhieuXuat());
		this.tableThuTien.getColumns().addAll(colSTT, colMa);
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
		
	}
	
	@FXML
	void onButtonLapPhieuThuClick(ActionEvent event) {

	}

	@FXML
	void onButtonExitClick(ActionEvent event) {
		ManHinhChinhController.tabThuTien.getTabPane().getTabs().remove(ManHinhChinhController.tabThuTien);
		ManHinhChinhController.tabThuTien = null;
	}
}
