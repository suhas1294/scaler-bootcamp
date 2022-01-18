package _02_intermediate._2022_01_17.assignments;

import utils.Util;

import java.util.ArrayList;

public class MaxSubArrayLimit {
    public static int maxSubarray(int A, int B, ArrayList<Integer> C) {
        int maxSubArraySumLessThenB = 0;
        for (int i = 0; i < A; i++) {
            int currentSubArraySum = 0;
            for (int j = i; currentSubArraySum < B && j < A; j++) { //  denotes a subarray from i to j
                currentSubArraySum += C.get(j);
                if (currentSubArraySum <= B){
                    maxSubArraySumLessThenB = Math.max(maxSubArraySumLessThenB, currentSubArraySum);
                }
            }
        }
        return maxSubArraySumLessThenB;
    }

    public static void main(String[] args) {
        //ArrayList<Integer> input = Util.fillArrayList(new int[]{2, 1, 3, 4, 5});
        //System.out.println(maxSubarray(5, 12, input));
        //ArrayList<Integer> input = Util.fillArrayList(new int[]{2, 2, 2});
        //System.out.println(maxSubarray(3, 1, input));
        ArrayList<Integer> input = Util.fillArrayList(new int[]{1, 2, 4, 4, 5, 5, 5, 7, 5});
        System.out.println(maxSubarray(9, 14, input));
    }
}

/*
You are given an integer array C of size A. Now you need to find a subarray (contiguous elements)
so that the sum of contiguous elements is maximum.But the sum must not exceed B.

1 <= A <= 10^3
1 <= B <= 10^9
1 <= C[i] <= 10^6

The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.

Return a single integer which denotes the maximum sum.

Input 1:
A = 5
B = 12
C = [2, 1, 3, 4, 5]
output : 12
explanation: We can select {3,4,5} which sums up to 12 which is the maximum possible sum.

Input 2:
A = 3
B = 1
C = [2, 2, 2]
output : 0
explanation: All elements are greater than B, which means we cannot select any subarray.
Hence, the answer is 0.

 */