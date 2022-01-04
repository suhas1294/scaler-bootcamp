package _01_beginner._2021_11_29.assignments;

import java.util.Scanner;

/**
 * Given an integer N, print the corresponding pattern for N.
 *
 * For example if N = 4 then pattern will be like:
 *
 * A
 * B B
 * C C C
 * D D D D
 */
public class CharacterStairPattern {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print((char)(i + 64) + " ");
			}
			System.out.print((char)(i + 64));
			System.out.println();
		}
	}
}
