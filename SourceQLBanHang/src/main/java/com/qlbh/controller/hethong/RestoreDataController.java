package com.qlbh.controller.hethong;

import java.io.File;

import org.apache.log4j.Logger;

import com.jfoenix.controls.JFXButton;
import com.qlbh.controller.common.DialogController;
import com.qlbh.pojo.InforConfig;
import com.qlbh.util.HibernateFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class RestoreDataController {
	private static final Logger logger = Logger.getLogger(RestoreDataController.class);

	@FXML
	private JFXButton btnDong, btnThucHien, btnOpenFile;
	@FXML
	private AnchorPane root;
	@FXML
	private Label lblError;
	@FXML
	private TextField txtDuongDan;

	@FXML
	protected void initialize() {
	}

	@FXML
	void btnThucHienClick(ActionEvent event) {
		this.restoreDB();
	}

	@FXML
	void btnDongClick(ActionEvent event) {
		this.closeStage();
	}

	@FXML
	void onKeyAction(KeyEvent e) {
		if (e.getCode().toString().equals("ENTER")) {
			this.restoreDB();
		}
		if (e.getCode().toString().equals("ESCAPE")) {
			this.closeStage();
		}
	}

	@FXML
	void btnOpenFileClick(ActionEvent event) {
		FileChooser fx = new FileChooser();
		fx.setInitialDirectory(new File("F:\\backup"));
		fx.getExtensionFilters().addAll(new ExtensionFilter("sql Files", "*.sql"));
		File path = fx.showOpenDialog(null);
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
		String path = this.txtDuongDan.getText();
		path = path.replace("\\", "\\\\");
		System.out.println(path);
		return path;
	}

	public void restoreDB() {
		try {
			if (txtDuongDan.getLength() == 0) {
				lblError.setText("Vui lòng điền đủ thông tin trong các mục (*)");
				return;
			}

			InforConfig config = new InforConfig();
			config = HibernateFactory.getInforConfig();
			System.out.println(config);
			String[] executeCmd = new String[] { "mysql", "--user=" + config.getUser(),
					"--password=" + config.getPass(), config.getDbname(), "-e", " source " + this.getPath() };
			Process runtimeProcess;
			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();
			if (processComplete == 0) {
				DialogController.show(root, null, "Thông báo", "Phục hồi dữ liệu đã sao lưu thành công.");
			} else {
				DialogController.show(root, null, "Thông báo",
						"Phục hồi dữ liệu đã sao lưu không thành công.Vui lòng thử lại.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("restore data error \n" + ex.getMessage());
			DialogController.show(root, null, "Thông báo",
					"Phục hồi dữ liệu đã sao lưu không thành công.Vui lòng thử lại.");
		}
	}

}
