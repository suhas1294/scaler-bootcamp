package _02_intermediate._2022_01_17.sub_arrays.homework;

import utils.Util;

import java.util.ArrayList;

public class CountingSubarrays {
    public static int solve(ArrayList<Integer> A, int B) {
        int counter = 0;
        int[] prefixSum = new int[A.size()];
        prefixSum[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            prefixSum[i] = prefixSum[i-1] + A.get(i);
        }

        for (int i = 0; i < A.size(); i++) {
            int curSum = 0;
            for (int j = i; j < A.size(); j++) {
                if (i == 0){
                    curSum = prefixSum[j];
                }else{
                    curSum = prefixSum[j] - prefixSum[i-1];
                }
                if (curSum < B) counter++;
            }
        }
        return counter;
    }

    public static void printArray(ArrayList<Integer> arr, int startIdx, int endIdx){
        System.out.print("[ ");
        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        System.out.println(solve(Util.arrayToList(new int[]{2,5,6}), 10)); // 4
        System.out.println(solve(Util.arrayToList(new int[]{1, 11, 2, 3, 15}), 10)); // 4
    }
}

/*
Given an array A of N non-negative numbers and you are also given non-negative number B.
You need to find the number of subarrays in A having sum less than B. We may assume that there is no overflow.

constraints:
1 <= N <= 10^3
1 <= A[i] <= 1000
1 <= B <= 10^7

input format: First argument is an integer array A. Second argument is an integer B.
output format: Return an integer denoting the number of subarrays in A having sum less than B.

Input 1:
 A = [2, 5, 6] B = 10, ouput : 4
 explanation: The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},

Input 2:
 A = [1, 11, 2, 3, 15] B = 10 output: 4
 explanation: The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}

 */