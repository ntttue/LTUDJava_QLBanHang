package com.qlbh.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.qlbh.app.MainApp;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ManHinhChinhController {
	@FXML
	private TabPane tabMainContent;
	@FXML
	private AnchorPane anchorPaneMainApp;

	@FXML
	private JFXButton btnThongTin;

	@FXML
	private JFXButton btnThongTinTroGiup;

	@FXML
	void btnMuaHangClick(ActionEvent event) throws IOException {
		Tab tab = new Tab();
		tab.setText("Nhập hàng");
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("../fxml/chucnang/NhapHang.fxml"));
		tab.setContent(root);
		tabMainContent.getTabs().add(tab);
		tabMainContent.getSelectionModel().select(tab);
	}

	public static Integer tabDonViTinhAdded = -1;

	@FXML
	void btnQuanLyDonViTinhClick(ActionEvent event) throws IOException {
		if (ManHinhChinhController.tabDonViTinhAdded != -1) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabDonViTinhAdded);
			return;
		}
		Tab tab = new Tab();
		tab.setText("Đơn vị tính");
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabDonViTinhAdded = -1;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("../fxml/danhmuc/QuanLyDonViTinh.fxml"));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabDonViTinhAdded = tabMainContent.getSelectionModel().getSelectedIndex();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnKetThucClick(ActionEvent event) {
		MainApp.getPrimaryStage().close();
	}

	public static Tab tabKhachHang = null;

	@FXML
	void onButtonKhachHangClick(ActionEvent event) {
		String title = "Khách hàng";
		String fxmlPath = "../fxml/danhmuc/KhachHang.fxml";
		// Check tab KhachHang added or not? If added, switch to this tab
		if (ManHinhChinhController.tabKhachHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabKhachHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabKhachHang = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabKhachHang = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabTyGia = null;

	@FXML
	void onButtonTyGiaClick(ActionEvent event) {
		String title = "Tỷ giá";
		String fxmlPath = "../fxml/danhmuc/TyGia.fxml";
		if (ManHinhChinhController.tabTyGia != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabTyGia);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabTyGia = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabTyGia = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnThongTinClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/trogiup/ThongTin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thông tin");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnThongTinTroGiupClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/trogiup/ThongTin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thông tin");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
