package _03_advance._2022_07_11.backtracking_1.assignments;

import java.util.ArrayList;
import java.util.Collections;

public class ReturnAllSubsets {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> totalSubsets = new ArrayList<>();
        Collections.sort(A);
        backtrack(totalSubsets, new ArrayList<Integer>(), A, 0);
        return totalSubsets;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> totalSubsets, ArrayList<Integer> subset,
                           ArrayList<Integer> nums, int start) {
        totalSubsets.add(new ArrayList<>(subset));
        for (int k=start; k<nums.size(); k++) {
            subset.add(nums.get(k));
            backtrack(totalSubsets, subset, nums, k + 1);
            subset.remove(subset.size()-1);
        }
    }


    // ---------- alternate solution using global variable -------------
    ArrayList<ArrayList<Integer>> resList = new ArrayList(); //Global variable to hold response
    public ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> A){
        // Since values are required in lex order lets sort given collection
        Collections.sort(A);
        //call recursive method
        computeSubSet(0, A, new ArrayList());
        return resList;
    }

    void computeSubSet(int index, ArrayList<Integer> A, ArrayList<Integer> tempList) {
        //add currentlist to result as its valid subset
        resList.add(new ArrayList(tempList));
        //for loop to iterate from start to end of inputlist
        for (int i = index; i < A.size() ; i++) {
            tempList.add(A.get(i)); //DO operation
            computeSubSet(index + 1, A, tempList); //Recursive call for next element
            tempList.remove(tempList.size() - 1); //UNDO operation
        }
    }
}

/*
Given a set of distinct integers A, return all possible subsets.

NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.

Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX

Input Format : First and only argument of input contains a single integer array A.
Output Format : Return a vector of vectors denoting the answer.

Input 1: A = [1]

Output 1:
[
    []
    [1]
]
Explanation 1: You can see that these are all possible subsets.

Input 2: A = [1, 2, 3]
Output 2:
[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]
Explanation 2: You can see that these are all possible subsets.
 */