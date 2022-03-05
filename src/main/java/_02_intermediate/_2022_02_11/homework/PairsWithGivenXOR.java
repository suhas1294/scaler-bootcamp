package _02_intermediate._2022_02_11.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairsWithGivenXOR {
    public static int solve(int[] A, int B) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (!set.contains(A[i] ^ B)){
                set.add(A[i]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(A[i]);
                list.add(A[i] ^ B);
                ans.add(list);
            }
        }
        for (List<Integer> list: ans) {
            System.out.println(list);
        }
        return ans.size();
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 6, 8, 10, 15, 50}, 5));
    }
}

/*
Given an 1D integer array A containing N distinct integers.
Find the number of unique pairs of integers in the array whose XOR is equal to B.
NOTE: Pair (a, b) and (b, a) is considered to be same and should be counted once.


Problem Constraints
1 <= N <= 10^5
1 <= A[i], B <= 10^7

Input Format : First argument is an 1D integer array A. Second argument is an integer B.
Output Format: Return a single integer denoting the number of unique pairs of integers in the array
A whose XOR is equal to B.

Input 1: A = [5, 4, 10, 15, 7, 6] B = 5 Output : 1,
Explanation 1: (10 ^ 15) = 5

Input 2: A = [3, 6, 8, 10, 15, 50] B = 5 Output : 2
Explanation 2: (3 ^ 6) = 5 and (10 ^ 15) = 5
 */