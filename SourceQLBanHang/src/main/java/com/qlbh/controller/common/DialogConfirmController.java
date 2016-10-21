package com.qlbh.controller.common;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogConfirmController {
	// Store static instance of this controller
	private static DialogConfirmController instance = null;
	// Store action when click on button OK
	public static Runnable runnableOK;
	public static Runnable runnableCancel;
	public static String title, content;
	// Store stage of this controller
	private Stage mainStage;	
	@FXML
	private Label lblContent, lblTitle;
	// Show stage
	private void showDialog() {
		this.mainStage.show();
	}
	// Hide stage
	private void hideDialog() {
		this.mainStage.close();
	}
	// Load UI for this controller
	private void initView() {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../../fxml/common/DialogConfirm.fxml"));
			Scene scene = new Scene(root);
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/warning.png")));
			this.mainStage = primaryStage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void onButtonCancelClick() {
		System.out.println("clickButtonCancel");
		if ( DialogConfirmController.runnableCancel != null ) {
			DialogConfirmController.runnableCancel.run();
		}
		DialogConfirmController.instance.hideDialog();
	}
	@FXML
	public void onButtonOKClick() {
		System.out.println("clickButtonOK");
		if ( DialogConfirmController.runnableOK != null ) {
			DialogConfirmController.runnableOK.run();
		}
		DialogConfirmController.instance.hideDialog();
	}
	@FXML
	public void initialize() {
		this.lblTitle.setText(DialogConfirmController.title);
		this.lblContent.setText(DialogConfirmController.content);
	}
	/**
	 * Show dialog confirm
	 * @param title Main title of dialog
	 * @param content Content to tell to user
	 * @param runnableOK Callback function call when button OK click
	 * @param runnableCancel Callback function call when button Cancel click
	 */
	public static void show(String title, String content, Runnable runnableOK, Runnable runnableCancel) {
		if ( DialogConfirmController.instance == null ) {
			DialogConfirmController.instance = new DialogConfirmController();
		}
		DialogConfirmController.title = title;
		DialogConfirmController.content = content;
		DialogConfirmController.runnableCancel = runnableCancel;
		DialogConfirmController.runnableOK = runnableOK;
		DialogConfirmController.instance.initView();
		DialogConfirmController.instance.showDialog();
	}
}
