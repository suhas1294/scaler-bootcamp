package _02_intermediate._2022_01_19._2dMatrix.assignments;

import utils.Util;

import java.util.ArrayList;

public class AddTheMatrices {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> curRow = new ArrayList<>();
            for (int j = 0; j < A.get(i).size(); j++) {
                curRow.add(A.get(i).get(j) + B.get(i).get(j));
            }
            result.add(curRow);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int[][] b = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        ArrayList<ArrayList<Integer>> A = Util.TwoDArrayToList(a);
        ArrayList<ArrayList<Integer>> B = Util.TwoDArrayToList(b);
        Util.print2DMatrix(solve(A, B));
    }
}

/*
You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.

1 <= A.size(), B.size() <= 1000
1 <= A[i].size(), B[i].size() <= 1000
1 <= A[i][j], B[i][j] <= 1000

First argument is vector of vector of integers representing matrix A.
Second argument is vecotor of vector of integers representing matrix B.
You have to return a vector of vector of integers after doing required operations.

input :
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]

output : [[10, 10, 10], [10, 10, 10], [10, 10, 10]]

explanation:
A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10, 10, 10]].
 */