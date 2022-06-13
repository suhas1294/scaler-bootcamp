package _02_intermediate._2022_02_09.hashmap.homework;

// TODO : implementation
public class ColorfulNumber {
    public static int colorful(int A) {
        return -1;
    }
}

/*
For Given Number A find if its COLORFUL number or not.
If number A is a COLORFUL number return 1 else return 0.

What is a COLORFUL Number:
A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.

Problem Constraints 1 <= A <= 2 * 10^9

Input Format: Single Argument which denotes integer A.
Output Format: Return 1 if integer A is COLORFUL else return 0.

Input 1: A = 23, output : 1,
Explanation 1:
 Possible Sub-sequences: [2, 3, 23] where
 2 -> 2
 3 -> 3
 23 -> 6  (product of digits)
 This number is a COLORFUL number since product of every digit of a sub-sequence are different.

Input 2: A = 236, output: 0
Explanation 2: Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 2 -> 2
 3 -> 3
 6 -> 6
 23 -> 6  (product of digits)
 36 -> 18  (product of digits)
 236 -> 36  (product of digits)
 This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
 */