package cdut.WarehouseManagement.controller;

import java.util.ArrayList;
import cdut.WarehouseManagement.service.GoodsService;
import cdut.WarehouseManagement.view.MyScrollPane;
import cdut.WarehouseManagement.view.MyTable;

public class GoodsController {
	GoodsService service=new GoodsService();

	public MyScrollPane getGoodsInfo() {
		MyTable goodsTable=service.getGoodsInfo();
		MyScrollPane jScrollPane=new MyScrollPane(goodsTable);
		return jScrollPane;
	}
	
	public void addRecord(String s1,String s2,String s3,String s4,String s5)
	{
		service.addRecord(s1,s2,s3,s4,s5);
	}
	public void modifyRecord(String s1,String s2,String s3,String s4,String s5)
	{
		service.modifyRecord(s1,s2,s3,s4,s5);
	}
	public void deleteRecord(String s1,String s2,String s3,String s4,String s5)
	{
		service.deleteRecord(s1,s2,s3,s4,s5);
	}
}
