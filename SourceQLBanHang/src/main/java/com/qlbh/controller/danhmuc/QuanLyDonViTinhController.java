package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.qlbh.model.DonvitinhHome;
import com.qlbh.pojo.Donvitinh;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuanLyDonViTinhController {
	public static QuanLyDonViTinhController quanLyDonViTinhController;
	private Stage stageThem = null;
	private Stage stageSua = null;
	@FXML
	private TableView<Donvitinh> tableDonViTinh;

	@FXML
	private Button btnThem, btnSua, btnXoa, btnNapLai;

	@FXML
	protected void initialize() {
		quanLyDonViTinhController = this;
		loadListDonViTinh();
		createRowsEvent();
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}

	private void createRowsEvent() {
		tableDonViTinh.setRowFactory(tv -> {
			TableRow<Donvitinh> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (row.isEmpty()) {
					onTableDonViTinhMouseClick();
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Donvitinh clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Donvitinh clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onTableDonViTinhMouseClick() {
		System.out.println("onTableDonViTinhMouseClick");
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
		tableDonViTinh.getSelectionModel().clearSelection();
	}

	private void onRowSingleClick(Donvitinh dvt) {
		System.out.println("Single click");
		System.out.println(dvt.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
	}

	private void onRowDoubleClick(Donvitinh dvt) {
		System.out.println("Double click");
		System.out.println(dvt.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
		btnSuaClick();
	}

	public Donvitinh getRowSelected() {
		return tableDonViTinh.getSelectionModel().getSelectedItem();
	}

	@SuppressWarnings("unchecked")
	private ObservableList<Donvitinh> getListDVT() {
		DonvitinhHome dvtHome = new DonvitinhHome();
		List<Donvitinh> listDVT = dvtHome.findAll();
		ObservableList<Donvitinh> oListDVT = FXCollections.observableList(listDVT);
		return oListDVT;
	}

	@SuppressWarnings("unchecked")
	private void loadListDonViTinh() {
		TableColumn<Donvitinh, String> id = new TableColumn<Donvitinh, String>("ID");
		id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

		TableColumn<Donvitinh, String> ma = new TableColumn<Donvitinh, String>("Mã");
		ma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Donvitinh, String> ten = new TableColumn<Donvitinh, String>("Tên");
		ten.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Donvitinh, String> ghichu = new TableColumn<Donvitinh, String>("Ghi chú");
		ghichu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));

		TableColumn<Donvitinh, Boolean> activite = new TableColumn<Donvitinh, Boolean>("Còn quản lý");
		activite.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getActivite()));
		activite.setCellFactory(tc -> new CheckBoxTableCell<>());

		this.tableDonViTinh.setItems(this.getListDVT());
		this.tableDonViTinh.getColumns().addAll(id, ma, ten, ghichu, activite);
	}

	@FXML
	void btnThemClick() {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemDonViTinh.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm đơn vị tính");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			stageThem = primaryStage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnSuaClick() {
		Stage primaryStage = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaDonViTinh.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SuaDonViTinhController controller = loader.<SuaDonViTinhController>getController();
			controller.setDonViTinh(this.getRowSelected());
			primaryStage.setTitle("Sửa đơn vị tính");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			stageSua = primaryStage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnXoaClick() {

	}

	@FXML
	void btnNapLaiClick() {
		tableDonViTinh.setItems(getListDVT());
	}

	void closeThem() {
		stageThem.close();
		reload();
	}

	void closeSua() {
		stageSua.close();
		reload();
	}

	void reload() {
		tableDonViTinh.setItems(getListDVT());
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}
}
