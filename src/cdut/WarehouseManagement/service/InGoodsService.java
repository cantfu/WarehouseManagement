package cdut.WarehouseManagement.service;

import java.util.ArrayList;
import cdut.WarehouseManagement.dao.InGoodsDao;
import cdut.WarehouseManagement.domain.InGoods;
import cdut.WarehouseManagement.view.MyTable;

public class InGoodsService {
	private String[] columnName={"入库员编号","货物编号","入库日期","仓库编号"};
	InGoodsDao dao=new InGoodsDao();

	public MyTable getInGoodsInfo() {
		ArrayList<InGoods> list=dao.getInGoodsInfo();
		return ListToTable(list);
	}
	private MyTable ListToTable(ArrayList<InGoods> list)
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
