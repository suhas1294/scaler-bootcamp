package _01_beginner._2021_12_06.recursion.homework;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // number of test cases
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            System.out.println(sumOfDigits(N));
        }
    }

    public static int sumOfDigits(int n) {
        if(n < 10) return n;
        return (n % 10) + sumOfDigits(n/10);
    }
}

/*
Given a number A, we need to find the sum of its digits using recursion.
1 <= A <= 10^9
Input Format : The first and only argument is an integer A.
Output Format : Return an integer denoting the sum of digits of the number A.

Input 1: A = 46, Output 1:10, Explanation 1: Sum of digits of 46 = 4 + 6 = 10
Input 2: A = 11, Output 2:2, Explanation 2: Sum of digits of 11 = 1 + 1 = 2

 */