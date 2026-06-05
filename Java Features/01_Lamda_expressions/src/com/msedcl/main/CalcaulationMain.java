package com.msedcl.main;

import com.msedcl.main.domain.Addition;
import com.msedcl.main.domain.Calculation;

public class CalcaulationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculation cal = null;

		cal = new Addition();
		double addResult = cal.docalculation(10, 20);
		System.out.println("Addition is ::" + addResult);

		cal = (double numberOne, double numberTwo) -> {
			return numberOne + numberOne;
		};
		double Addition1 = cal.docalculation(30, 40);
		System.out.println("Addition1 is ::" + Addition1);

		cal = (double numberOne, double numberTwo) -> {
			return numberOne - numberTwo;
		};
		double Substraction = cal.docalculation(60, 40);
		System.out.println("Substration is ::" + Substraction);

		cal = (double numberOne, double numberTwo) -> {
			return numberOne * numberTwo;
		};
		double multiplication = cal.docalculation(30, 40);
		System.out.println("multiplication is ::" + multiplication);

		cal = (double numberOne, double numberTwo) -> {
			return numberOne / numberTwo;
		};
		double division = cal.docalculation(60, 10);
		System.out.println("division is ::" + division);

		cal = (n1, n2) -> n1 * n2;
		{
			System.out.println("multiplication1 is ::" + cal.docalculation(10, 20));
		}
		;

		cal = (n1, n2) -> n1 / n2;
		{
			System.out.println("division1 is ::" + cal.docalculation(10, 20));
		}
		;
		
		cal= (a1,a2) -> a1%a2;
		{
		System.out.println("Percentage is : " + cal.docalculation(50, 50));};

	}

}
