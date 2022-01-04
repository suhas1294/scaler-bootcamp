package _01_beginner._2021_11_29;

import java.util.Scanner;

public class _01Sum1ToN {
    public static void main(String[] args) {
        int target, sum=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number upto which sum has to be calculated");
        target = scanner.nextInt();
        for (int i = 0; i < target; i++) {
            sum += i;
        }
        System.out.printf("\nsum of numbers from 1 to %d is %d\n", target, sum);

        // optimized method
        System.out.printf("\nsum of numbers from 1 to %d is %d\n", target, (target * (target-1))/2);
    }
}
