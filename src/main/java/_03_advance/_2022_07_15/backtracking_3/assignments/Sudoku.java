package _03_advance._2022_07_15.backtracking_3.assignments;

public class Sudoku {
    public void solveSudoku(char[][] A) {
        boolean[][] rowVisited = new boolean[9][9];
        boolean[][] colVisited = new boolean[9][9];
        boolean[][] boxVisited = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = A[i][j];
                if (c != '.') {
                    rowVisited[i][c - '1'] = true;
                    colVisited[j][c - '1'] = true;
                    boxVisited[(((i / 3) * 3) + (j / 3))][c - '1'] = true;
                }
            }
        }
        solveSudoku(A, 0, rowVisited, colVisited, boxVisited);
    }

    private boolean solveSudoku(char[][] board, int cell, boolean[][] rowVisited, boolean[][] colVisited, boolean[][] boxVisited) {
        if (cell >= 81) {
            return true;
        }
        int i = cell / 9;
        int j = cell % 9;
        char c = board[i][j];
        if (c != '.') {
            return solveSudoku(board, cell + 1, rowVisited, colVisited, boxVisited);
        }

        for (char k = '1'; k <= '9'; k++) {

            if (rowVisited[i][k - '1'] || colVisited[j][k - '1'] || boxVisited[(((i / 3) * 3) + (j / 3))][k - '1']) {
                continue;
            }

            board[i][j] = k;
            rowVisited[i][k - '1'] = true;
            colVisited[j][k - '1'] = true;
            boxVisited[(((i / 3) * 3) + (j / 3))][k - '1'] = true;

            if (solveSudoku(board, cell + 1, rowVisited, colVisited, boxVisited)) {
                return true;
            }

            board[i][j] = '.';
            rowVisited[i][k - '1'] = false;
            colVisited[j][k - '1'] = false;
            boxVisited[(((i / 3) * 3) + (j / 3))][k - '1'] = false;
        }

        return false;
    }
}

/*
Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are
indicated by the character '.' You may assume that there will be only one unique solution.
A sudoku puzzle, and its solution numbers marked in red. (refer image)

Problem Constraints
N = 9

Input Format : First argument is an array of array of characters representing the Sudoku puzzle.
Output Format : Modify the given input to the required answer.

Input 1:
A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
Output 1:
[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]

Explanation 1: Look at the diagrams given in the question.
 */