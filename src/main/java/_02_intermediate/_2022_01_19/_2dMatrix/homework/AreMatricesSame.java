package _02_intermediate._2022_01_19._2dMatrix.homework;

import java.util.ArrayList;

public class AreMatricesSame {
    public static int solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if (A.get(i).get(j) != B.get(i).get(j)) return 0;
            }
        }
        return 1;
    }
}

/*
You are given two two matrices A & B of equal sizes and you have to check whether two matrices are equal or not.
NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j in the given range.

1 <= A.size(), B.size() <= 1000
1 <= A[i].size(), B[i].size() <= 1000
1 <= A[i][j], B[i][j] <= 1000

input format:
First argument is vecotor of vector of integers representing matrix A.
Second argument is vecotor of vector of integers representing matrix B.

output format : Return 1 if both matrices are equal or return 0.

Input 1:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
output : 1
Clealry all the elements of both matrices are equal at respective postions.

Input 2:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[1, 2, 3],[7, 8, 9],[4, 5, 6]]
output : 0
Clealry all the elements of both matrices are not equal at respective postions.
 */