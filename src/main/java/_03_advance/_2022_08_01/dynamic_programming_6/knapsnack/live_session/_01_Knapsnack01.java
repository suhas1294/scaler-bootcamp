package _03_advance._2022_08_01.dynamic_programming_6.knapsnack.live_session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _01_Knapsnack01 {

    // ------------ recursive code ------------
    // tc : O(n*k) , sc: O(n * K)
    int[][] dp1;

    public _01_Knapsnack01(int n, int k) {
        for (int[] row : dp1) {
            dp1 = new int[n + 1][k + 1];
            Arrays.fill(row, -1);
        }
    }

    int kpRecursive(int i, int j, int[] w, int[] v) { // j represents - max how much weight you can pick <= j
        if (i == 0 || j == 0) return 0;
        if (dp1[i][j] == -1) { // visiting first time
            int a = kpRecursive(i - 1, j, w, v); // leave ith element
            if (j >= w[i]) { // pick ith element
                a = Integer.max(a, kpRecursive(i - 1, j - w[i], w, v) + v[i]);
            }
            dp1[i][j] = a;
        }
        return dp1[i][j];
    }

    // ------------ iterative code ------------
    // edge case : when i == 0, note : when j == 0, its handled
    // tc : O(n*k) , sc: O(n * K)
    int kpIterative(int n, int k, int[] w, int[] v) {
        int[][] dp = new int[n + 1][k + 1];
        // base conditions, i =0 means, 0 items, so fill all first row elements as 0
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 0;
        }
        // how to fill matrix - (row by row) or (col by col)
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int a = dp[i - 1][j];
                if (j >= w[i]) {
                    a = Integer.max(a, dp[i - 1][j - w[i]] + v[i]);
                }
                dp[i][j] = a;
            }
        }

        // extra code - to get items which constitue max value with weight <= k
        List<Integer> ans = new ArrayList<>();
        int i = n, j = k;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i = i - 1;
            } else { // we are picking ith item
                ans.add(i);
                i = i - 1;
                j = j - w[i];
            }
        }
        return dp[n][k];
    }

    // ------------ iterative code with space optimization ------------
    // tc : O(n*k) , sc: O(K)
    // disadvantage : we can no longer get list of items to store
    int kpIterativeSpaceOptimized(int n, int k, int[] w, int[] v) {
        int[][] dp = new int[2][k + 1]; //  space optimized
        // base conditions, i =0 means, 0 items, so fill all first row elements as 0
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int a = dp[(i - 1) % 2][j]; //  space optimized
                if (j >= w[i]) {
                    a = Integer.max(a, dp[(i - 1) % 2][j - w[i]] + v[i]); //  space optimized
                }
                dp[i % 2][j] = a;  //  space optimized
            }
        }
        return dp[n % 2][k];
    }


}

/*
Knapsnack 0/1
given n items each with a weight and value, find max value which
can be obtained by picking items such that total weight of all items  <= k
note-1 : every item can be picked at max 1 time
note-2 : we cannot take part of item
ex: n = 4 items, k = 50
n   = 1   2   3    4 (index)
w[] = 20  10  30   40
v[] = 100 60  120  150
v/w = 5   6   4    3.75

constraints :
1 <= N <= 10^3
1 <= k <= 10^3
1 <= w[i] <= 10^5
1 <= v[i] <= 10^5

idea-1 : pick greedily based on n values, pick 4 and 2, max val = 210
idea-2 : freedily pick based on v/w ratio : pick 2 and 1, max vale = 160
correct ans = pick 1 and 3 -> val = 220

sol idea-1 : generate all subset with weight <= k, get max value out of all subsets
tc: 2^n, sc: O(n)

dp state :
    dp[i, j] = max values using [1 to i] items such that total weight <= j
dp expression:
    dp[i, j] = max ( dp[i-1, j], dp[i-1, j - w[i]] + v[i]  )
dp table : dp[n+1][k+1], initialize with -1
final ans in dp[n][k]
 */