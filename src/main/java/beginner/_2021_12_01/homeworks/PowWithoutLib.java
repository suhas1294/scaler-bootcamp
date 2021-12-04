package beginner._2021_12_01.homeworks;

import java.util.Scanner;

public class PowWithoutLib {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		long product = 1;
		for (int i = 0; i < b; i++) {
			product *= a;
		}
		System.out.print(product);
	}
}
