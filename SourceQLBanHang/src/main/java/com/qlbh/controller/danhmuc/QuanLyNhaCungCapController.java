package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.NhacungcapHome;
import com.qlbh.pojo.Nhacungcap;

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

public class QuanLyNhaCungCapController {
	public static QuanLyNhaCungCapController quanLyNhaCungCapController;
	NhacungcapHome nccHome = new NhacungcapHome();
	private Stage stageThem = null;
	private Stage stageSua = null;
	@FXML
	private TableView<Nhacungcap> tableNhaCungCap;

	@FXML
	private Button btnThem, btnSua, btnXoa, btnNapLai;

	@FXML
	protected void initialize() {
		quanLyNhaCungCapController = this;
		loadListNhaCungCap();
		createRowsEvent();
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}

	private void createRowsEvent() {
		tableNhaCungCap.setRowFactory(tv -> {
			TableRow<Nhacungcap> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (row.isEmpty()) {
					onTableNhaCungCapMouseClick();
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Nhacungcap clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Nhacungcap clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onTableNhaCungCapMouseClick() {
		System.out.println("onTableNhaCungCapMouseClick");
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
		tableNhaCungCap.getSelectionModel().clearSelection();
	}

	private void onRowSingleClick(Nhacungcap ncc) {
		System.out.println("Single click");
		System.out.println(ncc.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
	}

	private void onRowDoubleClick(Nhacungcap ncc) {
		System.out.println("Double click");
		System.out.println(ncc.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
		btnSuaClick();
	}

	public Nhacungcap getRowSelected() {
		return tableNhaCungCap.getSelectionModel().getSelectedItem();
	}

	@SuppressWarnings("unchecked")
	private ObservableList<Nhacungcap> getListNhaCungCap() {
		List<Nhacungcap> listNCC = nccHome.findAll();
		ObservableList<Nhacungcap> oListNhaCungCap = FXCollections.observableList(listNCC);
		return oListNhaCungCap;
	}

	@SuppressWarnings("unchecked")
	private void loadListNhaCungCap() {
		TableColumn<Nhacungcap, String> id = new TableColumn<Nhacungcap, String>("ID");
		id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

		TableColumn<Nhacungcap, String> ma = new TableColumn<Nhacungcap, String>("Mã");
		ma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Nhacungcap, String> ten = new TableColumn<Nhacungcap, String>("Tên");
		ten.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Nhacungcap, String> kv = new TableColumn<Nhacungcap, String>("Khu vực");
		kv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhuvuc().getTen()));

		TableColumn<Nhacungcap, String> nlh = new TableColumn<Nhacungcap, String>("Người liên hệ");
		nlh.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getManguoilienhe()));

		TableColumn<Nhacungcap, String> diachi = new TableColumn<Nhacungcap, String>("Địa chỉ");
		diachi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiachi()));

		TableColumn<Nhacungcap, String> dt = new TableColumn<Nhacungcap, String>("Điện thoại");
		dt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTel()));

		TableColumn<Nhacungcap, String> fax = new TableColumn<Nhacungcap, String>("Fax");
		fax.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFax()));

		TableColumn<Nhacungcap, String> email = new TableColumn<Nhacungcap, String>("Email");
		email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

		TableColumn<Nhacungcap, String> website = new TableColumn<Nhacungcap, String>("Website");
		website.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWebsite()));

		tableNhaCungCap.setItems(this.getListNhaCungCap());
		tableNhaCungCap.getColumns().addAll(id, ma, ten, kv, nlh, diachi, dt, fax, email, website);
	}

	void deleteNhaCungCap() {
		Nhacungcap ncc = tableNhaCungCap.getSelectionModel().getSelectedItem();
		if (ncc == null)
			return;
		nccHome.delete(ncc);
		reload();
	}

	@FXML
	void btnThemClick() {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemNhaCungCap.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm nhà cung cấp");
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaNhaCungCap.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SuaNhaCungCapController controller = loader.<SuaNhaCungCapController>getController();
			controller.setNhaCungCap(this.getRowSelected());
			primaryStage.setTitle("Sửa nhà cung cấp");
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
		DialogConfirmController.show("Xóa nhà cung cấp", "Bạn có chắc muốn xóa nhà cung cấp này?", () -> this.deleteNhaCungCap(),
				null);
	}

	@FXML
	void btnNapLaiClick() {
		reload();
	}
	
	@FXML
	void btnCloseClick() {
		ManHinhChinhController.tabNhaCungCap.getTabPane().getTabs().remove(ManHinhChinhController.tabNhaCungCap);
		ManHinhChinhController.tabNhaCungCap = null;
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
		tableNhaCungCap.setItems(getListNhaCungCap());
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}
}
