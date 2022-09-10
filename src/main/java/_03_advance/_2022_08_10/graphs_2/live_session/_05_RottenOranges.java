package _03_advance._2022_08_10.graphs_2.live_session;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _05_RottenOranges {
    // TC :O(nm), sc :O(nm)
    int minTime(int[][] mat, int n, int m) {
        Queue<Cell> q = new ArrayDeque<>();
        int[][] time = new int[n][m];
        for (int[] row : time) {
            Arrays.fill(row, -1);
        }
        // lets push index of all rotten oranges into q
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.add(new Cell(i, j));
                    time[i][j] = 0;
                }
            }
        }

        int[] x = {-1, 1, 0, 0}; // top bottom left right
        int[] y = {0, 0, -1, 1}; // top bottom left right

        while (!q.isEmpty()) {
            Cell d = q.poll();
            int i = d.i;
            int j = d.j;
            for (int k = 0; k < 4; k++) {
                int a = i + x[k], b = j + y[k]; // cell(a,b)
                if (a >= 0 && a < n && b >= 0 && b < m && mat[a][b] == 1) {
                    // make it rotten
                    mat[a][b] = 2;
                    time[a][b] = time[i][j] + 1;
                    q.add(new Cell(a, b));
                }

            }
        }

        int timeRequired = -1; // timeRequiredForAllMangoesToRot
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) return -1;
                timeRequired = Integer.max(timeRequired, time[i][j]);
            }
        }
        return timeRequired;
    }

    static class Cell {
        int i, j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    // --------- assignment solution ------------
    // custom object will be stored in queue
    class Pair {
        // coordinate of orange
        int i;
        int j;
        // min distance to get rotten
        int minDist;

        public Pair(int i, int j, int minDist) {
            this.i = i;
            this.j = j;
            this.minDist = minDist;
        }
    }

    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] minDistance = new int[n][m];
        // Queue for BFS traversal
        Queue<Pair> queue = new LinkedList<Pair>();

        // fill queue with rotten oranges first
        // initialize the minDistance array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 2) {
                    minDistance[i][j] = 0;
                    // store the initial rotten oranges in Queue
                    queue.add(new Pair(i, j, 0));
                } else if (A[i][j] == 0) {
                    // initialize empty spaces with INT_MIN
                    minDistance[i][j] = Integer.MIN_VALUE;
                } else {
                    minDistance[i][j] = -1;
                }
            }
        }

        // allowed directions
        int[] rows = {-1, 0, 0, 1};
        int[] cols = {0, -1, 1, 0};

        while (!queue.isEmpty()) {
            Pair x = queue.poll();
            // new distance
            int dist = x.minDist + 1;
            for (int k = 0; k < rows.length; k++) {
                int new_i = x.i + rows[k];
                int new_j = x.j + cols[k];

                // insert into queue only when orange is fresh and valid coordinates are present
                if (new_i >= 0 && new_j >= 0 && new_i < n && new_j < m && A[new_i][new_j] == 1) {
                    // mark the orange as rotten
                    A[new_i][new_j] = 2;
                    // add new rotten orange to queue
                    queue.add(new Pair(new_i, new_j, dist));
                    // update distance
                    minDistance[new_i][new_j] = dist;
                }
            }
        }

        // find max element from matrix
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (minDistance[i][j] == -1) {
                    // if it is not possible to rot any of the oranges
                    max = -1;
                    break;
                }
                max = Math.max(minDistance[i][j], max);
            }
            if (max == -1)
                break;
        }

        return max;
    }
}

/*
given a matrix, which can consists of only 3 values and those3 values denotes state of orange
0 - empty
1 - fresh
2 - rotten
every minute any fresh orange - adjacent to a rotten orange becomes rotten.
find the minimum time when all the oranges become rotten.
if not possible return -1;


------------------ assignment description ----------------

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
Each cell can have three values:
The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom)
to a rotten orange becomes rotten. Return the minimum number of minutes that must
elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
Note: Your solution will run on multiple test cases. If you are using global variables,
make sure to clear them.

Problem Constraints
1 <= N, M <= 1000
0 <= A[i][j] <= 2

Input Format :The first argument given is the integer matrix A.
Output Format :Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.

Input 1:
A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Output 1: 4

Input 2:
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]
Output 2: -1

Explanation 1: Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
Explanation 2: Task is impossible
 */