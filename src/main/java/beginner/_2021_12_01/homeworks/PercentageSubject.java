package beginner._2021_12_01.homeworks;

import java.util.Scanner;

public class PercentageSubject {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = 0;
		for (int i = 0; i < 5; i++) {
			total += scanner.nextInt();
		}
		double percentage = Math.floor(total / 5d);
		if(percentage >= 90d){
			System.out.println((int)percentage + " A");
		}else if(percentage >= 80d){
			System.out.println((int)percentage + " B");
		}else if(percentage >= 70d){
			System.out.println((int)percentage + " C");
		}else if(percentage >= 60d){
			System.out.println((int)percentage + " D");
		}else if(percentage >= 40d){
			System.out.println((int)percentage + " E");
		}else{
			System.out.println((int)percentage + " F");
		}
	}
}
