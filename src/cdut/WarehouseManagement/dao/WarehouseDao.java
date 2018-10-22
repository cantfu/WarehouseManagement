package cdut.WarehouseManagement.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cdut.WarehouseManagement.domain.Warehouse;
import cdut.WarehouseManagement.tools.JDBCUtils;

public class WarehouseDao {
	Connection conn=JDBCUtils.getConnection();

	public ArrayList<Warehouse> getWarehouseInfo()
	{
		ArrayList<Warehouse> list=new ArrayList<>();
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="select * from Warehouse";
		list= JDBCUtils.resultSetToList(Warehouse.class,stat.executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addRecord(String s1, String s2, String s3, String s4, String s5) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="insert into Warehouse values('"+s1+"','"+s2+"',"+s3+",'"+s4+"','"+s5+"')";			                                         
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void modifyRecord(String s1, String s2, String s3, String s4, String s5) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="update Warehouse set Name="+"'"+s2+"'"+",Capacity="+s3+",address="+"'"+s4+"'"+",Date="+"'"+s5+"'"+" where ID='"+s1+"'";
		System.out.println(sql);
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteRecord(String s1, String s2, String s3, String s4, String s5) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="delete from Warehouse where ID='"+s1+"'";
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
