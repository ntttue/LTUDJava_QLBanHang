package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.BophanHome;
import com.qlbh.pojo.Bophan;

import javafx.beans.property.ReadOnlyObjectWrapper;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DanhSachBoPhanController {
	final static Logger logger = Logger.getLogger(DanhSachBoPhanController.class);
	public static DanhSachBoPhanController boPhanController = null;
	private Stage stageThemBoPhan = null;
	private Stage stageSuaBoPhan = null;
	@FXML
	private TableView<Bophan> tableBoPhan;
	@FXML
	private JFXButton btnSua, btnXoa;

	/**
	 * Catch when FXML loaded
	 */
	@FXML
	protected void initialize() {
		DanhSachBoPhanController.boPhanController = this;
		this.addRowEvents();
		this.loadBophanToTable();
		this.setButtonControlsDisable(true);
	}

	public TableView<Bophan> getTableBoPhan() {
		return this.tableBoPhan;
	}

	public void closeManHinhThemBophan() {
		if (this.stageThemBoPhan != null) {
			this.stageThemBoPhan.close();
		}
	}

	public void closeManHinhSuaBophan() {
		if (this.stageSuaBoPhan != null) {
			this.stageSuaBoPhan.close();
		}
	}

	public void onBoPhanAdded() {
		this.refreshBophanTableData();
		this.closeManHinhThemBophan();
		this.getTableBoPhan().requestFocus();
		this.getTableBoPhan().getSelectionModel().selectLast();
		this.setButtonControlsDisable(false);
	}

	public void onBophanUpdated() {
		Integer index = this.tableBoPhan.getSelectionModel().getSelectedIndex();
		this.refreshBophanTableData();
		this.closeManHinhSuaBophan();
		this.getTableBoPhan().requestFocus();
		this.getTableBoPhan().getSelectionModel().select(index);
	}

	private void addRowEvents() {
		this.tableBoPhan.setRowFactory(tv -> {
			TableRow<Bophan> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				// No row selected when click
				if (row.isEmpty()) {
					onTableBoPhanMouseClick();
				}
				// Double click
				else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Bophan clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				}
				// Single click
				else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Bophan clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onRowDoubleClick(Bophan Bophan) {
		this.setButtonControlsDisable(false);
		this.onButtonSuaClick();
	}

	private void onRowSingleClick(Bophan Bophan) {
		this.setButtonControlsDisable(false);
	}

	private void onTableBoPhanMouseClick() {
		System.out.println("onTableBophanMouseClick");
		this.setButtonControlsDisable(true);
		// Clear row selection
		this.tableBoPhan.getSelectionModel().clearSelection();
	}

	public void setButtonControlsDisable(Boolean disable) {
		btnSua.setDisable(disable);
		btnXoa.setDisable(disable);
	}

	@FXML
	public void onRefreshTableDataClick() {
		this.refreshBophanTableData();
		this.setButtonControlsDisable(true);
	}

	public void refreshBophanTableData() {
		this.tableBoPhan.setItems(this.getDSBophan());
	}

	@FXML
	public void onButtonExitClick() {
		ManHinhChinhController.tabBoPhan.getTabPane().getTabs().remove(ManHinhChinhController.tabBoPhan);
		ManHinhChinhController.tabBoPhan = null;
	}

	@FXML
	public void onButtonXuatClick() {
		System.out.println("onButtonXuatClick");
	}

	public Bophan getSelectedBophan() {
		return this.tableBoPhan.getSelectionModel().getSelectedItem();
	}

	@FXML
	public void onButtonThemClick() {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/ThemBoPhanCongTy.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm bộ phận công ty");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			this.stageThemBoPhan = primaryStage;
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaBoPhanCongTy.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			SuaBoPhanCongTyController controller = loader.<SuaBoPhanCongTyController>getController();
			controller.setBophan(this.getSelectedBophan());
			primaryStage.setTitle("Sửa bộ phận công ty");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			this.stageSuaBoPhan = primaryStage;
		} catch (IOException e) {
			logger.error("onButtonSuaClick error\n " + e.getMessage());
			e.printStackTrace();

		}
	}

	/**
	 * Get data for table Bophan
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ObservableList<Bophan> getDSBophan() {
		BophanHome BophanHome = new BophanHome();
		List<Bophan> Bophans = BophanHome.findAll();
		ObservableList<Bophan> oListBophan = FXCollections.observableList(Bophans);
		return oListBophan;
	}

	/**
	 * Load list Bophan into tableBophan
	 */
	@SuppressWarnings("unchecked")
	private void loadBophanToTable() {
		// Create column for table Bophan
		TableColumn<Bophan, Number> colSTT = new TableColumn<Bophan, Number>("#");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(
				column -> new ReadOnlyObjectWrapper<Number>(tableBoPhan.getItems().indexOf(column.getValue()) + 1));
		colSTT.setMaxWidth(70);
		colSTT.setMinWidth(70);

		TableColumn<Bophan, String> colMa = new TableColumn<Bophan, String>("Mã");
		colMa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Bophan, String> colTen = new TableColumn<Bophan, String>("Tên");
		colTen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Bophan, String> colGhiChu = new TableColumn<Bophan, String>("Ghi chú");
		colGhiChu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));

		this.tableBoPhan.setItems(this.getDSBophan());
		this.tableBoPhan.getColumns().addAll(colSTT, colMa, colTen, colGhiChu);
	}

	private void deleteBophan() {
		Bophan Bophan = this.tableBoPhan.getSelectionModel().getSelectedItem();
		if (Bophan == null) {
			return;
		}
		BophanHome BophanHome = new BophanHome();
		BophanHome.delete(Bophan);
		this.refreshBophanTableData();
		this.setButtonControlsDisable(true);
	}

	@FXML
	private void onButtonXoaClick() {
		DialogConfirmController.show("Xóa tỷ giá?", "Bạn có chắc muốn xóa tỷ giá này", () -> this.deleteBophan(), null);
	}
}
