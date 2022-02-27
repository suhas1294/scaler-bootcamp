package _02_intermediate._2022_02_06.strings.assignments;

public class ReverseSentence {
    public static String solve(String A) {
        String[] words = A.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length-1; i >=0 ; i--) {
            stringBuilder.append(words[i] + (i != 0 ? " " : ""));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv "));
    }
}

/*
Given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

1 <= N <= 3 * 10^5

Input 1: A = "the sky is blue", output: "blue is sky the", exp: We reverse the string word by word so the string becomes "the sky is blue".
Input 1: A = "this is ib", output: "ib is this", exp: We reverse the string word by word so the string becomes "this is ib".
 */