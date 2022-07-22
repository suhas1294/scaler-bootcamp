package _03_advance._2022_07_18.dynamic_programming_1.assignments;

import java.util.Arrays;

public class DanceLand {
    // TC : O(N) | SC : O(N)
    public int solve(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);
        return ways(A, dp);
    }

    int ways(int A, int[] dp) {
        if (A == 1 || A == 2) return A;
        if (dp[A] != -1) return dp[A];
        return dp[A] = (ways(A - 1, dp) + (A - 1) * ways(A - 2, dp)) % 10003;
    }


    //----------- bottom approach ------------
    int[] dp;
    public int solve2(int A) {
        dp = new int[A + 1];
        return compute(A);
    }

    int compute(int n) {
        if (n == 1) return 1;
        //init  values
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            //first is (n-1) choices and remaining people  is (n-2) --> pair
            // second is alone party (n-1) choices
            dp[i] = ((i - 1) * dp[i - 2]) + (1 * dp[i - 1]);
        }
        return dp[n];
    }
}

/*
In Danceland, one person can party either alone or can pair up with another person.
Can you find in how many ways they can party if there are A people in Danceland?
Note: Return your answer modulo 10003, as the answer can be large.

Problem Constraints : 1 <= A <= 10^5
Input Format : Given only argument A of type Integer, number of people in Danceland.
Output Format : Return an integer denoting the number of ways people of Danceland can party.

Input 1: A = 3 Output 1: 4
Explanation 1:
 Let suppose three people are A, B, and C. There are only 4 ways to party
 (A, B, C) All party alone
 (AB, C) A and B party together and C party alone
 (AC, B) A and C party together and B party alone
 (BC, A) B and C party together and A
 here 4 % 10003 = 4, so answer is 4.

Input 2: A = 5 Output 2: 26
Explanation 2: Number of ways they can party are: 26.
 */