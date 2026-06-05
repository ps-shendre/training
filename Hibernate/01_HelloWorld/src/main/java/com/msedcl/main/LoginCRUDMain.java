package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.entity.LoginDetails;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LoginCRUDMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int loginId, invalidLoginCount, max;
		String password, Status;

		System.out.println("Menu");
		System.out.println("1.Enter Login Id ");
		loginId = scanner.nextInt();
		System.out.println("1.Enter Password ");
		password = scanner.next();
		//LoginDetails logId = new LoginDetails();
		getLoginId(loginId);

	}
	
	public static void getLoginDet(int loginId) {
		// 1. create entity manager object
		Scanner scanner = new Scanner(System.in);
		EntityManager entityManager = HibernateUtil.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		LoginDetails loginDetails = entityManager.find(LoginDetails.class, loginId);
		System.out.println("Login :"+ loginDetails.getLoginId());
		if (loginDetails == null)
			System.out.println("Invalid User");
			else
		if (loginDetails != null) {
			String Status = loginDetails.getStatus();
			System.out.println("Login status :" + loginDetails.getStatus());
			if (loginDetails.getStatus() != null && loginDetails.getStatus().equals("Active") ) {
				System.out.println("Valid User");
				System.out.println("Enter Password :");
			        String password = scanner.next();
			       if (loginDetails.getPassword().equals(password))
			       {
			    	   System.out.println("User Login sucessfully");
			       }
			       else 
			    	   
			       {
			    	   updateLoginCount(loginId);
			       }
			}
			
		}
	}

	public static void getLoginId(int loginId) {
		// 1. create entity manager object
		Scanner scanner = new Scanner(System.in);
		EntityManager entityManager = HibernateUtil.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		LoginDetails loginDetails = entityManager.find(LoginDetails.class, loginId);
		System.out.println("Login :"+ loginDetails.getLoginId());
		if (loginDetails == null)
			System.out.println("Invalid User");
			else
		if (loginDetails != null) {
			String Status = loginDetails.getStatus();
			System.out.println("Login status :" + loginDetails.getStatus());
			if (loginDetails.getStatus() != null && loginDetails.getStatus().equals("Active") ) {
				System.out.println("Valid User");
				System.out.println("Enter Password :");
			        String password = scanner.next();
			       if (loginDetails.getPassword().equals(password))
			       {
			    	   System.out.println("User Login sucessfully");
			       }
			       else 
			    	   
			       {
			    	   updateLoginCount(loginId);
			       }
			}
			
		}

	
			
		// close
		entityTransaction.commit();
		entityManager.close();
	}

	public static void updateLoginCount(int loginId) {
		Scanner scanner = new Scanner(System.in);
		EntityManager entityManager = HibernateUtil.getEntityManager();
		LoginDetails existingId = entityManager.find(LoginDetails.class, loginId);
		// employee.setSalary(existingEmployee.getSalary());
		
		if (existingId != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			existingId.setInvalidLoginCount(existingId.getInvalidLoginCount()+1);
			entityTransaction.commit();
			System.out.println("Login id count updated sucessfully");
			System.out.println("Enter Password :");
			int password = scanner.nextInt();
			
		} else
			System.out.println("Invalid Login");
		entityManager.close();

	}

}
