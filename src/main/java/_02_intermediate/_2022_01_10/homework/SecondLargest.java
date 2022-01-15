package _02_intermediate._2022_01_10.homework;

import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int arr_len = scanner.nextInt();
            int[] arr = new int[arr_len];
            for (int j = 0; j < arr_len; j++) {
                arr[j] = scanner.nextInt();
            }
            if (arr_len <= 1) {
                System.out.println(-1);
                continue;
            }
            int curMax = Integer.MIN_VALUE;
            int curSecMax = Integer.MIN_VALUE;
            for (int j = 0; j < arr_len; j++) {
                if (arr[j] >= curMax) {
                    curSecMax = curMax;
                    curMax = arr[j];
                    continue;
                }
                if (arr[j] >= curSecMax && arr[j] < curMax){
                    curSecMax = arr[j];
                }
            }
        }
    }
}
