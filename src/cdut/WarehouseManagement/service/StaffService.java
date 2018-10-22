package cdut.WarehouseManagement.service;

import java.util.ArrayList;

import cdut.WarehouseManagement.dao.StaffDao;
import cdut.WarehouseManagement.domain.Staff;
import cdut.WarehouseManagement.domain.Goods;
import cdut.WarehouseManagement.view.MyTable;

public class StaffService {
	private String[] columnName={"员工编号","姓名","性别","年龄","联系方式","职位"};
	StaffDao staffDao=new StaffDao();
	public MyTable getStaffInfo() {
		ArrayList<Staff> list=staffDao.getStaffInfo();
		return ListToTable(list);
	}
	private MyTable ListToTable(ArrayList<Staff> list)
	{
		int rows=list.size();
		Object array[][]=new Object[rows][6];
		for(int i=0;i<rows;++i)
		{
			array[i]=list.get(i).toArray();
		}
		return new MyTable(array,columnName);
	}
	public void addRecord(String s1, String s2, String s3, String s4, String s5,String s6) {
		staffDao.addRecord(s1, s2, s3, s4, s5,s6);
	}

	public void modifyRecord(String s1, String s2, String s3, String s4, String s5,String s6) {
		staffDao.modifyRecord(s1, s2, s3, s4, s5,s6);
	}

	public void deleteRecord(String s1, String s2, String s3, String s4, String s5,String s6) {
		staffDao.deleteRecord(s1, s2, s3, s4, s5,s6);
	}

}
