package _03_advance._2022_07_06.heaps_3.live_session;

import _03_advance._2022_07_04.heaps_2.MinHeap;

import java.util.HashSet;

// TC : k log k * log k,  sc : O(k + 2k)
//      insert    delete      max heap size, hashset size
public class KSmallestPairSums {
    // given 2 sorted arrays, find k smallest pair sums a single pair once
    // (2,0) and (0,2) are different pair.
    void SmallestKPairSums(int a[], int b[], int k){
        int n = a.length, m = b.length;
        MinHeap<Data> minHeap = new MinHeap<>();
        HashSet<String> hs = new HashSet<>();

        // insert min pair.
        minHeap.insert(new Data(a[0] + b[0], 0 , 0));
        hs.add(0 + "_" + 0);

        for (int i = 1; i <= k; i++) {
            Data d = minHeap.getMinimum();
            minHeap.deleteMin();
            int val = d.val, r = d.row, c = d.col;
            System.out.println(val); // ans
            // for (r,c) -> next possibilities are (r+1, c) or (r, c+1)
            if (c + 1 < m && !hs.contains(r + "_" + (c+1) )){
                val = a[r] + b[c+1];
                minHeap.insert(new Data(val, r , c+1));
                hs.add(r + "_ + " + (c+1));
            }
            if ((r+1) < n && !hs.contains((r+1) + "_" + c)){
                val = a[r+1] + b[c];
                minHeap.insert(new Data(val, r + 1, c));
                hs.add((r+1) + "_" + c);
            }
        }
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
    idea-1 : store all pair sums in 1d array and sort. get 1st k elements.
    idea-2 : generate all pairs but insert in maxheap of size k (refer src/main/java/_03_advance/_2022_07_04/heaps_2/live_session/_01_KthSmallestElement.java)
    idea-3 : using mimHeap and hashset.
     */
}
