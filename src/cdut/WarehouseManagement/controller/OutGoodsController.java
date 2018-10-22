package cdut.WarehouseManagement.controller;

import java.util.ArrayList;
import cdut.WarehouseManagement.service.OutGoodsService;
import cdut.WarehouseManagement.view.MyScrollPane;
import cdut.WarehouseManagement.view.MyTable;

public class OutGoodsController {
	OutGoodsService service=new OutGoodsService();

	public MyScrollPane getOutGoodsInfo() {
		MyTable OutgoodsTable=service.getOutGoodsInfo();
		MyScrollPane jScrollPane=new MyScrollPane(OutgoodsTable);
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
