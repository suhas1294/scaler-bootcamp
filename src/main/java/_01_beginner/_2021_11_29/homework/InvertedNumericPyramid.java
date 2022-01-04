package _01_beginner._2021_11_29.homework;

import java.util.Scanner;

/**
 * Given an integer N, print the corresponding Numeric Inverted Half Pyramid pattern for N.
 *
 * For example if N = 4 then pattern will be like:
 *
 * 1 2 3 4
 * 1 2 3
 * 1 2
 * 1
 */

public class InvertedNumericPyramid {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for(int i = N; i >0 ; i--){
			int j = 1;
			for (; j < i ; j++) {
				System.out.print(j + " ");
			}
			System.out.println(j);
		}
	}
}
