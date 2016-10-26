package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.NhomhanghoaHome;
import com.qlbh.pojo.Nhomhanghoa;

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

public class QuanLyNhomHangHoaController {
	public static QuanLyNhomHangHoaController quanLyNhomHangHoaController;
	NhomhanghoaHome nhhHome = new NhomhanghoaHome();
	private Stage stageThem = null;
	private Stage stageSua = null;
	@FXML
	private TableView<Nhomhanghoa> tableNhomHangHoa;

	@FXML
	private Button btnThem, btnSua, btnXoa, btnNapLai;

	@FXML
	protected void initialize() {
		quanLyNhomHangHoaController = this;
		loadListNhomHangHoa();
		createRowsEvent();
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}

	private void createRowsEvent() {
		tableNhomHangHoa.setRowFactory(tv -> {
			TableRow<Nhomhanghoa> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (row.isEmpty()) {
					onTableNhomHangHoaMouseClick();
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					Nhomhanghoa clickedRow = row.getItem();
					onRowDoubleClick(clickedRow);
				} else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
					Nhomhanghoa clickedRow = row.getItem();
					onRowSingleClick(clickedRow);
				}
			});
			return row;
		});
	}

	private void onTableNhomHangHoaMouseClick() {
		System.out.println("onTableNhomHangHoaMouseClick");
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
		tableNhomHangHoa.getSelectionModel().clearSelection();
	}

	private void onRowSingleClick(Nhomhanghoa nhh) {
		System.out.println("Single click");
		System.out.println(nhh.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
	}

	private void onRowDoubleClick(Nhomhanghoa nhh) {
		System.out.println("Double click");
		System.out.println(nhh.getMa());
		btnSua.setDisable(false);
		btnXoa.setDisable(false);
		btnSuaClick();
	}

	public Nhomhanghoa getRowSelected() {
		return tableNhomHangHoa.getSelectionModel().getSelectedItem();
	}

	@SuppressWarnings("unchecked")
	private ObservableList<Nhomhanghoa> getListNHH() {
		List<Nhomhanghoa> listNHH = nhhHome.findAll();
		ObservableList<Nhomhanghoa> oListNHH = FXCollections.observableList(listNHH);
		return oListNHH;
	}

	@SuppressWarnings("unchecked")
	private void loadListNhomHangHoa() {
		TableColumn<Nhomhanghoa, String> id = new TableColumn<Nhomhanghoa, String>("ID");
		id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

		TableColumn<Nhomhanghoa, String> ma = new TableColumn<Nhomhanghoa, String>("Mã");
		ma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Nhomhanghoa, String> ten = new TableColumn<Nhomhanghoa, String>("Tên");
		ten.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Nhomhanghoa, String> ghichu = new TableColumn<Nhomhanghoa, String>("Ghi chú");
		ghichu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGhichu()));

		tableNhomHangHoa.setItems(this.getListNHH());
		tableNhomHangHoa.getColumns().addAll(id, ma, ten, ghichu);
	}

	void deleteNhomHangHoa() {
		Nhomhanghoa nhh = tableNhomHangHoa.getSelectionModel().getSelectedItem();
		if (nhh == null)
			return;
		nhhHome.delete(nhh);
		reload();
	}

	@FXML
	void btnThemClick() {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemNhomHangHoa.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm nhóm hàng hóa");
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaNhomHangHoa.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SuaNhomHangHoaController controller = loader.<SuaNhomHangHoaController>getController();
			controller.setNhomHangHoa(this.getRowSelected());
			primaryStage.setTitle("Sửa nhóm hàng hóa");
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
		DialogConfirmController.show("Xóa nhóm hàng hóa", "Bạn có chắc muốn xóa nhóm hàng hóa này?",
				() -> this.deleteNhomHangHoa(), null);
	}

	@FXML
	void btnNapLaiClick() {
		reload();
	}

	@FXML
	void btnCloseClick() {
		ManHinhChinhController.tabNhomHangHoa.getTabPane().getTabs().remove(ManHinhChinhController.tabNhomHangHoa);
		ManHinhChinhController.tabNhomHangHoa = null;
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
		tableNhomHangHoa.setItems(getListNHH());
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}
}
