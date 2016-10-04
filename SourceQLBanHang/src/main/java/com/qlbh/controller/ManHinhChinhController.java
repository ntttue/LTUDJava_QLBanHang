package com.qlbh.controller;
import java.io.IOException;

import com.qlbh.app.MainApp;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
	/**
	 * Sử dụng để lưu giá trị Index của tab Khách hàng khi đã được thêm vào trong tabPane.
	 * Nếu giá trị của nó là -1 thì nó chưa được thêm vào tabPane.
	 * Nếu giá trị khác -1 thì đó là Index của tabKhachHang.
	 */
	public static Integer tabKhachHangAdded = -1;
	@FXML
	/**
	 * Xử lý sự kiện khi bấm vào nút Khách Hàng => Thêm tab Khách hàng
	 * @param event
	 */
	void onButtonKhachHangClick(ActionEvent event) {
		String title = "Khách hàng";
		String fxmlPath = "../fxml/danhmuc/KhachHang.fxml";
		// Kiểm tra xem tab Khách hàng đã đc thêm vào hay chưa, nếu đã thêm thì thoát
		if ( ManHinhChinhController.tabKhachHangAdded != -1 ) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabKhachHangAdded);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabKhachHangAdded = -1;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabKhachHangAdded = tabMainContent.getSelectionModel().getSelectedIndex();
//	        System.out.println("Add tab "+title+" succeed!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			System.out.println("Add tab "+title+" failed!");
			e.printStackTrace();
		}
	}
	public static Integer tabTyGiaAdded = -1;
	@FXML
	void onButtonTyGiaClick(ActionEvent event) {
		String title = "Tỷ giá";
		String fxmlPath = "../fxml/danhmuc/TyGia.fxml";
		if ( ManHinhChinhController.tabTyGiaAdded != -1 ) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabTyGiaAdded);
			return;
		}
		Tab tab = new Tab();
        tab.setText(title);
        tab.setOnClosed(new EventHandler<Event>() {
            public void handle(Event arg0) {
            	ManHinhChinhController.tabTyGiaAdded = -1;
            }
        });
        Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
	        tabMainContent.getTabs().add(tab);
	        tabMainContent.getSelectionModel().select(tab);
	        ManHinhChinhController.tabTyGiaAdded = tabMainContent.getSelectionModel().getSelectedIndex();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
