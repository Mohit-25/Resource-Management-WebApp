package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.bean.AdminBean;
import com.bean.HrBean;
import com.util.DbConnection;

import google.util.UserConnection;





public class AdminDao {

	public AdminBean Authenticate(String emailId, String password) {
		Connection con = null;
		ResultSet rs = null;
		AdminBean user = null;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from Admin where adminEmail=? and adminPassword=?");
			pstm.setString(1, emailId);
			pstm.setString(2, password);

			rs = pstm.executeQuery();

			if (rs.next()) {
				user = new AdminBean();
				user.setAdminId(rs.getInt("adminId"));
				user.setAdminName(rs.getString("adminName"));
				user.setAdminEmail(rs.getString("adminEmail"));
				user.setAdminPassword(rs.getString("adminPassword"));

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return user;

	}

	public void addHr(HrBean bean) {
		Connection con=null;
		
         
		try {
			//store into database 
			con =DbConnection.getConnection();
			

			//sql 
			//Statement
			//PreparedStatement
			//CallableStatement 
			PreparedStatement pstm = con.prepareStatement("insert into Hr(hrFirstName,hrLastName,hrEmail,hrPassword,hrGender,hrContact,hrJoinDate) values (?,?,?,?,?,?,?) ");
			pstm.setString(1,bean.getHrFirstName());
			pstm.setString(2, bean.getHrLastName());
			pstm.setString(3, bean.getHrEmail());
			pstm.setString(4, bean.getHrPassword());
			pstm.setString(5, bean.getHrGender());
			pstm.setString(6, bean.getHrContact());
			pstm.setString(7, bean.getHrJoinDate());
			

			pstm.executeUpdate(); //db -> 	1 -> inserted , updated , deleted 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		
	}

	public ArrayList<HrBean> getHrList() {
		
		Connection con=null;
		ResultSet rs=null;
		HrBean user=null;
		ArrayList<HrBean> list=new ArrayList<>();
		try {
		con=DbConnection.getConnection();
		PreparedStatement pstm=con.prepareStatement("select * from Hr ");
				
		rs=pstm.executeQuery();
		
		while(rs.next())
		{
			user=new HrBean();
			user.setHrId(rs.getInt("hrId"));
			user.setHrFirstName(rs.getString("hrFirstName"));
			user.setHrLastName(rs.getString("hrLastName"));
			user.setHrEmail(rs.getString("hrEmail"));
//			user.setHrPassword(rs.getString("hrPassword"));
//			user.setHrGender(rs.getString("hrGender"));
			user.setHrContact(rs.getString("hrContact"));
//			user.setHrJoinDate(rs.getString("hrJoinDate"));
			
			list.add(user);
			
			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		return list;
	}

	public HrBean getHrById(Integer id) {
		
		HrBean user=null;
		ResultSet rs =null;
	
		Connection con=null;
	   try
	  {
		
		
		// TODO Auto-generated method stub
		con = DbConnection.getConnection();
		PreparedStatement pstm = con.prepareStatement("select * from hr where hrId=?");
		
		pstm.setInt(1,id);
		rs=pstm.executeQuery();
		
		if(rs.next())
		{
			user=new HrBean();
			user.setHrId(rs.getInt("hrId"));
			user.setHrFirstName(rs.getString("hrFirstName"));
			user.setHrLastName(rs.getString("hrLastName"));
			user.setHrEmail(rs.getString("hrEmail"));
			user.setHrPassword(rs.getString("hrPassword"));
			user.setHrGender(rs.getString("hrGender"));
			user.setHrContact(rs.getString("hrContact"));
			user.setHrJoinDate(rs.getString("hrJoinDate"));
			
		
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		return user;
	}

	public void deleteHr(int id) {
		
		Connection con=null;
		   try
		  {
			
			
			// TODO Auto-generated method stub
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("delete from hr where hrId=?");
			
			pstm.setInt(1,id);
			pstm.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public HrBean getUserById(Integer userId) {
		
		HrBean user=null;
		ResultSet rs =null;
	
		Connection con=null;
	   try
	  {
		
		
		// TODO Auto-generated method stub
		con = DbConnection.getConnection();
		PreparedStatement pstm = con.prepareStatement("select * from Hr where hrId=?");
		
		pstm.setInt(1,userId);
		rs=pstm.executeQuery();
		
		if(rs.next())
		{
			user=new HrBean();
			user.setHrId(rs.getInt("hrId"));
			user.setHrFirstName(rs.getString("hrFirstName"));
			user.setHrLastName(rs.getString("hrLastName"));
			user.setHrEmail(rs.getString("hrEmail"));
			user.setHrPassword(rs.getString("hrPassword"));
			user.setHrGender(rs.getString("hrGender"));
			user.setHrContact(rs.getString("hrContact"));
			user.setHrJoinDate(rs.getString("hrJoinDate"));
		
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		return user;
	}

	public void UpdateUser(HrBean bean) {
		
		 Connection con=null;
		   try
		  {
			
			
			// TODO Auto-generated method stub
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("update hr set hrFirstName=?,hrLastName=?,hrEmail=?,hrPassword=?,hrGender=?,hrContact=?,hrJoinDate=? where hrId=?");
			
			
			pstm.setString(1,bean.getHrFirstName());
			pstm.setString(2, bean.getHrLastName());
			pstm.setString(3, bean.getHrEmail());
			pstm.setString(4, bean.getHrPassword());
			pstm.setString(5, bean.getHrGender());
			pstm.setString(6, bean.getHrContact());
			pstm.setString(7, bean.getHrJoinDate());
			pstm.setInt(8,bean.getHrId());
			
			
			pstm.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}
}
