package com.qlbh.app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
	private static Stage primaryStage; // **Declare static Stage**

    private void setPrimaryStage(Stage stage) {
    	MainApp.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return MainApp.primaryStage;
    }
	@Override
	public void start(Stage primaryStage) {
		setPrimaryStage(primaryStage); // **Set the Stage**
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/ManHinhChinh.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Phần mềm quản lý bán hàng");
			primaryStage.initStyle(StageStyle.UNIFIED);
//			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			// Set application icon
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/ic_store_white_24dp.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
