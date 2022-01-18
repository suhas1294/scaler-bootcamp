package _02_intermediate._2022_01_17.sub_arrays.homework;

import utils.Util;

import java.util.ArrayList;

public class GoodSubArrays {
    public static int solve(ArrayList<Integer> A, int B) {
        int[] prefixSum = new int[A.size()];
        prefixSum[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            prefixSum[i] = prefixSum[i-1] + A.get(i);
        }
        int goodArrayCount = 0;
        for (int si = 0; si < A.size(); si++) {
            int subArraySum;
            for (int ei = si; ei < A.size(); ei++) {
                // calculate subArray sum
                if (si == 0){
                    subArraySum = prefixSum[ei];
                }else{
                    subArraySum = prefixSum[ei] - prefixSum[si-1];
                }
                // check if it satisfy the condition of good array
                if ( ((ei-si) % 2 == 1) && subArraySum < B){ // subarray len is even
                    goodArrayCount++;
                }else if (((ei-si) % 2 == 0) && subArraySum > B){ //sub array length is odd
                    goodArrayCount++;
                }
            }
        }
        return goodArrayCount;
    }

    public static void main(String[] args) {
        System.out.println(solve(Util.fillArrayList(new int[]{1, 2, 3, 4, 5}), 4)); // 6
        System.out.println(solve(Util.fillArrayList(new int[]{13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9}), 65)); // 36
    }
}

/*
Given an array of integers A.
A subarray of an array is said to be good if it fulfils any one of the criteria:
1. Length of the subarray must be even and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray must be odd and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.

1 <= len(A) <= 10^3
1 <= A[i] <= 10^3
1 <= B <= 10^7

input format:
The first argument given is the integer array A.
The second argument given is an integer B.

output format:
Return the count of good subarrays in A.

Input 1:
A = [1, 2, 3, 4, 5] B = 4, output : 6
explanation: Even length good subarrays = {1, 2}
Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}

Input 2:
A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9] B = 65, output : 36
 */