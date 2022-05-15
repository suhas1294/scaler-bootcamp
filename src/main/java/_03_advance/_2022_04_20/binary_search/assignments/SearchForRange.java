package _03_advance._2022_04_20.binary_search.assignments;

public class SearchForRange {
    public int[] searchRange(final int[] A, int B) {
        int firstIdx = getOccurence(A, B, true);
        int lastIdx = getOccurence(A, B, false);
        if (firstIdx == Integer.MIN_VALUE && lastIdx == Integer.MIN_VALUE) return new int[]{-1, -1};
        return new int[]{firstIdx, lastIdx};
    }

    // if firstOccurrence is false, then last occurrence will be given
    public static int getOccurence(int a[], int k, boolean firstOccurence){
        int n = a.length;
        int l = 0, h = n-1, ans = Integer.MIN_VALUE;
        while (l <= h){
            int m = (l+h)/2;
            if (a[m] == k) { // go to right for better answer index
                ans = m;
                if (firstOccurence){
                    h = m-1;
                }else {
                    l = m + 1;
                }
            } else if (a[m] < k) { // go to right
                l = m + 1;
            }else{ // a[m] > k, go to left.
                h = m - 1;
            }
        }
        return ans;
    }
}

/*
Given a sorted array of integers A(0 based index) of size N, find the starting and the ending
position of a given integer B in array A. Your algorithm's runtime complexity must be in the
order of O(log n).Return an array of size 2, such that the first element = starting position
of B in A and the second element = ending position of B in A, if B is not found in A return [-1, -1].

Problem Constraints
1 <= N <= 10^6
1 <= A[i], B <= 10^9

The first argument given is the integer array A.
The second argument given is the integer B.
Return an array of size 2, such that the first element = starting position of B in A and the second element = the ending position of B in A if B is not found in A return [-1, -1].

Input 1: A = [5, 7, 7, 8, 8, 10] B = 8, Output 1: [3, 4]
Explanation 1:
 The first occurence of 8 in A is at index 3.
 The second occurence of 8 in A is at index 4.
 ans = [3, 4]


Input 2: A = [5, 17, 100, 111] B = 3, Output 2: [-1, -1]
Explanation 2: There is no occurence of 3 in the array.


 */