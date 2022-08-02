package _03_advance._2022_07_22.dynamic_programming_3.live_session;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // working solution
    public int lis(final int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // tc : O(n^2), sc : O(n)
    // tc can be optimized to nlogn using dp + binary search
    int longestIncreasingSubsequence(int a[]) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // dp[i] -> length of longest increasing subsequence ending at i
            int v = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    v = Integer.max(v, dp[j]);
                }
            }
            dp[i] = v + 1;
        }
        // return max element in dp array
        return Arrays.stream(dp).max().getAsInt();
    }
}

/*
give ar[n], find the length of longest increasing subsequences.
note : subsequence values should be strictly increasing
subsequence : should be ordered based on index  : a1 < a2 < a3
constraints  : 1 <= n <= 10^3

dp[i] = length of longest increasing subsequence ending at i
dp[i] = max ( for all j = 0, till j = i-1, dp[j] if a[j] < a[i] ) + 1 (include ith index)
base condition : dp[0] = 1;
dp table  : dp[n]
 */
