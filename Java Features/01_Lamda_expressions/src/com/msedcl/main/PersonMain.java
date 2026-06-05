package com.msedcl.main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.msedcl.main.domain.Condition;
import com.msedcl.main.domain.LastNameStartWithG;
import com.msedcl.main.domain.Person;
import com.msedcl.main.domain.SortByLastName;

public class PersonMain {

	public static void main(String[] args) {
		// Creating person class objects
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharkar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);
		// Storing person objects into list
		List<Person> people = Arrays.asList(person1, person2, person3, person4);

		/*
		 * for (Person p1 : people) { System.out.println(p1); }
		 */
		for (Person person : people) {
			System.out.println(person);
		}

		// sort this lsist by last naeme
		SortByLastName byLastName = new SortByLastName();
		people.sort(byLastName);
		System.out.println("Done sorting by last name");

		printAll(people);

		// All people having lastname ending with l.
		System.out.println("Below is  the list all element end with L ");
		List<Person> filtered = new ArrayList<>();
		for (Person p : people) {
			if (p.getLastName().endsWith("l")) {
				filtered.add(p);
			}
		}

		// Print results
		for (Person p : filtered) {
			System.out.println(p);
		}

		// 1.sort this list by last name
		// 2. create a method to print all element from the list

		// all people having last name beging with G

		System.out.println("Below the list last name  starts withb G");
		Condition condition = new LastNameStartWithG();
		printStartWithG(people, condition);

		System.out.println("Below the list last name  starts withb G type 3");

		printStartWithG(people);

		System.out.println("Below the list last name  starts withb G type2");
		List<Person> filtered1 = new ArrayList<>();
		for (Person person : people) {
			if (person.getLastName().startsWith("G")) {
				filtered1.add(person);
			}

		}
		for (Person person : filtered1) {
			System.out.println(person);
		}
	}

	public static void printStartWithG(List<Person> people, Condition condition) {
		for (Person person : people) {
			if (condition.test(person))
				System.out.println(person);

		}

	}

	public static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);

		}

	}

	public static void printStartWithG(List<Person> people) {
		for (Person person : people) {
			if (person.getLastName().startsWith("G"))
				System.out.println(person);

		}
	}

}
