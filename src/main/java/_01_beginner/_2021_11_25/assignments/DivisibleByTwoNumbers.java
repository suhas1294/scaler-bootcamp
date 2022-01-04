package _01_beginner._2021_11_25.assignments;

import java.util.Scanner;

public class DivisibleByTwoNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		if (A % 5 == 0 && A % 11 == 0){
			System.out.print(1);
		}else{
			System.out.print(0);
		}
	}
}
