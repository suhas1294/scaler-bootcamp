package _02_intermediate._2022_01_12.prefix_sum.homework;

import java.util.ArrayList;

public class TimeToEquality {
    public int solve(ArrayList<Integer> A) {
        // step-1 find max element in array
        int curMax = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > curMax) curMax = A.get(i);
        }
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            result += curMax - A.get(i);
        }
        return result;
    }
}

/*
Given an integer array A of size N. In one second you can increase the value of one element by 1.
Find the minimum time in seconds to make all elements of the array equal.
constraints:
1 <= N <= 1000000
1 <= A[i] <= 1000
input format:
First argument is an integer array A.
output format:
Return an integer denoting the minimum time to make all elements equal.
input 1: A = [2, 4, 1, 3, 2]
output : 8, explanation: We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
 */