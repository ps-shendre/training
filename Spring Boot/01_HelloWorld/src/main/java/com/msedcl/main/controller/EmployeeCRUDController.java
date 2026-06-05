package com.msedcl.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msedcl.main.dto.EmployeeRequestDTO;
import com.msedcl.main.dto.EmployeeResponseDTO;
import com.msedcl.main.dto.ResponseDTO;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.service.EmployeeService;


@RestController
@RequestMapping("employeecrudapi")
public class EmployeeCRUDController {

	private EmployeeService employeeService;

	public EmployeeCRUDController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// URL = http://localhost:8081/employeecrudapi/employees/101
	// Method = DELETE
	/*@DeleteMapping("employees/{employeeId}")
	public boolean deleteEmployee(@PathVariable int employeeId) {
		return employeeService.deleteEmployeeByEmployeeId(employeeId);

	}*/
	@DeleteMapping("employees/{employeeId}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int employeeId) {
		boolean result= employeeService.deleteEmployeeByEmployeeId(employeeId);
		if (result)
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Employee With employee id = "+ employeeId +"deleted sucessfully"));
		else
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO("Failed to delete employee with employee id = "+employeeId + "not found"));
			
	}
	
	
	/*@PutMapping("employees/employee")
	public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
		 EmployeeResponseDTO employeeResult= esmployeeService.updateEmployee(employeeRequestDTO);
		 
		 return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("Employee With employee id = "+ employeeId +"updated sucessfully"));
		 

	}

	// URL = http://localhost:8081/employeecrudapi/employees/employee
	// Method = PUT
	/*@PutMapping("employees/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);

	}

	// URL = http://localhost:8081/employeecrudapi/employees/employee
	// Method = POST

	@PostMapping("employees/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addNewEmployee(employee);

	}

	// URL = http://localhost:8081/employeecrudapi/employees/101
	// Method = GET

	@GetMapping("employess/{employeeId}")
	public Employee getAllEmployee(@PathVariable int employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);

	}

	// URL = http://localhost:8081/employeecrudapi/employees
	// Method = GET
	@GetMapping("employess/employee")
	public List<Employee> allEmployee() {
		return employeeService.getAllEmployee();

	}*/

}
