package beginner._2021_12_06.recursion.homework;

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
