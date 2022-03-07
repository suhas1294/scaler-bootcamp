package _02_intermediate._2022_02_18.subset_subsequence.live_session;

import java.util.Arrays;

public class SumOfMaxOfEverySubSequence {
    public static int solve(int[] A) {
        // sort in ascending
        Arrays.sort(A);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (A[i] * (1 << i)); // (1 << i) is nothing but 2^i
        }
        return sum;
    }
}

/*
Given an array , find the sum of (max of every sub sequence)
 */
