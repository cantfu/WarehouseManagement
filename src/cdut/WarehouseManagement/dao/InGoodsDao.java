package cdut.WarehouseManagement.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cdut.WarehouseManagement.domain.InGoods;
import cdut.WarehouseManagement.tools.JDBCUtils;

public class InGoodsDao {
	Connection conn=JDBCUtils.getConnection();

	public ArrayList<InGoods> getInGoodsInfo()
	{
		ArrayList<InGoods> list=new ArrayList<>();
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="select *from InGoods";
		list= JDBCUtils.resultSetToList(InGoods.class,stat.executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addRecord(String s1, String s2, String s3, String s4) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="insert into InGoods values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void modifyRecord(String s1, String s2, String s3, String s4) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="update InGoods set BID="+"'"+s1+"'"+",Date="+"'"+s3+"'"+",WID="+"'"+s4+"'"+" where GID='"+s2+"'";
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteRecord(String s1, String s2, String s3, String s4) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="delete from InGoods where GID='"+s2+"'";
		System.out.println(sql);
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
