package com.service;

import java.util.List;
import java.util.Set;


import com.model.Employee;

public interface EmployeeService {

	Employee getemployee(int id);
    List<Employee> getAllEmployee();
    
    boolean insertEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int empId);
	boolean getEmployeeByUserNameAndPassword(String empName, String pass);
	void departmentwiseEmployeeCount();
	
//	List<Employee> listofEmployeesforGivenDepartmnet(int departmentId);
	List<Employee> ListEmpByDepartment(int departmentId);
	
	

	
	
}
