package _02_intermediate._2022_01_17.assignments;

import java.util.ArrayList;

public class SumOfAllSubArrays {
    public static long getSumOfAllSubArrays(ArrayList<Integer> A){
        long sum = 0;
        for (int i = 0; i < A.size(); i++) {
            long left = i+1; // in how many sub arrays, ith index can be start
            long right = A.size()-i; // in how many sub arrays, ith index can be end
            long noOfPresenceInAllSubArrays = left * right; // in how many sub arrays, ith index is present
            long sumContributionByNum = noOfPresenceInAllSubArrays * A.get(i);
            sum += sumContributionByNum;
        }
        return sum;
    }
}

/*
You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is a defined as a contiguous part of an array,
which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.

1 <= N <= 10^5
1 <= A[i] <= 10^4

input format: The first argument is the integer array A.
output formar: Return a single integer denoting the sum of all subarray sums of the given array.

input 1: A = [1, 2, 3], output : 20,
explanation: The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20

input 2: A = [2, 1, 3], output: 19
explanation: Similiar to the first example, the sum of all subarray sums for this array is 19.
 */