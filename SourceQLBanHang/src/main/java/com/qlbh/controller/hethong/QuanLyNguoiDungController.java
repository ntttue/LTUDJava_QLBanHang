package com.qlbh.controller.hethong;

import java.io.IOException;
import java.util.List;

import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.NguoidungHome;
import com.qlbh.pojo.Nguoidung;

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

public class QuanLyNguoiDungController {
	public static QuanLyNguoiDungController quanLyNguoiDungController;
	NguoidungHome ndHome = new NguoidungHome();
	private Stage stageThem = null;
	private Stage stageSua = null;
	@FXML
	private TableView<Nguoidung> tableNguoiDung;

	@FXML
	private Button btnThem, btnSua, btnXoa, btnNapLai;

	@FXML
	protected void initialize() {
		quanLyNguoiDungController = this;
		loadListNguoiDung();
		createRowsEvent();
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}

	private void createRowsEvent() {
		tableNguoiDung.setRowFactory(tv -> {
			TableRow<Nguoidung> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (row.isEmpty()) {
					onTableNguoiDungMouseClick();
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Nguoidung clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Nguoidung clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onTableNguoiDungMouseClick() {
		System.out.println("onTableNguoiDungMouseClick");
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
		tableNguoiDung.getSelectionModel().clearSelection();
	}

	private void onRowSingleClick(Nguoidung nd) {
		System.out.println("Single click");
		System.out.println(nd.getId());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
	}

	private void onRowDoubleClick(Nguoidung nd) {
		System.out.println("Double click");
		System.out.println(nd.getId());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
		btnSuaClick();
	}

	public Nguoidung getRowSelected() {
		return tableNguoiDung.getSelectionModel().getSelectedItem();
	}

	@SuppressWarnings("unchecked")
	private ObservableList<Nguoidung> getListNguoiDung() {
		List<Nguoidung> listND = ndHome.findAll();
		ObservableList<Nguoidung> oListNguoiDung = FXCollections.observableList(listND);
		return oListNguoiDung;
	}

	@SuppressWarnings("unchecked")
	private void loadListNguoiDung() {
		TableColumn<Nguoidung, String> id = new TableColumn<Nguoidung, String>("ID");
		id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

		TableColumn<Nguoidung, String> ten = new TableColumn<Nguoidung, String>("Tên người dùng");
		ten.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTennd()));

		TableColumn<Nguoidung, String> nv = new TableColumn<Nguoidung, String>("Nhân viên");
		nv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNhanvien().getTen()));

		TableColumn<Nguoidung, String> role = new TableColumn<Nguoidung, String>("Quyền");
		role.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQuyen().getTen()));

		TableColumn<Nguoidung, String> ghichu = new TableColumn<Nguoidung, String>("Ghi chú");
		ghichu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiengiai()));

		this.tableNguoiDung.setItems(this.getListNguoiDung());
		this.tableNguoiDung.getColumns().addAll(id, ten, nv, role, ghichu);
	}

	void deleteNguoiDung() {
		Nguoidung nd = tableNguoiDung.getSelectionModel().getSelectedItem();
		if (nd == null)
			return;
		ndHome.delete(nd);
		reload();
	}

	@FXML
	void btnThemClick() {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../fxml/hethong/ThemNguoiDung.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm người dùng");
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/hethong/SuaNguoiDung.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SuaNguoiDungController controller = loader.<SuaNguoiDungController>getController();
			controller.setNguoiDung(this.getRowSelected());
			primaryStage.setTitle("Sửa người dùng");
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
		DialogConfirmController.show("Xóa người dùng", "Bạn có chắc muốn xóa người dùng này?", () -> this.deleteNguoiDung(),
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
		tableNguoiDung.setItems(getListNguoiDung());
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}
}
