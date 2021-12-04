package beginner._2021_12_01;

import java.util.Scanner;

public class _03ReverseAlternate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int n = scanner.nextInt();
        int ans = 0;
        for (; n != 0 ; n = n/10) {
            int lastDigit = n%10;
            ans = ans * 10 + lastDigit;
        }
        System.out.println(ans);
        // will not work as expected if input has leading zeros, ex: 1240, output : 0421, expected: 421 as leading zeros
        // beware :
        // Reverse the number is different from print the number in reverse order
        // Reverse the number : reverse the number in memory, value might change
        // print in reverse order : print the characters of a number in reverse order
    }
}
