package cdut.WarehouseManagement.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cdut.WarehouseManagement.domain.OutGoods;
import cdut.WarehouseManagement.tools.JDBCUtils;

public class OutGoodsDao {
	Connection conn=JDBCUtils.getConnection();

	public ArrayList<OutGoods> getOutGoodsInfo()
	{
		ArrayList<OutGoods> list=new ArrayList<>();
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="select *from OutGoods";
		list= JDBCUtils.resultSetToList(OutGoods.class,stat.executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addRecord(String s1, String s2, String s3, String s4) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="insert into OutGoods values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
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
		String sql="update OutGoods set OID="+"'"+s1+"'"+",Date="+"'"+s3+"'"+",WID="+"'"+s4+"'"+" where GID='"+s2+"'";
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
		String sql="delete from OutGoods where GID='"+s2+"'";
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
