package _02_intermediate._2022_02_04.sorting.assignments;

import utils.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CheckIfArithmaticProgression {
    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int diff = A.get(1) - A.get(0);
        for (int n = 0; n < A.size(); n++) {
            int expectedValue = A.get(0) + (n * diff);
            if (A.get(n) != expectedValue) return -1;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solve(Util.arrayToList(new int[]{1,3,5})));
    }
}

/*
Given an integer array A of size N. Return 1 if the array can be rearranged to form an
arithmetic progression, otherwise, return 0.A sequence of numbers is called an arithmetic
progression if the difference between any two consecutive elements is the same.

2 <= N <= 10^5
-10^9 <= A[i] <= 10^9

First and only argument is an integer array A of size N.
Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0

input : A = [3, 5, 1], output : 1, exp: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
input : A = [2, 4, 1], output : 0, exp: There is no way to reorder the elements to obtain an arithmetic progression.

 */
