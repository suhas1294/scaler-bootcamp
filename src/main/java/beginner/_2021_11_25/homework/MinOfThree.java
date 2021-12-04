package beginner._2021_11_25.homework;

import java.util.Scanner;

public class MinOfThree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		System.out.print(Integer.min(Integer.min(A, B), C));
	}
}
