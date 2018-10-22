package cdut.WarehouseManagement.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cdut.WarehouseManagement.domain.Staff;
import cdut.WarehouseManagement.tools.JDBCUtils;

public class StaffDao {

	Connection conn=JDBCUtils.getConnection();

	public ArrayList<Staff> getStaffInfo()
	{
		ArrayList<Staff> list=new ArrayList<>();
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="select ID,name,Sex,Age,Tel,Duty from Buyer union select ID,name,Sex,Age,Tel,Duty from Outter";
		list= JDBCUtils.resultSetToList(Staff.class,stat.executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addRecord(String s1, String s2, String s3, String s4, String s5,String s6) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql=null;
		if(s6.equals("入库员"))
		{
			sql="insert into Buyer(ID,name,Sex,Age,Tel,Duty) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
			System.out.println(sql);
		}
		else if(s6.equals("出库员"))
		{
			sql="insert into Outter(ID,name,Sex,Age,Tel,Duty) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
		}
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void modifyRecord(String s1, String s2, String s3, String s4, String s5,String s6) {
		Statement stat;

		try {
		stat = conn.createStatement();
		String sql=null;
		if(s6.equals("入库员"))
		{
			sql="update Buyer set name="+"'"+s2+"'"+",Sex="+"'"+s3+"'"+",Age='"+s4+"',Tel="+"'"+s5+"'"+",Duty="+"'"+s6+"'"+" where ID='"+s1+"'";
			System.out.println(sql);
		}
		else if(s6.equals("出库员"))
		{
			sql="update Outter set name="+"'"+s2+"'"+",Sex="+"'"+s3+"'"+",Age='"+s4+"',Tel="+"'"+s5+"'"+",Duty="+"'"+s6+"'"+" where ID='"+s1+"'";
		System.out.println(sql);
		}
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteRecord(String s1, String s2, String s3, String s4, String s5,String s6) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql=null;
		if(s6.equals("入库员"))
		{
			sql="delete from Buyer where ID='"+s1+"'";
		}
		else if(s6.equals("出库员"))
		{
			sql="delete from Outter where ID='"+s1+"'";
			System.out.println(sql);
		}
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
