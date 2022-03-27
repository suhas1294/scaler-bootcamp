package _03_advance._2022_03_16.arrays_2.live_session;

public class _03_SumOfAllSubmatrixSums {
    public static int sumOfAllSubMatrix(int[][] A){
        int n = A.length;
        int m = A[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // in how many sub matrices, A[i][j] is present.
                int contribution = A[i][j] * (i+1) * (j+1) * (n-i) * (m-j);
                ans += contribution;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {8, 9, 9, 1, 7},
                {5, 5, 10, 1, 0},
                {7, 7, 5, 8, 6},
                {7, 3, 7, 9, 2},
                {7, 7, 8, 10, 6}
        };
        System.out.println(sumOfAllSubMatrix(arr)); // 7551
    }
}

/*
given a matrix of size nxm, calculate sum of all submatrix sums.
use contribution technique.
TC: O(nxm)
sc: O(1)
 */