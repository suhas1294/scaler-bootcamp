package _03_advance._2022_07_25.dynamic_programming_4.assignments;

import java.util.Arrays;

public class MinSumPathInMatrix {
    public int minPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int dp[][] = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return minpath(A, n - 1, m - 1, n, m, dp);
    }

    public int minpath(int A[][], int i, int j, int n, int m, int dp[][]) {
        if (i == 0 && j == 0) {
            return A[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Math.min(minpath(A, i - 1, j, n, m, dp), minpath(A, i, j - 1, n, m, dp));
        dp[i][j] += A[i][j];
        return dp[i][j];
    }

    // --------------- alternate solution ---------------

    // We take the idea of selecting a path or rejecting a path based on path’s value,
    // it forms binary space state tree where from current element there are two possible
    // paths and we have to find min
    public int minPathSum2(int[][] A) {
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = A[0].length - 1; j >= 0; j--) {
                if (i == A.length - 1 && j == A[0].length - 1) {
                    continue;
                }
                int rightVal = j + 1 == A[0].length ? Integer.MAX_VALUE : A[i][j + 1] + A[i][j];
                int bottomVal = i + 1 == A.length ? Integer.MAX_VALUE : A[i + 1][j] + A[i][j];
                A[i][j] = Math.min(rightVal, bottomVal);
            }
        }
        return A[0][0];
    }
}

/*
Given a M x N grid A of integers, find a path from top left to bottom right which
minimizes the sum of all numbers along its path.
Return the minimum sum of the path.
NOTE: You can only move either down or right at any point in time.

Problem Constraints
1 <= M, N <= 2000
-1000 <= A[i][j] <= 1000

Input Format : First and only argument is a 2-D grid A.
Output Format : Return an integer denoting the minimum sum of the path.

Input 1:
 A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]
Output 1: 8
Explanation 1: The path will be: 1 -> 3 -> 2 -> 1 -> 1.

Input 2:
 A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]

Output 2: -1
Explanation 2: The path will be: 1 -> -3 -> 5 -> -5 -> 1.
 */