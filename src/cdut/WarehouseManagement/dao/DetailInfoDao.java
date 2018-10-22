package cdut.WarehouseManagement.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import cdut.WarehouseManagement.domain.DetailInfo;
import cdut.WarehouseManagement.tools.JDBCUtils;

public class DetailInfoDao {
	private Connection conn=JDBCUtils.getConnection();
	
	public void modifyRecord(DetailInfo info) {
		String tableName=null;
		String ID=info.getID();
		if(ID.contains("A"))
		{
			tableName="Administrator";
		}
		else if(ID.contains("B"))
		{
			tableName="Buyer";
		}
		else if(ID.contains("O"))
		{
			tableName="Outter";
		}
		String sql="update "+tableName+" set name=?,sex=?,Birthday=?,Tel=?,Year=?,Email=?,Hometown=?,Address=?,Duty=?,School=?,Remark=?,Photo=? where ID=?";
		PreparedStatement stat;
		try {
			stat=conn.prepareStatement(sql);
			stat.setString(1, info.getName());
			stat.setString(2, info.getSex());
			stat.setString(3, info.getBirthday());
			stat.setString(4, info.getTel());
			stat.setInt(5, Integer.parseInt(info.getYear()));
			stat.setString(6, info.getEmail());
			stat.setString(7, info.getHometown());
			stat.setString(8, info.getAddress());
			stat.setString(9, info.getDuty());
			stat.setString(10, info.getSchool());
			stat.setString(11, info.getRemark());

			if(info.getPhoto()!=null)
			{
				InputStream in = new ByteArrayInputStream(info.getPhoto());
				try {
					stat.setBinaryStream(12, in, in.available());
					in.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			else{
				stat.setBinaryStream(12,null);
			}
			stat.setString(13, info.getID());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public DetailInfo getRecord(String iD) {
		DetailInfo detailInfo = new DetailInfo();
		detailInfo.setID(iD);
		String tableName=null;
		if(iD.contains("A"))
		{
			tableName="Administrator";
		}
		else if(iD.contains("B"))
		{
			tableName="Buyer";
		}
		else if(iD.contains("O"))
		{
			tableName="Outter";
		}
		
		String sql="select Name,Sex,Birthday,Tel,Year,Email,Hometown,Address,Duty,School,Remark,Photo from "+tableName+" where ID='"+iD+"'";
		Statement state;
		try {
			state=conn.createStatement();
			ResultSet res = state.executeQuery(sql);
			if(res.next()){
				detailInfo.setName(res.getString("Name"));
				detailInfo.setSex(res.getString("Sex"));
				detailInfo.setBirthday(res.getString("Birthday"));
				detailInfo.setTel(res.getString("Tel"));
				detailInfo.setYear(res.getString("Year"));
				detailInfo.setEmail(res.getString("Email"));
				detailInfo.setHometown(res.getString("Hometown"));
				detailInfo.setAddress(res.getString("Address"));
				detailInfo.setDuty(res.getString("Duty"));
				detailInfo.setSchool(res.getString("School"));
				detailInfo.setRemark(res.getString("Remark"));

			   if(res.getString("Photo")!=null)
			   {	
				InputStream inputStream  = 	res.getBinaryStream("Photo");
				detailInfo.setPhoto(JDBCUtils.toBArray(inputStream));
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			   }
				return detailInfo;
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
