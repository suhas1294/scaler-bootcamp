package _03_advance._2022_07_04.heaps_2.assignments;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ProductOf3 {
    public int[] solve(int[] A) {
        int heap[] = new int[3];
        int res[] = new int[A.length];
        int mul = 1;
        for (int i = 0; i < 3; i++) {
            heap[i] = A[i];
            mul = mul * A[i];
            res[i] = -1;
        }
        res[2] = mul;
        heapifyDown(heap, 3, 0);
        for (int i = 3; i < A.length; i++) {
            if (A[i] > heap[0]) {
                mul = mul / heap[0];
                mul = mul * A[i];
                heap[0] = A[i];
                heapifyDown(heap, 3, 0);
            }
            res[i] = mul;
        }
        return res;
    }

    private void heapifyDown(int heap[], int n, int i) {
        int min = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && heap[min] > heap[l])
            min = l;
        if (r < n && heap[min] > heap[r])
            min = r;
        if (min != i) {
            int temp = heap[i];
            heap[i] = heap[min];
            heap[min] = temp;
            heapifyDown(heap, n, min);
        }
    }


    // ------------- alternate solution -------------
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        //Need to implement min heap of size 3-> largest 3
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        int N = A.size();
        //inserting elements at index 0, 1 and 2 in the queue
        for (int i = 0; i < 3; i++) {
            pq.add(A.get(i));
            if (i < 2) {
                list.add(-1);
            }
        }

        //for index = 2, iterate on the pq and get the max of 3
        int max = getMaxOf3(pq);
        list.add(max);

        //iterating from index 3 and above
        for (int i = 3; i < N; i++) {
            int val = A.get(i);
            int minVal = pq.peek();
            if (val > minVal) {
                pq.poll();
                pq.add(val);
            }
            max = getMaxOf3(pq);
            list.add(max);
        }
        return list;
    }

    private int getMaxOf3(PriorityQueue<Integer> pq) {
        int res = 1;
        for (int v : pq) {
            res = res * v;
        }
        return res;
    }
}

/*
Given an integer array A of size N. You have to find the product of the three largest
integers in array A from range 1 to i, where i goes from 1 to N.
Return an array B where B[i] is the product of the largest 3 integers in
range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.

Problem Constraints
1 <= N <= 10^5
0 <= A[i] <= 10^3

Input Format : First and only argument is an integer array A.
Output Format : Return an integer array B. B[i] denotes the product of the
largest 3 integers in range 1 to i in array A.

Input 1: A = [1, 2, 3, 4, 5], Output 1: [-1, -1, 6, 24, 60]

Explanation 1:
 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 1 * 2 * 3 = 6
 For i = 4, ans = 2 * 3 * 4 = 24
 For i = 5, ans = 3 * 4 * 5 = 60
 So, the output is [-1, -1, 6, 24, 60].

Input 2: A = [10, 2, 13, 4] Output 2: [-1, -1, 260, 520]
Explanation 2:
 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 10 * 2 * 13 = 260
 For i = 4, ans = 10 * 13 * 4 = 520

 So, the output is [-1, -1, 260, 520].
 */