package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.LoaihangHome;
import com.qlbh.pojo.Loaihang;

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

public class QuanLyLoaiHangController {
	public static QuanLyLoaiHangController quanLyLoaiHangController;
	LoaihangHome lhHome = new LoaihangHome();
	private Stage stageThem = null;
	private Stage stageSua = null;
	@FXML
	private TableView<Loaihang> tableLoaiHang;

	@FXML
	private Button btnThem, btnSua, btnXoa, btnNapLai;

	@FXML
	protected void initialize() {
		quanLyLoaiHangController = this;
		loadListLoaiHang();
		createRowsEvent();
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}

	private void createRowsEvent() {
		tableLoaiHang.setRowFactory(tv -> {
			TableRow<Loaihang> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (row.isEmpty()) {
					onTableLoaiHangMouseClick();
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Loaihang clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Loaihang clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onTableLoaiHangMouseClick() {
		System.out.println("onTableLoaiHangMouseClick");
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
		tableLoaiHang.getSelectionModel().clearSelection();
	}

	private void onRowSingleClick(Loaihang lh) {
		System.out.println("Single click");
		System.out.println(lh.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
	}

	private void onRowDoubleClick(Loaihang lh) {
		System.out.println("Double click");
		System.out.println(lh.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
		btnSuaClick();
	}

	public Loaihang getRowSelected() {
		return tableLoaiHang.getSelectionModel().getSelectedItem();
	}

	@SuppressWarnings("unchecked")
	private ObservableList<Loaihang> getListLH() {
		List<Loaihang> listLH = lhHome.findAll();
		ObservableList<Loaihang> oListLH = FXCollections.observableList(listLH);
		return oListLH;
	}

	@SuppressWarnings("unchecked")
	private void loadListLoaiHang() {
		TableColumn<Loaihang, String> id = new TableColumn<Loaihang, String>("ID");
		id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

		TableColumn<Loaihang, String> ma = new TableColumn<Loaihang, String>("Mã");
		ma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Loaihang, String> ten = new TableColumn<Loaihang, String>("Tên");
		ten.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Loaihang, String> ghichu = new TableColumn<Loaihang, String>("Ghi chú");
		ghichu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));

		this.tableLoaiHang.setItems(this.getListLH());
		this.tableLoaiHang.getColumns().addAll(id, ma, ten, ghichu);
	}

	void deleteLoaiHang() {
		Loaihang lh = tableLoaiHang.getSelectionModel().getSelectedItem();
		if (lh == null)
			return;
		lhHome.delete(lh);
		reload();
	}

	@FXML
	void btnThemClick() {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemLoaiHang.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm loại hàng");
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaLoaiHang.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SuaLoaiHangController controller = loader.<SuaLoaiHangController>getController();
			controller.setLoaiHang(this.getRowSelected());
			primaryStage.setTitle("Sửa loại hàng");
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
		DialogConfirmController.show("Xóa nhóm hàng", "Bạn có chắc muốn xóa nhóm hàng này?",
				() -> this.deleteLoaiHang(), null);
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
		tableLoaiHang.setItems(getListLH());
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}
}
