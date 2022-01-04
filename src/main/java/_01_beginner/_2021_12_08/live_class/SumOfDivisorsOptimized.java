package _01_beginner._2021_12_08.live_class;

import java.util.Scanner;

public class SumOfDivisorsOptimized {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;
        for (int i = 2 ; i <= Math.sqrt(N); i++) {
            if ( N % i == 0){
                if ( i * i == N){
                    sum += i;
                }else{
                    sum += i + N/i; // Main part of code that optimizes the algorithm
                }
            }
        }
        System.out.println(sum);
    }
}
