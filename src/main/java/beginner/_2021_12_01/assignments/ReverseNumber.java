package beginner._2021_12_01.assignments;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			int N = scanner.nextInt();
			int sum = 0;
			int val = String.valueOf(N).length() - 1;
			while(N/10 != 0) {
				int ff = (int) ((N % 10) * Math.pow(10, val));
				sum += ff;
				val--;
				N = N/10;
			}
			sum +=  (int) ((N % 10) * Math.pow(10, val));
			System.out.println(sum);
		}
	}
}
