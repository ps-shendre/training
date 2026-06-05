package com.msedcl.main.mapper;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.entity.Employee;

public class EmployeeMapper {
// convert DTO to entity
	public static Employee mapEmployeeDTOToEmployee(EmployeeRequestDTO employeeRequestDto) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeRequestDto.getEmployeeId());
		employee.setName(employeeRequestDto.getName());
		employee.setSalary(employeeRequestDto.getSalary());
		return employee;

	}
// convert entity to DTO
	public static EmployeeResponseDTO mapEmployeeToEmployeeResponseDTO(Employee employee) {
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		employeeResponseDTO.setEmployeeId(employee.getEmployeeId());
		employeeResponseDTO.setName(employee.getName());
		employeeResponseDTO.setSalary(employee.getSalary());
		return employeeResponseDTO;

	}
}
