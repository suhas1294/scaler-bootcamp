package _03_advance._2022_04_29.two_pointers.assignments;

import java.util.Arrays;

public class ThreeSumZero {
    public static int[][] threeSum(int[] A) {
        return new int[][]{};
    }
}
/*
Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
Find all unique triplets in the array which gives the sum of zero.
Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.

Problem Constraints
0 <= N <= 7000
-10^8 <= A[i] <= 10^8

Input Format : Single argument representing a 1-D array A.
Output Format : Output a 2-D vector where each row represent a unique triplet.

Input A = [-1,0,1,2,-1,4] Output [ [-1,0,1], [-1,-1,2] ]
Explanation :
Out of all the possible triplets having total sum zero,only the above two triplets are unique.
 */