package _03_advance._2022_07_13.backtracking_2.live_session;

import utils.Util;

import java.util.Arrays;

public class PrintAllPermutations {
    // array to hold each uniquely generated number
    // i is current index which is being processed
    // tc : n! * n (n for printing array each time), sc : O(n)
    void printAllPermutations(int a[], int n, int i){
        if (i == n-1){
            System.out.println(Arrays.toString(a));
            return;
        }
        // we have to find ith index element
        for (int j = i; j < n; j++) {
            Util.swapIndicesOfanArray(a, i, j); // make changes
            printAllPermutations(a, n, i+1); // func call, generate all permutations
            Util.swapIndicesOfanArray(a, i, j); // revert changes
        }
    }
}

/*
given n distinct numbers, print all permutations (order does not matter)
ex : n = 2, numbers formed are 12 and 21
if n = 3, numbers formed are  : 123 132 213 231 312 321

 */