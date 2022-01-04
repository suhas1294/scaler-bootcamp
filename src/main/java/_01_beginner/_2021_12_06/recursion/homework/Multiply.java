package _01_beginner._2021_12_06.recursion.homework;

import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        System.out.println(multiply(N, M));
    }
    static int multiply(int N, int M){
        if (M == 1) return N;
        return N + multiply(N, M-1);
    }
}
