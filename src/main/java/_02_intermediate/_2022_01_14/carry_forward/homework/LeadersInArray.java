package _02_intermediate._2022_01_14.carry_forward.homework;

import java.util.ArrayList;

public class LeadersInArray {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int curMax = Integer.MIN_VALUE;
        for (int i = A.size()-1; i >= 0 ; i--) {
            if (A.get(i) > curMax) {
                curMax = A.get(i);
                result.add(0, curMax);
            }
        }
        return result;
    }
}

/*
Given an integer array A containing N distinct integers, you have to find all the leaders in the array A.
An element is leader if it is strictly greater than all the elements to its right side.
NOTE:The rightmost element is always a leader.

constraints:
1 <= N <= 105
1 <= A[i] <= 108

input format: First and only argument is an integer array A.
output format: Return an integer array denoting all the leader elements of the array.
NOTE: Ordering in the output doesn't matter.

Input 1:
 A = [16, 17, 4, 3, 5, 2]
 output : [17, 2, 5]
 explanation:
 Element 17 is strictly greater than all the elements on the right side to it.
 Element 2 is strictly greater than all the elements on the right side to it.
 Element 5 is strictly greater than all the elements on the right side to it.
 So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.

Input 2:
 A = [1, 2]
 output : [2]
 explanation: Only 2 the rightmost element is the leader in the array.

 */