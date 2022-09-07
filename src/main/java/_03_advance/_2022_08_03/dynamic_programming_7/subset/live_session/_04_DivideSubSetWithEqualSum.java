package _03_advance._2022_08_03.dynamic_programming_7.subset.live_session;

import java.util.stream.IntStream;

public class _04_DivideSubSetWithEqualSum {
    boolean canWeDivideSubsetWithEqSum(int[] a, int n){
        int sum = IntStream.of(a).sum();
        if (sum % 2 != 0) return false;
        int half = sum / 2;
        return _03_CheckIfSubsetWithSumKExists.isThereSubsetWithSumK(a, half);
    }
}

/*
given a[n] and k, divide all elements into 2 subsets.
check, if we can divide all elements in 2 subsets such that both subset have equal sum.
note : a[i] can only go into single subset.
{1,5,3,6,9,2} can be divided into {5,6,2} and {1,9,3}, so return true

observations:
1. if sum of all elements in arr is odd, return false
2. if all sum(subset1) == sum(subset2), then sum(subset1) = sum of arr elements/2
So what we need to do ? : check if there exists a subset with sum  = (sum of array elements)/2

 */