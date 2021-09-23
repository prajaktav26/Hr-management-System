package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.configuration.ConnectionFactory;
import com.model.Department;
import com.model.Employee;

public class DepartmentdaoImplementation implements DepartmentDao {
	ConnectionFactory connectionFactory;
	private Object ps;
	public DepartmentdaoImplementation() {
		connectionFactory=new ConnectionFactory();
	}
	public Department getDepartment(int departmentId) {
		 Connection connection = null;
		try {
			connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM department WHERE depatmntid=" + departmentId);
           if(rs.next())
           {
           	 return extractUserFromResultSet(rs);
           }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	       
	    return null;
	}
	private Department extractUserFromResultSet(ResultSet rs) throws SQLException {
	    Department department = new Department();
	    department.setDepartmentId( rs.getInt("depatmntid") );
	    department.setDepartmentName(rs.getString("deptname"));
	    department.setDepartmentLocation(rs.getString("deptlocation"));
	    return department;
	}

}
