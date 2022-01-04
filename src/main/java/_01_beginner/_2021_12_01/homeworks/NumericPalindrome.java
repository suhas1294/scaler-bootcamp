package _01_beginner._2021_12_01.homeworks;

import java.util.Scanner;

public class NumericPalindrome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int copyOfN = N;
		String reverse = "";
		while (N != 0) {
			reverse += String.valueOf(N % 10);
			N = N/10;
		}
		if(Integer.parseInt(reverse) == copyOfN){
			System.out.print("Yes");
		}else{
			System.out.print("No");
		}
	}
}
