package _03_advance._2022_03_16.arrays_2.live_session;

import mentor_session._2021_12_28.mock_interview.KadaneMaxSumInSubArray;

public class _05_MaxSubMatrixSumUntilAnyRow {
    public static int getMaxSum(int[][] mat){
        int rows = mat.length;
        int col = mat[0].length;

        int ans = mat[0][0];
        int[] pf = new int[col];
        for (int end = 0; end < rows; end++) { // end  = 0 because question says only those sub matricies which start from row 0
            // add data at end row to your pf[]
            for (int i = 0; i < col; i++) {
                pf[i] = pf[i] + mat[end][i];
            }
            // apply kadane on 1d array now.
            ans = Integer.max(ans, KadaneMaxSumInSubArray.maxSubArraySum(pf));
        }
        return ans;
    }
}

/*
Given a matrix nxm, find max sub matrix sum.
where sub matrix starts with row 0 and ends anywhere. (can end at 0th row / 1st row /2nd row / ... nth row)
 */