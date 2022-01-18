package _02_intermediate._2022_01_17.sub_arrays.assignments;

import utils.Util;

import java.util.ArrayList;
import java.util.List;

// sub array with largest sum
public class MaxSumContigiousSubArray {
    // kadanes algo : time complexity : O(n)
    static int maxSubArraySum2(ArrayList<Integer> A){
        int maxSum = A.get(0);
        int curSum = A.get(0);
        for (int i = 1; i < A.size(); i++){
            curSum = Math.max(A.get(i), curSum+A.get(i));
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    // will get TLE, time complexity O(n^2)
    public static int maxSubArray(final List<Integer> A) {
        int subArrayWithMaxSum = Integer.MIN_VALUE; // dont get confused with naming - this holds max sum
        for (int i = 0; i < A.size(); i++) {
            int curSubARraySum = 0;
            for (int j = i; j < A.size(); j++) {
                curSubARraySum += A.get(j);
                subArrayWithMaxSum = Math.max(subArrayWithMaxSum, curSubARraySum);
            }
        }
        return subArrayWithMaxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(Util.fillArrayList(new int[]{1, 2, 3, 4, -10})));
        System.out.println(maxSubArray(Util.fillArrayList(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})));
    }
}
/*
Find the contiguous subarray within an array, A of length N which has the largest sum.
1 <= N <= 1e6
-1000 <= A[i] <= 1000

input format: The first and the only argument contains an integer array, A.
output format: Return an integer representing the maximum possible sum of the contiguous subarray.

Input 1: A = [1, 2, 3, 4, -10], output : 10,
explanation: The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

Input 2: A = [-2, 1, -3, 4, -1, 2, 1, -5, 4], output : 6
explanation: The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
