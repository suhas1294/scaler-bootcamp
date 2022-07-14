package _03_advance._2022_07_04.heaps_2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxArraySumAfterBNegations {

    // approach-1 - using priority queue
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //Adding all element in pq
        for (int val : A) {
            pq.add(val);
        }
        //consuming B modifications on minimum value
        while (B > 0) {
            int minVal = pq.poll();
            pq.add(-1 * minVal);
            B--;
        }
        //finding sum
        int sum = 0;
        while (pq.size() > 0) {
            sum += pq.poll();
        }
        return sum;
    }

    // approach-2 : using sorting
    public int solve2(ArrayList<Integer> A, int B) {
        int N = A.size();
        int i = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        Collections.sort(A);
        while (B >= 0 && i < N) {
            int val = A.get(i);
            if (val < 0 && B > 0) {
                val = -1 * val;
                B--;
                A.set(i, val);
            }
            min = Math.min(min, val);
            sum += val;
            i++;
        }
        if (B > 0 && B % 2 != 0) {
            sum = sum - 2 * min;
        }
        return sum;
    }


    // approach-3 - using custom heap class
    public int solve(int[] A, int B) {
        // Idea: build a min heap and for every iteration remove min and insert
        // its negation into heap after all the iteration is complete.
        // extract every element from heap and return total sum.
        MinHeap heap = new MinHeap(A.length);
        for (int i = 0; i < A.length; i++) { // build heap
            heap.insert(A[i]);
        }
        for (int i = 0; i < B; i++) { // perform B operation
            int min = heap.getMinimum();
            int x = -min;
            heap.insert(x);
        }
        // get total sum of remaining elements in heap
        int sum = 0;
        while (!heap.isEmpty()) {
            sum += heap.getMinimum();
        }
        return sum;
    }

    private class MinHeap {
        int[] heap;
        int size;

        public MinHeap(int size) {
            this.heap = new int[size];
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        public int[] getHeap() {
            return this.heap;
        }

        public boolean isEmpty() {
            if (this.size == 0) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if (this.size == heap.length) {
                return true;
            }
            return false;
        }

        public void insert(int x) {
            // insert x into last position
            if (!isFull()) {
                heap[size] = x;
                size++;
                int i = size - 1;
                while (i > 0) {
                    int parentIndex = (i - 1) / 2;
                    if (heap[i] < heap[parentIndex]) {
                        swap(i, parentIndex);
                        i = parentIndex;
                    } else {
                        return;
                    }
                }
            }
        }

        public int getMinimum() {
            int x = -1;
            if (!isEmpty()) {
                x = heap[0];
                // swap last element and x
                swap(0, size - 1);
                heap[size - 1] = -1;
                size--;
                int i = 0;
                while ((2 * i) + 1 < size) {
                    int leftChildIndex = (2 * i) + 1;
                    int rightChildIndex = (2 * i) + 2;
                    int min = Math.min(heap[leftChildIndex], heap[i]);
                    if (rightChildIndex < size) {
                        min = Math.min(min, heap[rightChildIndex]);
                    }
                    if (min == heap[i]) {
                        break;
                    } else if (min == heap[leftChildIndex]) {
                        swap(i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (rightChildIndex < size && min == heap[rightChildIndex]) {
                        swap(i, rightChildIndex);
                        i = rightChildIndex;
                    }
                }

            }
            return x;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

    }
}

/*
Given an array of integers A and an integer B. You must modify the array
exactly B number of times. In a single modification, we can replace any one
array element A[i] by -A[i].You need to perform these modifications in such
a way that after exactly B modifications, sum of the array must be maximum.

Problem Constraints
1 <= length of the array <= 5*10^5
1 <= B <= 5 * 10^6
-100 <= A[i] <= 100

Input Format
The first argument given is an integer array A.
The second argument given is an integer B.

Output Format : Return an integer denoting the maximum array sum after B modifications.

Input 1: A = [24, -68, -29, -9, 84] B = 4 Output 1: 196
Explanation 1: Final array after B modifications = [24, 68, 29, -9, 84]

Input 2: A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61] B = 10 Output 2: 362
Explanation 2: Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
 */