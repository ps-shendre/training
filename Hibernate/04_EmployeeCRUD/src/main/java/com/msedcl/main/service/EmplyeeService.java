package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.entity.Employee;

public interface EmplyeeService {
	
	Employee addNewEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee getEmployeeByEmployeeId(int employeeId);

	boolean deleteEmployeeByEmployeeId(int employeeId);

	List<Employee> getAllEmployee();
	
	 List<Employee> getEmployeeByName(String name);
	 
	 long getCountOfEmployees();
	 
	 List<Employee> getMaxSalary();
}
