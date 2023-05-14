package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import com.bean.HrBean;
import com.bean.ResourceBean;
import com.util.DbConnection;

import google.Bean.UserBean;
import google.util.UserConnection;

public class HrDao {

	public void addResource(ResourceBean bean) {
		Connection con = null;

		try {

			con = DbConnection.getConnection();

			PreparedStatement pstm = con.prepareStatement("insert into Resource (firstName,lastName,emailId,contactNo,Gender,experience,qualification,resumeUrl) values (?,?,?,?,?,?,?,?) ");
			pstm.setString(1, bean.getFirstName());
			pstm.setString(2, bean.getLastName());
			pstm.setString(3, bean.getEmailId());
			pstm.setString(4, bean.getContactNo());
			pstm.setString(5, bean.getGender());
			pstm.setInt(6, bean.getExperience());
			pstm.setString(7, bean.getQualification());
			pstm.setString(8, bean.getResumeUrl());

			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	

	public int getIdofResource(String contactNo) {

		int id=0;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select userId from Resource where contactNo=?");
            pstm.setString(1, contactNo);
			rs = pstm.executeQuery();

			if(rs.next()) {
				
				id=rs.getInt("userId");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
		
	
	
	}

	public ArrayList<String> getDatabases() {
		ArrayList<String> optionsList = new ArrayList<String>();
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from Databases");

			rs = pstm.executeQuery();

			while (rs.next()) {
				String optionValue = rs.getString("dbName");
				String option = "<option value='" + optionValue + "'>" + optionValue + "</option>";
				optionsList.add(option);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return optionsList;

	}
	
	public ArrayList<String> getTechnology() {
		ArrayList<String> optionsList = new ArrayList<String>();
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from Technology");

			rs = pstm.executeQuery();

			while (rs.next()) {
				String optionValue = rs.getString("techName");
				String option = "<option value='" + optionValue + "'>" + optionValue + "</option>";
				optionsList.add(option);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return optionsList;

	}
	
	public ArrayList<String> getLanguage() {
		ArrayList<String> optionsList = new ArrayList<String>();
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from Language");

			rs = pstm.executeQuery();

			while (rs.next()) {
				String optionValue = rs.getString("lanName");
				String option = "<option value='" + optionValue + "'>" + optionValue + "</option>";
				optionsList.add(option);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return optionsList;

	}

	public int getIdFromDb(String db) {
		int id=0;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select dbId from Databases where dbName=?");
            pstm.setString(1, db);
			rs = pstm.executeQuery();

			if(rs.next()) {
				
				id=rs.getInt("dbId");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;

		
	}

	public void setuserdb(int userid, int dbid) {
		Connection con = null;

		try {

			con = DbConnection.getConnection();

			PreparedStatement pstm = con.prepareStatement("insert into User_Database (userId,dbId) values (?,?) ");
			pstm.setInt(1, userid);
			pstm.setInt(2, dbid);
			

			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
	}


	public int getIdFromLan(String lan) {
		int id=0;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select lanId from Language where lanName=?");
            pstm.setString(1, lan);
			rs = pstm.executeQuery();

			if(rs.next()) {
				
				id=rs.getInt("lanId");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;

	
	}


	public void setuserlan(int userid, int lanid) {
		Connection con = null;

		try {

			con = DbConnection.getConnection();

			PreparedStatement pstm = con.prepareStatement("insert into User_Language (userId,lanId) values (?,?) ");
			pstm.setInt(1, userid);
			pstm.setInt(2, lanid);
			

			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
	}


	public int getIdFromtech(String tech) {

		int id=0;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select techId from Technology where techName=?");
            pstm.setString(1, tech);
			rs = pstm.executeQuery();

			if(rs.next()) {
				
				id=rs.getInt("techId");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;

	
		
	}


	public void setusertech(int userid, int techid) {
		
		Connection con = null;

		try {

			con = DbConnection.getConnection();

			PreparedStatement pstm = con.prepareStatement("insert into User_Technology (userId,techId) values (?,?) ");
			pstm.setInt(1, userid);
			pstm.setInt(2, techid);
			

			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	public ArrayList<ResourceBean> getResourceList() {
		Connection con=null;
		ResultSet rs=null;
		ResourceBean user=null;
		ArrayList<ResourceBean> list=new ArrayList<>();
		try {
		con=DbConnection.getConnection();
		PreparedStatement pstm=con.prepareStatement("select * from Resource");
				
		rs=pstm.executeQuery();
		
		while(rs.next())
		{
			user=new ResourceBean();
			user.setUserId(rs.getInt("userId"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setEmailId(rs.getString("emailId"));
			user.setContactNo(rs.getString("contactNo"));
			user.setGender(rs.getString("Gender"));
			user.setExperience(rs.getInt("experience"));
			user.setQualification(rs.getString("qualification"));
			user.setResumeUrl(rs.getString("resumeUrl"));
			
			list.add(user);
			
			list.forEach(e->
			System.out.println(e));
			
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


	public String[] getDbList(int userid,int size) {

			int i=0;
			Connection con = null;
			ResultSet rs = null;
			
			String[] s= new String[size];
			try {
				con = DbConnection.getConnection();
				PreparedStatement pstm = con.prepareStatement("select dbName from Databases d, User_Database ud where ud.userId=? and ud.dbId=d.dbId");
	            pstm.setInt(1, userid);
				rs = pstm.executeQuery();

				while(rs.next()) {
					
					s[i++]=rs.getString("dbName");

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return s;

		
			
		
	}


	public String[] getLanList(int userid, int size) {
		int i=0;
		Connection con = null;
		ResultSet rs = null;
		
		String[] s= new String[size];
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select lanName from Language l,User_Language ul where ul.userId=? and ul.lanId=l.lanId");
            pstm.setInt(1, userid);
			rs = pstm.executeQuery();

			while(rs.next()) {
				
				s[i++]=rs.getString("lanName");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s;

		
	}


	public String[] getTechList(int userid, int size) {
		int i=0;
		Connection con = null;
		ResultSet rs = null;
		
		String[] s= new String[size];
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select techName from Technology	 t,User_Technology ut where ut.userId=? and ut.techId=t.techId");
            pstm.setInt(1, userid);
			rs = pstm.executeQuery();

			while(rs.next()) {
				
				s[i++]=rs.getString("techName");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s;

	}


	public void deleteResource(Integer id) {

		Connection con=null;
		   try
		  {
			
			
			// TODO Auto-generated method stub
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("delete from User_Language where userId=?;delete from User_Technology where userId=?;delete from User_Database where userId=?;delete from Resource where userId=?");
					
		
			pstm.setInt(1,id);
			pstm.setInt(2,id);
			pstm.setInt(3,id);
			pstm.setInt(4,id);
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


	public ResourceBean searchresource(String name) {
		

		  ResultSet rs=null;
		  ArrayList<UserBean> list=new ArrayList<>();
		  UserBean user=null;
		  Connection con=null;

		  try
		  {
			
			
			// TODO Auto-generated method stub
			con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from users where firstName like ?");
			
			pstm.setString(1,firstName+"%");
			
			
			
			rs=pstm.executeQuery();
			
			while(rs.next())
			{
				user=new UserBean();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmailId(rs.getString("emailId"));
				user.setPassword(rs.getString("password"));
				user.setCity(rs.getString("city"));
				user.setGender(rs.getString("gender"));
				user.setH1(rs.getString("h1"));
				user.setH2(rs.getString("h2"));
				user.setH3(rs.getString("h3"));
				
				list.add(user);
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
		   return list;
	
	}


}
