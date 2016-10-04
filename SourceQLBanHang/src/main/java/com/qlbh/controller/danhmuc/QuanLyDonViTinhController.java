package com.qlbh.controller.danhmuc;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuanLyDonViTinhController {

	@FXML
	private TableView<?> tableDonViTinh;

	@FXML
	private Button btnThem;

	@FXML
	private Button btnSua;

	@FXML
	private Button btnXoa;

	@FXML
	private Button btnNapLai;

	@FXML
	void btnThemClick(ActionEvent event) throws IOException {
		System.out.println("Thêm đơn vị tính");
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemDonViTinh.fxml"));
		// Fill stage with content
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Thêm đơn vị tính");
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.show();
	}

	@FXML
	void btnSuaClick(ActionEvent event) {

	}

	@FXML
	void btnXoaClick(ActionEvent event) {

	}

	@FXML
	void btnNapLaiClick(ActionEvent event) {

	}

}
