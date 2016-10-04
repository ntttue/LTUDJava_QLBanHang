package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.qlbh.model.KhachhangHome;
import com.qlbh.pojo.Khachhang;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KhachHangController {
	@FXML
	private TableView<Khachhang> tableKhachHang;
	@FXML
	private JFXButton btnThemKhachHang;
	/**
	 * Catch when FXML loaded
	 */
	@FXML
	protected void initialize() {
		this.loadKhachHangToTable();
	}
	@FXML
	void btnThemKhachHangClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemKhachHang.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm khách hàng");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void btnSuaKhachHangClick() {
		System.out.println("Button sửa clicked!");
	}
	/**
	 * Get data for table Khachhang
	 * @return
	 */
	private ObservableList<Khachhang> getDSKhachHang() {
		KhachhangHome khachhangHome = new KhachhangHome();
		List<Khachhang> khachHangs = khachhangHome.getKhachHangs();
		for ( Khachhang kh : khachHangs ) {
			System.out.println(kh.getTen());
		}
		ObservableList<Khachhang> oListKhachHang = FXCollections.observableList(khachHangs);
		return oListKhachHang;
	}
	/**
	 * Load danh sách khách hàng vào tableView
	 */
	@SuppressWarnings("unchecked")
	void loadKhachHangToTable() {
		// Create column for table KhachHang
		TableColumn<Khachhang, Number> colSTT = new TableColumn<Khachhang, Number>("#");
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper<Number>(tableKhachHang.getItems().indexOf(column.getValue()) + 1));
		
		TableColumn<Khachhang, String> colMaKhachHang = new TableColumn<Khachhang, String>("Mã");
		colMaKhachHang.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));
		
		TableColumn<Khachhang, String> colTenKhachHang = new TableColumn<Khachhang, String>("Tên");
		colTenKhachHang.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));
		
		TableColumn<Khachhang, String> colDiaChi = new TableColumn<Khachhang, String>("Địa chỉ");
		colDiaChi.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiachi()));
		
		TableColumn<Khachhang, Boolean> colConQuanLy = new TableColumn<Khachhang, Boolean>("Còn quản lý");
		colConQuanLy.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getActivite()));
		colConQuanLy.setCellFactory( tc -> new CheckBoxTableCell<>());
		
//		this.getDSKhachHang();
//		tableKhachHang.setItems(this.getDSKhachHang());
		tableKhachHang.getColumns().addAll(colSTT, colMaKhachHang, colTenKhachHang, colDiaChi, colConQuanLy);
	}
}
