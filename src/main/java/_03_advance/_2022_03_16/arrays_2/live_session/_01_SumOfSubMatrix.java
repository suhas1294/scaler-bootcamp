package _03_advance._2022_03_16.arrays_2.live_session;

import utils.Util;

import java.util.Arrays;

public class _01_SumOfSubMatrix {
    public static int[] getSubMatrixSum(int[][] arr, int[][] queries){
        // step-1 : calculate prefix matrix sum
        int[][] pf = Util.prefixSumMatrix(arr);
        // step-2 : calculate and return ans for each queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int a1 = query[0];
            int b1 = query[1];

            int a2 = query[2];
            int b2 = query[3];

            /*int res = 0;
            if (b1 > 0 && a1 > 0){
                res = arr[a2][b2] - arr[a2][b1-1] - arr[a1-1][b2] + arr[a1-1][b1-1];
            }*/
            int res = arr[a2][b2];
            if (b1 > 0) res = res-  pf[a2][b1-1];
            if (a1 > 0) res = res - pf[a1-1][b2];
            if (a1 > 0 && b1 > 0) res = res + pf[a1-1][b1-1];
            ans[i] = res;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2, -1, 3, 2},
                {3, 2, 6, 2},
                {10, 9 , 8, 2},
                {4, -1, 2 , 3},
                {3, 2, 6, 9}
        };
        int[][] queries = {
                {2, 1, 4, 2} // TL : (2,1), BR: (4, 2)
        };
        System.out.println(Arrays.toString(getSubMatrixSum(arr, queries)));
    }
}

/*
Given a matrix of size nxm, for each query q, find the sum of given sub matrix.
note : A submatrix can be fixed if (TL and BR) are fixed OR (TR and BL) are fixed.
for our discussion sake, in all out problems, (TL and BR) are fixed
ex:
2  -1  3  2
3   2  6  2
10  9  8  2
4  -1  2  3
3   2  6  9

tl : 2, 1
br : 4, 2
sum : 9 + 8 -1 + 2 + 2 + 6 = 26

TL : a1,  b1
BR : a2, b2
sum  = PF[a2, b2] - PF[a2, b1-1] - PF[a1-1, b2]  + PF[a1-1, b1-1]

 */