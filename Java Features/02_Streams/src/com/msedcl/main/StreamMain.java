package com.msedcl.main;

import java.util.Arrays;
import java.util.List;

import com.msedcl.main.domain.Person;

public class StreamMain {

	public static void main(String[] args) {
		List<String> names=Arrays.asList("Vivek","Bahubali","Trupti","Samarth");
		
		// print all except bahubali
		
		for (String name : names) {
			if(!name.equals(("Bahubali")))
				System.out.println(name);
		}
		
		//using strams
		System.out.println( );
		
		names.stream().filter((name) -> !name.equals("Bahubali")).forEach((name)-> System.out.println(name));

	
			// Creating person class objects
			Person person1 = new Person("Vivek", "Gohil", 36);
			Person person2 = new Person("Trupti", "Acharkar", 38);
			Person person3 = new Person("Samarth", "Patil", 10);
			Person person4 = new Person("Gurubux", "Gill", 30);
			// Storing person objects into list
			List<Person> people= Arrays.asList(person1, person2, person3, person4);
			System.out.println( );
			people.stream().filter((p) -> !p.getLastName().equals("Samarth")).forEach((p) -> System.out.println(p.getFirstName() + " "+ p.getLastName()));

		
	}

}
