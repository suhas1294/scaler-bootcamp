package _02_intermediate._2022_02_14.recursion_1.live_session;

import java.util.Scanner;

public class BasicRecursiveProblems {
    // sum from 1 to n
    int sum(int n){
        if (n == 1) return 1;
        return sum(n-1) + n;
    }

    // factorial
    int fact(int n){
        if (n == 1) return 1;
        return (fact(n-1) * n);
    }

    // return nth fibonacci number
    int fib(int n){
        if (n == 0) return 0;
        if ((n == 1) || (n == 2)) return 1;
        return (fib(n-1) + fib(n-2));
    }

    // print all numbers from 1 to n-1, n
    static void printInc(int n){
        if (n == 1) {
            System.out.println(1);
            return;
        }
        printInc(n-1);
        System.out.println(n);
    }

    static void printDec(int n){
        if (n == 1){
            System.out.println(1);
            return;
        }
        System.out.println(n);
        printDec(n-1);
    }

    static boolean checkIfPalindrome(String str, int s, int e){
        if (s >= e) return true;
        if (str.charAt(s) == str.charAt(e)){
            return checkIfPalindrome(str, s + 1, e - 1);
        }else {
            return false;
        }
    }

    static void printReverseString(String str){
        if ((str==null)||(str.length() <= 1)) {
            System.out.println(str);
        }else {
            System.out.print(str.charAt(str.length()-1));
            printReverseString(str.substring(0,str.length()-1));
        }
    }
}



















