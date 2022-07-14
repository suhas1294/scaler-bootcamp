package _03_advance._2022_07_01.heaps_1.assignments;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectRopesAlternate2 {
    public int solve(int[] A) {
        int n = A.length;
        for (int i = (n >> 1); i > 0; i--) {
            heapify(A, n, i);
        }

        int cost = 0;
        while (n != 1) {
            int sum = 0;

            sum += A[0];
            swap(A, 0, n - 1);
            n--;

            heapify(A, n, 1);

            sum += A[0];
            cost += sum;
            A[0] = sum;

            heapify(A, n, 1);
        }
        return cost;
    }


    //Heapify Function
    void heapify(int[] A, int n, int index) {
        while ((index << 1) <= n) {
            int left = (index << 1);
            int right = (index << 1) + 1;
            if (right <= n) {
                if (A[left - 1] < A[index - 1] && A[left - 1] < A[right - 1]) {
                    swap(A, index - 1, left - 1);
                    index = left;
                } else if (A[right - 1] < A[index - 1]) {
                    swap(A, index - 1, right - 1);
                    index = right;
                } else
                    break;
            } else {
                if (A[left - 1] < A[index - 1])
                    swap(A, index - 1, left - 1);
                else
                    break;
            }
        }
    }

    //Swap function
    void swap(int[] A, int index1, int index2) {
        A[index1] = A[index1] ^ A[index2];
        A[index2] = A[index1] ^ A[index2];
        A[index1] = A[index1] ^ A[index2];
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