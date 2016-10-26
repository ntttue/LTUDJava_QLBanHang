package com.qlbh.controller.hethong;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.common.DialogController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class BackupDataController {
	private static final Logger logger = Logger.getLogger(BackupDataController.class);

	@FXML
	private JFXButton btnDong, btnThucHien, btnOpenFile;
	@FXML
	private AnchorPane root;
	@FXML
	private Label lblError;
	@FXML
	private TextField txtTenFile, txtDuongDan;

	@FXML
	protected void initialize() {
		String pattern = "ddMMyyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		// formatting
		this.txtTenFile.setText("data" + format.format(new Date()) + ".sql");
	}

	@FXML
	void btnThucHienClick(ActionEvent event) {
		this.backupDB();
	}

	@FXML
	void btnDongClick(ActionEvent event) {
		this.closeStage();
	}

	@FXML
	void onKeyAction(KeyEvent e) {
		if (e.getCode().toString().equals("ENTER")) {
			this.backupDB();
		}
		if (e.getCode().toString().equals("ESCAPE")) {
			this.closeStage();
		}
	}

	@FXML
	void btnOpenFileClick(ActionEvent event) {
		DirectoryChooser fx = new DirectoryChooser();
		fx.setInitialDirectory(new File("F:\\backup"));
		File path = fx.showDialog(null);
		if (path != null) {
			this.txtDuongDan.setText(path.getPath());
		}
	}

	private void closeStage() {
		System.out.println("click cancel");
		Stage stage = (Stage) btnDong.getScene().getWindow();
		stage.close();
	}

	private String getPath() {
		String path = this.txtDuongDan.getText() + "\\" + this.txtTenFile.getText();
		path = path.replace("\\", "\\\\");
		System.out.println(path);
		return path;
	}

	public void backupDB() {
		try {
			if (txtTenFile.getLength() == 0 || txtDuongDan.getLength() == 0) {
				lblError.setText("Vui lòng điền đủ thông tin trong các mục (*)");
				return;
			}
			// String[] executeCmd = new String[] { "mysqldump", "--user=" +
			// "root", "--password=" + "1234", "qlbh", "-r",
			// "D:\\Study\\KH2_HCDH\\LTUDJava\\DoAn\\LTUDJava_QLBanHang\\Database\\backup.sql"
			// };
			String[] executeCmd = new String[] { "mysqldump", "--user=" + "root", "--password=" + "1234", "qlbh", "-r",
					this.getPath() };
			Process runtimeProcess;
			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();
			if (processComplete == 0) {
				DialogController.show(root, null, "Thông báo", "Sao lưu dữ liệu thành công.");
			} else {
				DialogController.show(root, null, "Thông báo", "Sao lưu dữ liệu không thành công.Vui lòng thử lại.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Backup data error \n" + e.getMessage());
			DialogController.show(root, null, "Thông báo", "Sao lưu dữ liệu không thành công.Vui lòng thử lại.");
		}
	}
}
