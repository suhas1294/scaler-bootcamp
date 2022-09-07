package _03_advance._2022_08_05.dynamic_programming_8.mcm_strings.live_session;

import java.util.Arrays;

public class _02_PalindromeSubstring {
    static boolean[][] palindromicSubstrings(String s){
        int n = s.length();
        // TODO : implementation, refer notes.
        return new boolean[n][n];
    }

    public boolean[][] palindromSubstrings(String input){
        boolean [][] dp = new boolean[input.length()][input.length()];
        for(int i = 0 ; i < input.length() ; ++i){
            Arrays.fill(dp[i],true);
        }
        for(int length = 2 ; length <= input.length() ; ++length){
            for(int start = 0 ; start <= input.length() - length ; ++start){
                int end = start + length - 1;
                dp[start][end] = dp[start+1][end-1] && input.charAt(start) == input.charAt(end);
            }
        }
        return dp;
    }
}

/*
given a string of length n, concstruct a boolean matrix mat[n][n]
where mat[i][j] is true if substring from i to j is palindrome.
note : i<=j

ex: string s =  bbdadb
bool matrix will be :

NA  0   1   2   3   4   5
0   T   T   F   F   F   F
1   -   T   F   F   F   T
2   -   -   T   F   F   F
3   -   -   -   T   F   F
4   -   -   -   -   T   F
5   -   -   -   -   -   T

brute force way will take n^3 TC, but optimized soln will take n^2
 */
