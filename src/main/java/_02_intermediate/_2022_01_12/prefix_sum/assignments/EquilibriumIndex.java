package _02_intermediate._2022_01_12.prefix_sum.assignments;

import utils.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class EquilibriumIndex {
    public static int solve(ArrayList<Integer> A) {
        // step-1 : construct prefix sum for input array
        int[] prefixSumArr = new int[A.size()];
        prefixSumArr[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            prefixSumArr[i] = A.get(i) + prefixSumArr[i-1];
        }
        System.out.println("input arr: " + A);
        System.out.println("prefix sum :" + Arrays.toString(prefixSumArr));
        // step-2 : at every index of a given array, check if it is equilibrium index
        int eqIdxCnt = 0;
        int minEqIdx = -1;
        for (int index = 0; index < A.size(); index++) {
            int leftSum = (index == 0) ? 0 : prefixSumArr[index-1];
            int rightSum = prefixSumArr[A.size()-1] - (index == 0 ? 0 : prefixSumArr[index]);
            if ( leftSum == rightSum) {
                if (minEqIdx == -1) minEqIdx = index;
                eqIdxCnt++;
            }
        }
        return minEqIdx;
    }

    public static void main(String[] args) {
        //ArrayList<Integer> input = Util.fillArrayList(new int[]{-7, 1, 5, 2, -4, 3, 0});
        ArrayList<Integer> input = Util.arrayToList(new int[]{1, 2, 3, 7, 1, 2, 3 });
        System.out.println(solve(input));
    }
}

/*
You are given an array A of integers of size N.
Your task is to find the equilibrium index of the given array
Equilibrium index of an array is an index such that the sum of elements
at lower indexes is equal to the sum of elements at higher indexes.

NOTE:
Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.
1<=N<=1e5
-1e5<=A[i]<=1e5

input format: First arugment contains an array A .
output format: Return the equilibrium index of the given array. If no such index is found then return -1.

input 1: A=[-7, 1, 5, 2, -4, 3, 0] , output : 3
explanation: 3 is an equilibrium index, because: A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

input 2: A=[1,2,3], ouput : -1
explanation: There is no such index.
 */