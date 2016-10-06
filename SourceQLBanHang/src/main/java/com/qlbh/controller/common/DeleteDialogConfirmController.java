package com.qlbh.controller.common;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;

import io.datafx.controller.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

@FXMLController(value = "/resources/fxml/common/deleteDialogConfirm.fxml", title = "Delete Confirm")
public class DeleteDialogConfirmController {
	@FXML
	private JFXDialog deleteDialog;

	@FXML
	private void initialize() {
		deleteDialog.setTransitionType(DialogTransition.CENTER);
//		deleteDialog.show((StackPane) context.getRegisteredObject("ContentPane"));
	}
}
