package _01_beginner._2021_12_17.homework;

import java.util.Scanner;

/*
Write a program to input T strings (S) from user and print 1 if it is palindrome otherwise print 0.
NOTE:A string is palindrome if it reads the same from backward as from forward.
1 <= T <= 100
1 <= S.size() <= 1000
input format: First line is T which means number of test cases.Each next T lines contain a string S.
output format: T lines each containing either 0 or 1.
input 1:
    3
    abcba
    axax
    abba
output :
    1
    0
    1
*/
public class IsStringPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(isPalindrome(scanner.next()));
        }
    }
    public static int isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return 0;
            left++;
            right--;
        }
        return 1;
    }
}
