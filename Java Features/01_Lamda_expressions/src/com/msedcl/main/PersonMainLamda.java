package com.msedcl.main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.msedcl.main.domain.Condition;
import com.msedcl.main.domain.Person;

public class PersonMainLamda {

	public static void main(String[] args) {

		// Creating person class objects
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharkar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);
		// Storing person objects into list
		List<Person> people = Arrays.asList(person1, person2, person3, person4);

		for (Person person : people) {
			System.out.println(person);
		}

		people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		System.out.println("Done sorting by lst name");

		//printAll(people);
		printConditionally(people, (p)-> true, (p) -> System.out.println(p));

		System.out.println("Below the list last name  starts withb G ");
		/*printConditionally(people, (p) -> {
			if (p.getLastName().startsWith("G"))
				return true;
			else
				return false;
		});*/
		
		printConditionally(people, (p) -> p.getLastName().startsWith("G") , 
				(p) -> System.out.println(p.getLastName()));

	
	
	System.out.println("Below the list last name  ends withb L ");
	/*printConditionally(people, (p) -> {
		if (p.getLastName().endsWith("l"))
			return true;
		else
			return false;
	});*/
	
	printConditionally(people, (p) -> p.getLastName().endsWith("l"), (p) -> System.out.println(p.getFirstName()+ " "+ p.getLastName()));

	}
	public static void printConditionally(List<Person> people, 
			Predicate<Person> condition, 
			Consumer<Person> consumer) {
		for (Person person : people) {
			if (condition.test(person))
				consumer.accept(person);

		}

	}
/*
	public static void printConditionally(List<Person> people, Condition condition) {
		for (Person person : people) {
			if (condition.test(person))
				System.out.println(person);

		}

	}

	/*public static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);

		}

	}*/

}
