package com.qlbh.controller.chucnang;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class ChuyenKhoController {
	@FXML
	private AnchorPane anchorPaneContent;
	@FXML
	public void onButtonPhieuChuyenKhoClick(ActionEvent event) {
		Parent root;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/chucnang/PhieuChuyenKho.fxml"));
		try {
			root = loader.load();
			anchorPaneContent.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void onButtonTheoHangHoaClick(ActionEvent event) {
		
	}
}
