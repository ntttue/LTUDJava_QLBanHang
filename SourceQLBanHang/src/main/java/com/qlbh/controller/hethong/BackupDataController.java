package com.qlbh.controller.hethong;

import org.apache.log4j.Logger;

import javafx.fxml.FXML;

public class BackupDataController {
	private static final Logger logger = Logger.getLogger(BackupDataController.class);

	@FXML
	protected void initialize() {
		this.restoreDB();
	}

	public void backupDB() {
		Process p = null;
		try {
			String[] comm = new String[4];
			comm[0] = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump";
			comm[1] = "-u " + "root@localhost";
			;
			comm[2] = "-p " + "1234" + " " + "qlbh";
			comm[3] = "-r D:\\Study\\KH2_HCDH\\LTUDJava\\DoAn\\LTUDJava_QLBanHang\\backup.sql";
			// change the dbpass and dbname with your dbpass and dbname
			Process runtimeProcess = Runtime.getRuntime().exec(comm);
			int processComplete = runtimeProcess.waitFor();

			if (processComplete == 0) {
				System.out.println("Backup taken successfully");
			} else {
				System.out.println("Could not take mysql backup");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean restoreDB() {
		String[] executeCmd = new String[] { "mysql", "--user=" + "root", "--password=" + "1234", "qlbh", "-e",
				" source " + "D:\\Study\\KH2_HCDH\\LTUDJava\\DoAn\\LTUDJava_QLBanHang\\Database\\qlbh20161026.sql" };
		Process runtimeProcess;
		try {
			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();
			if (processComplete == 0) {
				System.out.println("Backup restored successfully");
				return true;
			} else {
				System.out.println("Could not restore the backup");
			}
		} catch (

		Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
