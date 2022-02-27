package _02_intermediate._2022_02_04.sorting.assignments;

import utils.Util;

import java.util.ArrayList;
import java.util.Collections;

public class NobleElementGrtThen {
    public static int solve(ArrayList<Integer> A) {
        A.sort(Collections.reverseOrder());
        System.out.println(A);
        int more = 0;
        if(A.get(0) == 0) return 1;
        for (int i = 1; i < A.size(); i++) {
            if (!A.get(i).equals(A.get(i - 1))){
                more = i;
            }
            if (more == A.get(i)) return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = Util.arrayToList(new int[]{ -4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 });
        System.out.println(solve(list));
    }
}

/*
Given an integer array A, find if an integer p exists in the
array such that the number of integers greater than p in the array equals to p.

input format: First and only argument is an integer array A.
output format: Return 1 if any such integer p is found else return -1.

input: A = [3, 2, 1, 3], output: 1, exp: For integer 2, there are 2 greater elements in the array. So, return 1.
input: A = [1, 1, 3, 3], output: -1, exp:  There is no such integer exists.

 */