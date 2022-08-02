package _03_advance._2022_07_22.dynamic_programming_3.live_session;

public class PaintNHouses {
    // tc : O(n), sc : O(n), sc can be optimized to O(1) since at any given point of time we are using only 6 states.
    int minCostToPaintNHouses(int n, int[] r, int[] b, int[] g){
        int[][] dp = new int[n+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = r[i] + Integer.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = b[i] + Integer.min(dp[i-1][0], dp[i-1][2]);
            dp[i][0] = g[i] + Integer.min(dp[i-1][1], dp[i-1][0]);
        }
        return Integer.min(Integer.min(dp[n][2], dp[n][0]), dp[n][1]);
    }
}

/*
given n houses and cost associated to color each house in R/G/B
find min cost to paint all houses
note : no 2 adjacent houses should have same color.

idea-1 : try all combinations , tc : 3^n
idea-2 : by neglecting few combinations and making sure no 2 adjacent houses has same color : 3*2^n-1
idea-3 : dp

dp[i][0] : min cost to paint 1-i such ith house ends in red
dp[i][1] : min cost to paint 1-i such ith house ends in blue
dp[i][2] : min cost to paint 1-i such ith house ends in green

dp expression:
dp[i][0] = r[i] + min(dp[i-1][1], dp[i-1][2]) // where r[i] is cost to paint ith house with red.
dp[i][1] = b[i] + min(dp[i-1][0], dp[i-1][2])
dp[i][0] = g[i] + min(dp[i-1][1], dp[i-1][0])

base condition :
dp[0][0] = dp[0][1] = dp[0][2] = 0 (when i = 0, there are no houses)

dp table : dp[n+1][3]
 */