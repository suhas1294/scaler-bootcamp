package _01_beginner._2021_11_25.homework;

import java.util.Scanner;

public class EvenOrOdd {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		if(A%2 == 0){
			System.out.print(0);
		}else{
			System.out.print(1);
		}
	}
}
