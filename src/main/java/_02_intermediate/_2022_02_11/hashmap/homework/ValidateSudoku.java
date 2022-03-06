package _02_intermediate._2022_02_11.hashmap.homework;

import java.util.HashSet;

// note : check input sample image provided.
public class ValidateSudoku {
    // credits: https://leetcode.com/problems/valid-sudoku/discuss/1817561/JAVA-Simple-to-understand
    public static int isValidSudoku(final String[] A) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(A[i].charAt(j)!='.'){
                    String row = A[i].charAt(j)+"R"+i;
                    String col = A[i].charAt(j)+"C"+j;
                    String box = A[i].charAt(j)+"B"+i/3+j/3;
                    if(set.contains(row) || set.contains(col) || set.contains(box)) return 0;
                    set.add(row);
                    set.add(col);
                    set.add(box);
                }

            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String[] board = {
                "53..7....", "6..195...", ".98....6.",
                "8...6...3", "4..8.3..1", "7...2...6",
                ".6....28.", "...419..5", "....8..79"
        };
        System.out.println(isValidSudoku(board));
    }
}

/*
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.",
"8...6...3", "4..8.3..1", "7...2...6",
".6....28.", "...419..5", "....8..79"]

A partially filled sudoku which is valid.

Note: A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled
cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */