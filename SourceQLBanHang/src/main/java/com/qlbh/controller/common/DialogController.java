package com.qlbh.controller.common;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class DialogController {

	public static void show(AnchorPane root, Runnable runnable, String title, String contentStr) {
		System.out.println("dialog controller");
		JFXDialogLayout content = new JFXDialogLayout();
		content.setHeading(new Text(title));
		content.setBody(new Text(contentStr));

		JFXButton button = new JFXButton("OKay");
		StackPane stackPane = new StackPane();
		stackPane.setPrefWidth(root.getWidth());
		stackPane.setPrefHeight(root.getHeight());
		root.getChildren().add(stackPane);

		JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				dialog.close();
			}
		});
		content.setActions(button);
		dialog.show();
	}
}
