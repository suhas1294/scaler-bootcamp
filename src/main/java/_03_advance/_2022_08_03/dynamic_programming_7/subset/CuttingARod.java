package _03_advance._2022_08_03.dynamic_programming_7.subset;

import java.util.Arrays;

public class CuttingARod {
    //Memorization | Using 0-(infinity) Knapsack Problem
    public int solve(int[] A) {
        int N = A.length;
        int[][] dp = new int[N + 1][N + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return function(A, dp, N, N);
    }

    private int function(int[] A, int[][] dp, int i, int j) {
        if (j == 0 || i == 0) {
            return 0;
        }
        if (dp[i][j] == -1) {
            dp[i][j] = function(A, dp, i - 1, j);
            if (i <= j) {

                dp[i][j] = Integer.max(dp[i][j], function(A, dp, i, j - i) + A[i - 1]);
            }
        }
        return dp[i][j];
    }


    // ---------------- alternate appriach ------------------
    // Java : Cutting Rod : Knapsnack 0 /1 problem
    static int[][] max;

    public static int cuttingRod(int[] A) {
        int[] lenOfRod = new int[A.length]; // lenght of the rod 1, 2, 3, 4, 5,....
        max = new int[A.length + 1][A.length + 1];
        for (int i = 0; i <= A.length; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < A.length; i++) {
            lenOfRod[i] = i + 1;
        }

        return cuttingRodRecursion(A, A.length, A.length, lenOfRod);
    }

    private static int cuttingRodRecursion(int[] price, int maxLengthOfRod, int N, int[] lenOfRod) {

        if (N == 0 || maxLengthOfRod <= 0) {
            return 0;
        }
        if (max[N][maxLengthOfRod] != Integer.MIN_VALUE) {
            return max[N][maxLengthOfRod];
        }

        if (lenOfRod[N - 1] <= maxLengthOfRod) {
            int y = cuttingRodRecursion(price, maxLengthOfRod, N - 1, lenOfRod);
            int x = price[N - 1] + cuttingRodRecursion(price, maxLengthOfRod - lenOfRod[N - 1], N, lenOfRod);
            max[N][maxLengthOfRod] = Math.max(x, y);
        } else {
            max[N][maxLengthOfRod] = cuttingRodRecursion(price, maxLengthOfRod, N - 1, lenOfRod);
        }
        return max[N][maxLengthOfRod];
    }
}

/*
Given a rod of length N units and an array A of size N denotes prices
that contains prices of all pieces of size 1 to N.
Find and return the maximum value that can be obtained
by cutting up the rod and selling the pieces.

Problem Constraints
1 <= N <= 1000
0 <= A[i] <= 10^6

Input Format : First and only argument is an integer array A of size N.
Output Format : Return an integer denoting the maximum value that can be
obtained by cutting up the rod and selling the pieces.

Input 1: A = [3, 4, 1, 6, 2], Output 1: 15
Explanation 1:
 Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.

Input 2: A = [1, 5, 2, 5, 6], Output 2: 11
Explanation 2:
 Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
 */