package com.service;

import java.util.List;
import java.util.Set;


import com.dao.EmployeeDao;
import com.dao.EmployeedaoImplements;
import com.model.Employee;

public class EmployeeServiceImplementation implements EmployeeService{
	

	EmployeeDao employeeDao;
     
    

	public EmployeeServiceImplementation() {
		super();
		this.employeeDao = new EmployeedaoImplements();
	}

	public EmployeeDao getDao() {
		return employeeDao;
	}

	public void setDao(EmployeeDao dao) {
		this.employeeDao = dao;
	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(id);
	}

	
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}
	

	public boolean updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}
 
	@Override
	public Employee getemployee(int empId) {
		return employeeDao.getEmployee(empId);
	}


	@Override
	public boolean insertEmployee(Employee employee) {
		return employeeDao.insertEmployee(employee);

	}

	@Override
	public boolean deleteEmployee(int empId) {
		return employeeDao.deleteEmployee(empId);
	}



	public boolean getEmployeeByUserNameAndPassword(String empName, String pass) {
		return employeeDao.getEmployeeByUserNameAndPassword(empName, pass);
	}

	@Override
	public void departmentwiseEmployeeCount() {
		// TODO Auto-generated method stub
		employeeDao.departmentwiseEmployeeCount();
	}

	@Override
	public List<Employee> ListEmpByDepartment(int departmentId) {
		// TODO Auto-generated method stub
		return employeeDao.ListEmpByDepartment(departmentId);
	}
 
	
//	@Override
//	public List<Employee> listofEmployeesforGivenDepartmnet(int departmentId) {
//		// TODO Auto-generated method stub
//		return employeeDao.listofEmployeesforGivenDepartmnet(departmentId);
//		
//	}

	
	
	
	

}
