package _01_beginner._2021_12_17.homework;


import java.util.Scanner;

public class LengthOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(scanner.next().length());
        }
    }
}
