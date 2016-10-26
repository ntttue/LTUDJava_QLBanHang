package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.DonvitinhHome;
import com.qlbh.pojo.Donvitinh;
import com.qlbh.pojo.Khohang;

import javafx.beans.property.ReadOnlyObjectWrapper;
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

public class QuanLyDonViTinhController {
	public static QuanLyDonViTinhController quanLyDonViTinhController;
	DonvitinhHome dvtHome = new DonvitinhHome();
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
		List<Donvitinh> listDVT = dvtHome.findAll();
		ObservableList<Donvitinh> oListDVT = FXCollections.observableList(listDVT);
		return oListDVT;
	}

	@SuppressWarnings("unchecked")
	private void loadListDonViTinh() {
		// TableColumn<Donvitinh, String> id = new TableColumn<Donvitinh,
		// String>("ID");
		// id.setCellValueFactory(cellData -> new
		// SimpleStringProperty(cellData.getValue().getId().toString()));
		TableColumn<Donvitinh, Number> colSTT = new TableColumn<Donvitinh, Number>("#");
		colSTT.setSortable(false);
		colSTT.setResizable(false);
		colSTT.setPrefWidth(30);
		colSTT.setCellValueFactory(
				column -> new ReadOnlyObjectWrapper<Number>(tableDonViTinh.getItems().indexOf(column.getValue()) + 1));

		TableColumn<Donvitinh, String> ma = new TableColumn<Donvitinh, String>("Mã");
		ma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Donvitinh, String> ten = new TableColumn<Donvitinh, String>("Tên");
		ten.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Donvitinh, String> ghichu = new TableColumn<Donvitinh, String>("Ghi chú");
		ghichu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));

		this.tableDonViTinh.setItems(this.getListDVT());
		this.tableDonViTinh.getColumns().addAll(colSTT, ma, ten, ghichu);
	}

	void deleteDonViTinh() {
		Donvitinh dvt = tableDonViTinh.getSelectionModel().getSelectedItem();
		if (dvt == null)
			return;
		dvtHome.delete(dvt);
		reload();
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
		DialogConfirmController.show("Xóa đơn vị tính", "Bạn có chắc muốn xóa đơn vị tính này?",
				() -> this.deleteDonViTinh(), null);
	}

	@FXML
	void btnNapLaiClick() {
		reload();
	}

	@FXML
	void btnCloseClick() {
		ManHinhChinhController.tabDonViTinh.getTabPane().getTabs().remove(ManHinhChinhController.tabDonViTinh);
		ManHinhChinhController.tabDonViTinh = null;
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
