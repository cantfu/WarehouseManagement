package cdut.WarehouseManagement.service;

import java.util.ArrayList;
import cdut.WarehouseManagement.dao.OutGoodsDao;
import cdut.WarehouseManagement.domain.OutGoods;
import cdut.WarehouseManagement.view.MyTable;

public class OutGoodsService {
	private String[] columnName={"出库员编号","货物编号","出库日期","仓库编号"};
	OutGoodsDao dao=new OutGoodsDao();

	public MyTable getOutGoodsInfo() {
		ArrayList<OutGoods> list=dao.getOutGoodsInfo();
		return ListToTable(list);
	}
	private MyTable ListToTable(ArrayList<OutGoods> list )
	{
		int rows=list.size();
		Object array[][]=new Object[rows][5];
		for(int i=0;i<rows;++i)
		{
			array[i]=list.get(i).toArray();
		}
		return new MyTable(array,columnName);
	}
	public void addRecord(String s1, String s2, String s3, String s4) {
		dao.addRecord(s1,s2,s3,s4);
	}
	public void modifyRecord(String s1, String s2, String s3, String s4) {
		dao.modifyRecord(s1,s2,s3,s4);
	}

	public void deleteRecord(String s1, String s2, String s3, String s4) {
		dao.deleteRecord(s1,s2,s3,s4);
	}
}
