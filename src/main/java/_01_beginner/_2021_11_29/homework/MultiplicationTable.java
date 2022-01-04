package _01_beginner._2021_11_29.homework;

import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for (int i = 1; i < 11; i++) {
			System.out.printf("%d * %d = %d\n", N, i, N*i);
		}
	}
}
