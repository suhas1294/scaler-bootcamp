package _03_advance._2022_04_22.binary_search_2.assignments;

public class SpecialInteger {
    public static int solve(int[] A, int B) {
        int left = 1;
        int right = A.length;
        int ans = 0;
        while(left <= right) {
            int mid = left+right >> 1;
            if(isPossible(A, B, mid)) {
                ans = mid;
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] A, int B, int range) {
        long cur_sum = 0;
        for(int i=0; i<range; i++) {
            cur_sum += A[i];
        }
        if(cur_sum > B) return false;
        for(int i=range; i<A.length; i++) {
            cur_sum = cur_sum - A[i-range] + A[i];
            if(cur_sum > B) return false;
        }
        return true;
    }
}
/*
Given an array of integers A and an integer B, find and return the maximum value K
such that there is no subarray in A of size K with the sum of elements greater than B.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the maximum value of K (sub array length).

Input 1: A = [1, 2, 3, 4, 5] B = 10, Output 1: 2
Explanation 1: Constraints are satisfied for maximal value of 2.

Input 2: A = [5, 17, 100, 11] B = 130 Output 2: 3
Explanation 2: Constraints are satisfied for maximal value of 3.
 */