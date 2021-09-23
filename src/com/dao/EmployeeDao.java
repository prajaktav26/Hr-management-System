package com.dao;

import java.util.List;
import java.util.Set;

import com.model.Employee;


public interface EmployeeDao {

	    Employee getEmployee(int empid);
	    List<Employee> getAllEmployee();
	    void departmentwiseEmployeeCount();
	    boolean insertEmployee(Employee employee);
	    boolean updateEmployee(Employee employee);
	    boolean deleteEmployee(int empId);
		boolean getEmployeeByUserNameAndPassword(String empName, String pass);
		
//		List<Employee> listofEmployeesforGivenDepartmnet(int departmentId);
//		List<Employee> listofEmployeesforGivenDepartmnet(int departmentId);
		List<Employee> ListEmpByDepartment(int departmentId);
		

}
