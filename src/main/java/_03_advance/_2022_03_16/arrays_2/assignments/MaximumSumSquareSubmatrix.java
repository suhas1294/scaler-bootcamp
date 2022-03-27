package _03_advance._2022_03_16.arrays_2.assignments;

import mentor_session._2021_12_28.mock_interview.KadaneMaxSumInSubArray;

public class MaximumSumSquareSubmatrix {
    public static int solve(int[][] A, int B) {
        int rows = A.length;
        int col = A[0].length;

        int ans = A[0][0];
        for (int startAtRow = 0; startAtRow <= (rows - B); startAtRow++) { // sub matrix whose row can start anywhere
            int[] pf = new int[col];
            for (int end = startAtRow; end < startAtRow + B; end++) { // sub matrix whose column can end anywhere
                // add data at end row to your pf[]
                for (int i = 0; i < B; i++) {
                    pf[i] = pf[i] + A[end][i];
                }
                // apply kadane on 1d array now.
                ans = Integer.max(ans, KadaneMaxSumInSubArray.maxSubArraySum(pf));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {-67, -31, 42, -56, -84, -19, 98, 22, -49, -79},
                {-1, 57, -24, -8, 89, -25, 12, -100, 10, -97},
                {-31, -39, -12, -99, 89, -45, -77, -98, 85, 82},
                {-15, -12, -74, -83, 57, -68, 32, 69, 54, 21},
                {89, 76, 29, 68, -8, -75, 55, -66, 49, -59},
                {12, 45, -40, 18, 53, 39, -77, -21, 96, -13},
                {29, 49, -63, -34, 49, 93, 95, -3, -84, -14},
                {5, -12, -18, -45, 34, 14, 1, 16, -29, 86},
                {-37, 13, 55, 85, -47, 12, -92, -68, 45, 13},
                {56, 21, 58, -54, 82, -19, 44, 96, -78, 29}
        };
        int B = 2;
        System.out.println(solve(arr, B)); // 242
    }
}

/*
Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1,
such that the sum of all the elements in the submatrix is maximum.

Problem Constraints
1 <= N <= 10^3.
1 <= B <= N
-10^2 <= A[i][j] <= 10^2.

Input Format : First arguement is an 2D integer matrix A. Second argument is an integer B.
Output Format : Return a single integer denoting the maximum sum of submatrix of size B x B.

Example Input
Input 1:

 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
Input 2:

 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2


Example Output
Output 1: 48
Output 2: 8

Explanation 1:
    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48

Explanation 2:
 Maximum sum 2 x 2 matrix is
  2 2
  2 2
  Sum = 8
 */