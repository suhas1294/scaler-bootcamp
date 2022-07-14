package _03_advance._2022_07_11.backtracking_1.assignments;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {
    public ArrayList <ArrayList< Integer >> combinationSum(ArrayList < Integer > A, int B) {
        // Sort the array first it reduces the soritng required before returning the list.
        Collections.sort(A);
        ArrayList < ArrayList < Integer >> list = new ArrayList < > ();
        if (A.size() == 0)
            return list;
        combinationSum(list, A, new ArrayList < Integer > (), B, 0, 0);
        return list;
    }
    void combinationSum(ArrayList < ArrayList < Integer >> list, ArrayList < Integer > input, ArrayList < Integer > out, int B, int index, int sum) {
        // Returns if sum exceeds the targer value
        if (sum > B) return;
        if (sum == B) {
            // Check if the list already present dont add it again, duplicates lists can come becuse input list can have duplicate elements
            if (!list.contains(out))
                list.add(new ArrayList < > (out));
            return;
        }

        for (int i = index; i < input.size(); i++) {
            out.add(input.get(i));
            // Dont need to increase the index here as we need all possible sum even if the value is counted multiple times.
            combinationSum(list, input, out, B, i, sum + input.get(i));
            out.remove(out.size() - 1);
        }
    }
}

/*
Given an array of candidate numbers A and a target number B, find all unique
combinations in A where the candidate numbers sums to B.
The same repeated number may be chosen from A unlimited number of times.

Note:
1) All numbers (including target) will be positive integers.
2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3) The combinations themselves must be sorted in ascending order.
4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
5) The solution set must not contain duplicate combinations.

Problem Constraints
1 <= |A| <= 20
1 <= A[i] <= 50
1 <= B <= 500

Input Format :
The first argument is an integer array A.
The second argument is integer B.

Output Format :  Return a vector of all combinations that sum up to B.

Input 1: A = [2, 3] B = 2 Output 1: [ [2] ]
Explanation 1: All possible combinations are listed.

Input 2: A = [2, 3, 6, 7] B = 7 Output 2: [ [2, 2, 3] , [7] ]
Explanation 2: All possible combinations are listed.
 */