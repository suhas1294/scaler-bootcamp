package _03_advance._2022_03_25.bit_manipulation.live_session;

import utils.Util;

public class _04_MaxFixedSubMatrixSumSortedMatrix {
    public static int maxSubMatrixSum(int[][] mat, int B){
        // step-1 : construct prefix matrix
        int[][] pf = Util.prefixSumMatrixMutate(mat);

        // required variables
        int ans = Integer.MIN_VALUE;
        int a2 = mat.length-1, b2 = mat[0].length-1; // bottom right corner element

        // find the top left of the result sub matrix, say (a1 and b1 are coordinates for top left)
        for (int a1 = 0; a1 < mat.length ; a1++) {
            for (int b1 = 0; b1 < mat.length; b1++) { // bcoz input matrix is square matrix
                // calculate sub matrix sub defined by top left and bottom right
                // TL  : a1, b1
                // BR  : a2, b2
                a2 = a1 + B -1;
                b2 = b1 + B -1;
                if (a2 < mat.length && b2 < mat.length){ // submatrix should not go out of index
                    int tempRes = mat[a2][b2];
                    if (b1 > 0) tempRes = tempRes -  pf[a2][b1-1];
                    if (a1 > 0) tempRes = tempRes - pf[a1-1][b2];
                    if (a1 > 0 && b1 > 0) tempRes = tempRes + pf[a1-1][b1-1];
                    ans = Integer.max(ans, tempRes);
                }
            }
        }

        return ans;
    }
}

/*
given a Square matrix of nxm which is sorted both row wise and column wise,
calculate max sub matrix sum. where submatrix is defined by bxb given where b is given in question.
 */