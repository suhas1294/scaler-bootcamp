package _03_advance._2022_08_05.dynamic_programming_8.mcm_strings.live_session;

import java.util.Arrays;

public class _01_MatrixChainMultiplication {
    // recursive function, TC: O(n^3), sc : O(N^2)
    int mcm(int i, int j, int[] v, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] == -1) { // unvisited
            int ans = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) {
                int leftExpression = mcm(i, k, v, dp); // min cost to multiply [i to k]
                int rightExpression = mcm(k + 1, j, v, dp); // min cost to multiply [k+1 to j]
                int costResultant = v[i - 1] * v[k] * v[j];
                int totalCost = leftExpression + rightExpression + costResultant;
                ans = Integer.min(ans, totalCost);
            }
            dp[i][j] = ans;
        }
        return dp[i][j];
    }

    // main code which calls recursive function
    int minCost(int n, int[] v) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return mcm(1, n, v, dp); // min cost to multiply all matrices from 1 - n
    }

    // ----------------- assignment problem -----------------
    public int solve(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return findMin(A, 0, n - 1, dp);
    }

    int findMin(int[] A, int start, int end, int[][] dp) {
        if (end - start <= 1)
            return 0;

        if (dp[start][end] != -1)
            return dp[start][end];

        int ans = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            ans = Math.min(ans, findMin(A, start, i, dp) + findMin(A, i, end, dp) + A[start] * A[i] * A[end]);
        }
        return dp[start][end] = ans;
    }

    // ---------- iterative approach ----------
    /*Iterations: no of cells in grid/2 => n*n/2 as only half matrix is being used
    TC: O(n^3)
    SC: O(n^2) for dp array*/
    public int tabulation_mcm(int[] A) {
        int n = A.length;
        // initialize dp array with max value as we need to find the min value
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        // start from bottom row to top row
        for (int i = n; i >= 1; i--) {
            // start from left column to right column
            for (int j = i; j < n; j++) {
                // base case
                if (i == j)
                    dp[i][j] = 0;
                // recursive relation converted to iterative code
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k + 1][j] + (A[i - 1] * A[k] * A[j]));
                }
            }
        }
        // answer will be stored at dp[1][n-1]
        return dp[1][n - 1];
    }

}

/*
Given N matrices and a value array which contains dimentions of those n matrices,
find the minimum cost (least iterations) to multiply all of the matrices.

few observations:
1. If we multiply Matrix A (r1xc1) with Matrix B  (r2x c2) the resultant matrix will be
Matrix R with (r1 x c2) (vector multiplication of matrices)
2. with matrices with above mentioned dimensions, number of iterations required to
get resultant matrix is r1xc2xr1 or r1xc2xr2

dp state :
dp[i, j] = min cost to multiply all matrices from i-j
dp expression:
dp[i, j] = min of below group :
group = [
    dp[i, i] + dp[i+1, j] + cost to multiply resultant matrix say c1,
    dp[i, i+1] + dp[i+2, j] + c2,
    dp[i, i+2] + dp[i+3, j] + c3,
    dp[i, i+3] + dp[i+4, j] + c4,
    .
    .
    dp[i, j-1] + dp[j, j] + c4,
]

So final dp expression:
dp[i, j] = min ( for all k from k = i to <j, dp[i, k] + dp[k+1, j] + (v[i-1] * v[k] * v[j]))
where v[i-1] * v[k] * v[j] is cost to multiply subsequent resultant matrix

dp table : dp[n+1][n+1]

----------------------------------------------------------------------

Given an array of integers A representing chain of 2-D matices such that the
dimensions of ith matrix is A[i-1] x A[i].Find the most efficient way to multiply
these matrices together. The problem is not actually to perform the multiplications,
but merely to decide in which order to perform the multiplications.
Return the minimum number of multiplications needed to multiply the chain.

Problem Constraints
1 <= length of the array <= 1000
1 <= A[i] <= 100

Input Format : The only argument given is the integer array A.
Output Format : Return an integer denoting the minimum number of multiplications needed to multiply the chain.

Input 1: A = [40, 20, 30, 10, 30] Output 1:26000
Input 2: A = [10, 20, 30] Output 2:6000


Explanation 1:
 Dimensions of A1 = 40 x 20
 Dimensions of A2 = 20 x 30
 Dimensions of A3 = 30 x 10
 Dimensions of A4 = 10 x 30
 First, multiply A2 and A3 ,cost = 20*30*10 = 6000
 Second, multilpy A1 and (Matrix obtained after multilying A2 and A3) =  40 * 20 * 10 = 8000
 Third, multiply (Matrix obtained after multiplying A1, A2 and A3) and A4 =  40 * 10 * 30 = 12000
 Total Cost = 12000 + 8000 + 6000 =26000

Explanation 2:
 Cost to multiply two matrices with dimensions 10 x 20 and 20 x 30 = 10 * 20 * 30 = 6000.
 */