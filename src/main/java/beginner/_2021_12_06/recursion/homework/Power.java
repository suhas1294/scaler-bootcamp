package beginner._2021_12_06.recursion.homework;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        System.out.println(computePower(N, M));
    }
    static int computePower(int N, int M){
        if (M == 0) return 1;
        return N * computePower(N, M-1);
    }
}
