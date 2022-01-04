package _01_beginner._2021_12_08.assignments;

import java.util.Scanner;

public class EuclidsGcdAlgoRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println(gcdEuclidRecursionAlgo(A, B));
        }
    }

    public static int gcdEuclidRecursionAlgo(int a, int b){
        if (a == 0) return b;
        if (b == 0) return a;

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int remainder = max % min;

        return (gcdEuclidRecursionAlgo(min, remainder));
    }
}
