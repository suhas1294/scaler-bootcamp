package _03_advance._2022_07_13.backtracking_2.assignments;

import java.util.ArrayList;
import java.util.Collections;

public class Permutations {
    ArrayList<ArrayList<Integer>> bigList;

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        bigList = new ArrayList<>();
        ArrayList<Integer> smallList = A;
        genList(0, A.size(), A, smallList);
        return bigList;
    }

    public void genList(int i, int n, ArrayList<Integer> A, ArrayList<Integer> smallList) {
        if (i == n) {
            bigList.add(new ArrayList<>(smallList));
            return;
        }

        for (int j = i; j < n; j++) {
            Collections.swap(smallList, j, i);
            genList(i + 1, n, A, smallList);
            Collections.swap(smallList, j, i);
        }
    }
}

/*
Given an integer array A of size N denoting collection of numbers ,
return all possible permutations.
NOTE:
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= N <= 9

Input Format :Only argument is an integer array A of size N.
Output Format : Return a 2-D array denoting all possible permutation of the array.

Example Input : A = [1, 2, 3]
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3]
  [2, 3, 1]
  [3, 1, 2]
  [3, 2, 1] ]

Example Explanation
All the possible permutation of array [1, 2, 3].
 */