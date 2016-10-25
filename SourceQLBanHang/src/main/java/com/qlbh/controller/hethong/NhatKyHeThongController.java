package com.qlbh.controller.hethong;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.NhatkyHome;
import com.qlbh.pojo.Nhatky;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;

public class NhatKyHeThongController {
	public static NhatKyHeThongController nhatKyController = null;
	@FXML
	private TableView<Nhatky> tableNhatKy;
	@FXML
	private JFXButton btnXoa;

	/**
	 * Catch when FXML loaded
	 */
	@FXML
	protected void initialize() {
		NhatKyHeThongController.nhatKyController = this;
		this.addRowEvents();
		this.loadNhatKyToTable();
		this.setButtonControlsDisable(true);
	}

	public TableView<Nhatky> getTableNhatKy() {
		return this.tableNhatKy;
	}

	private void addRowEvents() {
		this.tableNhatKy.setRowFactory(tv -> {
			TableRow<Nhatky> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				// No row selected when click
				if (row.isEmpty()) {
					onTableNhatKyMouseClick();
				}
				// Double click
				else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Nhatky clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				}
				// Single click
				else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Nhatky clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onRowDoubleClick(Nhatky obj) {
		this.setButtonControlsDisable(false);
	}

	private void onRowSingleClick(Nhatky obj) {
		this.setButtonControlsDisable(false);
	}

	private void onTableNhatKyMouseClick() {
		System.out.println("onTableNhatKyMouseClick");
		this.setButtonControlsDisable(true);
		// Clear row selection
		this.tableNhatKy.getSelectionModel().clearSelection();
	}

	public void setButtonControlsDisable(Boolean disable) {
//		btnXoa.setDisable(disable);
	}

	@FXML
	public void onRefreshTableDataClick() {
		this.refreshNhatKyTableData();
		this.setButtonControlsDisable(true);
	}

	public void refreshNhatKyTableData() {
		this.tableNhatKy.setItems(this.getDSNhatKy());
	}

	@FXML
	public void onButtonExitClick() {
		ManHinhChinhController.tabNhatKy.getTabPane().getTabs().remove(ManHinhChinhController.tabNhatKy);
		ManHinhChinhController.tabNhatKy = null;
	}

	@FXML
	public void onButtonXuatClick() {
		System.out.println("onButtonXuatClick");
	}

	public Nhatky getSelectedNhatKy() {
		return this.tableNhatKy.getSelectionModel().getSelectedItem();
	}

	/**
	 * Get data for table NhatKy
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ObservableList<Nhatky> getDSNhatKy() {
		NhatkyHome NhatKyHome = new NhatkyHome();
		List<Nhatky> nhatKys = NhatKyHome.findAll();
		ObservableList<Nhatky> oListNhatKy = FXCollections.observableList(nhatKys);
		return oListNhatKy;
	}

	/**
	 * Load list NhatKy into tableNhatKy
	 */
	@SuppressWarnings("unchecked")
	private void loadNhatKyToTable() {
		// Create column for table NhatKy
		TableColumn<Nhatky, Number> colSTT = new TableColumn<Nhatky, Number>("#");
		// colSTT.setSortable(false);
		// colSTT.setResizable(false);
		// colSTT.setPrefWidth(30);
		colSTT.setCellValueFactory(
				column -> new ReadOnlyObjectWrapper<Number>(tableNhatKy.getItems().indexOf(column.getValue()) + 1));

		TableColumn<Nhatky, String> colNguoiDung = new TableColumn<Nhatky, String>("Người dùng");
		colNguoiDung.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNguoiDung()));

		TableColumn<Nhatky, String> colChucNang = new TableColumn<Nhatky, String>("Nhóm chức năng");
		colChucNang.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTable()));

		TableColumn<Nhatky, String> colHanhDong = new TableColumn<Nhatky, String>("Hành động");
		colHanhDong.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHanhDong()));

		TableColumn<Nhatky, String> colNgay = new TableColumn<Nhatky, String>("Thời gian");
		colNgay.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNgay().toString()));

		this.tableNhatKy.setItems(this.getDSNhatKy());
		this.tableNhatKy.getColumns().addAll(colSTT, colNguoiDung, colChucNang, colHanhDong, colNgay);
	}

	private void deleteNhatKy() {
		Nhatky nhatKy = this.tableNhatKy.getSelectionModel().getSelectedItem();
		if (nhatKy == null) {
			return;
		}
		NhatkyHome nhatKyHome = new NhatkyHome();
		nhatKyHome.delete(nhatKy);
		this.refreshNhatKyTableData();
		this.setButtonControlsDisable(true);
	}

	@FXML
	private void onButtonXoaClick() {
//		DialogConfirmController.show("Xóa tỷ giá?", "Bạn có chắc muốn xóa", () -> this.deleteNhatKy(), null);
	}
}
