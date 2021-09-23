package com.configuration;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.model.Employee;

public class ConnectionFactory {

	
	public  Connection getConnection() throws SQLException
	{
		Connection con=null;

		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmanagement","root","P1234");
	
//		con=DriverManager.getConnection(DBConnection);
		return con;
	}


}
