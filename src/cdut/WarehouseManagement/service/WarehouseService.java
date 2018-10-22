package cdut.WarehouseManagement.service;

import java.util.ArrayList;
import cdut.WarehouseManagement.dao.WarehouseDao;
import cdut.WarehouseManagement.domain.Warehouse;
import cdut.WarehouseManagement.view.MyTable;

public class WarehouseService {
	private String[] columnName={"仓库编号","仓库名称","仓库容量","仓库地址","建立日期"};
	WarehouseDao dao=new WarehouseDao();

	public MyTable getWarehouseInfo() {
		ArrayList<Warehouse> list=dao.getWarehouseInfo();
		return ListToTable(list);
	}
	private MyTable ListToTable(ArrayList<Warehouse> list )
	{
		int rows=list.size();
		Object array[][]=new Object[rows][5];
		for(int i=0;i<rows;++i)
		{
			array[i]=list.get(i).toArray();
		}
		return new MyTable(array,columnName);
	}
	public void addRecord(String s1, String s2, String s3, String s4, String s5) {
		dao.addRecord(s1,s2,s3,s4,s5);
	}
	public void modifyRecord(String s1, String s2, String s3, String s4, String s5) {
		dao.modifyRecord(s1,s2,s3,s4,s5);
	}

	public void deleteRecord(String s1, String s2, String s3, String s4, String s5) {
		dao.deleteRecord(s1,s2,s3,s4,s5);
	}
}
