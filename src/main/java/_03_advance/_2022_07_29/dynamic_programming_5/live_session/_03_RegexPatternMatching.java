package _03_advance._2022_07_29.dynamic_programming_5.live_session;

import java.util.Arrays;

public class _03_RegexPatternMatching {

    int[][] dp;

    public _03_RegexPatternMatching(int n, int m) {
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
    }

    // TC: O(n*m),  SC: O(n*m)
    boolean regexMatch(String t, String p, int i, int j) {
        if (i == -1 && j == -1) return true;
        if (j == -1) { // text left out, pattern empty
            return false;
        }
        if (i == -1) { // text empty, pattern present
            // if pattern contains only '*' return true
            for (int k = 0; k <= j; k++) {
                if (p.indexOf(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[i][j] == -1) { // never visited
            if (t.indexOf(i) == p.indexOf(j) || p.indexOf(j) == '?') {
                dp[i][j] = regexMatch(t, p, i - 1, j - 1) ? 1 : 0;
            } else if (p.indexOf(j) == '*') {
                dp[i][j] = (regexMatch(t, p, i - 1, j) || regexMatch(t, p, i, j - 1)) ? 1 : 0;
            } else {
                dp[i][j] = 0;
            }
        }
        return dp[i][j] == 1;
    }

    // -------------- assignment solution ---------------

    public int isMatch(final String s1, final String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] first = new int[m + 1];
        int[] second = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            if (s2.charAt(i - 1) == '*')
                first[i] = 1;
            else
                break;
        }

        first[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s2.charAt(j - 1) == '?')
                    second[j] = first[j - 1];
                else if (s2.charAt(j - 1) == '*')
                    second[j] = (first[j] == 1 || second[j - 1] == 1) ? 1 : 0;
                else
                    second[j] = 0;
            }
            first[0] = 0;
            int[] temp = first;
            first = second;
            second = temp;
        }

        return first[m];
    }

    /*

    Analysis

    a c z
    a 1
    c 1
    * 1
    z 1

    if (B[j] == * && j>i) then move up => --i

    a b c d
    a 1
    * 1 1
    d 1
    if (B[j] == * && j<i) then move left => --j

    a b c
    a 1
    * 1
    c 1
    if(B[j] == * && j==1) then move top-left => --i; --j;

     */
}

/*
given text t and pattern p, check if both are same or not.
t - text , contains only alphabets
p - pattern - can contains two things:
        ? - it can match any 1 character only
        * - it can match any number of character (>= 0)
p can have any number of ? and *

----------

dp state :
dp[i,j] = whether we can match t[0-i] and p[o-j]
dp expression :
if (t[i] == p[j] || p[j] == '?') dp[i][j] = dp[i-1, j-1]
else if (p[j] == '*') dp[i][j] = dp[i, j-1] || dp[i-1, j]
else dp[i][j] = false
 */

/*

Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Problem Constraints 1 <= length(A), length(B) <= 10^4

Input Format
The first argument of input contains a string A.
The second argument of input contains a string B.

Output Format : Return 1 if the patterns match else return 0.

Input 1: A = "aaa" B = "a*" Output 1: 1
Input 2: A = "acz" B = "a?a" Output 2: 0

Explanation 1:
 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 So, the pattern matches we return 1.

Explanation 2:
 '?' matches any single character. First two character in string A will be match.
 But the last character i.e 'z' != 'a'. Return 0.

 */