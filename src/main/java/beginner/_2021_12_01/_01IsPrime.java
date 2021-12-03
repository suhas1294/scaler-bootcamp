package beginner._2021_12_01;

import java.util.Scanner;

public class _01IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int target = scanner.nextInt();
        int divisorsCount = 0;
        for (int i = 2; i <= Math.sqrt(target); i++) {
            if (target%i==0){
                divisorsCount++;
                System.out.println("Not prime");
                break;
            }
        }
        if (divisorsCount == 0) System.out.println("Its prime");
    }
}
