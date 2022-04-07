package _03_advance._2022_03_25.bit_manipulation.live_session;

import utils.Util;

public class _03_MaxSubMatrixSumSortedMatrix {
    public static int maxSubMatrixSum(int[][] mat){
        // step-1 : construct prefix matrix
        int[][] pf = Util.prefixSumMatrixMutate(mat);

        // required variables
        int ans = Integer.MIN_VALUE;
        int a2 = mat.length-1, b2 = mat[0].length-1; // bottom right corner element

        // find the top left of the result sub matrix, say (a1 and b1 are coordinates for top left)
        for (int a1 = 0; a1 < mat.length ; a1++) {
            for (int b1 = 0; b1 < mat[0].length; b1++) {
                // calculate sub matrix sub defined by top left and bottom right
                // TL  : a1, b1
                // BR  : a2, b2
                int tempRes = mat[a2][b2];
                if (b1 > 0) tempRes = tempRes -  pf[a2][b1-1];
                if (a1 > 0) tempRes = tempRes - pf[a1-1][b2];
                if (a1 > 0 && b1 > 0) tempRes = tempRes + pf[a1-1][b1-1];
                ans = Integer.max(ans, tempRes);
            }
        }

        return ans;
    }
}

/*
given a matrix of nxm which is sorted both row wise and column wise,
calculate max sub matrix sum.

Hint : since row and column are sorted, our bottom-right corer is
fixed since that is largest element since its fixed.

If all elements of matrix is positive, then sum of all elements of matrix is ans
If all elements of matrix is negative, then single element i.e., bottom right element should be ans.


 */