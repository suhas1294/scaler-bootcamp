package _01_beginner._2021_11_25.homework;

import java.util.Scanner;

/**
 * Given an integer A denoting the amount of units of electricity consumed, you have to calculate the electricity bill (in Rs.) with the help of the below charge conditions:
 *
 * For first 50 units Rs. 0.50/unit
 * For next 100 units Rs. 0.75/unit
 * For next 100 units Rs. 1.20/unit
 * For unit above 250 Rs. 1.50/unit
 * An additional surcharge of 20% is added to the bill.
 *
 * NOTE: As the electricity bill can have any real value (floating point), you have to tell the floor value of the bill.
 *
 * Floor value of a floating point is the closest integer less than or equal to that value. For eg, Floor value of 2.91 is 2.
 */

public class ElectricityBill {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		float totalCharge = 0;
		if (A < 50){
			totalCharge += 0.50f * A;
		}else if (A >= 51 && A < 151){
			totalCharge += (0.5f*50) + ((A-50)*0.75f);
		}else if(A >= 151 && A < 251){
			totalCharge += (0.5f*50) + (100*0.75f) + ((A - 150) * 1.20f) ;
		}else{
			totalCharge += (0.5f*50) + (100*0.75f) + (100 * 1.20f) + ((A - 250) * 1.50f)  ;
		}
		totalCharge += 0.20f*totalCharge;
		totalCharge = (float) Math.floor(totalCharge);
		System.out.print((int)totalCharge);
	}
}
