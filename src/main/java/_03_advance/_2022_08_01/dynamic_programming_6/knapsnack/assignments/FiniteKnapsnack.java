package _03_advance._2022_08_01.dynamic_programming_6.knapsnack.assignments;

import java.util.Arrays;

public class FiniteKnapsnack {
    // Recursion + DP [TC: O(n x target) SC: O(n x target) + recursion stack space]
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] dp = new int[n + 1][C + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return recursion_dp(n, C, A, B, dp);
    }

    public int recursion_dp(int n, int target, int[] values, int[] weights, int[][] dp) {
        if (n == 0 || target == 0) {
            return 0;
        }

        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        // do not pick
        int x = recursion_dp(n - 1, target, values, weights, dp);
        // pick
        int y = 0;
        if (target - weights[n - 1] >= 0) {
            y = values[n - 1] + recursion_dp(n - 1, target - weights[n - 1], values, weights, dp);
        }

        return dp[n][target] = Math.max(x, y);
    }

    // ----------------------- iterative
    // tabulation + DP [TC: O(n x target) SC: O(n x target) for dp array]
    public int solve2(int[] A, int[] B, int C) {
        int n = A.length;
        return tabulation_dp(n, C, A, B);
    }

    public int tabulation_dp(int n, int target, int[] values, int[] weights) {
        // initialize base cases. first row and first column will be 0
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // do not pick
                int x = dp[i - 1][j];
                // pick
                int y = 0;
                if (j - weights[i - 1] >= 0) {
                    y = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                }
                dp[i][j] = Math.max(x, y);
            }
        }
        return dp[n][target];
    }

    // --------------- space optimized + iterative -----------------
    //space optimized solution + DP [TC: O(n x target) SC: O(2 x target) for dp array]

    public int solve3(int[] A, int[] B, int C) {
        int n = A.length;
        return space_optimized(n, C, A, B);
    }

    public int space_optimized(int n, int target, int[] values, int[] weights) {
        // initialize base cases. first row and first column will be 0
        int[][] dp = new int[2][target + 1];

        for (int i = 1; i <= n; i++) {
            int prevRow = (i - 1) % 2;
            int currRow = i % 2;
            for (int j = 1; j <= target; j++) {
                // do not pick
                int x = dp[prevRow][j];
                // pick
                int y = 0;
                if (j - weights[i - 1] >= 0) {
                    y = values[i - 1] + dp[prevRow][j - weights[i - 1]];
                }
                dp[currRow][j] = Math.max(x, y);
            }
        }
        return dp[n % 2][target];
    }
}

/*
Given two integer arrays A and B of size N each which represent values and
weights associated with N items respectively.Also given an integer C which
represents knapsack capacity. Find out the maximum value subset of A such
that sum of the weights of this subset is smaller than or equal to C.
NOTE:  You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Problem Constraints
1 <= N <= 10^3
1 <= C <= 10^3
1 <= A[i], B[i] <= 10^3

Input Format
First argument is an integer array A of size N denoting the values on N items.
Second argument is an integer array B of size N denoting the weights on N items.
Third argument is an integer C denoting the knapsack capacity.

Output Format
Return a single integer denoting the maximum value subset of A such that
sum of the weights of this subset is smaller than or equal to C.

Input 1: A = [60, 100, 120] B = [10, 20, 30] C = 50 Output 1: 220
Explanation 1: Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220

Input 2: A = [10, 20, 30, 40] B = [12, 13, 15, 19] C = 10 Output 2: 0
Explanation 2: Knapsack capacity is 10 but each item has weight greater
than 10 so no items can be considered in the knapsack therefore answer is 0.
 */