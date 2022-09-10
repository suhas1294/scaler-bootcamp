package _03_advance._2022_08_10.graphs_2.live_session;

public class _03_NoOfIslands {
    // tc : O(nxm), sc : O(1 + NM), NM is recursive stack space.
    int islands(int[][] mat, int n, int m) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    // with cell (i,j) as source, apply dfs
                    count++;
                    dfs(mat, i, j, n, m);
                }
            }
        }
        return count;
    }

    void dfs(int[][] mat, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] == 0) return;
        mat[i][j] = 0; // mark it as visited.
        dfs(mat, i + 1, j, n, m);
        dfs(mat, i - 1, j, n, m);
        dfs(mat, i, j + 1, n, m);
        dfs(mat, i, j - 1, n, m);
    }

    int[] x = {-1, 1, 0, 0}; // top bottom left right
    int[] y = {0, 0, -1, 1}; // top bottom left right

    void dfsImprovised(int[][] mat, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] == 0) return;
        mat[i][j] = 0; // mark it as visited.
        for (int k = 0; k < 4; k++) {
            dfs(mat, i + x[k], j + y[k], n, m);
        }
    }

    // assignment solution
    public int solve(int[][] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    ans++;
                    dfs(i, j, A.length, A[0].length, A);
                }
            }
        }
        return ans;
    }

    public void dfs(int r, int c, int R, int C, int[][] A) {
        if (r < 0 || c < 0 || r >= R || c >= C || A[r][c] != 1) {
            return;
        }
        A[r][c] = -1;
        dfs(r + 1, c, R, C, A);
        dfs(r, c + 1, R, C, A);
        dfs(r - 1, c, R, C, A);
        dfs(r, c - 1, R, C, A);
        dfs(r + 1, c + 1, R, C, A);
        dfs(r - 1, c - 1, R, C, A);
        dfs(r + 1, c - 1, R, C, A);
        dfs(r - 1, c + 1, R, C, A);
    }
}

/*
given a binary matrix, find numnber of islands in it.
island definition :  if surrounded by water in all direction then its island.
0 - water
1 - land
note : ignore checking diagonally

----------- assignment questions -------------
Given a matrix of integers A of size N x M consisting of 0 and 1. A group of
connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can
visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

Problem Constraints
1 <= N, M <= 100
0 <= A[i] <= 1

Input Format : The only argument given is the integer matrix A.
Output Format : Return the number of islands.

Input 1:
 A = [
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]
Output 1:  2
Explanation 1:  The 1's at position A[0][1] and A[1][2] forms one island. Other is formed by A[2][0].

Input 2:
 A = [
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]
     ]

Output 2: 5
Explanation 2: There 5 island in total.
 */