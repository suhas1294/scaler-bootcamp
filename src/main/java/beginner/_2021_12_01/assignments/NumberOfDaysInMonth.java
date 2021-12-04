package beginner._2021_12_01.assignments;

import java.util.Scanner;

public class NumberOfDaysInMonth {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		switch (N){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println(31);
				break;
			case 2:
				System.out.println(28);
				break;
			default:
				System.out.println(30);
		}
	}
}
