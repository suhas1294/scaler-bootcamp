package _03_advance._2022_07_29.dynamic_programming_5.live_session;

import java.util.Arrays;

public class _01_LongestCommonSubsequence {

    int[][] dp;

    public _01_LongestCommonSubsequence(int n, int m) {
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
    }

    // TC: O(n*m),  SC: O(n*m)
    int getLcs(String s1, String s2, int i, int j) {
        if (i == -1 || j == -1)
            return 0; // note : i == -1 indicates s1 is computed and there is nothing, with empty string lcs = 0
        if (dp[i][j] == -1) { // sub problem called for first time
            if (s1.indexOf(i) == s2.indexOf(j)) {
                dp[i][j] = 1 + getLcs(s1, s2, i - 1, j - 1);
            } else {
                dp[i][j] = Integer.max(
                        getLcs(s1, s2, i - 1, j),
                        getLcs(s1, s2, i, j - 1)
                );
            }
        }
        return dp[i][j]; // TODO : shouldn't it be dp[n-1][m-1] ?
    }

    // to print longest common sequence:
    String printLcs(String s1, String s2, int n, int m) {
        int i = n - 1, j = m - 1; // n and m are length of s1 and s2 respectively
        StringBuilder ans = new StringBuilder("");
        while (i >= 0 && j >= 0) {
            if (s1.indexOf(i) == s2.indexOf(j)) {
                // s1[i] present in ans
                ans.append(s1.indexOf(i));
                i--;
                j--;
            } else {
                if (i > 0 && dp[i][j] == dp[i - 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return ans.reverse().toString(); // bcoz we are adding char by char from back
    }

    // ------------------- assignment solution ---------------------

    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(A, B, n - 1, m - 1, dp);
    }

    private int lcs(String A, String B, int i, int j, int[][] dp) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = 0;
        if (A.charAt(i) == B.charAt(j)) {
            max = 1 + lcs(A, B, i - 1, j - 1, dp);
        } else {
            max = Math.max(lcs(A, B, i - 1, j, dp), lcs(A, B, i, j - 1, dp));
        }
        dp[i][j] = max;
        return dp[i][j];
    }

}

/*
given two strings s1 and s2 of length n and m respectively, find length of longest common subsequence.
dp state : dp[i, j] = LCS of s1[0, i] and s2[0, j] where
i and j represent ending index of s1 and s2 respectively.
 */

/*
Given two strings A and B. Find the longest common subsequence
( A sequence which does not need to be contiguous), which is common in both the strings.
You need to return the length of such longest common subsequence.

Problem Constraints
1 <= Length of A, B <= 1005

Input Format
First argument is a string A.
Second argument is a string B.

Output Format
Return an integer denoting the length of the longest common subsequence.

Input 1: A = "abbcdgf"  B = "bbadcgf", Output 1: 5
Explanation 1: The longest common subsequence is "bbcgf", which has a length of 5.

Input 2: A = "aaaaaa" B = "ababab" Output 2:3
Explanation 2:The longest common subsequence is "aaa", which has a length of 3.
 */