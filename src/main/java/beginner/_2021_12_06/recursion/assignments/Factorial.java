package beginner._2021_12_06.recursion.assignments;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(factorial(N));
    }
    static int factorial(int N){
        if (N == 1) return 1;
        return (N * factorial(N-1));
    }
}
