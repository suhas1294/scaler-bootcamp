package _03_advance._2022_07_15.backtracking_3.assignments;

public class RatInMaze {
    //TC: O(MxN) - each array element will be visited only once
    //SC: O(NxM) - max-height of the recursion tree will be N
    public int[][] solve(int[][] A) {
        // initialize n, m and path array
        int N = A.length;
        int M = A[0].length;
        int[][] path = new int[N][M];
        // start with [0,0] position
        traverse(0, 0, A, path, N, M);
        return path;
    }

    public boolean traverse(int i, int j, int[][] A, int[][] path, int n, int m) {

        // base conditions to check if path is found
        if (i + 1 == n && j + 1 == m) {
            // path found
            path[i][j] = A[i][j];
            return true;
        }

        // base conditions where we can't move next
        if (i < 0 || j < 0 || i >= n || j >= m || A[i][j] == 2 || A[i][j] == 0) {
            return false;
        }

        // update path
        path[i][j] = A[i][j];
        // mark as visited
        A[i][j] = 2;

        if (traverse(i + 1, j, A, path, n, m) || traverse(i, j + 1, A, path, n, m)) {
            return true;
        }
        // revert path state as we are backtracking
        path[i][j] = 0;
        // mark as unvisited
        A[i][j] = 1;
        return false;
    }

    // ---------- alternate ans --------------

    // Assumption: return maze[row][col] is valid or not.
    boolean probeRatPathInMaze(int[][] maze, int[][] pathInMaze, int N, int row, int col) {
        // Base Case I
        // When we’re at maze[N-1][N-1] && there’s a path to
        // maze[N-1][N-1], (i.e., maze[N-1][N-1] == 1), we mark the
        // route as 1 in pathInMaze[N-1][N-1], and return true.
        if (row == N - 1 && col == N - 1 && maze[row][col] == 1) {
            pathInMaze[row][col] = 1;
            return true;
        }

        // Base Case II
        if (row == N || col == N) { // either row or col is exhausted
            return false;
        }

        // Main Logic
        if (maze[row][col] == 1) {
            pathInMaze[row][col] = 1;

            // go right and explore
            if (probeRatPathInMaze(maze, pathInMaze, N, row, col + 1)) {
                return true;
            }


            // go down and explore
            if (probeRatPathInMaze(maze, pathInMaze, N, row + 1, col)) {
                return true;
            }

            // Reset the value in the path
            // NOTE: we can only reset a marked path to 0, because
            // the other probed paths are invalid, and hence the
            // above 2 if conditions resulted into false
            pathInMaze[row][col] = 0;
        }

        return false;
    }


    public int[][] solve2(int[][] maze) {
        int N = maze.length;
        int[][] pathInMaze = new int[N][N];
        probeRatPathInMaze(maze, pathInMaze, N, 0, 0);
        return pathInMaze;
    }
}

/*
Given a grid A, a rat is at position (1, 1). He wants to go to the position (n, n)
where n is size of the square matrix A.
1 represents a traversable cell and 0 represents a
non-traversable cell. Rat can only move right or down.
Return a path that the rat can take.

Problem Constraints : 1 <= |A| <= 4

Input Format : First and only argument is the vector of vectors A.
Output Format : Return a vector of vectors that denotes a path that can be taken.

Input 1:
A = [   [1, 0]
        [1, 1]
    ]
Output 1:

[   [1, 0]
    [1, 1]
]

Explanation 1:  Path is shown in output.

Input 2:
A = [    [1, 1, 1]
         [1, 0, 1]
         [0, 0, 1]
    ]

Output 2:
[    [1, 1, 1]
     [0, 0, 1]
     [0, 0, 1]
]
Explanation 2: Path is shown in output.
 */