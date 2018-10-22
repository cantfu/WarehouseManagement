package cdut.WarehouseManagement.app;

import cdut.WarehouseManagement.tools.JDBCUtils;
import cdut.WarehouseManagement.view.LoginWindow;
import cdut.WarehouseManagement.view.MainWindow;

public class WarehouseManagementApp {

	public static void main(String[] args) {
		JDBCUtils.getConnection();
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.setVisible(true);		
	}

}
