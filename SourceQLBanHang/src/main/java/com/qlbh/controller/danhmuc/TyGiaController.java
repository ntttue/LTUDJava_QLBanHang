package com.qlbh.controller.danhmuc;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TyGiaController {
	private static Stage stageThemTyGia = null;
	@FXML
	private TableView<Tygia> tableTyGia;
	private static TableView<Tygia> staticTableTyGia;
	@FXML
	private JFXButton btnSua, btnXoa;	
	/**
	 * Catch when FXML loaded
	 */
	@FXML
	protected void initialize() {
		TyGiaController.staticTableTyGia = this.tableTyGia;
		this.addRowEvents();
		this.loadTyGiaToTable();
		this.setButtonControlsDisable(true);
	}
	public static void closeManHinhThemTyGia() {
		if ( TyGiaController.stageThemTyGia != null ) {
			TyGiaController.stageThemTyGia.close();
		}
	}
	private void addRowEvents() {
		TyGiaController.staticTableTyGia.setRowFactory(tv -> {
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
		    	else if ( ! row.isEmpty() && event.getButton() == MouseButton.PRIMARY ) {
		        	Tygia clickedRow = row.getItem();
		        	onRowSingleClick(clickedRow);
		        }
		    });
		    return row;
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
		TyGiaController.staticTableTyGia.getSelectionModel().clearSelection();
	}
	void setButtonControlsDisable(Boolean disable) {
		btnSua.setDisable(disable);
		btnXoa.setDisable(disable);
	}
	@FXML
	void onRefreshTableDataClick() {
		TyGiaController.refreshTyGiaTableData();
	}
	public static void refreshTyGiaTableData() {
		TyGiaController.staticTableTyGia.setItems(TyGiaController.getDSTyGia());
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
	@FXML
	void onButtonThemClick() {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemTyGia.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm Tỷ giá");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			TyGiaController.stageThemTyGia = primaryStage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Get data for table TyGia
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static ObservableList<Tygia> getDSTyGia() {
		TygiaHome tygiaHome = new TygiaHome();
		List<Tygia> tygias = tygiaHome.findAll();
		ObservableList<Tygia> oListTyGia = FXCollections.observableList(tygias);
		return oListTyGia;
	}
	/**
	 * Load list TyGia into tableTyGia
	 */
	@SuppressWarnings("unchecked")
	void loadTyGiaToTable() {
		// Create column for table TyGia
		TableColumn<Tygia, Number> colSTT = new TableColumn<Tygia, Number>("#");
		colSTT.setSortable(false);
//		colSTT.setResizable(false);
//		colSTT.setPrefWidth(50);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableTyGia.getItems().indexOf(column.getValue()) + 1));
		
		TableColumn<Tygia, String> colMa = new TableColumn<Tygia, String>("Mã");
		colMa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));
		
		TableColumn<Tygia, String> colTen = new TableColumn<Tygia, String>("Tên");
		colTen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));
		
		TableColumn<Tygia, String> colTyGiaQuyDoi = new TableColumn<Tygia, String>("Tỷ giá quy đổi");
		colTyGiaQuyDoi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTygiaquydoi().toString()));
		colTyGiaQuyDoi.setStyle( "-fx-alignment: CENTER-RIGHT;"); // Set text align right for number
		
		TableColumn<Tygia, Boolean> colConQuanLy = new TableColumn<Tygia, Boolean>("Còn quản lý");
		colConQuanLy.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getActivite()));
		colConQuanLy.setCellFactory( tc -> new CheckBoxTableCell<>());
		
		TyGiaController.staticTableTyGia.setItems(TyGiaController.getDSTyGia());
		TyGiaController.staticTableTyGia.getColumns().addAll(colSTT, colMa, colTen, colTyGiaQuyDoi, colConQuanLy);
	}
}