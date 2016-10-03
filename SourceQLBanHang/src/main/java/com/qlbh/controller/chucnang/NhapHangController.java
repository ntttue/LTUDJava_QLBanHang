package com.qlbh.controller.chucnang;

import com.qlbh.pojo.Nhanvien;
import com.qlbh.pojo.Phieunhap;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NhapHangController {
	
	@FXML
    private Button btnLuu;

    @FXML
    private ComboBox<?> cmbMaNCC;

    @FXML
    private TextField txtThanhToan;

    @FXML
    private ComboBox<?> cmbKho;

    @FXML
    private Button btnTaoMoi;

    @FXML
    private TableView<Phieunhap> tablePhieuNhap;

    @FXML
    private TextArea txtGhiChu;

    @FXML
    private ComboBox<Nhanvien> cmbNhanVien;

    @FXML
    private TextField txtDiaChi;

    @FXML
    private ComboBox<?> cmbTenNCC;

    @FXML
    private TextField txtMaPhieu;

    @FXML
    private Button btnNapLai;

    @FXML
    private DatePicker datePickerNhap;

    @FXML
    void btnTaoMoiClick(ActionEvent event) {

    }

}
