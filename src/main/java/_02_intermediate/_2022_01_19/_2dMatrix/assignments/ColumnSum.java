package _02_intermediate._2022_01_19._2dMatrix.assignments;

import java.util.ArrayList;

public class ColumnSum {
    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int cols = A.get(0).size();
        int rows = A.size();
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += A.get(i).get(j);
            }
            result.add(colSum);
        }
        return result;
    }
}

/*
You are given a 2D integer matrix A, return a 1D integer vector containing column-wise sums of original matrix.
1 <= A.size() <= 10^3
1 <= A[i].size() <= 10^3
1 <= A[i][j] <= 10^3
input : First argument is a vector of vector of integers.(2D matrix).
output: Return a vector conatining column-wise sums of original matrix.

Input 1:

[1,2,3,4]
[5,6,7,8]
[9,2,3,4]

output : {15,10,13,16}

explanation:
Column 1 = 1+5+9 = 15
Column 2 = 2+6+2 = 10
Column 3 = 3+7+3 = 13
Column 4 = 4+8+4 = 16
 */