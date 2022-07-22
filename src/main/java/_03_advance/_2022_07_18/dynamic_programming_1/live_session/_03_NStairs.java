package _03_advance._2022_07_18.dynamic_programming_1.live_session;

public class _03_NStairs {

    // its nothing  but Fibonacci series code but with tiny changes in base condition
    // dp[0] = 1 instead of 0.
    public int climbStairs(int A) {
        int[] dp = new int[A+1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= A; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[A];
    }

}

/*
given n stairs, how many ways we can go from 0th step to nth step ?
note  : from ith step u can directly go to (i+1)th step and (i+2)th step
ex : n = 2, # ways = 2, n = 3, #ways = 3, n = 4, #ways = 5 (refer notes)

 */
