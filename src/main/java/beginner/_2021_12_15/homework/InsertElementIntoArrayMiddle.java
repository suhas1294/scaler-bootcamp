package beginner._2021_12_15.homework;

import java.util.Scanner;

public class InsertElementIntoArrayMiddle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int X = scanner.nextInt(); // position to be inserted, X > 1
        int Y = scanner.nextInt(); // numbers to be inserted
        for (int i = arr.length-1; i > X-1; i--) {
            arr[i] = arr[i-1];
        }
        arr[X-1] = Y;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
