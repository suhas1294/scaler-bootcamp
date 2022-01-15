package _02_intermediate._2022_01_14.carry_forward.homework;

import java.util.Arrays;
import java.util.List;

public class AmazingSubArrays {
    public static int solve(String A) {
        char[] chars = A.toCharArray();
        List<Character> amazingChars = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (amazingChars.contains(chars[i])){
                int noOfCharsFromHereToEnd = A.length() - i;
                count += noOfCharsFromHereToEnd;
            }
        }
        return count % 10003;
    }

    public static void main(String[] args) {
        System.out.println(solve("ABEC"));
    }
}

/*
You are given a string S, and you have to find all the amazing substrings of S.
Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

constraints:
1 <= length(S) <= 1e6
S can have special characters

input format: Only argument given is string S.
output format: Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.

Input
    ABEC

Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
 */