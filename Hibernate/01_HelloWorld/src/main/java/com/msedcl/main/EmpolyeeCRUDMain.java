package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmpolyeeCRUDMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int employeeId, choice;
		String name, continueChoice;
		double salary;

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Employee");
			System.out.println("Enter your choice");
			System.out.println("2. Search New Employee");
			System.out.println("3. delete  New Employee by EmployeeId");
			System.out.println("4. update  New Employee by EmployeeId");
			System.out.println("5. Merge  New Employee by EmployeeId");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				addNewEmployee(employee);
				break;
			case 2:
				System.out.println("Search employee  from  employeddId");
				employeeId = scanner.nextInt();
				// System.out.println("Emplyee Id");
				getEmployeeByEmployeeId(employeeId);
				break;
			case 3:
				System.out.println("Delete employee by  employeddId");
				employeeId = scanner.nextInt();
				// System.out.println("Emplyee Id");
				deleteByEmployeeId(employeeId);
				break;
			case 4:
				System.out.println("Update employee by  employeddId");
				employeeId = scanner.nextInt();
				 System.out.println("Emplyee New name");
				 name=scanner.next();
				 System.out.println("Emplyee New salary");
				 salary= scanner.nextDouble();
				  employee =   new Employee(employeeId, name, salary);
				 updateEmployee(employee);
				break;
			case 5:
				System.out.println("Merge employee by  employeddId");
				employeeId = scanner.nextInt();
				 System.out.println("Emplyee New name");
				 name=scanner.next();
				 System.out.println("Emplyee New salary");
				 salary= scanner.nextDouble();
				  employee =   new Employee(employeeId, name, salary);
				//  employee =   new Employee(employeeId, name, 0);
				  mergeEmployee(employee);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

	}

	public static void deleteByEmployeeId(int employeeId) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		
		Employee employee = entityManager.find(Employee.class, employeeId);

		if (employee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			System.out.println(employee);
			System.out.println("deleted3 Employee");
		} else
			System.out.println("Invalid Employee");
		//
		entityManager.close();
	}

	public static void getEmployeeByEmployeeId(int employeeId) {
		// 1. create entity manager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		// 2.get employee from databse
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null)
			System.out.println(employee);
		else
			System.out.println("Invalid Employee");
		// close
		entityTransaction.commit();
		entityManager.close();
	}

	public static void addNewEmployee(Employee empolyee) {
		// 1. create entity manager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2. create transaction object

		EntityTransaction entityTransaction = entityManager.getTransaction();

		// 3. start transacrtion
		entityTransaction.begin();

		// 4. save employee object into database
		entityManager.persist(empolyee);

		// 5. commit transaction
		entityTransaction.commit();

		// 6. close entityManager
		entityManager.close();

		System.out.println("Employee create eith emloyeeId =" + empolyee.getEmployeeId());

	}
	
	public static void mergeEmployee (Employee employee) {
		EntityManager entityManager =HibernateUtil.getEntityManager();
		Employee existingEmployee=entityManager.find(Employee.class, employee.getEmployeeId());
		if(existingEmployee != null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
			System.out.println("Employee updated sucessfully");
		}else
			System.out.println("Invalid Emplyee");
		entityManager.close();
		
	}
	
	public static void updateEmployee (Employee employee) {
		EntityManager entityManager =HibernateUtil.getEntityManager();
		Employee existingEmployee=entityManager.find(Employee.class, employee.getEmployeeId());
		//employee.setSalary(existingEmployee.getSalary());
		if(existingEmployee != null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			existingEmployee.setName(employee.getName());
			existingEmployee.setSalary(employee.getSalary());
			entityTransaction.commit();
			System.out.println("Employee updated sucessfully");
		}
		else
			System.out.println("Invalid EmplyeeId");
		entityManager.close();
		
	}

}
