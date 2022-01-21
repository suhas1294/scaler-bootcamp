package _02_intermediate._2022_01_19._2dMatrix.homework;

import utils.Util;

import java.util.ArrayList;

public class RowToColumnZero {
    /*
    for space efficient solution refer here:
    https://leetcode.com/problems/set-matrix-zeroes/discuss/1698334/Javascript-Time-O(nm)-Space-O(1)-With-Comments
    https://leetcode.com/problems/set-matrix-zeroes/discuss/1700313/1-ms-faster-than-95.27-of-Java-online-submissions
    */

    // note : this solution uses extra space. and also its not efficient
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> cols_to_be_zeroes = new ArrayList<>();
        for (ArrayList<Integer> row: A ) {
            if (row.contains(0)){
                for (int i = 0; i < row.size(); i++) {
                    if (row.get(i) == 0 ) cols_to_be_zeroes.add(i);
                }
                for (int i = 0; i < row.size(); i++) {
                    row.set(i, 0);
                }
            }
        }

        System.out.println("col containing zeros " + cols_to_be_zeroes);
        for (Integer colNo : cols_to_be_zeroes) {
            for (int row = 0; row < A.size(); row++) {
                A.get(row).set(colNo, 0);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        /*ArrayList<ArrayList<Integer>> input = Util.TwoDArrayToList(new int[][]{
                {1,2,3,4},
                {5,6,7,0},
                {9,2,0,4}
        });
        ArrayList<ArrayList<Integer>> input = Util.TwoDArrayToList(new int[][]{
                        {97, 18, 55, 1, 50, 17, 16, 0, 22, 14},
                        {58, 14, 75, 54, 11, 23, 54, 95, 33, 23},
                        {73, 11, 2, 80, 6, 43, 67, 82, 73, 4},
                        {61, 22, 23, 68, 23, 73, 85, 91, 25, 7},
                        {6, 83, 22, 81, 89, 85, 56, 43, 32, 89},
                        {0, 6, 1, 69, 86, 7, 64, 5, 90, 37},
                        {10, 3, 11, 33, 71, 86, 6, 56, 78, 31},
                        {16, 36, 66, 90, 17, 55, 27, 26, 99, 59},
                        {67, 18, 65, 68, 87, 3, 28, 52, 9, 70},
                        {41, 19, 73, 5, 52, 96, 91, 10, 52, 21}
                });*/
        ArrayList<ArrayList<Integer>> input = Util.TwoDArrayToList(new int[][]{
                {51, 21, 90, 38, 57, 12, 11, 1, 68, 60},
                {81, 24, 63, 97, 75, 70, 23, 91, 39, 84},
                {0, 21, 97, 12, 46, 48, 50, 3, 57, 69},
                {44, 8, 42, 34, 99, 0, 98, 10, 53, 67},
                {23, 34, 43, 86, 31, 18, 9, 54, 61, 48},
                {90, 61, 21, 87, 26, 67, 88, 28, 70, 45},
                {98, 14, 5, 92, 1, 4, 44, 99, 67, 98},
                {18, 42, 32, 61, 80, 64, 32, 89, 70, 93},
                {89, 61, 7, 10, 0, 85, 29, 40, 13, 0},
                {85, 63, 66, 43, 56, 67, 99, 0, 67, 66}
        });
        Util.print2DMatrix(solve(input));
    }
}

/*
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
Specifically, make entire ith row and jth column zero.

1 <= A.size() <= 10^3
1 <= A[i].size() <= 10^3
0 <= A[i][j] <= 10^3

input format : First argument is a vector of vector of integers.(2D matrix).
output format: Return a vector of vector after doing required operations.

Input 1:
[1,2,3,4]
[5,6,7,0]
[9,2,0,4]

output:
[1,2,0,0]
[0,0,0,0]
[0,0,0,0]

explanation: A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
 */