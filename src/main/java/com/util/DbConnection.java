package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection getConnection() 
	{
		Connection con = null;
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:50253;DatabaseName=Resource_Management;trustServerCertificate=true;","sa","root");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_database", "root", "root");


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (con != null) {
			System.out.println("Success1 "  	+ con);
		} else {
			System.out.println("Fail..");
		}

		return con;

}


}
