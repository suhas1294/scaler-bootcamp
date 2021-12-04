package beginner._2021_11_29.assignments;

import java.util.Scanner;

/**
 * Write a program to input T numbers(N) from user and print the sum of the digits of the given numbers.
 *
 * 1 <= T <= 1000
 * 0 <= N <= 100000000
 *
 * First line is T which means number of test cases.
 * Each next T lines contain an integer N.
 * T lines each containing one integer representing sum of the digits of the input integer.
 *
 * Ex:
 * 2
 * 123
 * 1589
 *
 * output:
 * 6
 * 23
 *
 * Sum(123) = 1+2+3 = 6.
 * Sum(1589) = 1+5+8+9 = 23.
 */
public class SumTheDigits {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); // number of test cases
		for (int i = 0; i < T; i++) {
			int N = scanner.nextInt();

			int sum = 0;
			while( N!= 0) {
				sum += N % 10;
				N = N/10;
			}
			System.out.println(sum);
		}
	}
}
