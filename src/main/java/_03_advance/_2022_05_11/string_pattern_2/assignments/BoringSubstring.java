package _03_advance._2022_05_11.string_pattern_2.assignments;

public class BoringSubstring {
    // TC : O(n),
    public static int solve(String A) {
        int emin = Integer.MAX_VALUE, emax = Integer.MIN_VALUE;
        int omin = Integer.MAX_VALUE, omax = Integer.MIN_VALUE;

        for(int i = 0; i < A.length(); i++) {
            int val = A.charAt(i) - 'a';
            if((val&1) == 0) {
                emin = Math.min(val, emin);
                emax = Math.max(val, emax);
            } else {
                omin = Math.min(val, omin);
                omax = Math.max(val, omax);
            }
        }

        if(Math.abs(emin - omax) != 1 || Math.abs(emin - omin) != 1 ||
                Math.abs(omin - emax) != 1 || Math.abs(omax - emax) != 1) {
            return 1;
        }

        return 0;
    }

}

/*
You are given a string A of lowercase English alphabets. Rearrange the
characters of the given string A such that there is no boring substring in A.
A boring substring has the following properties:
Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first
character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring
substrings in A else, return 0.

Problem Constraints
1 <= |A| <= 10^5

Input Format : ument given is a string A.
Output Format : Return 1 if it is possible to rearrange the letters of A such that
there are no boring substrings in A else, return 0.

Input 1: A = "abcd" Output 1: 1
Input 2: A = "aab" Output 2: 0

Explanation 1: String A can be rearranged into "cadb" or "bdac"
Explanation 2: No arrangement of string A can make it free of boring substrings.
 */