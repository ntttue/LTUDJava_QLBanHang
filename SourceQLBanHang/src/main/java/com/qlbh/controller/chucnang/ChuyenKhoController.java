package com.qlbh.controller.chucnang;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class ChuyenKhoController {
	@FXML
	private AnchorPane anchorPaneContent;
	@FXML
	public void initialize() {
		this.setManHinhChuyenKhoan();
	}
	@FXML
	public void onButtonPhieuChuyenKhoClick(ActionEvent event) {
		this.setManHinhChuyenKhoan();
	}
	@FXML
	public void onButtonTheoHangHoaClick(ActionEvent event) {
		
	}
	
	private void setManHinhChuyenKhoan() {
		Node node;
		try {
			node = (Node) FXMLLoader.load(getClass().getResource("../../fxml/chucnang/PhieuChuyenKho.fxml"));
			anchorPaneContent.getChildren().addAll(node);
			AnchorPane.setTopAnchor(node, 0d);
			AnchorPane.setLeftAnchor(node, 0d);
			AnchorPane.setRightAnchor(node, 0d);
			AnchorPane.setRightAnchor(node, 0d);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setManHinhbBangKeChuyenKhoan() {
		Node node;
		try {
			node = (Node) FXMLLoader.load(getClass().getResource("../../fxml/chucnang/PhieuChuyenKho.fxml"));
			anchorPaneContent.getChildren().addAll(node);
			AnchorPane.setTopAnchor(node, 0d);
			AnchorPane.setLeftAnchor(node, 0d);
			AnchorPane.setRightAnchor(node, 0d);
			AnchorPane.setRightAnchor(node, 0d);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
