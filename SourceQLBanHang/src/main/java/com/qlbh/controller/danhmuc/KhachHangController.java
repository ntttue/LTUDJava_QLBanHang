package com.qlbh.controller.danhmuc;

import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.qlbh.model.TygiaHome;
import com.qlbh.pojo.Khachhang;
import com.qlbh.pojo.Tygia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
		System.out.println("KhachHangController initialize");
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
			System.out.println("+ Mở màn hình thêm khách hàng thành công :)");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("- Mở màn hình thêm khách hàng thất bại :(");
			e.printStackTrace();
		}
	}
	@FXML
	void btnSuaKhachHangClick() {
		System.out.println("Button sửa clicked!");
	}
	/**
	 * Load danh sách khách hàng vào tableView
	 */
	void loadKhachHangToTable() {
	}
}
