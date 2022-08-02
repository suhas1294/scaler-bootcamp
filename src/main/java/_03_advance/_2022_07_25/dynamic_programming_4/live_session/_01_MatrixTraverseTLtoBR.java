package _03_advance._2022_07_25.dynamic_programming_4.live_session;

public class _01_MatrixTraverseTLtoBR {
    // TC: O(N*M), SC: O(N*M)
    int NoOfWays(int n, int m){
        int[][]dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0){ // handles base case
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}

/*
return number of ways to go from (0,0) (top left) to (Bottom-right) corner in a 2d matrix.
you can only go either right or bottom by one step at a time.

dp state : dp[i][j] : number of ways to reach from (0,0) to (i,j)
dp expression : dp[i][j] = dp[i-1][j] + dp[i][j-1]
base conditions : if i == 0 || j == 0, dp[i][j] = 1
do table : dp[n][m]
 */