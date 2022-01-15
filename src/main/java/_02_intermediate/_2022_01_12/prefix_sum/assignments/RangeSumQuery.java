package _02_intermediate._2022_01_12.prefix_sum.assignments;

import java.util.ArrayList;

public class RangeSumQuery {
    public static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        long[] prefixSum = new long[A.size()];
        prefixSum[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            prefixSum[i] = A.get(i) + prefixSum[i-1];
        }
        ArrayList<Long> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> query = B.get(i);
            int left = query.get(0) - 1;
            int right = query.get(1) - 1 ;
            long sum = prefixSum[right] - (left-1 < 0 ? 0 : prefixSum[left-1]);
            result.add(sum);
        }
        return result;
    }
}

/*
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

constraints:
    1 <= N, M <= 10^5
    1 <= A[i] <= 10^9
    1 <= L <= R <= N

input format:
The first argument is the integer array A.
The second argument is the 2D integer array B.

output format:
Return an integer array of length M where ith element is the answer for ith query in B.

input 1:
A = [1, 2, 3, 4, 5]
B = [[1, 4], [2, 3]]
output : [10, 5]
explanation: The sum of all elements of A[1 ... 4] = 1 + 2 + 3 + 4 = 10.
The sum of all elements of A[2 ... 3] = 2 + 3 = 5.

input 2:
A = [2, 2, 2]
B = [[1, 1], [2, 3]]
output: [2, 4]
explanation: The sum of all elements of A[1 ... 1] = 2 = 2.
The sum of all elements of A[2 ... 3] = 2 + 2 = 4.

 */