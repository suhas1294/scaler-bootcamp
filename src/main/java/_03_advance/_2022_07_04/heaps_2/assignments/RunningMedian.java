package _03_advance._2022_07_04.heaps_2.assignments;

import _03_advance._2022_07_04.heaps_2.MaxHeap;
import _03_advance._2022_07_04.heaps_2.MinHeap;

public class RunningMedian {
    public int[] solve(int[] A) {
        int[] output = new int[A.length];
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        MinHeap<Integer> minHeap = new MinHeap<Integer>();

        int index = 0;
        for (int i = 0; i < A.length; i++) {
            // insert into maxHeap if empty
            if (maxHeap.isEmpty()) {
                maxHeap.insert(A[i]);
            } else {
                if (A[i] < maxHeap.peekMax()) {
                    // insert into maxHeap
                    maxHeap.insert(A[i]);
                    if (maxHeap.size() - minHeap.size() > 1) {
                        // if size(maxHeap) - size(minHeap) > 1, insert top element from maxHeap into
                        // minHeap
                        minHeap.insert(maxHeap.getMaximum());
                    }
                } else {
                    // insert into minHeap
                    minHeap.insert(A[i]);
                    if (minHeap.size() > maxHeap.size()) {
                        // if size(minHeap) > size(minHeap), insert top element from minHeap into
                        // maxHeap
                        maxHeap.insert(minHeap.getMinimum());
                    }
                }
            }
            output[index++] = maxHeap.peekMax();
        }
        return output;
    }
}

/*
Given an array of integers, A denoting a stream of integers. New arrays of
integer B and C are formed.Each time an integer is encountered in a stream,
append it at the end of B and append the median of array B at the C.
Find and return the array C.

NOTE:
1. If the number of elements is N in B and N is odd, then consider
the median as B[N/2] ( B must be in sorted order).
2. If the number of elements is N in B and N is even, then consider
the median as B[N/2-1]. ( B must be in sorted order).


Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9

Input Format : The only argument given is the integer array A.
Output Format : Return an integer array C, C[i] denotes the median of the first i elements.

Input 1: A = [1, 2, 5, 4, 3], Output 1: [1, 1, 2, 2, 3]

Explanation 1:
 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3

Input 2: A = [5, 17, 100, 11] , Output 2: [5, 5, 17, 11]
Explanation 2:

 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11
 */