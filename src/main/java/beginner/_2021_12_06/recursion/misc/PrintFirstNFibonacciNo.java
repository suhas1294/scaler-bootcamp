package beginner._2021_12_06.recursion.misc;

import java.util.Scanner;

// Question : Print first N fibonacci Numbers

public class PrintFirstNFibonacciNo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.print(fibonacci(i) +  "\t");
        }
    }

    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

}
