package _03_advance._2022_07_01.heaps_1.assignments;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectRopes {
    public int solve(int[] A) {
        // Priority Queue contains element in sorted order. Can be considered as a Min-Heap
        // Max heap use PriorityQueue<Long> pq = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Long> pq = new PriorityQueue();
        long bigRope = 0;

        for (int i = 0; i < A.length; i++) {
            pq.offer((long) A[i]);
        }
        while (pq.size() > 1) {
            long min1 = pq.poll(); //Find the first minimum rope
            long min2 = pq.poll(); //Find the Second minimum rope
            bigRope = bigRope + min1 + min2; //Add the resulting Rope to Heap
            pq.offer(min1 + min2);
        }
        return (int) bigRope;
    }

    public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : A) {
            pq.add(i);
        }
        int j = 0;
        int totalLength = 0;
        while (pq.size() > 1) {
            int temp1 = pq.poll();
            int temp2 = pq.poll();
            int temp = temp1 + temp2;
            totalLength += temp;
            pq.add(temp);
        }
        return totalLength;
    }
}

/*
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes
equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000

Input Format : The only argument given is the integer array A.
Output Format : Return an integer denoting the minimum cost to connect these ropes into one rope.

Input 1: A = [1, 2, 3, 4, 5], Output 1: 33
Explanation 1:
 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15
So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.

Input 2: A = [5, 17, 100, 11],  Output 2: 182
Explanation 2:
 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133
So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.

 */