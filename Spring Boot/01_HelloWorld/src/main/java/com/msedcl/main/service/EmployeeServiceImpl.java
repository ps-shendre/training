package com.msedcl.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.mapper.EmployeeMapper;
import com.msedcl.main.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeResponseDTO addNewEmployee(EmployeeRequestDTO employeeRequestDTO) {
		Employee employee = EmployeeMapper.mapEmployeeDTOToEmployee(employeeRequestDTO);
		Employee savedEmployee= employeeRepository.addNewEmployee(employee);
		EmployeeResponseDTO employeeResponseDTO = EmployeeMapper.mapEmployeeToEmployeeResponseDTO(savedEmployee);
		return employeeResponseDTO;
	}

	@Override
	public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO) {
		Employee employee= EmployeeMapper.mapEmployeeDTOToEmployee(employeeRequestDTO);
		Employee updatedEmployee= employeeRepository.updateEmployee(employee);
		EmployeeResponseDTO employeeResponseDTO = EmployeeMapper.mapEmployeeToEmployeeResponseDTO(updatedEmployee);
		return employeeResponseDTO;
		
		
	}

	@Override
	public EmployeeResponseDTO getEmployeeByEmployeeId(int employeeId) {
		Employee employee= employeeRepository.getEmployeeByEmployeeId(employeeId);
		EmployeeResponseDTO employeeResponseDTO = EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee);
		return employeeResponseDTO;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		return  employeeRepository.deleteEmployeeByEmployeeId(employeeId);
		 
	}


	@Override
	public List<EmployeeResponseDTO> getAllEmployee() {
		List<Employee> employeeList = employeeRepository.getAllEmployee();

		List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();
		for (Employee employee : employeeList) {
			EmployeeResponseDTO employeeResponseDTO = EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee);
			employeeResponseDTOList.add(employeeResponseDTO);
		}

		return employeeResponseDTOList;
	}

	@Override
	public List<EmployeeResponseDTO> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountOfEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EmployeeResponseDTO> getMaxSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
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
	}*/

}
