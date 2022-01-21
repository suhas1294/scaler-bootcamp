package _02_intermediate._2022_01_19._2dMatrix.homework;

import java.util.ArrayList;
import java.util.List;

public class MainDiagonalSum {
    public int solve(final List<ArrayList<Integer>> A) {
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i).get(i);
        }
        return sum;
    }
}

/*
You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.
Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.

1 <= N <= 10^3
-1000 <= A[i][j] <= 1000

First and only argument is a 2D integer matrix A.
Return an integer denoting the sum of main diagonal elements.

Input 1:
 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
output : 15
explanation: A[1][1] + A[2][2] + A[3][3] = 1 + 5 + 9 = 15

Input 2:
 A = [[3, 2],
      [2, 3]]
output : 6
explanation: A[1][1] + A[2][2] = 3 + 3 = 6
 */