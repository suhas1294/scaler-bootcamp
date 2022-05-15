package _03_advance._2022_04_20.binary_search_1.live_session;

// TC : log n + log m
public class _05_SearchForElementeSortedMatrix {
    public static boolean searchInMatrix(int[][] A, int B){
        // step-1 : collect last column elements
        int n = A.length; //  rows
        int m = A[0].length; //  columns
        int[] last_column = new int[n];
        for (int i = 0; i < n; i++) {
            last_column[i] = A[i][m-1];
        }
        // step-2 : apply ceil search for last column
        int row_to_be_searched = getCeilIdxOfElement(last_column, B);
        if(row_to_be_searched == Integer.MIN_VALUE) return false; // edge case when highest element in matrix is lesser then target element
        // step-2 : apply binary search on row
        int found = _01_SearchForElement.searchElement(A[row_to_be_searched], B);
        return found != -1;
    }

    public static int getCeilIdxOfElement(int a[], int k){
        int n = a.length;
        int l = 0, h = n-1, ans = Integer.MIN_VALUE;
        while (l <= h){
            int m = (l+h)/2;
            if (a[m] == k) return m;
            if (a[m] < k) { // go to right
                l = m + 1;
            }else{ // a[m] > k, go to left.
                ans = m;
                h = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(searchInMatrix(new int[][]{{1}}, 1));
        System.out.println(searchInMatrix(new int[][]{
                {22, 32, 67}
        }, 93));
        /*System.out.println(searchInMatrix(new int[][]{
                {3, 3, 11, 12, 14},
                {16, 17, 30, 34, 35},
                {45, 48, 49, 50, 52},
                {56, 59, 63, 63, 65},
                {67, 71, 72, 73, 79},
                {80, 84, 85, 85, 88},
                {88, 91, 92, 93, 94}
        }, 94));*/
        /*System.out.println(searchInMatrix(new int[][]{
                {3},
                {29},
                {36},
                {63},
                {67},
                {72},
                {74},
                {78},
                {85}
        }, 41));*/
    }
}
/*
Given a sorted matrix, search for k
In a given row, there are m elements,
In a given column, there are n elements

idea-1 : search for entire row.
idea-2 : apply binary search in each row or in each column
idea-3 : for every row compare its last element with k, based on that we can apply BS in a particuluar row.
idea-4 : apply ceil search in last column and then apply BS on row
 */
