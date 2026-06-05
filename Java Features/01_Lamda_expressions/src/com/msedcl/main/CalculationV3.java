package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.domain.BillUnitInterface;
import com.msedcl.main.domain.Calculation;

public class CalculationV3 {

	public static void main(String[] args) {
		
		/*double totalUnit=100;
		double gst=0.18;
		double cost=8;
		//printResult((n1, n2) -> n1 % n2, 2, 100);
		 double totalBill= billCalculation((a1,a2,a3 )->totalUnit*cost, totalUnit,gst,cost );
		
		  gst = billCalculation((a1,a2,a3)-> totalUnit* gst ,totalUnit,gst,cost  );
		 
		 double finalBill = billCalculation((a1,a2,a3)-> totalUnit+gst+cost ,totalUnit,gst,cost );*/
		Scanner scanner = new Scanner(System.in);
		BillUnitInterface calTotalUnits =(totalUnits, perUnitCost) -> totalUnits* perUnitCost ;
		System.out.println("Enter Consumer units");
		double unitConsumed= scanner.nextDouble();
		
		
	//	double totalUnitCost= getDetails (calTotalUnits,unitConsumed )-> calTotalUnits
			
		// System.out.println("Total unit cost"+ billCalculation(totalBill)); 
			
	}
	
	
	public static double getDetails(BillUnitInterface billCal, double a1, double a2) {
		// cal.docalculation(10, 20);
		return billCal.billCalculation(a1, a2);
	}
	
	
	
	
	
	
	

}
