package _01_beginner._2021_12_15.homework;

import java.util.Scanner;

public class RemoveElementFromArrayLocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int X = scanner.nextInt(); // position where number needs to be removed, X > 1

        for (int i = X-1; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        // print array
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
