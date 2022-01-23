package _02_intermediate._2022_01_21.sliding_window.homework;

import utils.Util;
import java.util.ArrayList;

public class MaximumPositivity {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxLen = 0, curLen, startIdx = 0;
        int start = 0;
        for (int end = 0; end < A.size(); end++) {
            if (A.get(end) >= 0){
                curLen = end - start + 1;
                if (curLen > maxLen) startIdx = start;
                if (curLen == maxLen) startIdx = Math.min(startIdx, start);
                maxLen = Math.max(maxLen, curLen);
            }else{
                start = end + 1;
            }
        }
        for (int i = startIdx; i < startIdx + maxLen; i++) {
            result.add(A.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(Util.arrayToList(new int[]{5, 6, -1, 7, 8})));
        System.out.println(solve(Util.arrayToList(new int[]{ 8986143, -5026827, 5591744, 4058312, 2210051,
                5680315, -5251946, -607433, 1633303, 2186575 }))); // expected : 5591744 4058312
    }
}

/*
Given an array of integers A, of size N.
Return the maximum size subarray of A having only non-negative elements.
If there are more than one such subarrays, return the one having the earliest starting index in A.
NOTE: It is guaranteed that an answer always exists.

constraints:
1 <= N <= 10^5
-109 <= A[i] <= 10^9

input format: The first and only argument given is the integer array A.
output format: Return maximum size subarray of A having only non-negative elements.
If there are more than one such subarrays, return the one having earliest starting index in A.

Input 1: A = [5, 6, -1, 7, 8], output : [5, 6]
explanation:  There are two subarrays of size 2 having only non-negative elements.
 1. [5, 6]  starting point  = 0
 2. [7, 8]  starting point  = 3
 As starting point of 1 is smaller, return [5, 6]

Input 2: A = [1, 2, 3, 4, 5, 6], output : [1, 2, 3, 4, 5, 6]
explanation: There is only one subarray of size 6 having only non-negative elements:
 [1, 2, 3, 4, 5, 6]


 */