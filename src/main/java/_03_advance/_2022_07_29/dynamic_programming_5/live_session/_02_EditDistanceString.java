package _03_advance._2022_07_29.dynamic_programming_5.live_session;

import java.util.Arrays;

public class _02_EditDistanceString {

    int[][] dp;

    public _02_EditDistanceString(int n, int m) {
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
    }

    // TC: O(n*m),  SC: O(n*m)
    int editDistance(String s1, String s2, int i, int j) {
        if (i == -1 && j == -1) return 0;
        if (i == -1) { // we need to perform j+1 insert, ex: s1 = "", s2 = "abcd"
            return j + 1;
        }
        if (j == -1) { // we need to perform i+1 deletions, ex: s1 = "abcd", s2 = ""
            return i + 1;
        }
        if (dp[i][j] == -1) {
            if (s1.indexOf(i) == s2.indexOf(j)) {
                dp[i][j] = editDistance(s1, s2, i - 1, j - 1);
            } else {
                dp[i][j] = 1 + Integer.min(
                        editDistance(s1, s2, i, j - 1),             // insert
                        Integer.min(
                                editDistance(s1, s2, i - 1, j - 1), // replace
                                editDistance(s1, s2, i - 1, j)      // delete
                        )
                );
            }
        }
        return dp[i][j];
    }


    // ----------------- assignment solution ---------------------
    public int minDistance(String A, String B) {

        int n = A.length();
        int m = B.length();
        int[][] dpa = new int[n][m];
        for (int[] arr : dpa)
            Arrays.fill(arr, -1);
        return distance(A, B, n - 1, m - 1, dpa);
    }

    int distance(String A, String B, int A_pos, int B_pos, int[][] dp) {
        if (A_pos < 0 && B_pos < 0)
            return 0;

        if (A_pos < 0)
            return B_pos + 1;
        if (B_pos < 0)
            return A_pos + 1;

        if (dp[A_pos][B_pos] != -1)
            return dp[A_pos][B_pos];

        if (A.charAt(A_pos) == B.charAt(B_pos))
            return dp[A_pos][B_pos] = distance(A, B, A_pos - 1, B_pos - 1, dp);
        else
            return dp[A_pos][B_pos] = 1 + Math.min(distance(A, B, A_pos - 1, B_pos - 1, dp),
                    Math.min(distance(A, B, A_pos, B_pos - 1, dp), distance(A, B, A_pos - 1, B_pos, dp)));
    }


    public int minDistance2(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


}
/*
given 2 strings s1 and s2, return min operations to be performed in s1
so that s1 becomes s2.
in 1 operations of s1,
- we can insert a character in s1 at any position
- we can replace a character in s1 at any position, with any character
- we can delete a character in s1 at any position

dp state : dp[i, j] = min operations required to make s1[0, i] same as s2[o, j]
where i and j are ending index of s1 and d2 repectively

 */


/*
Given two strings A and B, find the minimum number of steps required
to convert A to B. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

Problem Constraints 1 <= length(A), length(B) <= 450

Input Format
The first argument of input contains a string, A.
The second argument of input contains a string, B.

Output Format : Return an integer, representing the minimum number of steps required.

Input 1: A = "abad" B = "abac", Output 1: 1
Exlanation 1:
 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.

Input 2: A = "Anshuman" B = "Antihuman Output 2: 2
Explanation 2:
 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.
 */