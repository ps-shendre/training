package com.msedcl.main;

import com.msedcl.main.domain.Addition;
import com.msedcl.main.domain.Calculation;

public class CalculationV2 {

	public static void main(String[] args) {
		/*
		 * Calculation cal = null;
		 * 
		 * cal = new Addition(); printMessage((double) 10,20);
		 */

		printResult((n1, n2) -> n1 + n2, 10, 20);
		printResult((n1, n2) -> n1 - n2, 20, 60);
		printResult((n1, n2) -> n1 * n2, 100, 20);
		printResult((n1, n2) -> n1 % n2, 2, 100);
		
		
		
		

	}

	public static void printMessage(Calculation cal) {
		cal.docalculation(10, 20);
	}

	public static void printResult(Calculation cal, double a1, double a2) {
		// cal.docalculation(10, 20);
		System.out.println("Result of " + cal.docalculation(a1, a2));
		System.out.println("Result of " + a1 + " and  "+ a2 + " is "+ cal.docalculation(a1, a2));
	}
	
	
	public static void billCalculation(Calculation cal, double a1, double a2) {
		// cal.docalculation(10, 20);
		System.out.println("Result of " + cal.docalculation(a1, a2));
		System.out.println("Result of " + a1 + " and  "+ a2 + " is "+ cal.docalculation(a1, a2));
	}

}
