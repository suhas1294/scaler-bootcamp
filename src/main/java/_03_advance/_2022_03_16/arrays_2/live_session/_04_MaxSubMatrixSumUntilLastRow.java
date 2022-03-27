package _03_advance._2022_03_16.arrays_2.live_session;

import mentor_session._2021_12_28.mock_interview.KadaneMaxSumInSubArray;

public class _04_MaxSubMatrixSumUntilLastRow {
    public static int getMax(int[][] mat){
        int n = mat.length; // no of rows
        int m = mat[0].length; // no of columns
        int[] pf = new int[mat[0].length];
        for (int col = 0; col < m; col++) {
            for (int row = 1; row < n; row++) {
                pf[col] = pf[col] + mat[row][col];
            }
        }
        return KadaneMaxSumInSubArray.maxSubArraySum(pf);
    }
}

/*
Given a matrix nxm, find max sub matrix sum.
where sub matrix starts with row 0 and ends with n-1
 */