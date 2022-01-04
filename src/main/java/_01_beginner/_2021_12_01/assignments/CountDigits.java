package _01_beginner._2021_12_01.assignments;

import java.util.Scanner;

public class CountDigits {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			String N = scanner.next();
			System.out.println(N.length());
		}
	}
}
