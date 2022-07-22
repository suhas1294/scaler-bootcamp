package _03_advance._2022_07_13.backtracking_2.assignments;

import java.util.ArrayList;

public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<Integer> curRes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int col[] = new int[A];
        int leftDiagonal[] = new int[2 * A - 1];
        int rightDiagonal[] = new int[2 * A - 1];
        Nqeens(0, A, col, leftDiagonal, rightDiagonal, curRes, res);
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            ArrayList<Integer> cur = new ArrayList<>(res.get(i));
            ArrayList<String> re = new ArrayList<>();
            for (int j = 0; j < cur.size(); j++) {
                String s = "";
                for (int l = 0; l < A; l++) {
                    if (cur.get(j) == l)
                        s += "Q";
                    else
                        s += ".";
                }
                re.add(s);
            }
            result.add(re);
        }
        return result;
    }

    public boolean Nqeens(int rowIndex, int n, int[] col, int[] leftDiagonal, int[] rightDiagonal, ArrayList<Integer> curRes, ArrayList<ArrayList<Integer>> res) {
        if (rowIndex == n) {
            res.add(new ArrayList<>(curRes));
            return true;
        }
        for (int column = 0; column < n; column++) {
            if (col[column] == 1 || leftDiagonal[rowIndex - column + n - 1] == 1 || rightDiagonal[rowIndex + column] == 1) {
                continue;
            }
            col[column] = 1;
            leftDiagonal[rowIndex - column + n - 1] = 1;
            rightDiagonal[rowIndex + column] = 1;
            curRes.add(column);
            boolean k = Nqeens(rowIndex + 1, n, col, leftDiagonal, rightDiagonal, curRes, res);
            col[column] = 0;
            leftDiagonal[rowIndex - column + n - 1] = 0;
            curRes.remove(curRes.size() - 1);
            rightDiagonal[rowIndex + column] = 0;
        }
        return false;
    }
}

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard
such that no two queens attack each other.
Given an integer A, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in
each list should be in reverse lexicographical order.

Problem Constraints
1 <= A <= 10

Input Format : First argument is an integer n denoting the size of chessboard
Output Format : Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.

Input 1: A = 4
Output 1:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation 1: There exist only two distinct solutions to the 4-queens puzzle:

Input 2: A = 1
Output 2:
[
 [Q]
]
Explanation 2: There exist only one distinct solutions to the 1-queens puzzle:
 */