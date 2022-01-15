package _02_intermediate._2022_01_12.prefix_sum.assignments;

import utils.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialIndexSumOfOddEvenIndexes {
    public static int solve(ArrayList<Integer> A) {
        int[] prefixEvenSum = new int[A.size()];
        prefixEvenSum[0] = A.get(0);
        int[] prefixOddSum = new int[A.size()];
        prefixOddSum[0] = 0;

        for (int i = 1; i < A.size(); i++) {
            if (i % 2 == 0){
                prefixEvenSum[i] = A.get(i) + prefixEvenSum[i-1];
                prefixOddSum[i] = prefixOddSum[i-1];
            }else{
                prefixOddSum[i] = A.get(i) + prefixOddSum[i-1];
                prefixEvenSum[i] = prefixEvenSum[i-1];
            }
        }
        // for each index check if its special index or not
        int specialIndicesCount = 0;
        for (int index = 0; index < A.size(); index++) {
            int leftEvenSum = index == 0 ? 0 : prefixEvenSum[index-1];
            int rightEvenSum = prefixOddSum[A.size()-1] - prefixOddSum[index];
            int leftOddSum = index == 0 ? 0 : prefixOddSum[index-1];
            int rightOddSum = prefixEvenSum[A.size()-1] - prefixEvenSum[index] ;
            int totalEvenSum = leftEvenSum + rightEvenSum;
            int totalOddSum = leftOddSum + rightOddSum;
            if (totalEvenSum == totalOddSum) specialIndicesCount++;
        }
        return specialIndicesCount;
    }

    public static void main(String[] args) {
        //ArrayList<Integer> input = Util.fillArrayList(new int[]{2, 1, 6, 4});
        ArrayList<Integer> input = Util.fillArrayList(new int[]{1,1,1});
        //ArrayList<Integer> input = Util.fillArrayList(new int[]{4, 3, 2, 7, 6, -2});
        System.out.println(solve(input));
    }
}
/*
Count ways to make sum of odd and even indexed elements equal by removing an array element
Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element
from these indices makes the sum of even-indexed and odd-indexed array elements equal.
constraints:
1<=n<=1e5
-1e5<=A[i]<=1e5
input format: First argument contains an array A of integers of size N
output format: Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
input 1: A=[2, 1, 6, 4], output : 1
explanation: Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
Therefore, the required output is 1.

input 2: A=[1, 1, 1], output : 3
explanation: Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Therefore, the required output is 3.

 */