package _03_advance._2022_07_20.dynamic_programming_2.live_session;

public class _03_MaxSubsequenceSumCondition {
    /*
    dp state : dp[i]  : max subsequence sum from 0th index till ith index.
    dp expression : dp[i] = max (a[i] + dp[i-2] , dp[i-1]) // edge case - here, if dp[i-2] is negative, we avoid it.
    tc : O(n), sc : o(n)
    to understand edge case, take example of a[] = {-2, -4, 1}
     */
    int maxSubseqSum(int[] ar){
        int n = ar.length;
        int[] dp = new int[n];
        dp[0] = ar[0];
        dp[1] = Integer.max(ar[0], ar[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Integer.max( Integer.max(  dp[i-1],   dp[i-2]),    ar[i]); // edge case: compare with ar[i]
        }
        return dp[n-1];
    }

    // at any given point of time we are using only 3 states, so SC : O(1)
    int maxSubseqSumSpaceEffecient(int[] ar){
        int n = ar.length;
        int a = ar[0];
        int b = Integer.max(ar[0], ar[1]);
        int c = Integer.MIN_VALUE;
        for (int i = 2; i < n; i++) {
            c = Integer.max( Integer.max(  a,   b),    ar[i]);
            a = b;
            b = c;
        }
        return c;
    }
}

/*
given a[n], find max subsequence sum
condition : in a subsequence, 2 adjacent elements cannot be picked.

 */