package com.qlbh.controller.danhmuc;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KhachHangController {
	@FXML
	private TableView tableKhachHang;
	@FXML
	private JFXButton btnThemKhachHang;
	
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
			System.out.println("+ Mở màn hình thêm khách hàng thành công");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("- Mở màn hình thêm khách hàng thất bại");
			e.printStackTrace();
		}
	}
}
