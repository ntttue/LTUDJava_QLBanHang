package com.qlbh.controller.danhmuc;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Tygia;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseButton;

public class TyGiaController {
	@FXML
	private TableView<Tygia> tableTyGia;
	@FXML
	private JFXButton btnSua;
	
	@FXML
	private JFXButton btnXoa;
	
	/**
	 * Catch when FXML loaded
	 */
	@FXML
	protected void initialize() {
		this.addRowEvents();
		this.loadTyGiaToTable();
		this.setButtonControlsDisable(true);
	}
	private void addRowEvents() {
		tableTyGia.setRowFactory(tv -> {
		    TableRow<Tygia> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		    	// No row selected when click
		    	if ( row.isEmpty() ) {
		    		onTableTyGiaMouseClick();
		    	}
		    	// Double click
		    	else if ( ! row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2 ) {
		        	Tygia clickedRow = row.getItem();
		            onRowDoubleClick(clickedRow);
		        }
		    	// Single click
		    	else if ( ! row.isEmpty() && event.getButton() == MouseButton.PRIMARY ) { // And single click
		        	Tygia clickedRow = row.getItem();
		        	onRowSingleClick(clickedRow);
		        }
		    });
		    return row ;
		});
	}
	private void onRowDoubleClick(Tygia tyGia) {
	    System.out.println("Double click");
	    System.out.println(tyGia.getMa());
	    this.setButtonControlsDisable(false);
	}
	private void onRowSingleClick(Tygia tyGia) {
		System.out.println("Single click");
	    System.out.println(tyGia.getMa());
	    this.setButtonControlsDisable(false);
	}
	
	private void onTableTyGiaMouseClick() {
		System.out.println("onTableTyGiaMouseClick");
		this.setButtonControlsDisable(true);
		// Clear row selection
		tableTyGia.getSelectionModel().clearSelection();
	}
	void setButtonControlsDisable(Boolean disable) {
		btnSua.setDisable(disable);
		btnXoa.setDisable(disable);
	}
	@FXML
	void onRefreshTableDataClick() {
		tableTyGia.setItems(this.getDSTyGia());
	}
	@FXML
	void onButtonExitClick() {
		ManHinhChinhController.tabTyGia.getTabPane().getTabs().remove(ManHinhChinhController.tabTyGia);
		ManHinhChinhController.tabTyGia = null;
	}
	@FXML
	void onButtonXuatClick() {
		//ManHinhChinhController.tabTyGia.
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
