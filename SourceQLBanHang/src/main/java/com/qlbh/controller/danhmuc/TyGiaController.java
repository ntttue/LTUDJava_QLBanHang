package com.qlbh.controller.danhmuc;

import java.util.List;

import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Tygia;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

public class TyGiaController {
	@FXML
	private TableView<Tygia> tableTyGia;
	/**
	 * Catch when FXML loaded
	 */
	@FXML
	protected void initialize() {
		this.loadTyGiaToTable();
	}
	@FXML
	void refreshTableData() {
		tableTyGia.setItems(this.getDSTyGia());
	}
	/**
	 * Get data for table TyGia
	 * @return
	 */
	private ObservableList<Tygia> getDSTyGia() {
		TygiaHome tygiaHome = new TygiaHome();
		List<Tygia> tygias = tygiaHome.getTygias();
		ObservableList<Tygia> oListTyGia = FXCollections.observableList(tygias);
		return oListTyGia;
	}
	/**
	 * Load list TyGia into tableTyGia
	 */
	@SuppressWarnings("unchecked")
	void loadTyGiaToTable() {
		// Create column for table TyGia
		TableColumn<Tygia, Number> sttCol = new TableColumn<Tygia, Number>("#");
		sttCol.setSortable(false);
		sttCol.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableTyGia.getItems().indexOf(column.getValue()) + 1));
		
		TableColumn<Tygia, String> tyGiaMaCol = new TableColumn<Tygia, String>("Mã");
		tyGiaMaCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));
		
		TableColumn<Tygia, String> tyGiaTenCol = new TableColumn<Tygia, String>("Tên");
		tyGiaTenCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));
		
		TableColumn<Tygia, String> tyGiaQuyDoiCol = new TableColumn<Tygia, String>("Tỷ giá quy đổi");
		tyGiaQuyDoiCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTygiaquydoi().toString()));
		tyGiaQuyDoiCol.setStyle( "-fx-alignment: CENTER-RIGHT;"); // Set text align right for number
		
		TableColumn<Tygia, Boolean> conQuanLyCol = new TableColumn<Tygia, Boolean>("Còn quản lý");
		conQuanLyCol.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getActivite()));
		conQuanLyCol.setCellFactory( tc -> new CheckBoxTableCell<>());
		
		tableTyGia.setItems(this.getDSTyGia());
	    tableTyGia.getColumns().addAll(sttCol, tyGiaMaCol, tyGiaTenCol, tyGiaQuyDoiCol, conQuanLyCol);
	}
}
