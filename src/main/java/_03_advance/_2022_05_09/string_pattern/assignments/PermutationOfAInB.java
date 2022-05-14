package _03_advance._2022_05_09.string_pattern.assignments;

import java.util.Arrays;

public class PermutationOfAInB {
    public int solve(String A, String B) {
        int[] a = new int[26];

        for (int i = 0; i < 26; i++) { // As there is only lower case by question
            a[A.charAt(i) - 'a']++;
        }

        //System.out.println(Arrays.toString(a));
        int r = 0;
        int l = 0;
        int count = 26;
        int res = 0;
        int[] b = new int[26];
        while (r < B.length()) {
            b[B.charAt(r) - 'a']++;
            if ((r - l + 1) == A.length()) {
                for (int i = 0; i < 26; i++) {
                    if (a[i] == b[i]) {
                        continue;
                    } else {
                        count--;
                    }
                }
                if (count == 26) {
                    res++;
                } else {
                    count = 26;
                }
                b[B.charAt(l) - 'a']--; // left pointer - sliding window
                l++;
            }
            r++;
        }
        return res;
    }
}

/*
You are given two strings, A and B, of size N and M, respectively.
You have to find the count of all permutations of A present in B as a substring.
You can assume a string will have only lowercase letters.

Problem Constraints : 1 <= N < M <= 10^5

Input Format: Given two arguments, A and B of type String.
Output Format : Return a single integer, i.e., number of permutations of A present in B as a substring.

Input 1: A = "abc" B = "abcbacabc" Output 1: 5
Explanation 1:
 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.

Input 2: A = "aca" B = "acaa" Output 2: 2
Explanation 2:
 Permutations of A that are present in B as substring are:
    1. aca
    2. caa
 */