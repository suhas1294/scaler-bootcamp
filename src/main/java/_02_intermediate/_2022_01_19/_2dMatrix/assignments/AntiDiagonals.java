package _02_intermediate._2022_01_19._2dMatrix.assignments;

import utils.Util;

import java.util.ArrayList;

public class AntiDiagonals {
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // step-1 : print anti diagonaly elements which start from first row
        for (int j = 0; j < A.size(); j++) {
            int i = 0, k = j;
            int noOfZerosToBeAdded = A.size() - j - 1;
            ArrayList<Integer> row = new ArrayList<>();
            while(k >= 0){
                row.add(A.get(i).get(k));
                i++;
                k--;
            }
            for (int l = 0; l < noOfZerosToBeAdded; l++) {
                row.add(0);
            }
            result.add(row);
        }
        // step-2 : print anti diagonaly elements which start from last column
        for (int i = 1; i < A.size(); i++) {
            int row = i, col = A.size() - 1;
            ArrayList<Integer> arr = new ArrayList<>();
            int noOfZerosToBeAdded = i;
            while(row <= A.size()-1){
                arr.add(A.get(row).get(col));
                row++;
                col--;
            }
            for (int j = 0; j < noOfZerosToBeAdded; j++) {
                arr.add(0);
            }
            result.add(arr);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Util.print2DMatrix(diagonal(Util.TwoDArrayToList(arr)));
    }
}

/*
Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
1<= N <= 1000
1<= A[i][j] <= 1e9
input format:
First argument is an integer N, denoting the size of square 2D matrix.
Second argument is a 2D array A of size N * N.

output format:
Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.

Input 1:
3
1 2 3
4 5 6
7 8 9

Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0

explanation:
The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].

Input 2:
1 2
3 4

Output 2:
1 0
2 3
4 0

explanation:
The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].
 */