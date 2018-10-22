package cdut.WarehouseManagement.controller;

import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import cdut.WarehouseManagement.service.StaffService;
import cdut.WarehouseManagement.view.InfoDialog;
import cdut.WarehouseManagement.view.MainWindow;
import cdut.WarehouseManagement.view.MyScrollPane;
import cdut.WarehouseManagement.view.MyTable;

public class StaffController {
	StaffService staffService=new StaffService();
    MainWindow mainWindow;
	
    public void setMainWindow(MainWindow mainWindow){
    	this.mainWindow = mainWindow;
    }
    
	public MyScrollPane getStaffInfo() {
		MyTable buyerTable=staffService.getStaffInfo();
		buyerTable.addMouseListener(new doubleClick());
		MyScrollPane jScrollPane=new MyScrollPane(buyerTable);
		return jScrollPane;
	}
	
	public void addRecord(String s1,String s2,String s3,String s4,String s5,String s6)
	{
		staffService.addRecord(s1,s2,s3,s4,s5,s6);
	}
	public void modifyRecord(String s1,String s2,String s3,String s4,String s5,String s6)
	{
		staffService.modifyRecord(s1,s2,s3,s4,s5,s6);
	}
	public void deleteRecord(String s1,String s2,String s3,String s4,String s5,String s6)
	{
		staffService.deleteRecord(s1,s2,s3,s4,s5,s6);
	}
	
	/**
	 * 双击触发事件
	 * @author 寂滅
	 *
	 */
	 class doubleClick extends MouseAdapter{ 
	    	public void mouseClicked(MouseEvent e){
	    		if(e.getClickCount()==2)
	    		{
	    			 int row =((MyTable)e.getSource()).rowAtPoint(e.getPoint()); //获得行位置	    			
	    			 String iD = ((MyTable)e.getSource()).getValueAt(row, 0).toString();
	    			 InfoDialog dialog=new InfoDialog(mainWindow,iD);
	    		}
	    	}
	    }
}
