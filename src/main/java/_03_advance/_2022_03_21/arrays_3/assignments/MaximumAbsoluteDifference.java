package _03_advance._2022_03_21.arrays_3.assignments;

public class MaximumAbsoluteDifference {
    public static int maxArr(int[] arr) {
        int add_max = arr[0]+0, sub_max = arr[0]-0;
        int add_min = arr[0]+0, sub_min = arr[0]-0;

        for(int i=0; i<arr.length; i++) {
            add_max = Math.max(add_max, arr[i]+i);
            add_min = Math.min(add_min, arr[i]+i);
            sub_max = Math.max(sub_max, arr[i]-i);
            sub_min = Math.min(sub_min, arr[i]-i);
        }
        return Math.max(add_max-add_min, sub_max-sub_min);
    }
}

/*
You are given an array of N integers, A1, A2, …. AN.
Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined
as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

1 <= N <= 100000
-10^9 <= A[i] <= 10^9

Input Format : First argument is an integer array A of size N.
Output Format : Return an integer denoting the maximum value of f(i, j).

Input 1: A = [1, 3, -1]
Input 2: A = [2]

Output 1: 5
Output 2: 0

Explanation 1:
f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
So, we return 5.

Explanation 2:
Only possibility is i = 1 and j = 1. That gives answer = 0.
 */