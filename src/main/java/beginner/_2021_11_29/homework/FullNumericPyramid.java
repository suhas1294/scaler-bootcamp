package beginner._2021_11_29.homework;

import java.util.Scanner;

/**
 * Given an integer N, print the corresponding Full Numeric Pyramid pattern for N.
 *
 * For example if N = 5 then pattern will be like:
 *
 * 0 0 0 0 1 0 0 0 0
 * 0 0 0 2 3 2 0 0 0
 * 0 0 3 4 5 4 3 0 0
 * 0 4 5 6 7 6 5 4 0
 * 5 6 7 8 9 8 7 6 5
 *
 * NOTE: There should be exactly one extra space after each number for each row.
 *
 * Output the Full Pyramid pattern corresponding to the given N.
 *
 * NOTE:
 *
 * There is no extra space before the first integer of any row.
 * There is an extra space after the last integer of any row.
 * All the integers in any row are space separated.
 */
public class FullNumericPyramid {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for (int i = 1; i <= N; i++) {

			// spaces/zeros
			int spaces = N - i;
			for (int j = 0; j < spaces; j++) {
				System.out.print("0 ");
			}

			// numbers - ascending order
			int j = i;
			for (; j <= ((2 * i) - 1); j++) {
				System.out.print(j + " ");
			}
			// numbers - descending order
			for(int k = j-2; k >= i ; k--){
				System.out.print(k + " ");
			}

			// spaces
			for (int x = 0; x < spaces; x++) {
				System.out.print("0 ");
			}

			// line after each row
			System.out.println();
		}
	}
}
