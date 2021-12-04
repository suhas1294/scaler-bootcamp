package beginner._2021_12_01.homeworks;

import java.util.Scanner;

public class VowelCheck {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String c = scanner.next();
		switch (c){
			case "a":
			case "e":
			case "i":
			case "o":
			case "u":
				System.out.print(1);
				break;
			default:
				System.out.print(0);
		}
	}
}
