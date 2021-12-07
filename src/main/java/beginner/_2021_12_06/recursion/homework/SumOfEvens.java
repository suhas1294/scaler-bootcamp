package beginner._2021_12_06.recursion.homework;

import java.util.Scanner;

/**
 * You are given an integer A, you need to find and return the sum of all the even numbers between 1 and A.
 * Even numbers are those numbers that are divisible by 2.
 * 1 <= N <= 500
 * Input format:  First and only argument is an integer A.
 * output:  Return an integer denoting the sum of even numbers between [1, A] (both inclusive).
 * ex: input 5, output : 6, Explanation:   Even numbers between [1, 5] are (2, 4).
 * ex: input 2, output : 2, Explanation:  Even numbers between [1, 2] are (2)
 */
public class SumOfEvens {
    public static void main(String[] args) {
        int N = 6;
        System.out.println(solve(N));
    }
    public static int solve(int A) {
        if (A == 2) return 2;
        int num = A % 2 == 0 ? A : A - 1;
        return num + solve(num - 2);
    }
}
