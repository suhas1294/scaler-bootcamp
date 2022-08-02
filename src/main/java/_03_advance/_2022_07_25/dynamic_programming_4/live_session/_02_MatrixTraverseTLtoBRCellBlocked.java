package _03_advance._2022_07_25.dynamic_programming_4.live_session;

import java.util.Arrays;

public class _02_MatrixTraverseTLtoBRCellBlocked {
    // TC: O(N*M), SC: O(N*M)
    int NoOfWays(int mat[][], int n, int m){
        int[][]dp = new int[n][m];
        for (int[] row :dp) {
            Arrays.fill(row, 0);
        }
        // case-1 : iterate from 0th to jth col
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 1) {
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        // case-2 : iterate on 0th row
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 1) {
                dp[0][j] = 1;
            }else {
                break;
            }
        }
        // main logic
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0){ // handles base case
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }

    // -------------- recursive code --------------
    int ways(int[][] mat, int n, int m){
        int[][]dp = new int[n][m];
        for (int[] row :dp) {
            Arrays.fill(row, 0);
        }
        dp[0][0] = 1; // base condition
        return traverse(mat, dp, n-1, m-1);
    }

    int traverse(int[][] mat, int[][] dp, int i, int j){
        if (i < 0 || j < 0) return 0;
        if (mat[i][j] == 0) return 0;
        if (dp[i][j] == -1) { // calculating dp[i][j] for first time.
            dp[i][j] = traverse(mat, dp, i-1, j) + traverse(mat, dp, i, j-1);
        }
        return dp[i][j];
    }
}

/*
return number of ways to go from (0,0) (top left) to (Bottom-right) corner in a 2d matrix.
you can only go either right or bottom by one step at a time.
if mat[i][j] = 0, it means, that cell is blocked. we cannot traverse blocked cell.

dp state : dp[i][j] : number of ways to reach from (0,0) to (i,j)
dp expression : dp[i][j] = dp[i-1][j] + dp[i][j-1] else 0 if mat[i][j] = 0 i.e., blocked.
base conditions : if i == 0 || j == 0, dp[i][j] = 1
do table : dp[n][m]
 */