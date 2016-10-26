package com.qlbh.controller.chucnang;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.model.ChitietphieuxuatHome;
import com.qlbh.model.KhohangHome;
import com.qlbh.pojo.Chitietphieuxuat;
import com.qlbh.pojo.Hanghoa;
import com.qlbh.pojo.Khohang;
import com.qlbh.render.combobox.BaoCaoBanHang;
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

public class BaoCaoBanHangController {

	private KhohangHome khoHangHome = new KhohangHome();
	private ChitietphieuxuatHome chitietphieuxuatHome = new ChitietphieuxuatHome();
	private final DecimalFormat doubleFormat = new DecimalFormat("#");

	@FXML
	private JFXButton btnDong;

	@FXML
	private JFXButton btnXem;

	@FXML
	private ComboBox<Khohang> cmbKho;
	private ObservableList<Khohang> modelCmbKho;

	@FXML
	private DatePicker datePickerDen;

	@FXML
	private ComboBox<DateOption> cmbTuyChon;

	@FXML
	private TableView<BaoCaoBanHang> tabel;
	private ObservableList<BaoCaoBanHang> modelTabel;

	@FXML
	private DatePicker datePickerTu;

	@FXML
	public void initialize() {
		// Set data for comboBox
		cmbTuyChon.setItems(DateOption.getDateOptions());
		modelCmbKho = FXCollections.observableArrayList(khoHangHome.getKhoHangList());
		cmbKho.setItems(modelCmbKho);
		// Select first option
		cmbTuyChon.getSelectionModel().select(0);
		// Set format of date for two DatePicker
		DataInputUtils.formatDatePicker(datePickerTu, "dd/MM/yyyy");
		DataInputUtils.formatDatePicker(datePickerDen, "dd/MM/yyyy");
		datePickerTu.setShowWeekNumbers(false);
		datePickerDen.setShowWeekNumbers(false);
		initTabel();
	}
	
	@FXML
	void btnXemOnClick(ActionEvent event){
		LocalDate localDateTu = datePickerTu.getValue();
		Instant instant = Instant.from(localDateTu.atStartOfDay(ZoneId.systemDefault()));
		Date ngaytu = Date.from(instant);
		LocalDate localDateDen = datePickerDen.getValue();
		Instant instant2 = Instant.from(localDateDen.atStartOfDay(ZoneId.systemDefault()));
		Date ngayden = Date.from(instant2);
		tabel.setItems(FXCollections.observableArrayList(chitietphieuxuatHome.LayBaoCaoBanHang(cmbKho.getValue().getId(), ngaytu, ngayden)));
	}
	
	@FXML
	void btnDongClick(ActionEvent event){
		ManHinhChinhController.tabBaoCaoBanHang.getTabPane().getTabs().remove(ManHinhChinhController.tabBaoCaoBanHang);
		ManHinhChinhController.tabBaoCaoBanHang = null;
	}

	private void initTabel() {
		TableColumn<BaoCaoBanHang, Number> colSTT = new TableColumn<BaoCaoBanHang, Number>("STT");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(
				column -> new ReadOnlyObjectWrapper<Number>(tabel.getItems().indexOf(column.getValue()) + 1));

		TableColumn<BaoCaoBanHang, String> colMa = new TableColumn<BaoCaoBanHang, String>("Mã Hàng");
		colMa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getMa()));

		TableColumn<BaoCaoBanHang, String> colTen = new TableColumn<BaoCaoBanHang, String>("Tên Hàng");
		colTen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getTen()));

		TableColumn<BaoCaoBanHang, String> colDonVi = new TableColumn<BaoCaoBanHang, String>("Đơn vị");
		colDonVi.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getDonvitinh().getTen()));

		TableColumn<BaoCaoBanHang, String> colNhomHang = new TableColumn<BaoCaoBanHang, String>("Nhóm hàng");
		colNhomHang.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHanghoa().getNhomhanghoa().getTen()));

		TableColumn<BaoCaoBanHang, String> colSLXuat = new TableColumn<BaoCaoBanHang, String>("SL Xuất");
		colSLXuat.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getSoLuongXuat() + ""));

		TableColumn<BaoCaoBanHang, String> colDoanSoBan = new TableColumn<BaoCaoBanHang, String>("Doanh Số bán");
		colDoanSoBan.setCellValueFactory(
				cellData -> new SimpleStringProperty(doubleFormat.format(cellData.getValue().getDoanhSoBan())));

		TableColumn<BaoCaoBanHang, String> colDonGiaNhap = new TableColumn<BaoCaoBanHang, String>("Đơn giá nhập");
		colDonGiaNhap
				.setCellValueFactory(cellData -> new SimpleStringProperty(doubleFormat.format(cellData.getValue().getHanghoa().getGiamua())));

		TableColumn<BaoCaoBanHang, String> colThanhTienNhap = new TableColumn<BaoCaoBanHang, String>("Thành tiền nhập");
		colThanhTienNhap
				.setCellValueFactory(cellData -> new SimpleStringProperty(doubleFormat.format(cellData.getValue().getThanhTienNhap())));

		TableColumn<BaoCaoBanHang, String> colChenhLech = new TableColumn<BaoCaoBanHang, String>("Chênh lệch");
		colChenhLech
				.setCellValueFactory(cellData -> new SimpleStringProperty(doubleFormat.format(cellData.getValue().getChenhLech())));

		tabel.getColumns().addAll(colSTT, colMa, colTen, colDonVi, colNhomHang, colSLXuat, colDoanSoBan, colDonGiaNhap, colThanhTienNhap, colChenhLech);
		tabel.setItems(modelTabel);
	}
}