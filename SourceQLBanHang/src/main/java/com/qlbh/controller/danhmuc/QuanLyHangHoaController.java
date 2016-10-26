package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.text.DecimalFormat;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.controller.common.DialogConfirmController;
import com.qlbh.model.DonvitinhHome;
import com.qlbh.model.HanghoaHome;
import com.qlbh.model.KhachhangHome;
import com.qlbh.model.KhohangHome;
import com.qlbh.model.LoaihangHome;
import com.qlbh.model.NhacungcapHome;
import com.qlbh.pojo.Hanghoa;
import com.qlbh.pojo.Khachhang;
import com.qlbh.pojo.Nhomhanghoa;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuanLyHangHoaController {

	public static QuanLyHangHoaController controller = null;
	private Stage stageThem = null, stageSua = null;
	private final DecimalFormat doubleFormat = new DecimalFormat("#");
	
	private HanghoaHome hanghoaHome = new HanghoaHome();
	private KhohangHome khohangHome = new KhohangHome();
	private NhacungcapHome nhacungcapHome = new NhacungcapHome();
	private DonvitinhHome DonvitinhHome = new DonvitinhHome();
	private LoaihangHome LoaihangHome = new LoaihangHome();
	private Nhomhanghoa Nhomhanghoa = new Nhomhanghoa();
	
	@FXML
	private TableView<Hanghoa> table;
	private ObservableList<Hanghoa> modelTabel;
	@FXML
	private JFXButton btnThem, btnSua, btnXoa;
	/**
	 * Catch when FXML loaded
	 */
	@FXML
	protected void initialize() {
	}
	
	
	@FXML
	void btnThemClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemHangHoa.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm hàng hóa");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			this.stageThem = primaryStage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Hanghoa getSelected() {
		return this.table.getSelectionModel().getSelectedItem();
	}
	@FXML
	void onButtonSuaClick() {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/danhmuc/SuaKhachHang.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			SuaKhachHangController controller = 
				    loader.<SuaKhachHangController>getController();
//			controller.setKhachhang(this.getSelected());
			primaryStage.setTitle("Sửa Khách hàng");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/appIcon.png")));
			primaryStage.show();
			this.stageSua = primaryStage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void onButtonXoaClick() {
		DialogConfirmController.show(
				"Xóa khách hàng?",
				"Bạn có chắc muốn xóa khách hàng này",
				()-> this.delete(),
				null);
	}
	@FXML
	void onButtonExitClick() {
		ManHinhChinhController.tabKhachHang.getTabPane().getTabs().remove(ManHinhChinhController.tabKhachHang);
		ManHinhChinhController.tabKhachHang = null;
	}
	@FXML
	void onButtonRefreshClick() {
		table.refresh();
		this.setButtonControlsDisable(true);
	}
	
	void setButtonControlsDisable(Boolean disable) {
		btnSua.setDisable(disable);
		btnXoa.setDisable(disable);
	}
	
	private void delete() {
		Hanghoa hangHoa = this.table.getSelectionModel().getSelectedItem();
		if ( hangHoa == null ) {
			return;
		}
		hanghoaHome.delete(hangHoa);
		table.refresh();
		this.setButtonControlsDisable(true);
	}
	
	private void initTabel(){
		modelTabel = FXCollections.observableArrayList(hanghoaHome.getHangHoaList());
		TableColumn<Hanghoa, Number> colSTT = new TableColumn<Hanghoa, Number>("#");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
		
		TableColumn<Hanghoa, String> colMa = new TableColumn<Hanghoa, String>("Mã Hàng");
		colMa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));
		
		TableColumn<Hanghoa, String> colTen = new TableColumn<Hanghoa, String>("Tên Hàng");
		colTen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));
		
		TableColumn<Hanghoa, String> colDonVi = new TableColumn<Hanghoa, String>("Đơn vị");
		colDonVi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDonvitinh().getTen()));
		
		TableColumn<Hanghoa, String> colGiaMua = new TableColumn<Hanghoa, String>("Giá mua");
		colGiaMua.setCellValueFactory(cellData -> new SimpleStringProperty(doubleFormat.format(cellData.getValue().getGiamua())));
		
		TableColumn<Hanghoa, String> colGiaBanLe = new TableColumn<Hanghoa, String>("Giá bán lẻ");
		colGiaBanLe.setCellValueFactory(cellData -> new SimpleStringProperty(doubleFormat.format(cellData.getValue().getGiabanle())));
		
		TableColumn<Hanghoa, String> colGiaBanSi = new TableColumn<Hanghoa, String>("Giá bán sỉ");
		colGiaBanSi.setCellValueFactory(cellData -> new SimpleStringProperty(doubleFormat.format(cellData.getValue().getGiabansi())));
		
		TableColumn<Hanghoa, String> colKhoMacDinh = new TableColumn<Hanghoa, String>("Kho");
		colKhoMacDinh.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKhohang().getTen()));
		
		table.getColumns().addAll(colSTT, colMa, colTen, colDonVi, colGiaMua, colGiaBanLe, colGiaBanSi, colKhoMacDinh);
		table.setItems(modelTabel);
	}
}
