package _03_advance._2022_07_13.backtracking_2.assignments;

import java.util.ArrayList;

public class AllUniquePermutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        backtrack(0, A.size(), A, list);
        return list;
    }

    public void backtrack(int index, int n, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> list) {
        // base condition
        if(index == n) {
            // only add unique combinations
            if(!list.contains(A)) {
                list.add(new ArrayList<Integer>(A));
            }
        }

        for(int i=index; i< n; i++) {
            // do: swap
            swap(A, index, i);
            backtrack(index + 1, n, A, list);
            // undo: swap
            swap(A, index, i);
        }
    }

    public void swap(ArrayList<Integer> A, int i, int k) {
        Integer temp = A.get(i);
        A.set(i, A.get(k));
        A.set(k, temp);
    }
}

/*
Given an array A of size N denoting collection of numbers that might contain duplicates,
return all possible unique permutations.
NOTE: No 2 entries in the permutation sequence should be the same.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.

Problem Constraints
1 <= |A| <= 9
0 <= A[i] <= 10

Input Format : Only argument is an integer array A of size N.
Output Format : Return a 2-D array denoting all possible unique permutation of the array.

Input 1: A = [1, 1, 2]
Output 1:
[ [1,1,2]
  [1,2,1]
  [2,1,1] ]
Explanation 1: All the possible unique permutation of array [1, 1, 2].

Input 2: A = [1, 2]
Output 2:
[ [1, 2]
  [2, 1] ]
Explanation 2: All the possible unique permutation of array [1, 2].
 */