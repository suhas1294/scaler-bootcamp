package _02_intermediate._2022_01_19._2dMatrix.assignments;

import utils.Util;

import java.util.ArrayList;

//credits: https://leetcode.com/problems/spiral-matrix-ii/discuss/1703964/Java-Solution
public class GenerateMatrixInSpiralPattern {
	public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
		int n=1;
		// int[][] spiralMatrix = new int[A][A];
		ArrayList<ArrayList<Integer>> spiralMatrix = new ArrayList<>();
		// fill arraylist with zero
		for (int i = 1; i <= (A * A); i+=A) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = i; j <= i+(A-1); j++) { row.add(0);}
			spiralMatrix.add(row);
		}

		int left = 0;
		int right = A-1;
		int top = 0;
		int bottom = A-1;
		int direction = 0;
		while (top <= bottom && left <= right) {
			if (direction == 0) {
				for (int i = left; i <= right; i++) {
					spiralMatrix.get(top).set(i, n++);
					// spiralMatrix[top][i] = n++;
				}
				top++;
			}
			if (direction == 1) {
				for (int i = top; i <= bottom; i++) {
					spiralMatrix.get(i).set(right, n++);
					// spiralMatrix[i][right] = n++;
				}
				right--;
			}
			if (direction == 2) {
				for (int i = right; i >= left; i--) {
					spiralMatrix.get(bottom).set(i, n++);
					// spiralMatrix[bottom][i] = n++;
				}
				bottom--;
			}
			if (direction == 3) {
				for (int i = bottom; i >= top; i--) {
					spiralMatrix.get(i).set(left, n++);
					// spiralMatrix[i][left] = n++;
				}
				left++;
			}
			direction = (direction + 1) % 4;
		}
		return spiralMatrix;
	}

	public static void main(String[] args) {
		Util.print2DMatrix(generateMatrix(1));
	}
}

/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
1 <= A <= 1000
input foramt: First and only argument is integer A
output format: Return a 2-D matrix which consists of the elements in spiral order.

input 1 : [ [1, 2], [4, 3] ]
output : [ [1, 2], [4, 3] ]
1 --> 2
      |
      |
4<--- 3

input 2 : 1
output: [ [1] ]
Only 1 is to be arranged.

 */