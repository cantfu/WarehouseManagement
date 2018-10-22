package cdut.WarehouseManagement.service;

import java.util.ArrayList;
import cdut.WarehouseManagement.dao.GoodsDao;
import cdut.WarehouseManagement.domain.Goods;
import cdut.WarehouseManagement.view.MyTable;

public class GoodsService {
	private String[] columnName={"货物编号","货物名称","供应商","生产日期","保质日期"};
	GoodsDao dao=new GoodsDao();

	public MyTable getGoodsInfo() {
		ArrayList<Goods> list=dao.getGoodsInfo();
		return ListToTable(list);
	}
	private MyTable ListToTable(ArrayList<Goods> list)
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
