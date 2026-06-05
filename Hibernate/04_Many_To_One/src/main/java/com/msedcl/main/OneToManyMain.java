package com.msedcl.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.msedcl.main.entity.Department;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToManyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//one to many method
		//select();
		insert1();
		//merge();
		//many to one method
	}

/*	
 * one to many method
 * public static void insert() {
		EntityManager entityManager= HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		//Department existingDepartmnet = entityManager.find(Department.class, 1);
		Employee employee1 = new Employee(0, "Abhay", 190000);
		Employee employee2 = new Employee(0, "Prasad",190000);
		List<Employee> employee= Arrays.asList(employee1,employee2);
		Department departmnet = new Department(0,"Sales",employee);
		entityManager.persist(departmnet);
		entityTransaction.commit();
		entityManager.close();

	}

	public static void select() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Department existingDepartmnet = entityManager.find(Department.class, 1);
		entityManager.close();
		System.out.println(existingDepartmnet.getDepartmentName());
		List<Employee> employee = existingDepartmnet.getEmployees();
		employee.forEach(e -> System.out.println(e));
	}
	
	public static void merge() {
		EntityManager entityManager= HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		//Department existingDepartmnet = entityManager.find(Department.class, 1);
		Employee employee1 = new Employee(0, "Abhay", 190000);
		Employee employee2 = new Employee(0, "Prasad",190000);
		List<Employee> employee= Arrays.asList(employee1,employee2);
		Department departmnet = new Department(2,"Mech",null);
		entityManager.merge(departmnet);
		entityTransaction.commit();
		entityManager.close();

	}*/
	//Many to one functionaly
	public static void select() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Employee employee = entityManager.find(Employee.class, 1);
		entityManager.close();
		System.out.println(employee);
		
	}
	
	 public static void insert() {
			EntityManager entityManager= HibernateUtil.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			Employee employee= new Employee(0, "Reema", 190000, new Department(1, "IT"));
			
			
			
			entityManager.persist(employee);
			entityTransaction.commit();
			entityManager.close();

		}

	 
	 public static void insert1() {
			EntityManager entityManager= HibernateUtil.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			Employee employee= new Employee(0, "Reema", 190000, new Department(1, "HR"));
			
			
			
			entityManager.persist(employee);
			entityTransaction.commit();
			entityManager.close();

		}
	 
	 public static void merge() {
			EntityManager entityManager= HibernateUtil.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			Employee employee= new Employee(0, "Vivek", 190000, new Department(1, "GAD"));
			
			
			
			entityManager.merge(employee);
			entityTransaction.commit();
			entityManager.close();

		}

}
