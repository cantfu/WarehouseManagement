package cdut.WarehouseManagement.view;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class MyScrollPane extends JScrollPane{
	
	private MyTable myTable;
	public MyTable getMyTable() {
		return myTable;
	}
	public MyScrollPane(MyTable myTable) {
		super(myTable);
		this.myTable=myTable;
		initScrollPane();
	}
	private void initScrollPane()
	{
		setBorder(new LineBorder(new Color(234,239,242),15));
		getViewport().setBackground(new Color(234,239,242));
	}
}
