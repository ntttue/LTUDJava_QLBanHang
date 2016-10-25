package com.qlbh.controller;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.qlbh.app.MainApp;
import com.qlbh.controller.common.DialogController;
import com.qlbh.controller.hethong.DoiMatKhauController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class ManHinhChinhController {
	final static Logger logger = Logger.getLogger(ManHinhChinhController.class);

	@FXML
	private TabPane tabMainContent;

	@FXML
	private AnchorPane anchorPaneMainApp;

	@FXML
	private JFXButton btnThongTin, btnThongTinTroGiup, btnBoPhan, btnNhatKyHeThong;

	@FXML
	private Text lblStatus;

	@FXML
	private AnchorPane anchorManHinhChinhRoot;

	public void setStatus() {
		if (MainApp.loginUser != null) {
			System.out.println(MainApp.loginUser.getQuyen().getTen());
			String status = MainApp.loginUser.getQuyen().getTen() + " - " + MainApp.loginUser.getNhanvien().getTen();
			lblStatus.setText(status);
		}

	}

	public static Tab tabNhapHang = null;

	@FXML
	void btnMuaHangClick(ActionEvent event) {
		String title = "Nhập hàng";
		String fxmlPath = "../fxml/chucnang/NhapHang.fxml";
		if (ManHinhChinhController.tabNhapHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabNhapHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabNhapHang = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabNhapHang = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabKhuVuc = null;

	@FXML
	void btnQuanLyKhuVucClick(ActionEvent event) {
		String title = "Khu vực";
		String fxmlPath = "../fxml/danhmuc/QuanLyKhuVuc.fxml";
		if (ManHinhChinhController.tabKhuVuc != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabKhuVuc);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabKhuVuc = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabKhuVuc = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabNhaCungCap = null;

	@FXML
	void btnQuanLyNhaCungCapClick(ActionEvent event) {
		String title = "Nhà cung cấp";
		String fxmlPath = "../fxml/danhmuc/QuanLyNhaCungCap.fxml";
		if (ManHinhChinhController.tabNhaCungCap != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabNhaCungCap);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabNhaCungCap = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabNhaCungCap = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabKhoHang = null;

	@FXML
	void btnQuanLyKhoHangClick(ActionEvent event) {
		String title = "Kho hàng";
		String fxmlPath = "../fxml/danhmuc/QuanLyKhoHang.fxml";
		if (ManHinhChinhController.tabKhoHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabKhoHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabKhoHang = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabKhoHang = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabDonViTinh = null;

	@FXML
	void btnQuanLyDonViTinhClick(ActionEvent event) {
		String title = "Đơn vị tính";
		String fxmlPath = "../fxml/danhmuc/QuanLyDonViTinh.fxml";
		if (ManHinhChinhController.tabDonViTinh != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabDonViTinh);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabDonViTinh = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabDonViTinh = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabLoaiHang = null;

	@FXML
	void btnQuanLyLoaiHangClick(ActionEvent event) {
		String title = "Nhóm hàng";
		String fxmlPath = "../fxml/danhmuc/QuanLyLoaiHang.fxml";
		if (ManHinhChinhController.tabLoaiHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabLoaiHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabLoaiHang = null;
			}
		});
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabLoaiHang = tab;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Tab tabKhachHang = null;

	@FXML
	void onButtonKhachHangClick(ActionEvent event) {
		String title = "Khách hàng";
		String fxmlPath = "../fxml/danhmuc/KhachHang.fxml";
		// Check tab KhachHang added or not? If added, switch to this tab
		if (ManHinhChinhController.tabKhachHang != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabKhachHang);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabKhachHang = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabKhachHang = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabTyGia = null;

	@FXML
	void onButtonTyGiaClick(ActionEvent event) {
		String title = "Tỷ giá";
		String fxmlPath = "../fxml/danhmuc/TyGia.fxml";
		if (ManHinhChinhController.tabTyGia != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabTyGia);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabTyGia = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabTyGia = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabTraTien = null;

	@FXML
	void onButtonTraTienClick(ActionEvent event) {
		String title = "Trả tiền";
		String fxmlPath = "../fxml/chucnang/TraTien.fxml";
		if (ManHinhChinhController.tabTraTien != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabTraTien);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabTraTien = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabTraTien = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Tab tabThuTien = null;

	@FXML
	void onButtonThuTienClick(ActionEvent event) {
		String title = "Thu tiền";
		String fxmlPath = "../fxml/chucnang/ThuTien.fxml";
		if (ManHinhChinhController.tabThuTien != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabThuTien);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabThuTien = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabThuTien = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnKetThucClick(ActionEvent event) {
		MainApp.getPrimaryStage().close();
	}

	@FXML
	void btnThongTinClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/trogiup/ThongTin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thông tin");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnThongTinTroGiupClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../fxml/trogiup/ThongTin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Thông tin");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void onButtonNhapDanhMucTuExcelClick() {
		System.out.println("onButtonNhapDanhMucTuExcelClick");
	}

	@FXML
	void btnDoiMatKhauClick(ActionEvent event) {
		Stage primaryStage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/hethong/DoiMatKhau.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			DoiMatKhauController doiMatKhauCtrl = loader.<DoiMatKhauController>getController();
			primaryStage.setTitle("Đổi mật khẩu");
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/appIcon.png")));
			primaryStage.show();
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					if (doiMatKhauCtrl.isDoiMatKhauThanhCong()) {
						DialogController.show(anchorManHinhChinhRoot, null, "Thông báo", "Đổi mật khẩu thành công.");
						primaryStage.close();
					}
				}
			});
		} catch (IOException e) {
			logger.error("exeption open frmDoiMatKhau", e);
			e.printStackTrace();
		}
	}

	public static Tab tabBoPhan = null;

	@FXML
	void btnBoPhanClick(ActionEvent event) {
		String title = "DS bộ phận";
		String fxmlPath = "../fxml/danhmuc/DanhSachBoPhan.fxml";
		if (ManHinhChinhController.tabBoPhan != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabBoPhan);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabBoPhan = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabBoPhan = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("exeption open tabBoPhan", e);
			e.printStackTrace();
		}
	}

	public static Tab tabNhanVien = null;

	@FXML
	void btnNhanVienClick(ActionEvent event) {
		String title = "DS Nhân viên";
		String fxmlPath = "../fxml/danhmuc/DanhSachNhanVien.fxml";
		if (ManHinhChinhController.tabNhanVien != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabNhanVien);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabNhanVien = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabNhanVien = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("exeption open tabNhanVien", e);
			e.printStackTrace();
		}
	}

	public static Tab tabNhatKy = null;

	@FXML
	void btnNhatKyHeThongClick(ActionEvent event) {
		String title = "Nhật ký hệ thống";
		String fxmlPath = "../fxml/hethong/NhatKyHeThong.fxml";
		if (ManHinhChinhController.tabNhatKy != null) {
			tabMainContent.getSelectionModel().select(ManHinhChinhController.tabNhatKy);
			return;
		}
		Tab tab = new Tab();
		tab.setText(title);
		tab.setOnClosed(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ManHinhChinhController.tabNhatKy = null;
			}
		});
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource(fxmlPath));
			tab.setContent(root);
			tabMainContent.getTabs().add(tab);
			tabMainContent.getSelectionModel().select(tab);
			ManHinhChinhController.tabNhatKy = tab;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("exeption open tabNhatKyHeThong", e);
			e.printStackTrace();
		}
	}
}
