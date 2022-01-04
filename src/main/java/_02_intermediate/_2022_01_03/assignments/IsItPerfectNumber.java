package _02_intermediate._2022_01_03.assignments;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * You are given N positive integers.
 * For each given integer A, you have to tell whether it is a perfect number or not.
 * Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
 *
 * First line of the input contains a single integer N.
 * Input : Each of the next N lines contains a single integer A.
 * output: In a seperate line, print YES if a given integer is perfect, else print NO.
 *
 * N = 2 n1 = 4,  n2 = 6, output : No, Yes
 * explanation: For A = 4, the answer is "NO" as sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
 *  For A = 6, the answer is "YES" as sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.
 *
 * N = 1 n1 = 3 output : No
 * explanation: For A = 3, the answer is "NO" as sum of its proper divisors = 1, is not equal to 3.
 *
 */
public class IsItPerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(isItPerfectNumber(scanner.nextInt()) ? "YES" : "NO");
        }
    }

    static boolean isItPerfectNumber(int n){
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                if (i != n/i){
                    sum += i + n/i;
                }else {
                    sum += i;
                }
            }
        }
        return sum == n;
    }
}
