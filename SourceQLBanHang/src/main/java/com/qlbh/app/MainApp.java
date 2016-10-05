package com.qlbh.app;

import java.io.IOException;

import com.qlbh.pojo.Nguoidung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
	private static Stage primaryStage; // **Declare static Stage**
	private static Stage loginStage;
	private static Stage mainStage;
	public static Nguoidung loginUser;

	public MainApp() {
		MainApp.loginStage = new Stage();
		MainApp.mainStage = new Stage();
	}

	public static void setPrimaryStage(Stage stage) {
		MainApp.primaryStage = stage;
	}

	public static Stage getPrimaryStage() {
		return MainApp.primaryStage;
	}

	static public void setUserLogin(Nguoidung nd) {
		MainApp.loginUser = nd;
		MainApp.loginStage.close();
		MainApp.mainStage.show();
		MainApp.setPrimaryStage(MainApp.mainStage);
	}

	public void initStage() {
		Parent root;
		Scene scene;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/DangNhap.fxml"));
			scene = new Scene(root);
			loginStage.setTitle("Phần mềm quản lý bán hàng - Đăng nhập");
			loginStage.initStyle(StageStyle.UNIFIED);
			loginStage.setResizable(false);
			loginStage.setScene(scene);
			loginStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));

			root = FXMLLoader.load(getClass().getResource("../fxml/ManHinhChinh.fxml"));
			scene = new Scene(root);
			mainStage.setTitle("Phần mềm quản lý bán hàng");
			mainStage.initStyle(StageStyle.UNIFIED);
			mainStage.setMaximized(true);
			mainStage.setScene(scene);
			mainStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void start(Stage primaryStage) {
		this.initStage();
		if (MainApp.loginUser == null) {
			MainApp.setPrimaryStage(MainApp.loginStage);
			MainApp.loginStage.show();
		} else {
			MainApp.setPrimaryStage(MainApp.mainStage);
			MainApp.mainStage.show();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
