package com.qlbh.controller.chucnang;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.ManHinhChinhController;
import com.qlbh.model.HanghoaHome;
import com.qlbh.model.KhohangHome;
import com.qlbh.pojo.Hanghoa;
import com.qlbh.pojo.Khohang;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TonKhoController {
	HanghoaHome hhHome = new HanghoaHome();

	@FXML
	private JFXButton btnXem, btnClose;

	@FXML
	private ComboBox<Khohang> cmbKho;

	@FXML
	private TableView<Hanghoa> tableTonKho;

	@FXML
	void btnXemClick() {
		tableTonKho.setItems(getListHangHoa(cmbKho.getValue().getId()));
	}

	@FXML
	void btnCloseClick() {
		ManHinhChinhController.tabTonKho.getTabPane().getTabs().remove(ManHinhChinhController.tabTonKho);
		ManHinhChinhController.tabTonKho = null;
	}

	@FXML
	protected void initialize() {
		cmbKho.setItems(getDSKhoHang());
		cmbKho.getSelectionModel().select(0);
		loadListTonKho(0);
	}

	private ObservableList<Khohang> getDSKhoHang() {
		KhohangHome khHome = new KhohangHome();
		List<Khohang> lkh = khHome.getKhoHangList();
		Khohang kh = new Khohang();
		kh.setId(0);
		kh.setTen("Tất cả");
		lkh.add(0, kh);
		ObservableList<Khohang> oListKH = FXCollections.observableList(lkh);
		return oListKH;
	}

	private ObservableList<Hanghoa> getListHangHoa(int khoId) {
		List<Hanghoa> listHH = hhHome.getListHangHoaTonKho(khoId);
		ObservableList<Hanghoa> oListHH = FXCollections.observableList(listHH);
		return oListHH;
	}

	@SuppressWarnings("unchecked")
	private void loadListTonKho(int khoId) {
		TableColumn<Hanghoa, String> id = new TableColumn<Hanghoa, String>("ID");
		id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));

		TableColumn<Hanghoa, String> ma = new TableColumn<Hanghoa, String>("Mã hàng");
		ma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMa()));

		TableColumn<Hanghoa, String> ten = new TableColumn<Hanghoa, String>("Tên hàng");
		ten.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTen()));

		TableColumn<Hanghoa, String> kho = new TableColumn<Hanghoa, String>("Kho hàng");
		kho.setCellValueFactory(cellData -> {
			if (cellData.getValue().getKhohang() == null) {
				return new SimpleStringProperty("");
			}
			return new SimpleStringProperty(cellData.getValue().getKhohang().getTen());
		});

		TableColumn<Hanghoa, String> dv = new TableColumn<Hanghoa, String>("Đơn vị");
		dv.setCellValueFactory(cellData -> {
			if (cellData.getValue().getDonvitinh() == null) {
				return new SimpleStringProperty("");
			}
			return new SimpleStringProperty(cellData.getValue().getDonvitinh().getTen());
		});

		TableColumn<Hanghoa, String> sl = new TableColumn<Hanghoa, String>("Số lượng");
		sl.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTonkho().toString()));

		TableColumn<Hanghoa, String> nh = new TableColumn<Hanghoa, String>("Nhóm hàng");
		nh.setCellValueFactory(cellData -> {
			if (cellData.getValue().getNhomhanghoa() == null) {
				return new SimpleStringProperty("");
			}
			return new SimpleStringProperty(cellData.getValue().getNhomhanghoa().getTen());
		});

		
		tableTonKho.setItems(this.getListHangHoa(khoId));
		tableTonKho.getColumns().addAll(id, ma, ten, kho, dv, sl, nh);
	}
}
