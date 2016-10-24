package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.NhanvienHome;
import com.qlbh.pojo.Nhanvien;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class DanhSachNhanVienController {
	public static DanhSachNhanVienController nhanVienController = null;
	private Stage stageThemNhanVien = null;
	private Stage stageSuaNhanVien = null;
	@FXML
	private TableView<Nhanvien> tableNhanVien;
	@FXML
	private JFXButton btnSua, btnXoa;

	/**
	 * Catch when FXML loaded
	 */
	@FXML
	protected void initialize() {
		DanhSachNhanVienController.nhanVienController = this;
		this.addRowEvents();
		this.loadNhanVienToTable();
		this.setButtonControlsDisable(true);
	}

	public TableView<Nhanvien> getTableNhanVien() {
		return this.tableNhanVien;
	}

	public void closeManHinhThemNhanVien() {
		if (this.stageThemNhanVien != null) {
			this.stageThemNhanVien.close();
		}
	}

	public void closeManHinhSuaNhanVien() {
		if (this.stageSuaNhanVien != null) {
			this.stageSuaNhanVien.close();
		}
	}

	public void onNhanVienAdded() {
		this.refreshNhanVienTableData();
		this.closeManHinhThemNhanVien();
		this.getTableNhanVien().requestFocus();
		this.getTableNhanVien().getSelectionModel().selectLast();
		this.setButtonControlsDisable(false);
	}

	public void onNhanVienUpdated() {
		Integer index = this.tableNhanVien.getSelectionModel().getSelectedIndex();
		this.refreshNhanVienTableData();
		this.closeManHinhSuaNhanVien();
		this.getTableNhanVien().requestFocus();
		this.getTableNhanVien().getSelectionModel().select(index);
	}

	private void addRowEvents() {
		this.tableNhanVien.setRowFactory(tv -> {
			TableRow<Nhanvien> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				// No row selected when click
				if (row.isEmpty()) {
					onTableNhanVienMouseClick();
				}
				// Double click
				else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Nhanvien clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				}
				// Single click
				else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Nhanvien clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onRowDoubleClick(Nhanvien obj) {
		this.setButtonControlsDisable(false);
		this.onButtonSuaClick();
	}

	private void onRowSingleClick(Nhanvien obj) {
		this.setButtonControlsDisable(false);
	}

	private void onTableNhanVienMouseClick() {
		System.out.println("onTableNhanVienMouseClick");
		this.setButtonControlsDisable(true);
		// Clear row selection
		this.tableNhanVien.getSelectionModel().clearSelection();
	}

	public void setButtonControlsDisable(Boolean disable) {
		btnSua.setDisable(disable);
		btnXoa.setDisable(disable);
	}

	@FXML
	public void onRefreshTableDataClick() {
		this.refreshNhanVienTableData();
		this.setButtonControlsDisable(true);
	}

	public void refreshNhanVienTableData() {
		this.tableNhanVien.setItems(this.getDSNhanVien());
	}

	@FXML
	public void onButtonExitClick() {
		ManHinhChinhController.tabNhanVien.getTabPane().getTabs().remove(ManHinhChinhController.tabNhanVien);
		ManHinhChinhController.tabNhanVien = null;
	}

	@FXML
	public void onButtonXuatClick() {
		System.out.println("onButtonXuatClick");
	}

	public Nhanvien getSelectedNhanVien() {
		return this.tableNhanVien.getSelectionModel().getSelectedItem();
	}

	@FXML
	public void onButtonThemClick() {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/ThemNhanVien.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm nhân viên");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			this.stageThemNhanVien = primaryStage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void onButtonSuaClick() {
		// Stage primaryStage = new Stage();
		// Parent root;
		// try {
		// FXMLLoader loader = new
		// FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaNhanVien.fxml"));
		// root = loader.load();
		// Scene scene = new Scene(root);
		// SuaNhanVienController controller =
		// loader.<SuaNhanVienController>getController();
		// controller.setNhanVien(this.getSelectedNhanVien());
		// primaryStage.setTitle("Sửa Tỷ giá");
		// primaryStage.initStyle(StageStyle.UNIFIED);
		// primaryStage.initModality(Modality.APPLICATION_MODAL);
		// primaryStage.setResizable(false);
		// primaryStage.setScene(scene);
		// primaryStage.getIcons().add(new
		// Image(getClass().getResourceAsStream("../../images/appIcon.png")));
		// primaryStage.show();
		// this.stageSuaNhanVien = primaryStage;
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	/**
	 * Get data for table NhanVien
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ObservableList<Nhanvien> getDSNhanVien() {
		NhanvienHome nhanVienHome = new NhanvienHome();
		List<Nhanvien> nhanViens = nhanVienHome.findAll();
		ObservableList<Nhanvien> oListNhanVien = FXCollections.observableList(nhanViens);
		return oListNhanVien;
	}

	/**
	 * Load list NhanVien into tableNhanVien
	 */
	@SuppressWarnings("unchecked")
	private void loadNhanVienToTable() {
		// Create column for table NhanVien
		TableColumn<Nhanvien, Number> colSTT = new TableColumn<Nhanvien, Number>("#");
		colSTT.setSortable(false);
		colSTT.setResizable(false);
		colSTT.setPrefWidth(30);
		colSTT.setCellValueFactory(
				column -> new ReadOnlyObjectWrapper<Number>(tableNhanVien.getItems().indexOf(column.getValue()) + 1));

		TableColumn<Nhanvien, String> colMa = new TableColumn<Nhanvien, String>("Mã");
		colMa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Nhanvien, String> colTen = new TableColumn<Nhanvien, String>("Tên");
		colTen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Nhanvien, String> colGioiTinh = new TableColumn<Nhanvien, String>("Giới tính");
		colGioiTinh.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getGioiTinh() == false ? "Nữ" : "Nam"));

		TableColumn<Nhanvien, String> colEmail = new TableColumn<Nhanvien, String>("Email");
		colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

		TableColumn<Nhanvien, String> colSDT = new TableColumn<Nhanvien, String>("SDT");
		colSDT.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDienThoai()));

		DecimalFormat dFormat = new DecimalFormat("####,###,###");
		TableColumn<Nhanvien, String> colLuong = new TableColumn<Nhanvien, String>("Lương");
		colLuong.setCellValueFactory(
				cellData -> new SimpleStringProperty(dFormat.format(cellData.getValue().getLuong())));

		TableColumn<Nhanvien, String> colDiaChi = new TableColumn<Nhanvien, String>("Địa chỉ");
		colDiaChi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiaChi()));

		TableColumn<Nhanvien, String> colChucVu = new TableColumn<Nhanvien, String>("Chức vụ");
		colChucVu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getChucVu()));

		TableColumn<Nhanvien, String> colBoPhan = new TableColumn<Nhanvien, String>("Bộ phận");
		colBoPhan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBophan().getTen()));

		this.tableNhanVien.setItems(this.getDSNhanVien());
		this.tableNhanVien.getColumns().addAll(colSTT, colMa, colTen, colGioiTinh, colEmail, colSDT, colLuong,
				colChucVu, colBoPhan, colDiaChi);
	}

	private void deleteNhanVien() {
		Nhanvien NhanVien = this.tableNhanVien.getSelectionModel().getSelectedItem();
		if (NhanVien == null) {
			return;
		}
		NhanvienHome nhanVienHome = new NhanvienHome();
		nhanVienHome.delete(NhanVien);
		this.refreshNhanVienTableData();
		this.setButtonControlsDisable(true);
	}

	@FXML
	private void onButtonXoaClick() {
		DialogConfirmController.show("Xóa tỷ giá?", "Bạn có chắc muốn xóa tỷ giá này", () -> this.deleteNhanVien(),
				null);
	}
}
