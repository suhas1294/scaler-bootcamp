package _01_beginner._2021_12_06.recursion.assignments;

import java.util.Scanner;

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
// Question: Find nth number in the fibonacci series

public class FindNthNoInFibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(fibonacci(N));
    }

    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

}
