package _02_intermediate._2022_01_26.bit_manipulation.homework;

import java.util.Arrays;

// TLE error
public class SubArrayWithBitwiseOR1 {
    public static long solve(int A, int[] B) {
        long cnt = 0;
        for (int start = 0; start < A; start++) {
            int temp = 0;
            for (int end = start; end < A; end++) {
                if(subArrayContainsOne(B, start, end)) cnt++;
            }
            if (temp == 1) cnt++;
        }
        return cnt;
    }

    public static boolean subArrayContainsOne(int[] arr, int startIdx, int endIdx){
        for (int i = startIdx; i <= endIdx; i++) {
            if (arr[i] == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solve(3, new int[]{1, 0, 1}));
    }
}

/*
Given an array B of length A with elements 1 or 0. Find the number of subarrays with bitwise OR 1.
1 <= A <= 10^5
The first argument is a single integer A.
The second argument is an integer array B.
Return the number of subarrays with bitwise array 1.

Input 1: A = 3 , B = [1, 0, 1], output: 5
explanation: The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1

Input 2: A = 2, B = [1, 0], output : 2
explanation: The subarrays are :- [1], [0], [1, 0]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 */