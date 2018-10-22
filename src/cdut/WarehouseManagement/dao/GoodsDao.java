package cdut.WarehouseManagement.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cdut.WarehouseManagement.domain.Goods;
import cdut.WarehouseManagement.tools.JDBCUtils;

public class GoodsDao {
	Connection conn=JDBCUtils.getConnection();

	public ArrayList<Goods> getGoodsInfo()
	{
		ArrayList<Goods> list=new ArrayList<>();
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="select *from Goods";
		list= JDBCUtils.resultSetToList(Goods.class,stat.executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addRecord(String s1, String s2, String s3, String s4, String s5) {
		Statement stat;
		try {
		stat = conn.createStatement();
		String sql="insert into Goods values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
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
		String sql="update Goods set name="+"'"+s2+"'"+",Supplier="+"'"+s3+"'"+",Pdate="+"'"+s4+"'"+",Deadline="+"'"+s5+"'"+" where ID='"+s1+"'";
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
		String sql="delete from Goods where ID='"+s1+"'";
		stat.execute(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
