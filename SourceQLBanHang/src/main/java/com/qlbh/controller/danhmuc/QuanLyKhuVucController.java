package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.KhuvucHome;
import com.qlbh.pojo.Khuvuc;

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
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuanLyKhuVucController {
	public static QuanLyKhuVucController quanLyKhuVucController;
	KhuvucHome kvHome = new KhuvucHome();
	private Stage stageThem = null;
	private Stage stageSua = null;
	@FXML
	private TableView<Khuvuc> tableKhuVuc;

	@FXML
	private Button btnThem, btnSua, btnXoa, btnNapLai;

	@FXML
	protected void initialize() {
		quanLyKhuVucController = this;
		loadListKhuVuc();
		createRowsEvent();
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}

	private void createRowsEvent() {
		tableKhuVuc.setRowFactory(tv -> {
			TableRow<Khuvuc> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (row.isEmpty()) {
					onTableKhuVucMouseClick();
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Khuvuc clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Khuvuc clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onTableKhuVucMouseClick() {
		System.out.println("onTableKhuVucMouseClick");
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
		tableKhuVuc.getSelectionModel().clearSelection();
	}

	private void onRowSingleClick(Khuvuc kv) {
		System.out.println("Single click");
		System.out.println(kv.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
	}

	private void onRowDoubleClick(Khuvuc kv) {
		System.out.println("Double click");
		System.out.println(kv.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
		btnSuaClick();
	}

	public Khuvuc getRowSelected() {
		return tableKhuVuc.getSelectionModel().getSelectedItem();
	}

	@SuppressWarnings("unchecked")
	private ObservableList<Khuvuc> getListKV() {
		List<Khuvuc> listKV = kvHome.findAll();
		ObservableList<Khuvuc> oListKV = FXCollections.observableList(listKV);
		return oListKV;
	}

	@SuppressWarnings("unchecked")
	private void loadListKhuVuc() {
		TableColumn<Khuvuc, String> id = new TableColumn<Khuvuc, String>("ID");
		id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

		TableColumn<Khuvuc, String> ma = new TableColumn<Khuvuc, String>("Mã");
		ma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Khuvuc, String> ten = new TableColumn<Khuvuc, String>("Tên");
		ten.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Khuvuc, String> ghichu = new TableColumn<Khuvuc, String>("Ghi chú");
		ghichu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));

		this.tableKhuVuc.setItems(this.getListKV());
		this.tableKhuVuc.getColumns().addAll(id, ma, ten, ghichu);
	}

	void deleteKhuVuc() {
		Khuvuc kv = tableKhuVuc.getSelectionModel().getSelectedItem();
		if (kv == null)
			return;
		kvHome.delete(kv);
		reload();
	}

	@FXML
	void btnThemClick() {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemKhuVuc.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm khu vực");
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaKhuVuc.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SuaKhuVucController controller = loader.<SuaKhuVucController>getController();
			controller.setKhuVuc(this.getRowSelected());
			primaryStage.setTitle("Sửa khu vực");
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
		DialogConfirmController.show("Xóa khu vực", "Bạn có chắc muốn xóa khu vực này?",
				() -> this.deleteKhuVuc(), null);
	}

	@FXML
	void btnNapLaiClick() {
		reload();
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
		tableKhuVuc.setItems(getListKV());
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}
}
