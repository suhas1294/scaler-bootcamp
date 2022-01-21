package _02_intermediate._2022_01_19._2dMatrix.homework;

import java.util.ArrayList;

public class MatrixScalerProduct {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        //ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                int prod = A.get(i).get(j) * B;
                A.get(i).set(j, prod);
            }
        }
        return A;
    }
}

/*
You are given a matrix A and and an integer B, you have to perform scalar multiplication of matrix A with an integer B.

1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000
1 <= B <= 1000

input format:
First argument is vecotor of vector of integers A representing matrix.
Second argument is an integer B.

output format:
You have to return a vector of vector of integers after doing required operations.

input : A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]] B = 2
output : [[2, 4, 6], [8, 10, 12], [14, 16, 18]]

explanation:
==> ( [[1, 2, 3],[4, 5, 6],[7, 8, 9]] ) * 2
==> [[2*1, 2*2, 2*3],[2*4, 2*5, 2*6],[2*7, 2*8, 2*9]]
==> [[2, 4, 6], [8, 10, 12], [14, 16, 18]]


 */