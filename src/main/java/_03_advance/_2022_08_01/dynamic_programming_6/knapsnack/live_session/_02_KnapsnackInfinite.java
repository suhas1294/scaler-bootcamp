package _03_advance._2022_08_01.dynamic_programming_6.knapsnack.live_session;

import java.util.Arrays;

public class _02_KnapsnackInfinite {

    public int solve(int A, int[] B, int[] C) {
        int W = A;
        int[] dp = new int[W + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i <= W; i++)
            for (int j = 0; j < B.length; j++)
                if (C[j] <= i)
                    dp[i] = Math.max(dp[i], dp[i - C[j]] + B[j]);
        return dp[W];
    }

    //  --------------- alternate solution -----------

    public int solve2(int A, int[] B, int[] C) {
        return knapsack(B, C, A, B.length);
    }
    
    public int knapsack(int[] val, int[] wt, int max_cap, int n) {
        int[] dp = new int[max_cap + 1];
        dp[0] = 0;
        for (int bagc = 1; bagc <= max_cap; bagc++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (wt[i] <= bagc) {
                    int rem_bag_c = bagc - wt[i];
                    int rem_bag_val = dp[rem_bag_c];
                    int tot_bag_val = val[i] + rem_bag_val;
                    if (max < tot_bag_val) {
                        max = tot_bag_val;
                    }
                }
            }
            dp[bagc] = max;
        }
        return dp[max_cap];
    }

}

/*
Given a knapsack weight A and a set of items with certain value B[i] and
weight C[i], we need to calculate maximum amount that could fit in this quantity.
This is different from classical Knapsack problem, here we are allowed to use
unlimited number of instances of an item.

Problem Constraints
1 <= A <= 1000
1 <= |B| <= 1000
1 <= B[i] <= 1000
1 <= C[i] <= 1000

Input Format
First argument is the Weight of knapsack A
Second argument is the vector of values B
Third argument is the vector of weights C

Output Format : Return the maximum value that fills the knapsack completely

Input 1: A = 10 B = [5] C = [10] Output 1: 5
Explanation 1: Only valid possibility is to take the given item.

Input 2: A = 10 B = [6, 7] C = [5, 5] Output 2: 14
Explanation 2:Take the second item twice.
 */