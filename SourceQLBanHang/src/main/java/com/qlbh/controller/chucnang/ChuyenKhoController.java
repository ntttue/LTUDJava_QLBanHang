package com.qlbh.controller.chucnang;

import java.io.IOException;

import com.qlbh.model.PhieunhapHome;

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
		this.setManHinhChuyenKho();
	}
	@FXML
	public void onButtonPhieuChuyenKhoClick(ActionEvent event) {
		this.setManHinhChuyenKho();
	}
	@FXML
	public void onButtonTheoHangHoaClick(ActionEvent event) {
		this.setManHinhbBangKeChuyenKho();
	}
	
	private void setManHinhChuyenKho() {
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
	
	private void setManHinhbBangKeChuyenKho() {
		Node node;
		try {
			node = (Node) FXMLLoader.load(getClass().getResource("../../fxml/chucnang/ThongKePhieuChuyenKho.fxml"));
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
