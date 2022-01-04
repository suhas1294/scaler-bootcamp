package _01_beginner._2021_12_12.homework;

import java.util.Scanner;

public class PrintReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = N-1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
