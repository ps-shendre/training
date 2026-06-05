package com.msedcl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.repository.EmployeeRepository;

@Service
public class EmplyeeServiceImpl implements EmplyeeService {
	private EmployeeRepository employeeRepository;

	public EmplyeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.addNewEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {

		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.deleteEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployee();
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeByName(name);
	}

	@Override
	public long getCountOfEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getCountOfEmployees();
	}

	@Override
	public List<Employee> getMaxSalary() {
		// TODO Auto-generated method stub
		return employeeRepository.getMaxSalary();
	}

}
