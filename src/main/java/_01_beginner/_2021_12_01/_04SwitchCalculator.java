package _01_beginner._2021_12_01;

import java.util.Scanner;

public class _04SwitchCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // by default scanner uses space is delimiter when given multiple inputs in a single line
        int a = scanner.nextInt();
        String operation = scanner.next();
        int b = scanner.nextInt();
        switch (operation){
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                System.out.println(a / b);
                break;
            default:
                System.out.println("Give valid input");
        }
        System.out.println("done computing");
    }
}
