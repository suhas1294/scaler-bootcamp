package beginner._2021_12_08.homeworks;

import beginner._2021_12_08.assignments.EuclidsGcdAlgoRecursion;

import java.util.Scanner;

public class LcmOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        System.out.println(getLcm(A, B));
    }

    private static int getLcm(int a, int b) {
        return ((a * b)/ EuclidsGcdAlgoRecursion.gcdEuclidRecursionAlgo(a, b));
    }
}
