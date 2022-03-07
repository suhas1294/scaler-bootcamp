package _02_intermediate._2022_02_18.subset_subsequence.live_session;

import java.util.Arrays;

public class SumOf_MaxMinDiffInEverySubset {
    public static int solve(int[] A){
        Arrays.sort(A);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int max = A[i] * (1 << i);
            int min = A[i] * (1 << A.length-i-1);
            sum += (max-min);
        }
        return sum;
    }
}

/*
Given an array , find the sum of (max-min of every sub sequence)
 */