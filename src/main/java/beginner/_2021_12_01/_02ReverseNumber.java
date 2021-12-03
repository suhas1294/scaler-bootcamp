package beginner._2021_12_01;

import java.util.Scanner;

public class _02ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int target = scanner.nextInt();

        while(target != 0){
            int lastDigit = target%10;
            System.out.print(lastDigit);
            target = target/10;
        }

    }
}
