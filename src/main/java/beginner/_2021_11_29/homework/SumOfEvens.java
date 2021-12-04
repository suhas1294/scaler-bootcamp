package beginner._2021_11_29.homework;

import java.util.Scanner;

/**
 * You are given an integer A, you need to find and return the sum of all the even numbers between 1 and A.
 *
 * Even numbers are those numbers that are divisible by 2.
 * First and only argument is an integer A.
 * Return an integer denoting the sum of even numbers between [1, A] (both inclusive).
 * Input 1:
 *  5
 * Input 2:
 *  2
 * Output 1:
 *  6
 * Output 2:
 *  2
 */
public class SumOfEvens {
	public static int solve(int A) {
		int sum = 0;
		for (int i = 1; i <= A; i++) {
			if(i %2 == 0) sum += i;
		}
		 return sum;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		System.out.print(solve(N));
	}
}
