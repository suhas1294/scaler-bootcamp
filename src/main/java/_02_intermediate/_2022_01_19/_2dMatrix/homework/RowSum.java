package _02_intermediate._2022_01_19._2dMatrix.homework;

import java.util.ArrayList;

public class RowSum {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> rowSum = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int sum = 0;
            for (int j = 0; j < A.get(0).size(); j++) {
                sum += A.get(i).get(j);
            }
            rowSum.add(sum);
        }
        return rowSum;
    }
}
/*
You are given a 2D integer matrix A, return a 1D integer vector containing row-wise sums of original matrix.
1 <= A.size() <= 10^3
1 <= A[i].size() <= 10^3
1 <= A[i][j] <= 10^3

First argument is a vector of vector of integers.(2D matrix).
Return a vector conatining row-wise sums of original matrix.


Input 1:
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]

output : {10,26,18}

explanation:
Row 1 = 1+2+3+4 = 10
Row 2 = 5+6+7+8 = 26
Row 3 = 9+2+3+4 = 18
 */
