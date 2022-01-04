package _01_beginner._2021_11_25;

import java.util.Scanner;

public class _02LargestOf3Numbers {
    public static void main(String[] args) {
        int n1, n2, n3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 numbers");
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        n3 = scanner.nextInt();
        System.out.printf("largest of %d, %d, %d is %d", n1, n2, n3, Integer.max(Integer.max(n1, n2), n3));
    }
}
