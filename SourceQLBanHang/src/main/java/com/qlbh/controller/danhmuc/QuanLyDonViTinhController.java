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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuanLyDonViTinhController {
	public static QuanLyDonViTinhController quanLyDonViTinhController;
	private Stage stageThem = null;
	@FXML
	private TableView<?> tableDonViTinh;

	@FXML
	private Button btnThem, btnSua, btnXoa, btnNapLai;

	@FXML
	protected void initialize() {
		quanLyDonViTinhController = this;
		btnSua.setDisable(true);
		btnXoa.setDisable(true);
	}

	@FXML
	void btnThemClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../../fxml/danhmuc/ThemDonViTinh.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thêm đơn vị tính");
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

	void closeThem() {
		stageThem.close();
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
