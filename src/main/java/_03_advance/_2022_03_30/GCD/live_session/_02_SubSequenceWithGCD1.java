package _03_advance._2022_03_30.GCD.live_session;

public class _02_SubSequenceWithGCD1 {
    public static boolean solve(int[] arr){
        return _01_EuclideanGCD.getGcdOfArray(arr) == 1;
    }
}
/*
Given an array, return if there exists a sub sequence with gcd = 1;
Note that {} subsequence is not valid.
 */
