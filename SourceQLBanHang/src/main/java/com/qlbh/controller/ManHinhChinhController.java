package com.qlbh.controller;
import java.io.IOException;

import com.qlbh.app.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManHinhChinhController {
	@FXML
	private TabPane tabMainContent;
	@FXML
	private AnchorPane anchorPaneMainApp;
	@FXML
	void btnMuaHangClick(ActionEvent event) throws IOException {
		System.out.println("Clicked on button 'Mua Hàng'!");       
        Tab tab = new Tab();
        tab.setText("Nhập hàng");
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("../fxml/chucnang/NhapHang.fxml"));
        tab.setContent(root);
        tabMainContent.getTabs().add(tab);
        tabMainContent.getSelectionModel().select(tab);
	}
	@FXML
    void btnQuanLyDonViTinhClick(ActionEvent event) throws IOException {
		System.out.println("Clicked on button 'Quản lý đơn vị tính'!");       
        Tab tab = new Tab();
        tab.setText("Đơn vị tính");
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("../fxml/danhmuc/QuanLyDonViTinh.fxml"));
        tab.setContent(root);
        tabMainContent.getTabs().add(tab);
        tabMainContent.getSelectionModel().select(tab);
    }
	@FXML
	void btnKetThucClick(ActionEvent event) {
		Stage primaryStage = MainApp.getPrimaryStage();
		primaryStage.close();
	}
}
