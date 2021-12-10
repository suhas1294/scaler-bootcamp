package beginner._2021_12_08.live_class;

import java.util.Scanner;

/**
 * Express a number in the form of product of prime
 * Refer notes for example
 */
public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        primeFactorization(N);
    }
    public static void primeFactorization(int N){
        int i = 2;
        for (; i <= Math.sqrt(N); i++) {
            while (N % i == 0){
                System.out.print(i + " x ");
                N = N / i;
            }
        }
        System.out.println(N);
    }
}
