package _03_advance._2022_08_03.dynamic_programming_7.subset.live_session;

// tc : O(nxk) and sc: O(2k) = O(k)
public class _02_LengthOfSmallestSubsetWithSumK {
    int smallestSubsetWithSumK(int[] a, int k){
        int n = a.length;
        int[][] dp = new int[n][k+1];
        // base conditions
        for (int j = 0; j <= k; j++) {
            dp[0][j] = n+1; // since answer cannot be more then n+1, we initialize values with n+1
        }
        dp[0][0] = 0;
        if(a[0] <= k){
            dp[0][a[0]] = 1;
        }
        // main logic
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= a[i]){
                    dp[i][j] = Integer.min(dp[i][j], dp[i-1][j-a[i]] + 1); // +1 bcoz we have included that in array to get sum j
                }
            }
        }
        return dp[n-1][k];
    }
}

/*
Given an array of n elements, calculate length of smallest subset with sum = k(given)
all elements are >= 0, and k >= 0

dp state : dp(i, j) = length of smallest subset with sum = j from [0 to i]
dp expression : dp(i, j) = MIN of { dp(i-1, j) , dp(i, j - a[i])  } where
dp(i-1, j) = length of smallest subset from o to i-1 with sum =j, ( leave it - ith index element)
dp(i, j - a[i]) = length of smallest subset from o to i with sum = j -a[i], ( pick it - ith index element included)
dp table : dp[n][k+1] since we need to return dp[n-1][k] from dp array

 */