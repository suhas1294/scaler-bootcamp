package _03_advance._2022_08_03.dynamic_programming_7.subset.live_session;

// tc : O(nxk) and sc: O(2k) = O(k) which can be further optimized to constant since at any
// point of time we are using only 2 variables. so ultimately sc can be made O(1)
public class _01_NoOfSubsetWithSumK {
    int subsetSum(int[] a, int k){
        int n = a.length;
        int[][] dp = new int[n][k+1];
        // base conditions
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 0;
        }
        dp[0][0] = 1;
        if(a[0] <= k){
            dp[0][a[0]] += 1;
        }
        // main logic
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= a[i]){
                    dp[i][j] += dp[i-1][j-a[i]];
                }
            }
        }
        return dp[n-1][k];
    }
}

/*
Given an array of n elements, calculate number of subsets with sum = k(given)
all elements are >= 0, and k >= 0

hint : if first element of array is 0, then dp[0][0] = 2

ideas:
1. using bit manipulation - tc ; O((2^n)xn)
2. back tracking : tc :O(2^n)
3. dp

dp state : dp(i, j) = number of subsets with sum = j from [0 to i]
dp expression : dp(i, j) = { dp(i-1, j) + dp(i, j - a[i])  } where
dp(i-1, j) = no of subsets from o to i-1 with sum =j, ( leave it - ith index element)
dp(i, j - a[i]) = no of subsets from o to i with sum = j -a[i], ( pick it - ith index element included)
dp table : dp[n][k+1] since we need to return dp[n-1][k] from dp array

 */