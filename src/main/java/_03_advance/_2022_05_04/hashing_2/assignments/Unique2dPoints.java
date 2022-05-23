package _03_advance._2022_05_04.hashing_2.assignments;

import java.util.HashSet;

public class Unique2dPoints {
    public static int solve(int[][] A) {
        HashSet<String> rtrn = new HashSet<String>();
        for(int i=0;i<A.length;i++){
            rtrn.add(""+A[i][0]+","+A[i][1]);
        }
        return rtrn.size();
    }
}

/*
Given a 2D array A of integer points on a 2D plane. Find and return the number of
unique points in the array. The ith point in the array is (A[i][0], A[i][1])

Problem Constraints
1 <= len(A) <= 10^5
-10^9 <= A[i][0], A[i][1] <= 10^9

Input Format : The first argument is a 2D integer array A.
Output Format : Return an integer that is the number of unique points.

Input:
A = [[5, 6],
     [2, 8],
     [-1, -1],
     [2, -3],
     [2, 8],
     [7, 7],
     [2, -3]]

Output: 5

Explanation: There are 5 unique points in the given array.
 */