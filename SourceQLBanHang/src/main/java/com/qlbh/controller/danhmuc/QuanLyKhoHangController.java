package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.KhohangHome;
import com.qlbh.pojo.Khohang;

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

public class QuanLyKhoHangController {
	public static QuanLyKhoHangController quanLyKhoHangController;
	KhohangHome khHome = new KhohangHome();
	private Stage stageThem = null;
	private Stage stageSua = null;
	@FXML
	private TableView<Khohang> tableKhoHang;

	@FXML
	private Button btnThem, btnSua, btnXoa, btnNapLai;

	@FXML
	protected void initialize() {
		quanLyKhoHangController = this;
		loadListKhoHang();
		createRowsEvent();
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}

	private void createRowsEvent() {
		tableKhoHang.setRowFactory(tv -> {
			TableRow<Khohang> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (row.isEmpty()) {
					onTableKhoHangMouseClick();
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Khohang clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Khohang clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onTableKhoHangMouseClick() {
		System.out.println("onTableKhoHangMouseClick");
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
		tableKhoHang.getSelectionModel().clearSelection();
	}

	private void onRowSingleClick(Khohang kh) {
		System.out.println("Single click");
		System.out.println(kh.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
	}

	private void onRowDoubleClick(Khohang kh) {
		System.out.println("Double click");
		System.out.println(kh.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
		btnSuaClick();
	}

	public Khohang getRowSelected() {
		return tableKhoHang.getSelectionModel().getSelectedItem();
	}

	@SuppressWarnings("unchecked")
	private ObservableList<Khohang> getListKhoHang() {
		List<Khohang> listKH = khHome.findAll();
		ObservableList<Khohang> oListKhoHang = FXCollections.observableList(listKH);
		return oListKhoHang;
	}

	@SuppressWarnings("unchecked")
	private void loadListKhoHang() {
		TableColumn<Khohang, String> id = new TableColumn<Khohang, String>("ID");
		id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

		TableColumn<Khohang, String> ma = new TableColumn<Khohang, String>("Mã");
		ma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Khohang, String> ten = new TableColumn<Khohang, String>("Tên");
		ten.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Khohang, String> nql = new TableColumn<Khohang, String>("Người quản lý");
		nql.setCellValueFactory(cellData -> {
			if (cellData.getValue().getNhanvien() == null) {
				return new SimpleStringProperty("");
			}
			return new SimpleStringProperty(cellData.getValue().getNhanvien().getTen());
		});

		TableColumn<Khohang, String> nlh = new TableColumn<Khohang, String>("Người liên hệ");
		nlh.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNguoilienhe()));

		TableColumn<Khohang, String> diachi = new TableColumn<Khohang, String>("Địa chỉ");
		diachi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiachi()));

		TableColumn<Khohang, String> dt = new TableColumn<Khohang, String>("Điện thoại");
		dt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDienthoai()));

		TableColumn<Khohang, String> fax = new TableColumn<Khohang, String>("Fax");
		fax.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFax()));

		TableColumn<Khohang, String> email = new TableColumn<Khohang, String>("Email");
		email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

		TableColumn<Khohang, String> ghichu = new TableColumn<Khohang, String>("Ghi chú");
		ghichu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiengiai()));

		this.tableKhoHang.setItems(this.getListKhoHang());
		this.tableKhoHang.getColumns().addAll(id, ma, ten, nql, nlh, diachi, dt, fax, email, ghichu);
	}

	void deleteKhoHang() {
		Khohang kh = tableKhoHang.getSelectionModel().getSelectedItem();
		if (kh == null)
			return;
		khHome.delete(kh);
		reload();
	}

	@FXML
	void btnThemClick() {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemKhoHang.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm kho hàng");
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaKhoHang.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SuaKhoHangController controller = loader.<SuaKhoHangController>getController();
			controller.setKhoHang(this.getRowSelected());
			primaryStage.setTitle("Sửa kho hàng");
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
		DialogConfirmController.show("Xóa kho hàng", "Bạn có chắc muốn xóa kho hàng này?", () -> this.deleteKhoHang(),
				null);
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
		tableKhoHang.setItems(getListKhoHang());
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}
}
