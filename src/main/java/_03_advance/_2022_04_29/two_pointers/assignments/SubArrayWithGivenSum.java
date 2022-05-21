package _03_advance._2022_04_29.two_pointers.assignments;

public class SubArrayWithGivenSum {
    public static int[] solve(int[] A, int B) {
        int sum = 0;
        int l = 0, r = 0;
        boolean flag = false;

        while(r < A.length && l < A.length){
            while(sum < B && r < A.length){
                sum += A[r];
                r++;
            }
            if(sum == B){
                flag = true;
                break;
            }
            while(sum > B && l < A.length){
                sum -= A[l];
                l++;
            }
            if(sum == B){
                flag = true;
                break;
            }
        }

        if(flag){
            int[] result = new int[r-l];
            for (int i = l, j = 0; i < r; i++, j++) {
                result[j] = A[i];
            }
            return result;
        }
        return new int[]{-1};
    }
}

/*
Given an array of positive integers A and an integer B, find and return first continuous
subarray which adds to B. If the answer does not exist return an array with a single element "-1".
First sub-array means the sub-array for which starting index in minimum.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not
exist return an array with a single element "-1".

Input 1: A = [1, 2, 3, 4, 5] B = 5 Output 1: [2, 3]
Explanation 1: [2, 3] sums up to 5.

Input 2: A = [5, 10, 20, 100, 105] B = 110 Output 2: -1
Explanation 2: No subarray sums up to required number.
 */