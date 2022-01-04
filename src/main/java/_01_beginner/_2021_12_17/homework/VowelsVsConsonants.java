package _01_beginner._2021_12_17.homework;

import java.util.Scanner;

/*
Write a program to input T strings (S) from user and print count of vowels and consonants in it.
1 <= T <= 100
1 <= S.size() <= 1000
input format : First line is T which means number of test cases. Each next T lines contain a lowercase string S.
output format: T lines each containing two space separated integers representing cont of vowels and consonants in input string.

input :
    2
    interviewbit
    scaler
output:
    5 7
    2 4

*/
public class VowelsVsConsonants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String s = scanner.next();
            int vcount = getCountOfVowerlsAndConsonants(s);
            System.out.printf("%d %d\n", vcount, s.length()-vcount);
        }
    }
    static int getCountOfVowerlsAndConsonants(String s){
        int vowelCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (String.valueOf(s.charAt(i))){
                case "a":
                case "e":
                case "i":
                case "o":
                case "u":
                    vowelCounter++;
                    break;
            }
        }
        return vowelCounter;
    }
}
