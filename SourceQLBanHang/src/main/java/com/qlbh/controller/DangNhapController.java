package com.qlbh.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class DangNhapController {

    @FXML
    private JFXButton btnDangNhap;

    @FXML
    private JFXTextField txtTenDangNhap;

    @FXML
    private JFXPasswordField txtMatKhau;

    @FXML
    void btnDangNhapClick(ActionEvent event) {
    	System.out.println("aaaaaaaaaaaa");
    }
    

}
