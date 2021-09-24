package com.controller;

import java.util.Scanner;
//import java.awt.List;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import com.dao.EmployeedaoImplements;

import com.model.Employee;
import com.service.EmployeeService;
import com.service.EmployeeServiceImplementation;

public class MyAppStart {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeedaoImplements dao = new EmployeedaoImplements();

		EmployeeService employeeService = new EmployeeServiceImplementation();

		Employee u3 = new Employee(6, "Avinash", 35, 60000, "kolhapur", "675438902", "avi234@gmail", 1, 2);

		System.out.println(employeeService.insertEmployee(u3));

	}
}
