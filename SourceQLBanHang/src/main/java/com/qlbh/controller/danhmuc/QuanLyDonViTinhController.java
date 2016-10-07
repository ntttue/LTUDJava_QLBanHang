package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.qlbh.model.DonvitinhHome;
import com.qlbh.pojo.Donvitinh;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuanLyDonViTinhController {
	public static QuanLyDonViTinhController quanLyDonViTinhController;
	private Stage stageThem = null;
	@FXML
	private TableView<Donvitinh> tableDonViTinh;

	@FXML
	private Button btnThem, btnSua, btnXoa, btnNapLai;

	@FXML
	protected void initialize() {
		quanLyDonViTinhController = this;
		loadListDonViTinh();
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
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
	void btnThemClick(ActionEvent event) {
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

	void closeThem() {
		stageThem.close();
	}

	@FXML
	void btnSuaClick(ActionEvent event) {

	}

	@FXML
	void btnXoaClick(ActionEvent event) {

	}

	@FXML
	void btnNapLaiClick(ActionEvent event) {

	}

}
