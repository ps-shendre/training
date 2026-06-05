package com.msedcl.main;


import com.msedcl.main.domain.GoodAfternoonClass;
import com.msedcl.main.domain.GoodEvening;
import com.msedcl.main.domain.GoodMorning;
import com.msedcl.main.domain.Greetings;

public class GreetingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//GoodMorning goodMorning = new GoodMorning();
	//	goodMorning.greet();
		
		Greetings greetings = null;
		/*  polyphorsim
		 * greetings =new GoodMorning();
		greetings.greet();
		
		greetings= new GoodAfternoonClass();
		greetings.greet();
		
		greetings= new GoodEvening();
		greetings.greet();*/
		// lamda expression implmentation
		greetings= () -> {
			System.out.println("Good Evening All");
		};
		greetings.greet();
		greetings= () -> {
			System.out.println("Good Night All");
		};
		greetings.greet();
		
		greetings = () ->{
			System.out.println("Good Day All of U my dear fnds");
		};
		greetings.greet();
	}

}
