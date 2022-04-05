package _03_advance._2022_03_21.arrays_3.live_session;

public class _02_SearchInSortedMatrix {
    // idea 1 : iterate in entier matrix, tc: o(nxm), sc: o(1)
    // idea 2 : apply binary search in each row : tc: o(n x logm base 2)
    // idea 3 : apply binary search in each column : tc: O(m x log n base 2)
    // idea 4 : compare k with first and last element of a row , based on that apply BS in that row. tc: o(n x logm base 2)
    // idea 5 : at every step, we either skip a row, or a column.
    // Note : tracing can be started from 4 corners of matrix, in this example we are taking from top left corner (to the viewer) of matrix
    public static boolean isNumberPresent(int[][] mat, int k){
        int n = mat.length, m = mat[0].length;
        int i = 0, j = m-1;
        while (i < n &&  j >= 0){
            if (mat[i][j] < k){
                i++; // skip row
            }else if (mat[i][j] > k){
                j--; // skip column
            }else{
                return true;
            }
        }
        return false;
    }

}

/*
Given a 2d matrix of nxm, every row sorted , every column sorted, find whether element k is present or not.
(sorted in natural order AKA ascending)
 */
