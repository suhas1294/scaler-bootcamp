package _03_advance._2022_07_20.dynamic_programming_2.live_session;

public class _02_MinPerfectSquaresToTargetSum {
    // dp state : dp[i] = min perfect squares required to get ith sum
    // dp expression : dp[i] =  min ( dp[i-1²] + 1 , dp[i-2²] + 1, dp[i-3²] + 1,.... dp[i-j²] + 1)
    // where j * j < i, refer notes for mathematical expression
    // tc : O(n √n), √n for each state , n for no of states,sc : O(n)
    // note  : space cannot be optimized to O(1)
    int minPerfectSquares(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n ; i++) {
            int ans = i;
            for (int j = 1; j*j < i; j++) {
                ans = Integer.min(ans, dp[i-j*j] + 1);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}

/*
min no of perfect squares to be added to get target sum
 */