package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.DialogConfirmController;
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
	public static TyGiaController tyGiaController = null;
	private Stage stageThemTyGia = null;
	private Stage stageSuaTyGia = null;
	@FXML
	private TableView<Tygia> tableTyGia;
	@FXML
	private JFXButton btnSua, btnXoa;
	/**
	 * Catch when FXML loaded
	 */
	@FXML
	protected void initialize() {
		TyGiaController.tyGiaController = this;
		this.addRowEvents();
		this.loadTyGiaToTable();
		this.setButtonControlsDisable(true);
	}
	public TableView<Tygia> getTableTyGia() {
		return this.tableTyGia;
	}
	public void closeManHinhThemTyGia() {
		if ( this.stageThemTyGia != null ) {
			this.stageThemTyGia.close();
		}
	}
	public void closeManHinhSuaTyGia() {
		if ( this.stageSuaTyGia != null ) {
			this.stageSuaTyGia.close();
		}
	}
	public void onTyGiaAdded() {
		this.refreshTyGiaTableData();
		this.closeManHinhThemTyGia();
		this.getTableTyGia().requestFocus();
		this.getTableTyGia().getSelectionModel().selectLast();
		this.setButtonControlsDisable(false);
	}
	public void onTyGiaUpdated() {
		Integer index = this.tableTyGia.getSelectionModel().getSelectedIndex();
		this.refreshTyGiaTableData();
		this.closeManHinhSuaTyGia();
		this.getTableTyGia().requestFocus();
		this.getTableTyGia().getSelectionModel().select(index);
	}
	private void addRowEvents() {
		this.tableTyGia.setRowFactory(tv -> {
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
	    this.onButtonSuaClick();
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
		this.tableTyGia.getSelectionModel().clearSelection();
	}
	public void setButtonControlsDisable(Boolean disable) {
		btnSua.setDisable(disable);
		btnXoa.setDisable(disable);
	}
	@FXML
	public void onRefreshTableDataClick() {
		this.refreshTyGiaTableData();
		this.setButtonControlsDisable(true);
	}
	public void refreshTyGiaTableData() {
		this.tableTyGia.setItems(this.getDSTyGia());
	}
	@FXML
	public void onButtonExitClick() {
		ManHinhChinhController.tabTyGia.getTabPane().getTabs().remove(ManHinhChinhController.tabTyGia);
		ManHinhChinhController.tabTyGia = null;
	}
	@FXML
	public void onButtonXuatClick() {
		System.out.println("onButtonXuatClick");
	}
	public Tygia getSelectedTygia() {
		return this.tableTyGia.getSelectionModel().getSelectedItem();
	}
	@FXML
	public void onButtonThemClick() {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/ThemTyGia.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm Tỷ giá");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			this.stageThemTyGia = primaryStage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	private void onButtonSuaClick() {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaTyGia.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			SuaTyGiaController controller = 
				    loader.<SuaTyGiaController>getController();
			controller.setTyGia(this.getSelectedTygia());
			primaryStage.setTitle("Sửa Tỷ giá");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			this.stageSuaTyGia = primaryStage;
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
	private ObservableList<Tygia> getDSTyGia() {
		TygiaHome tygiaHome = new TygiaHome();
		List<Tygia> tygias = tygiaHome.findAll();
		ObservableList<Tygia> oListTyGia = FXCollections.observableList(tygias);
		return oListTyGia;
	}
	/**
	 * Load list TyGia into tableTyGia
	 */
	@SuppressWarnings("unchecked")
	private void loadTyGiaToTable() {
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
		
		this.tableTyGia.setItems(this.getDSTyGia());
		this.tableTyGia.getColumns().addAll(colSTT, colMa, colTen, colTyGiaQuyDoi);
	}
	private void deleteTyGia() {
		Tygia tyGia = this.tableTyGia.getSelectionModel().getSelectedItem();
		if ( tyGia == null ) {
			return;
		}
		TygiaHome tyGiaHome = new TygiaHome();
		tyGiaHome.delete(tyGia);
		this.refreshTyGiaTableData();
		this.setButtonControlsDisable(true);
	}
	@FXML
	private void onButtonXoaClick() {
		DialogConfirmController.show(
				"Xóa tỷ giá?",
				"Bạn có chắc muốn xóa tỷ giá này",
				()-> this.deleteTyGia(),
				null);
	}
}
