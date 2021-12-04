package beginner._2021_11_29.assignments;

import java.util.Scanner;

/**
 * Given an integer N, print the corresponding pattern for N.
 *
 * For example if N = 4 then pattern will be like:
 *
 * 1
 * 1 2
 * 1 2 3
 * 1 2 3 4
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 100
 */
public class NumericStairPattern {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for (int i = 1; i <= N; i++) {
			int j = 1;
			for (; j < i; j++) {
				System.out.print(j + " ");
			}
			System.out.print(j);
			System.out.println();
		}
	}
}
