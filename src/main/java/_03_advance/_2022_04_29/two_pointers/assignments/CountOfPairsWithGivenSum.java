package _03_advance._2022_04_29.two_pointers.assignments;

public class CountOfPairsWithGivenSum {
    public static int solve(int[] A, int B) {
        int p1=0, p2=A.length-1;
        int ans=0;
        while(p1 < p2) {
            if(A[p1] + A[p2] == B) {
                ans++;
                p1++;
                p2--;
            }
            else if(A[p1] + A[p2] < B) {
                p1++;
            }
            else {
                p2--;
            }
        }
        return ans;
    }
}

/*
Given a sorted array of distinct integers A and an integer B, find and return how
many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format : Return the number of pairs for which sum is equal to B.

Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input 1: A = [1, 2, 3, 4, 5] B = 5 Output 1: 2
Input 2: A = [5, 10, 20, 100, 105] B = 110 Output 2: 2
 */