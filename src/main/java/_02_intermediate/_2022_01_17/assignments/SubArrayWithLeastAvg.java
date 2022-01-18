package _02_intermediate._2022_01_17.assignments;

import utils.Util;

import java.util.ArrayList;

public class SubArrayWithLeastAvg {
    // the subarray with least sum will have least average
    public static int solve(ArrayList<Integer> A, int B) {
        int leastSumValue = Integer.MAX_VALUE;
        int leastSumIdx = -1;
        for (int i = 0; i <= A.size() - B; i++) {
            int curSum = 0;
            int j = i;
            for (; j < i+B; j++) {
                curSum += A.get(j);
            }
            if (curSum < leastSumValue){
                leastSumValue = curSum;
                leastSumIdx = j - B;
            }
        }
        return leastSumIdx;
    }

    public static void main(String[] args) {
        System.out.println(solve(Util.fillArrayList(new int[]{3, 7, 90, 20, 10, 50, 40}), 3)); // expected : 3
        System.out.println(solve(Util.fillArrayList(new int[]{3, 7, 5, 20, -10, 0, 12}), 2)); // expected : 4
        System.out.println(solve(Util.fillArrayList(new int[]{20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11}), 9)); // expected : 3
    }
}

/*
Given an array of size N, Find the subarray with least average of size k.
constraints:
1<=k<=N<=1e5
-1e5<=A[i]<=1e5
input format:
    First argument contains an array A of integers of size N.
    Second argument contains integer k.
output format:
    Return the index of the first element of the subarray of size k that has least average.
    Array indexing starts from 0.

Input 1:
A=[3, 7, 90, 20, 10, 50, 40] B=3, output : 3
explanation: Subarray between indexes 3 and 5 The subarray {20, 10, 50} has the
least average  among all subarrays of size 3.

Input 2:
A=[3, 7, 5, 20, -10, 0, 12] B=2, output : 4
explanation:  Subarray between [4, 5] has minimum average

 */