package beginner._2021_11_25.assignments;

import java.util.Scanner;

public class MAxOFThreeNUmbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		System.out.print(Integer.max(Integer.max(A, B), C));
	}
}
