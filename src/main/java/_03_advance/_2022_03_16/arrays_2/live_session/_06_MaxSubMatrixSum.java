package _03_advance._2022_03_16.arrays_2.live_session;

import mentor_session._2021_12_28.mock_interview.KadaneMaxSumInSubArray;

public class _06_MaxSubMatrixSum {
    public static int getMaxSum(int[][] A){
        int rows = A.length;
        int col = A[0].length;
        int ans = A[0][0];
        for (int startAtRow = 0; startAtRow < rows; startAtRow++) { // sub matrix whose row can start anywhere
            int[] pf = new int[col];
            for (int end = startAtRow; end < rows; end++) { // sub matrix whose column can end anywhere
                // add data at end row to your pf[]
                for (int i = 0; i < col; i++) {
                    pf[i] = pf[i] + A[end][i];
                }
                // apply kadane on 1d array now.
                ans = Integer.max(ans, KadaneMaxSumInSubArray.maxSubArraySum(pf));
            }
        }
        return ans;
    }
}

/*
Given a matrix nxm, find max sub matrix sum.
where sub matrix starts with any row and ends anywhere.
TC: O(N^2 * (m+m)) ~ O(n^2 + m)
sc: o(m)

 */