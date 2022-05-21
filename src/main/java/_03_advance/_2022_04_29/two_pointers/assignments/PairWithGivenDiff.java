package _03_advance._2022_04_29.two_pointers.assignments;

import java.util.Arrays;

public class PairWithGivenDiff {
    public static int solve(int[] A, int B) {
        int N = A.length;
        int count = 0, i = 0, j = 1;
        Arrays.sort(A);

        int p2 = -1, p1 = -1;
        while (j < N) {
            int diff = Math.abs(A[j] - A[i]);
            if (diff == B) {
                if (p1 != A[j] && p2 != A[i]) {
                    count++;
                    p1 = A[j];
                    p2 = A[i];
                }
                i++;
                j++;
            } else if (diff > B) {
                i++;
                if (i == j) {
                    j++;
                }
            } else {
                j++;
            }
        }
        return count;
    }
}

/*
Given an one-dimensional integer array A of size N and an integer B.
Count all distinct pairs with difference equal to B.
Here a pair is defined as an integer pair (x, y), where x and y are
both numbers in the array and their absolute difference is B.

Problem Constraints
1 <= N <= 10^4
0 <= A[i], B <= 10^5

Input Format
First argument is an one-dimensional integer array A of size N.
Second argument is an integer B.

Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.

Input 1: A = [1, 5, 3, 4, 2] B = 3 Output 1: 2
Input 2: A = [8, 12, 16, 4, 0, 20] B = 4 Output 2: 5
Input 3: A = [1, 1, 1, 2, 2] B = 0 Output 3: 2

Explanation 1:
 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
Explanation 2:
 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
Explanation 3:
 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */