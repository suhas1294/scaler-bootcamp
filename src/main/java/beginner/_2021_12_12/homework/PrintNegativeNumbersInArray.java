package beginner._2021_12_12.homework;

import java.util.Scanner;

public class PrintNegativeNumbersInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            if ( arr[i] < 0) System.out.print(arr[i] + " ");
        }

    }
}
