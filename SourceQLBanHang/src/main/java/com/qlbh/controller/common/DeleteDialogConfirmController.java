package com.qlbh.controller.common;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.qlbh.controller.danhmuc.TyGiaController;

import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

@FXMLController(value = "/resources/fxml/common/deleteDialogConfirm.fxml", title = "Delete Confirm")
public class DeleteDialogConfirmController {
	@FXML
	private JFXDialog deleteDialog;
	@FXML private AnchorPane root;
	@FXMLViewFlowContext
	private ViewFlowContext context;
	private static DeleteDialogConfirmController deleteDialogConfirmController = null;
	@FXML
	protected void initialize() {
		root.getChildren().remove(deleteDialog);
	}
	private void showDialog() {
		deleteDialog.setTransitionType(DialogTransition.CENTER);
		deleteDialog.show((StackPane) context.getRegisteredObject("ContentPane"));
	}
	public static void show() {
		if ( DeleteDialogConfirmController.deleteDialogConfirmController == null ) {
			DeleteDialogConfirmController.deleteDialogConfirmController = new DeleteDialogConfirmController();
		}
		DeleteDialogConfirmController.deleteDialogConfirmController.showDialog();
	}
}
