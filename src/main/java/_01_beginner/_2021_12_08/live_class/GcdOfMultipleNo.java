package _01_beginner._2021_12_08.live_class;

import _01_beginner._2021_12_08.assignments.EuclidsGcdAlgoRecursion;

import java.util.Scanner;

public class GcdOfMultipleNo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int gcd = 0;
        for (int i = 0; i < T; i++) {
            gcd = EuclidsGcdAlgoRecursion.gcdEuclidRecursionAlgo(gcd, scanner.nextInt());
        }
        System.out.println(gcd);
    }
}
