package _02_intermediate._2022_01_19._2dMatrix.assignments;

import utils.Util;

import java.util.ArrayList;

public class MatrixMultiplication {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int cols = B.get(0).size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> row: A ) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int jB = 0; jB < cols; jB++) {
                // for each element in A'th row, multiply B's column
                int sum = 0;
                for (int i = 0; i < A.get(0).size(); i++) {
                    sum += ( row.get(i) * B.get(i).get(jB));
                }
                arr.add(sum);
            }
            result.add(arr);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] b = {
                {1, 3},
                {2, 8},
                {1, 0}
        };
        /*
        expected: [
            [8, 19],
            [20, 52]
            [32, 85]
        ]
         */

        /*int[][] a = {
                {94, 91}
        };
        int[][] b = {
                {35, -52, -12, 26, -93, -61},
                {29, -20, -36, -9, 66, 15}
        }; // expected : {5929 -6708 -4404 1625 -2736 -4369 } */
        Util.print2DMatrix(solve(Util.TwoDArrayToList(a), Util.TwoDArrayToList(b)));
    }
}

/*
You are given two integer matrices A(having M X N size) and B(having N X P). You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).

1 <= M, N, P <= 100
-100 <= A[i][j], B[i][j] <= 100

input format:
First argument is a 2D integer matrix A.
Second argument is a 2D integer matrix B.

output: Return a 2D integer matrix denoting AB.

Input 1:
 A = [[1, 2],            B = [[5, 6],
      [3, 4]]                 [7, 8]]
output:
  [[19, 22],
  [43, 50]]

Input 2:
 A = [[1, 1]]            B = [[2],
                              [3]]

output: [[5]]
explanation: [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]
 */