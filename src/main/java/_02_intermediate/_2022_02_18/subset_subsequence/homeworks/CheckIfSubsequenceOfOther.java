package _02_intermediate._2022_02_18.subset_subsequence.homeworks;

import java.util.ArrayList;
import java.util.List;

/*
solution:
The idea is simple, we traverse both strings from one side to another side (say from
rightmost character to leftmost). If we find a matching character, we move ahead in both strings.
Otherwise, we move ahead only in str2.
Following is a Recursive Implementation of the above idea.
 */

public class CheckIfSubsequenceOfOther {
    public static String solve(String A, String B) {
        return isSubSequence(A, B, A.length(), B.length()) ? "YES" : "NO";
    }

    static boolean isSubSequence(String str1, String str2, int m, int n) {
        // Base Cases
        if (m == 0) return true;
        if (n == 0) return false;

        // If last characters of two strings are matching
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return isSubSequence(str1, str2, m - 1, n - 1);

        // If last characters are not matching
        return isSubSequence(str1, str2, m, n - 1);
    }
}

/*
Given two strings A and B, find if A is a subsequence of B.
Return "YES" if A is a subsequence of B, else return "NO".

Input FormatThe first argument given is the string A.
The second argument given is the string B.

Output Format : Return "YES" if A is a subsequence of B, else return "NO".

Constraints
1 <= lenght(A), length(B) <= 100000
'a' <= A[i], B[i] <= 'z'

For Example

Input 1: A = "bit" B = "dfbkjijgbbiihbmmt"
Output 1: YES

Input 2: A = "apple" B = "appel"
Output 2: "NO"

soln using stack: https://www.geeksforgeeks.org/check-if-a-string-is-a-subsequence-of-another-string-using-stacks/
 */