package _03_advance._2022_05_09.string_pattern.live_session;

public class _05_MakeStringPalindrome {
    public static int makePalindrome(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        String s1 = s + "$" + sb; // string + reverse(string)
        int[] lps = _01_LPSAlgo.LPS(s1);
        int n = s.length();
        return n - lps[2*n];
    }
}

/*
Given a string n, calculate minimum no of characters we need to add to start to make
the entire string as palindrome.
ex:
input: abacd,output : 2, we need to add 'dc' at start to make the input a palindrome.
input : abbaacd, output : 3,  we need to add 'dca' at start to make the input a palindrome.

 */