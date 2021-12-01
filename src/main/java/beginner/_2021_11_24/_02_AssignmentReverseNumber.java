package beginner._2021_11_24;

import java.util.Scanner;

public class _02_AssignmentReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        while(number/10 > 10){
            System.out.print(number % 10);
            number = number/10;
        }
        System.out.print(number % 10);
        System.out.print(number/10);

    }
}
