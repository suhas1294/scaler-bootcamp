package _03_advance._2022_07_18.dynamic_programming_1.live_session;

public class _05_Dice6Faced {
    // tc : O(n), sc : O(n)
    int dice6Sum(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int s = 0;
            for (int j = 1; j <= 6 && j <= i ; j++) {
                s = s + dp[i-j];
            }
            dp[i] = s;
        }
        return dp[n];
    }
}
/*
There is a six faced dice, we can roll dice as many times as we want
what is no of ways to get sum N ?

this time dp expressoin is:
dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4] + dp[i-5] + dp[i-6]

in short mathematical formula, Summation from j from 1 to 6 of dp[i-j]
 */