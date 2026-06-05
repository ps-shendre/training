package com.msedcl.main;

import com.msedcl.main.entity.Address;
import com.msedcl.main.entity.User;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.TransactionManager;

public class OneToOneMain {

	public static void main(String[] args) {

		// select();
		 insert();
		// update();
		// merge();
		// remove();
		// detach();
		//refresh();
	}

	public static void update() {
		// Address address= new Address (0,"Navi Mumbai","412312");
		// User user = new User(0,"Rahul",address);
		User user = new User();
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		// entityManager.persist(user);
		user = entityManager.find(User.class, 1);
		user.getAddress().setCity("Pune");
		entityTransaction.commit();
		entityManager.close();

	}

	public static void merge1() {

		User user = new User();
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		// entityManager.persist(user);
		user = entityManager.find(User.class, 2);
		user.getAddress().setCity("Kirt");
		user.getAddress().setPinCode("000111");
		user.setName("Ria");
		entityManager.merge(user);
		entityTransaction.commit();
		entityManager.close();

	}

	public static void merge() {

		EntityManager entityManager = HibernateUtil.getEntityManager();
		User existingUser = entityManager.find(User.class, 1);
		System.out.println("obct fetched");
		System.out.println(existingUser);
		entityManager.close();

		System.out.println("Entity manager closed");
		existingUser.setName("Seema Rao");
		System.out.println("Modified Detached object");
		System.out.println(existingUser);
		// entitySystem.out.println("check ur table ");
		entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(existingUser);
		entityTransaction.commit();
		entityManager.close();

	}

	public static void insert() {
		Address address = new Address(5, "Amravati", "412312");
		User user = new User(5, "Seema", address);
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		entityManager.close();

	}

	public static void select() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		User user = entityManager.find(User.class, 1);
		// System.out.println(user.getName()+""+ user.getAddress().getCity());
		System.out.println(user.getAddress().getCity());
		entityManager.close();

	}

	public static void remove() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		User existingUser = entityManager.find(User.class, 2);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(existingUser);
		entityTransaction.commit();
		entityManager.close();

	}

	public static void detach() {
		// detach = remove entity from perisitence context
		// which means hibernate stop tracking object changes
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		// object fetch -peristent
		User existingUser = entityManager.find(User.class, 4);
		System.out.println("before detach");
		System.out.println(existingUser);
		entityManager.detach(existingUser);
		existingUser.setName("Rahul dravid");
		existingUser.getAddress().setCity("Pune");
		entityTransaction.commit();
		entityManager.close();
		System.out.println("After changes into detached object");
		System.out.println(existingUser);
		System.out.println("Check db");

	}

	public static void refresh() {
		// onj loaded in java - from db
		// obj may be updated externally - from db

		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		// object fetch -peristent
		User existingUser = entityManager.find(User.class, 4);
		System.out.println("before refresh");
		System.out.println(existingUser);
		//
		existingUser.setName("Rahul dravid");
		existingUser.getAddress().setCity("Amravati");
		System.out.println("before changes");
		System.out.println(existingUser);
		System.out.println("refresh called");
		entityManager.refresh(existingUser);
		System.out.println("after changes");
		System.out.println(existingUser);
		entityTransaction.commit();
		entityManager.close();

	}

}
