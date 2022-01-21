package _02_intermediate._2022_01_19._2dMatrix.assignments;

import java.util.ArrayList;

public class MatrixTranspose {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int j = 0; j < A.get(0).size(); j++) {
            ArrayList<Integer> tCol = new ArrayList<>();
            for (int i = 0; i < A.size(); i++) {
                tCol.add(A.get(i).get(j));
            }
            transpose.add(tCol);
        }
        return transpose;
    }
}
/*
You are given a matrix A, you have to return another matrix which is the transpose of A.
NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row

1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000

input format: First argument is vector of vector of integers A representing matrix.
output format: You have to return a vector of vector of integers after doing required operations.

Input 1: A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]], ouput : [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
explanation: Cearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]] we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].

Input 2: A = [[1, 2],[1, 2],[1, 2]], output : [[1, 1, 1], [2, 2, 2]]
 */