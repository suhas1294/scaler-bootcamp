package _02_intermediate._2022_02_11.assignments;

public class SubArrayWithGivenSum {
    // https://www.interviewbit.com/blog/subarray-with-given-sum/
    public static int[] Find_Subarray(int A[], int B) {
        int sum = A[0];
        int start = 0;
        for (int i = 1; i <= A.length; i++) {
            while (sum > B && start < i - 1) {
                sum = sum - A[start];
                start++;
            }
            if (sum == B) {
                int[] ans = new int[i-start];
                for (int j = start, k = 0; j < i; j++,k++) {
                    ans[k] = A[j];
                }
                return ans;
            }
            if (i < A.length) {
                sum = sum + A[i];
            }
        }
        return new int[]{-1};
    }
}

/*
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single element "-1".
First sub-array means the sub-array for which starting index in minimum.

1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

input format:
The first argument given is the integer array A.
The second argument given is integer B.

output format: Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".

Input 1: A = [1, 2, 3, 4, 5] B = 5, output: [2, 3], exp; [2, 3] sums up to 5.
Input 2: A = [5, 10, 20, 100, 105] B = 110, output: [-1], exp:  No subarray sums up to required number.

We have to take two variables one for the current sum and the other for the starting index of the window
Check if the current sum is less than or equal to the required sum.
If less then add the new element to the current sum.
If equal, return true.
If the current sum exceeds the required sum, subtract the arr[start] from the current sum and change start=start+1.
If we return from the nested loop then we could not find any desired subarray so return false.

 */