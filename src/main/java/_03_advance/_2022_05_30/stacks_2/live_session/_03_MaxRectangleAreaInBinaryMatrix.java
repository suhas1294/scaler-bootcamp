package _03_advance._2022_05_30.stacks_2.live_session;

public class _03_MaxRectangleAreaInBinaryMatrix {

    public static int getMaxArea(int[][] A){
        int n = A.length;
        int m = A[0].length;
        int[] tmp = new int[m];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            tmp[i] = A[0][i];
        }
        ans = Math.max(ans, _02_MaxRectangularAreaInHistogram.getMaxArea(tmp));

        // for each row (from 1st row), add prev row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] != 0) {
                    tmp[j] += A[i][j];
                }else{
                    tmp[j] = 0;
                }
            }
            ans = Math.max(ans, _02_MaxRectangularAreaInHistogram.getMaxArea(tmp));
        }
        return ans;
    }

    // TC: O(n * m), SC: O(n * m)
    public static int getMaxArea2(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] tmp = new int[n][m];
        int ans = 0;

        // copy first row of input to our ans
        for (int i = 0; i < m; i++) {
            tmp[0][i] = mat[0][i];
        }

        // for each row (from 1st row), add prev row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 0) {
                    tmp[i][j] += tmp[i - 1][j];
                }else{
                    tmp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, _02_MaxRectangularAreaInHistogram.getMaxArea(tmp[i]));
        }

        return ans;
    }
}

/*
given a binary matrix containing 1 & 0, find max rectangular
area which contains all 1's
 */