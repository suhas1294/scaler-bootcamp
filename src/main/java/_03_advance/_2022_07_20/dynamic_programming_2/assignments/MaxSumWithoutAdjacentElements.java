package _03_advance._2022_07_20.dynamic_programming_2.assignments;

// note same as : _03_MaxSubsequenceSumCondition.java
public class MaxSumWithoutAdjacentElements {
    // BottomUp/Iterative Approach, SC: O(1)
    public int adjacent(int[][] A) {
        int a = 0;
        int b = Math.max(A[0][0], A[1][0]);
        int c = b;
        int N = A[0].length;
        for (int i = 2; i <= N; i++) {
            c = Math.max(Math.max(A[0][i - 1], A[1][i - 1]) + a, b);
            a = b;
            b = c;
        }
        return c;
    }
}

/*
Given a 2 x N grid of integer, A, choose numbers such that the sum of the
numbers is maximum and no two chosen numbers are adjacent horizontally, vertically
or diagonally, and return it.
Note: You can choose more than 2 numbers.

Problem Constraints

1 <= N <= 20000
1 <= A[i] <= 2000



Input Format

The first and the only argument of input contains a 2d matrix, A.



Output Format

Return an integer, representing the maximum possible sum.



Example Input

Input 1:

 A = [
        [1]
        [2]
     ]
Input 2:

 A = [
        [1, 2, 3, 4]
        [2, 3, 4, 5]
     ]


Example Output

Output 1:

 2
Output 2:

 8


Example Explanation

Explanation 1:

 We will choose 2.
Explanation 2:

 We will choose 3 and 5.
 */