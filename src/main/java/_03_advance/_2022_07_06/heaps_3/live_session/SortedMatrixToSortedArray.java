package _03_advance._2022_07_06.heaps_3.live_session;

import _03_advance._2022_07_04.heaps_2.MinHeap;


public class SortedMatrixToSortedArray {
    // tc : nm log n, sc : n
    public int[] sortNArrays(int[][] mat){
        int n = mat.length; // rows
        int m = mat[0].length; // columns
        MinHeap<Data> minHeap = new MinHeap<>();

        int[] ans = new int[n*m];
        int idx = 0; // to progress with answer

        // step-1 : insert entire 0th column into minheap
        for (int i = 0; i < n; i++) {
            int ele = mat[i][0];
            minHeap.insert(new Data(ele, i, 0));
        }

        while (!minHeap.isEmpty()){
            Data data = minHeap.getMinimum();
            minHeap.deleteMin();
            int val = data.val; int r = data.row; int c = data.col;
            ans[idx] = val; idx++;
            // we need to insert next element in that row
            if (c + 1 < m){ // when pointer reaches last column, to prevent IOB exception
                val = mat[r][c+1];
                minHeap.insert(new Data(val, r, c+1));
            }
        }
        return ans;
    }

    private class Data implements Comparable<Data> {
        int val;
        int row;
        int col;

        public Data(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Data o) {
            return 0;
        }
    }
    /*
    idea-1 : store nxm elements in array and directly sort it.
    tc: nm log(nm) sc : nm (if merge sort else O(1))

    idea-2 : store all nm elements in min heap and delete 1 by 1 element and insert it in new array
    tc: nm log nm  + nm log nm (for insert and delete opn respectively), sc : O(nm) max heap size

    idea-3 : divide matrix into two halves and apply merge sort on both
    tc: nm log nm

    idea-4 : n pointer approach
    take n pointers pointing to each row and progress the pointer accordingly using

    */
}

/*
given n sorted arrays, return an array which has completed sorted data of matrix
 */