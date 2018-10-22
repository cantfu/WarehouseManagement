 package cdut.WarehouseManagement.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import cdut.WarehouseManagement.view.LoginWindow;

public class JDBCUtils{
	private static Connection connection;
	static{
//		  String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		  String url="jdbc:sqlserver://localhost:1433;DatabaseName=WarehouseManagement";
//		  String user="sa";sqlServer.ini
//		  String passWord="123456";
		  
		  String driver;
		  String url;
		  String user;
		  String passWord;
		
		InputStream in=JDBCUtils.class.getResourceAsStream("sqlServer.ini");
        Properties properties=new Properties();
		try {
			properties.load(in);
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		passWord =properties.getProperty("pass");	
		
		  try
		  {
		   Class.forName(driver);
		   connection=DriverManager.getConnection(url,user,passWord);
		   System.out.println("连接成功！");
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   System.out.print("连接失败");
		  }    
	}
	
	public static Connection getConnection()
	{
		return connection;
	}
	
	public static <T> ArrayList<T> resultSetToList(Class<T> type,ResultSet rs)
	{
		ArrayList<T> list=new ArrayList<>();
		Constructor constructor = null;
		try{
			Constructor[] constructors=type.getConstructors();
			for(Constructor c : constructors)
			{
				if(c.getParameterCount()>0)
				{
					constructor=c;
					break;
				}
			}
			while(rs.next())
			{
				ArrayList<String> list2=new ArrayList<>();
				int columnCount=rs.getMetaData().getColumnCount();
				for(int i=1;i<=columnCount;++i)
				{
					list2.add(rs.getString(i));
				}
				list.add((T)constructor.newInstance(list2.toArray()));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 判断是否存在此账户且与密码匹配
	 * @param acc 账户
	 * @param pwd 密码
	 * @return true 匹配成功；false 匹配失败
	 * @throws SQLException 
	 */
	public static boolean getAccountInfo(String acc, String pwd,LoginWindow loginWindow){
		Statement statement;
		try {
			statement = getConnection().createStatement();
			String sql="select ID from Administrator where Account="+"'"+acc+"' and Password="+"'"+pwd+"'";
			ResultSet res = statement.executeQuery(sql);
			if(res.next())
			{
				loginWindow.setID(res.getString("ID"));
				return true;
			}
			sql="select ID from Buyer where Account="+"'"+acc+"' and Password="+"'"+pwd+"'";
			res = statement.executeQuery(sql);
			if(res.next())
			{
				loginWindow.setID(res.getString("ID"));
				return true;
			}
			sql="select ID from Outter where Account="+"'"+acc+"' and Password="+"'"+pwd+"'";
			res = statement.executeQuery(sql);
			if(res.next())
			{
				loginWindow.setID(res.getString("ID"));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		return false;
	}

	/**
	 * 从数据库获取账号对应的图片信息
	 * @param account 账号
	 * @return true 获取成功；false 获取失败
	 */
    public static boolean ReadImageAccount(String account){
    	Statement statement;
		try {
			statement = getConnection().createStatement();
			String sql="select Photo from Administrator where Account='"+account+"'";
			ResultSet res = statement.executeQuery(sql);
						
			if(res.next()){
				if(res.getString("Photo")==null) return false;
				LoginWindow.inputStream = res.getBinaryStream("Photo");
				return true;
				}
			
			sql="select Photo from Buyer where Account='"+account+"'";
			res = statement.executeQuery(sql);
						
			if(res.next()){
				if(res.getString("Photo")==null) return false;
				LoginWindow.inputStream = res.getBinaryStream("Photo");
				return true;
				}
			
			sql="select Photo from Outter where Account='"+account+"'";
			res = statement.executeQuery(sql);
						
			if(res.next()){
				if(res.getString("Photo")==null) return false;
				LoginWindow.inputStream = res.getBinaryStream("Photo");
				return true;
				}
			
			
		} catch (SQLException e){
			e.printStackTrace();
		return false;  
		}
		return false;
    }

    /**
     * 
     * @param is 
     * @return 字节数组
     */
    public static byte[] toBArray(InputStream is){
    	ByteArrayOutputStream out = new  ByteArrayOutputStream();
	    int ch=0;
        try {
	    while((ch=is.read())!=-1)
	    out.write(ch);} 
        catch (IOException e) {
	    e.printStackTrace();}
        byte[] b  =  out.toByteArray();
        try {
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return b;
	} 

}

