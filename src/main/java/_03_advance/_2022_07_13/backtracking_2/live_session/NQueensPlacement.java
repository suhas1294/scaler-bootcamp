package _03_advance._2022_07_13.backtracking_2.live_session;

import utils.Util;

public class NQueensPlacement {
    void queenPlacement(int[][] mat, int n, int i){
        if (i == n){
            Util.print2DMatrix(mat);
            return;
        }
        // at it index we need to place the queen
        for (int j = 0; j < n; j++) {
            // we are trying to place at i,j - check ith row and jth col (row, col, diagonal)
            if (check(mat, i, j)){
                mat[i][j] = 1; // indicates presence of queen (make changes)
                queenPlacement(mat, n, i+1); // function call
                mat[i][j] = 0; // indicates no queen (revert changes)
            }
        }
    }

    boolean check(int[][] mat, int i, int j){
        // whether we can keep queen at i, j
        // step-1 : check column
        for (int r = 0; r < i; r++) {
            if (mat[r][j] == 1) return false;
        }
        // step-2 : check left diagonal
        int r = i, c = j;
        while (r >= 0 && c >= 0){
            if (mat[r][c] == 1) return false;
            r--; c--;
        }
        // check right diagonal
        r = i;
        c = j;
        int n = mat.length;
        while (r >= 0 && c < n){
            if (mat[r][c] == 1) return false;
            r--; c++;
        }
        return true;
    }
}

/*
given n*n matrix, print all valid placements of N queen such that
no queen can kill another queen
 */