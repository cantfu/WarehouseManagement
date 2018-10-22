package cdut.WarehouseManagement.controller;

import java.util.ArrayList;
import cdut.WarehouseManagement.service.InGoodsService;
import cdut.WarehouseManagement.view.MyScrollPane;
import cdut.WarehouseManagement.view.MyTable;

public class InGoodsController {
	InGoodsService service=new InGoodsService();

	public MyScrollPane getInGoodsInfo() {
		MyTable IngoodsTable=service.getInGoodsInfo();
		MyScrollPane jScrollPane=new MyScrollPane(IngoodsTable);
		return jScrollPane;
	}
	
	public void addRecord(String s1,String s2,String s3,String s4)
	{
		service.addRecord(s1,s2,s3,s4);
	}
	public void modifyRecord(String s1,String s2,String s3,String s4)
	{
		service.modifyRecord(s1,s2,s3,s4);
	}
	public void deleteRecord(String s1,String s2,String s3,String s4)
	{
		service.deleteRecord(s1,s2,s3,s4);
	}
}
