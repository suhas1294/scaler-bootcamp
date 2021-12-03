package beginner._2021_11_29;

import java.util.Scanner;

public class _02SumOfNInputs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of inputs");
        int size = scanner.nextInt();
        int accumulator = 0;
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter %dth element\t", i+1);
            accumulator += scanner.nextInt();
        }
        System.out.println("Total sum is " + accumulator);
    }
}
