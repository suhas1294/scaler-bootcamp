package _03_advance._2022_08_03.dynamic_programming_7.subset.live_session;

import java.util.stream.IntStream;

public class _05_LeastDiffBwSubsetSums {
    int leastDiffBwSubsetSums(int[] a){
        int n = a.length;
        int sum = IntStream.of(a).sum();
        int k = sum / 2;

        boolean[][] dp = isThereSubsetWithSumK(a, k);

        // subset 1(i.e., s1) sum is s1 = totalSum/2, subset2 (i.e., s2) is : s2 = totalSum - s1
        int s1 = sum/2, s2 = sum - s1;
        while (dp[n-1][s1] == false){
        // meaning :subset sum s1 is not possible, continue process until its possible
            s1--;
            s2++;
        }
        return s2-s1;
    }

    static boolean[][] isThereSubsetWithSumK(int[] a, int k){ // this was a independent problem independently
        int n = a.length;
        boolean[][] dp = new boolean[n][k+1];
        // base conditions
        for (int j = 0; j <= k; j++) {
            dp[0][j] = false; // since answer cannot be more then n+1, we initialize values with n+1
        }
        dp[0][0] = true;
        if(a[0] <= k){
            dp[0][a[0]] = true;
        }
        // main logic
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= a[i]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-a[i]] ;
                }
            }
        }
        return dp;
    }

}

/*
given a[n] elements, divide all elements in two subsets.
divide in such a way that diff between both is min
| sum(subset1) - sum(subset2) | is minimized (take absolute value of diff)
return the min difference
ex: {3,2,4,7,6,3} can be divided into {7,4,2} and {3,3,6} so that diff is 13-12=1
 */