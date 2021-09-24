package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.configuration.ConnectionFactory;
import com.model.Employee;

public class EmployeedaoImplements implements EmployeeDao {

	ConnectionFactory connectionFactory;
	private Object ps;

	public EmployeedaoImplements() {
		connectionFactory = new ConnectionFactory();
	}

	public Employee getEmployee(int empid) {
		Connection connection = null;
		try {
			connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE empid=" + empid);
			if (rs.next()) {
				return extractUserFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Employee extractUserFromResultSet(ResultSet rs) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("empid"));
		employee.setEmpName(rs.getString("empname"));
		employee.setEmpAge(rs.getInt("empage"));
		employee.setEmpSalary(rs.getInt("empSalary"));
		employee.setEmpAdress(rs.getString("empAddress"));
		employee.setEmpMobile(rs.getString("empcontact"));
		employee.setEmpEmail(rs.getString("empEmail"));
		employee.setroleid(rs.getInt("roleisd"));
		employee.setdeptId(rs.getInt("deptid"));

		return employee;
	}

	public boolean insertEmployee(Employee employee) {

		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?,?,?,?,?,?)");
			ps.setInt(1, employee.getEmpId());
			ps.setString(2, employee.getEmpName());

			ps.setInt(3, employee.getEmpSalary());
			ps.setInt(4, employee.getEmpAge());
			ps.setString(5, employee.getEmpAdress());
			ps.setString(6, employee.getEmpMobile());
			ps.setString(7, employee.getEmpEmail());
			ps.setInt(8, employee.getroleid());
			ps.setInt(9, employee.getdeptdid());

			int i = ps.executeUpdate();
			if (i == 1) {

				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub

		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM employee WHERE empid=" + empId);
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public List<Employee> getAllEmployee() {
		ArrayList<Employee> employees = null;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			employees = new ArrayList<>();
			while (rs.next()) {
				Employee employee = extractUserFromResultSet(rs);
				employees.add(employee);

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return employees;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		System.out.println(employee);
		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE employee SET empname=?, empsalary=?, empage=?,empaddress=?,empcontact=?,empemail=? WHERE empid=?");

			ps.setString(1, employee.getEmpName());
			ps.setInt(2, employee.getEmpSalary());
			ps.setInt(3, employee.getEmpAge());
			ps.setString(4, employee.getEmpAdress());
			ps.setString(5, employee.getEmpMobile());
			ps.setString(6, employee.getEmpEmail());
			ps.setInt(7, employee.getEmpId());

			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean getEmployeeByUserNameAndPassword(String empName, String pass) {
		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM authentication WHERE username=? AND password=?");
			ps.setString(1, empName);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public void departmentwiseEmployeeCount() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT d.deptname,count(e.empid) from department d join employee e on d.depatmnetid=e.deptid group by d.deptname";
		try {
			connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString(1) + ":-   " + rs.getInt(2) + "  ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> ListEmpByDepartment(int departmentId) {
		Connection connection = null;
		ArrayList<Employee> list = new ArrayList<>();
		try {
			connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE deptid=" + departmentId);

			while (rs.next()) {
				Employee eo = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
				list.add(eo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
