package beginner._2021_12_15.homework;

import java.util.ArrayList;
import java.util.Arrays;

/*
You are given a n x n 2D matrix A representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note: If you end up using an additional array, you will only receive partial score.

1 <= n <= 1000
input format: First argument is a 2D matrix A of integers
output format:  Return the 2D rotated matrix.

input1 :
[
    [1, 2],
    [3, 4]
 ]

 output1:
 [
    [3, 1],
    [4, 2]
 ]

 input 2:
 [
    [1]
 ]
 output 2:
 [
    [1]
 ]

Explanation 1:
After rotating the matrix by 90 degree:
1 goes to 2, 2 goes to 4
4 goes to 3, 3 goes to 1

Explanation 2: 2D array remains the ssame as there is only element.
*/
public class RotateMatrix {
    public static void main(String[] args) {
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(7);
        row3.add(8);
        row3.add(9);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        solve(matrix);
    }

    // optimal solution without extra using extra array
    public static void solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();

        // take transpose
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <= n-1; j++) {
                if (i != j){
                    int v1 = A.get(i).get(j);
                    int v2 = A.get(j).get(i);
                    A.get(i).set(j, v2);
                    A.get(j).set(i, v1);
                }
            }
        }
        //System.out.println("--- transposed matrix ---");
        //print2dMatrix(A);

        // reverse each row
        for (ArrayList<Integer> row: A) {
            int left = 0;
            int right = row.size()-1;
            while (left < right){
                int temp = row.get(left);
                row.set(left, row.get(right));
                row.set(right, temp);
                left++;
                right--;
            }
        }
        //System.out.println("--- 90 deg rotated matrix ---");
        //print2dMatrix(A);
        StringBuilder sb = new StringBuilder();

        for (ArrayList<Integer> row: A) {
            sb.append("[");
            for (int num: row) {
                sb.append(num + " ");
            }
            sb.append("] ");
        }
        System.out.println(sb);
        for (ArrayList<Integer> row: A) {
            System.out.print("[");
            for (int num: row) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
    }

    // extra space complexity
    public static void solve2(ArrayList<ArrayList<Integer>> A) {
        int n = A.get(0).size();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n-i-1] = A.get(i).get(j);
            }
        }
        for (int[] row: matrix) {
            System.out.print("[");
            for (int num: row) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    static void print2dMatrix(int[][] arr2d){
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d.length; j++) {
                System.out.print(arr2d[i][j] + "\t");
            }
            System.out.println();
        }
    }
    static void print2dMatrix(ArrayList<ArrayList<Integer>> arr2d){

        for (int i = 0; i < arr2d.size(); i++) {
            for (int j = 0; j < arr2d.size(); j++) {
                System.out.print(arr2d.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
}
