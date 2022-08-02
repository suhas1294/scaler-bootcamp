package _03_advance._2022_07_25.dynamic_programming_4.assignments;

import java.util.ArrayList;

public class UniquePathsInGrid {
    public int uniquePathsWithObstacles(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] memoryArr = new int[N][M];
        return dpFunction(A, memoryArr, 0, 0, N, M);
    }

    private int dpFunction(int[][] A, int[][] memoryArr, int i, int j, int N, int M) {
        if (i >= N || j >= M) return 0;
        if (i == N - 1 && j == M - 1) {
            if (A[N - 1][M - 1] != 1) {
                return 1;
            }
            return 0;
        }
        if (memoryArr[i][j] == 0 && A[i][j] != 1) {
            memoryArr[i][j] = dpFunction(A, memoryArr, i + 1, j, N, M) +
                    dpFunction(A, memoryArr, i, j + 1, N, M);
        }
        return memoryArr[i][j];
    }

    // ------------- iterative solution -----------------
    //  TC: O(n*m) SC: O(1)
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();

        if (A.get(0).get(0) == 1 || A.get(n - 1).get(m - 1) == 1)
            return 0; // Check if start or end has obstacle

        A.get(0).set(0, 2); // Since 1 is used as obstacles therefore used 2 to denote single available path

        // For loop to set all 1st column value. If not obstacles then it can contain only 2
        for (int i = 1; i < n; i++) {
            if (A.get(i).get(0) != 1 && A.get(i - 1).get(0) != 1) {
                A.get(i).set(0, 2);
            } else {
                A.get(i).set(0, 1);
            }
        }

        // For loop to set all 1st row value. If not obstacles then it can contain only 2
        for (int i = 1; i < m; i++) {
            if (A.get(0).get(i) != 1 && A.get(0).get(i - 1) != 1) {
                A.get(0).set(i, 2);
            } else {
                A.get(0).set(i, 1);
            }
        }

        // Starting from cell(1,1) check if it does not contain obstacles from top or
        // left cell then add the top and left cell value to get total num of path
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A.get(i).get(j) != 1) {
                    int top = 0;
                    int left = 0;
                    if (A.get(i - 1).get(j) != 1) {
                        top = A.get(i - 1).get(j);
                    }

                    if (A.get(i).get(j - 1) != 1) {
                        left = A.get(i).get(j - 1);
                    }
                    A.get(i).set(j, top + left);
                }
            }
        }
        // Since I used 2 to denotes available path therefore I have to divide the ans by 2
        return (A.get(n - 1).get(m - 1)) / 2;
    }

}

/*
Given a grid of size n * m, lets assume you are starting at (1,1) and your
goal is to reach (n, m). At any instance, if you are on (x, y), you can either
go to (x, y + 1) or (x + 1, y). Now consider if some obstacles are added to the grids.
How many unique paths would there be? An obstacle and empty space is marked as 1 and 0
respectively in the grid.

Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1

Input Format : Firts and only argument A is a 2D array of size n * m.
Output Format : Return an integer denoting the number of unique paths from (1, 1) to (n, m).

Input 1:

 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]

Output 1: 2
Explanation 1: Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
So, the total number of unique paths is 2.

Input 2:

 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]
Output 2:  0
Explanation 2:It is not possible to reach (n, m) from (1, 1). So, ans is 0.
 */