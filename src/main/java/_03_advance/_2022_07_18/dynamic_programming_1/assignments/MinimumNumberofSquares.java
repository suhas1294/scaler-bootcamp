package _03_advance._2022_07_18.dynamic_programming_1.assignments;

import java.util.Arrays;
// similar to dice problem
public class MinimumNumberofSquares {
    public int countMinSquares(int A) {
        if (A <= 0) return 0;
        int dp[] = new int[A + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - (j * j)]);
            }
        }
        return dp[A];
    }

    // ----------------- alterne solution -------------------
    // TC : O(N*sqrt(N)) | SC : O(N)
    public int countMinSquares2(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return count(A, dp);
    }

    int count(int A, int[] dp) {
        if (A == 0)
            return 0;

        if (dp[A] != Integer.MAX_VALUE)
            return dp[A];

        for (int i = 1; i <= Math.floor(Math.sqrt(A)); i++) {
            dp[A] = Math.min(dp[A], 1 + count(A - i * i, dp));
        }
        return dp[A];
    }
}

/*
Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
Problem Constraints : 1 <= A <= 10^5
Input Format : First and only argument is an integer A.
Output Format : Return an integer denoting the minimum count.
Input 1:  A = 6, Output 1: 3
Explanation 1:
 Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 Minimum count of numbers, sum of whose squares is 6 is 3.

Input 2: A = 5 Output 2: 2
Explanation 2:  We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 */