package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.entity.Employee;

public interface EmployeeService {

	EmployeeResponseDTO addNewEmployee(EmployeeRequestDTO employeeRequestDTO);

	EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO);;

	EmployeeResponseDTO getEmployeeByEmployeeId(int employeeId);

	boolean deleteEmployeeByEmployeeId(int employeeId);

	List<EmployeeResponseDTO> getAllEmployee();

	List<EmployeeResponseDTO> getEmployeeByName(String name);

	long getCountOfEmployees();

	List<EmployeeResponseDTO> getMaxSalary();
}
