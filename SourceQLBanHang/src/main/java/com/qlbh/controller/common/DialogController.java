package com.qlbh.controller.common;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DialogController {

	public static void show(AnchorPane root, Runnable runnable, String titleStr, String contentStr,
			boolean closeRootStage) {
		JFXDialogLayout content = new JFXDialogLayout();
		// design layout content
		// content.setPadding(new Insets(24,24,16,24));
		// content.setStyle("-fx-text-fill: rgba(0, 0, 0, 0.87);");

		// design heading
		StackPane heading = new StackPane();
		heading.getChildren().add(new Text(titleStr));
		heading.setStyle("-fx-font-weight: BOLD;-fx-alignment: center-left;");
		heading.setPadding(new Insets(5, 0, 5, 0));
		content.setHeading(heading);

		// design body
		StackPane body = new StackPane();
		body.getChildren().add(new Text(contentStr));
		body.setStyle("-fx-pref-width: 400px;-fx-wrap-text: true;");
		content.setBody(body);

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
				if (closeRootStage) {
					Stage stage = (Stage) dialog.getScene().getWindow();
					stage.close();
				}
			}
		});
		content.setActions(button);
		dialog.show();
	}
}
