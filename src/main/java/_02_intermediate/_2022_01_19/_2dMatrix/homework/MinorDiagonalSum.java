package _02_intermediate._2022_01_19._2dMatrix.homework;

import utils.Util;

import java.util.ArrayList;
import java.util.List;

public class MinorDiagonalSum {
    public static int solve(final List<ArrayList<Integer>> A) {
        int sum = 0;
        int row = A.size();
        int col = A.get(0).size();
        int i = 0;
        int j = col - 1;
        while (i < row && j>=0){
            System.out.println("i = " + i + " j = " + j);
            sum += A.get(i).get(j);
            i++;
            j--;
        }
        //for loop equivalent
        /*for (int i = 0, j = A[0].length -1 ; i < A.length && j>=0; i++, j--) {
            sum += A[i][j];
        }*/
        return sum;
    }

    public static int solve2(final List<ArrayList<Integer>> A) {
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if (i  + j == A.size() - 1) {
                    System.out.printf("i = %d, j = %d\n", i, j);
                    sum += A.get(i).get(j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        /*ArrayList<ArrayList<Integer>> input = Util.TwoDArrayToList(new int[][]{
                {47, -59, 20, 33, 20, -47, -87, -59, 85},
                {8, -67, 48, -10, -23, -68, -28, 62, -94},
                {-50, 77, -39, -57, 15, 71, 44, 13, -53},
                {-30, 43, -92, -94, 42, 37, 95, 7, 19},
                {-1, 92, -85, 20, -53, -16, 31, -95, 4},
                {-62, 49, 0, 53, -93, -61, -49, 86, 97},
                {62, -26, -1, -38, 59, -93, -93, 12, -90},
                {78, 85, 90, 89, -65, 5, 48, 40, -86},
                {-79, -68, -89, 90, -40, 47, 68, -25, 92}
        }); // 233*/
        ArrayList<ArrayList<Integer>> input = Util.TwoDArrayToList(new int[][]{
                {1, -2, -3},
                {-4, 5, -6},
                {-7, -8, 9}
        }); // -5
    }
}

/*
You are given a N X N integer matrix. You have to find the sum of
all the minor diagonal elements of A. Minor diagonal of a M X M matrix A
is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).

1 <= N <= 103
-1000 <= A[i][j] <= 1000

input format: First and only argument is a 2D integer matrix A.
output format: Return an integer denoting the sum of minor diagonal elements.

Input 1:
 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
output: -5
explanation:  A[1][3] + A[2][2] + A[3][1] = (-3) + 5 + (-7) = -5

Input 2:
 A = [[3, 2],
      [2, 3]]
output : 4
explanation:  A[1][2] + A[2][1] = 2 + 2 = 4
 */