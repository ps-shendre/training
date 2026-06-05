package com.msedcl.main.repository;

import java.sql.JDBCType;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.msedcl.main.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private JdbcTemplate jdbcTemplate;

	private static final String ADD_NEW_EMPLOYEE = "Insert into employee_details(name, salary) values (?,?)";
	private static final String UPDATE_EXISING_EMPLOYEE = "UPDATE employee_details SET name= ?, salary=? WHERE employee_id=?";
	private static final String DELETE_EXISING_EMPLOYEE = "delete from employee_details WHERE employee_id=2";
	private static final String SELECT_EMPLOYEE_BY_EMPLOYEE_ID = "SELECT * from employee_details WHERE employee_id=?";
	private static final String SELECT_ALL_EMPLOYEE = "select *  from employee_details ";

	public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Overloaded constructor called - EmployeeRepositoryImpl");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		int rowInserted = jdbcTemplate.update(ADD_NEW_EMPLOYEE, employee.getName(), employee.getSalary());
		if (rowInserted > 0)
			return employee;
		else
			return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		int rowUpdated = jdbcTemplate.update(UPDATE_EXISING_EMPLOYEE, employee.getName(), employee.getSalary(),
				employee.getEmployeeId());
		if (rowUpdated > 0)
			return employee;
		else
			return null;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		
		return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_EMPLOYEE_ID,
				(rs, row) -> new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)), employeeId);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		int rowDeleted = jdbcTemplate.update(DELETE_EXISING_EMPLOYEE);
		if (rowDeleted > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
	//	RowMapper<Employee> employeeRowMapper = (rs, row) -> 
//		new Employee(
//				rs.getInt(1), 
//				rs.getString(2), 
//				rs.getDouble(3));
//		
//		
//		return jdbcTemplate.query(SELECT_ALL_EMPLOYEE, employeeRowMapper);

		return jdbcTemplate.query(SELECT_ALL_EMPLOYEE,
				(rs, rowCount) -> new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountOfEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> getMaxSalary() {
		// TODO Auto-generated method stub
		return null;
	}

}
