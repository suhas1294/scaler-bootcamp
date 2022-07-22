package _03_advance._2022_07_15.backtracking_3.live_session;

import utils.Util;

public class Sudoku {
    // tc : 9^81 (worst case), sc : O(81) ~ O(1)
    void printSudoku(int mat[][], int x){
        if (x == 81){
            Util.print2DMatrix(mat);
            return;
        }
        int row = x / 9, col = x % 9;
        // we need to fill mat[row][col]
        if (mat[row][col] != 0){ // go to next cell
            printSudoku(mat, x + 1);
        }else { // cell is empty, we can try all combinations from 1 - 9
            for (int i = 1; i <= 9; i++) {
                if(valid(mat, row, col, i)){
                    mat[row][col] = i;          // make changes
                    printSudoku(mat, x + 1);  // function call
                    mat[row][col] = 0;          // revert changes
                }
            }
        }
    }

    boolean valid(int[][] mat, int r, int c, int d){
        for (int j = 0; j < 9; j++) {
            if (mat[r][j] == d) return false; // to check rth row
            if (mat[j][c] == d) return false; // to check rth col
        }
        // to check the mini dabba
        int x = r - (r % 3), y = c - (c % 3);
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (mat[i][j] == d) return false;
            }
        }
        return true;
    }
}
