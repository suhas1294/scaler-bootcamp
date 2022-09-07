package _03_advance._2022_08_05.dynamic_programming_8.mcm_strings.live_session;

import java.util.Arrays;

public class _03_PalindromicPartitioning {
    // recursive code
    int minPartitions(int i, int[] dp, boolean[][] pal, int n) {
        if (pal[0][i]) return 1; // pal[0][i] = is substring from 0 to i is palindrome
        if (dp[i] == -1) {
            int ans = n; // ans cannot exceed n
            for (int j = i - 1; j >= 0; j--) {
                if (pal[j + 1][i]) { // pal[j+1][i] = is substring from j+1 to i is palindrome
                    ans = Integer.min(ans, minPartitions(j, dp, pal, n) + 1); // min partition from 0 to j
                }
            }
            dp[i] = ans;
        }
        return dp[i];
    }

    // main cod where core logic gets called
    int palindromePartitions(String s) {
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] pal = _02_PalindromeSubstring.palindromicSubstrings(s);
        return minPartitions(n - 1, dp, pal, n);
    }

    // ------------- assignment soln --------------
    public int minCut(String A) {

        /*// iterative apparoch
        boolean[][] pal = palindromSubstrings(A);
        return minCutsIterative(A, pal);*/

        // recursive approach
        boolean[][] pal = palindromSubstrings(A);
        int[] dp = new int[A.length()];
        Arrays.fill(dp, -1);
        int minCutsRec = minCuts(A, dp, pal, A.length() - 1);
        return minCutsRec;
    }

    // helper function
    public boolean[][] palindromSubstrings(String input) {
        boolean[][] dp = new boolean[input.length()][input.length()];
        for (int i = 0; i < input.length(); ++i) {
            Arrays.fill(dp[i], true);
        }
        for (int length = 2; length <= input.length(); ++length) {
            for (int start = 0; start <= input.length() - length; ++start) {
                int end = start + length - 1;
                dp[start][end] = dp[start + 1][end - 1] && input.charAt(start) == input.charAt(end);
            }
        }
        return dp;
    }

    // iterative approach
    public int minCutsIterative(String input, boolean[][] pal) {
        int[] dp = new int[input.length()];
        dp[0] = 0;
        for (int i = 1; i < input.length(); ++i) {
            int ans = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (pal[j][i]) {
                    ans = Math.min(ans, j - 1 < 0 ? 0 : dp[j - 1] + 1);
                }
            }
            dp[i] = ans;
        }
        return dp[input.length() - 1];
    }

    // recursive approach
    public int minCuts(String input, int[] dp, boolean[][] isPalindrome, int n) {
        //Base Case
        if (n < 0) return -1;
        if (dp[n] != -1) return dp[n];
        int ans = Integer.MAX_VALUE;
        for (int k = n; k >= 0; k--) {
            if (isPalindrome[k][n]) {
                ans = Math.min(ans, minCuts(input, dp, isPalindrome, k - 1) + 1);
            }
        }
        dp[n] = ans;
        return ans;
    }
}

/*
given a string s, calculate min no of paritions required to be done on s
such that all partitions are palindromes.
ex: anaconoaa, ans = 4 bcoz partitions : ana c ono aa

tc: (n dp states * n = n^2) + (n^2 to calculate pal[][]), therefore, tc : O(N² + N²)
sc : O(N = N²), here N² is for constructing pal[][]

----------------- assignment question description ------------------

Given a string A, partition A such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of A.

Problem Constraints
1 <= length(A) <= 501

Input Format : The first and the only argument contains the string A.
Output Format : Return an integer, representing the minimum cuts needed.

Input 1: A = "aba", Output 1: 0
Explanation 1: "aba" is already a palindrome, so no cuts are needed.

Input 2: A = "aab", Output 2: 1
Explanation 2: Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */