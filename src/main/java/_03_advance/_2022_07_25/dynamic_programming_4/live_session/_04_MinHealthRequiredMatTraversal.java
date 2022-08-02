package _03_advance._2022_07_25.dynamic_programming_4.live_session;

import java.util.Arrays;

public class _04_MinHealthRequiredMatTraversal {
    // TC:
    int minHealth(int[][] h, int n, int m ){ // here h is nothing but health matrix mat[][]
        int[][]dp = new int[n][m];
        for (int[] row :dp) {
            Arrays.fill(row, -1);
        }
        dp[n-1][m-1] = Integer.max(1, 1 - h[n-1][m-1]); // we do Int.max to resolve edge case
        return traverse(h, n, m, dp, 0 , 0);
    }

    int traverse(int[][] h, int n, int m, int[][] dp, int i,  int j){
        if (i == n || j == m) return Integer.MAX_VALUE; // edge case
        if (dp[i][j] == -1) { // never visited
            int a = traverse(h, n, m, dp, i, j+1);
            int b = traverse(h, n, m, dp, i+1, j);
            dp[i][j] = Integer.max(1, (Integer.min(a, b) -h[i][j]));
        }
        return dp[i][j];
    }
}

/*
given matrix[n][m], where each cell mat[i][j] indicates health gained,
calculate min health required at (0,0) so that we can reach [n-1][m-1]
you can only traverse either right or bottom, one step at a time.
if health reaches zero at any place, you are dead.
we are starting at (0,0) and target is [n-1][m-1]

dp state : dp[i][j] : min health required to start at (i, j) and reach (n-1, m-1)
dp expression : dp[i][j]  = max (1,  min ( dp[i, j+1], dp[i+1][j] ) - mat[i][j] )
base condition : i == n-1 || j == m -1  //  wont work !
dp table : dp[n][m]
 */