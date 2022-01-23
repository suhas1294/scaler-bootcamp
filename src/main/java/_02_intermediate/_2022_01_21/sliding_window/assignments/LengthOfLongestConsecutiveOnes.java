package _02_intermediate._2022_01_21.sliding_window.assignments;

public class LengthOfLongestConsecutiveOnes {
    public static int solve(String A) {
        return -1;
    }

    // solution in case we are allowed to (flip one zero) and not (swap zero with one)
    public static int solveFlip(String A) {
        char[] arr = A.toCharArray();
        int maxConsecutiveOne = 0;
        int start = 0;
        int  k = 1; // no of swaps allowed
        int zeroCount = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == '0') zeroCount++;
            System.out.printf("start = %d, end  = %d,  zeroCount = %d, arr[i] = %c, k = %d, maxCount = %d, zeroCount > k : %b\n"
                    , start, end, zeroCount, arr[end], k, maxConsecutiveOne, zeroCount > k);
            while (zeroCount > k){
                if (arr[start] == '0') zeroCount--;
                start++;
            }
            maxConsecutiveOne = Math.max(maxConsecutiveOne, end-start + 1);
        }
        return maxConsecutiveOne;
    }

    public static void main(String[] args) {
        System.out.println(solve("111011101"));
    }
}

/*
Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
Find and return the length of the longest consecutive 1’s that can be achieved.
input format : The only argument given is string A.
output format: Return the length of the longest consecutive 1’s that can be achieved.
constraints:
1 <= length of string <= 1000000
A contains only characters 0 and 1.
Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7
 */