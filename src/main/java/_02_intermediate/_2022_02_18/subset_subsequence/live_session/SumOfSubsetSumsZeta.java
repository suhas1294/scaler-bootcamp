package _02_intermediate._2022_02_18.subset_subsequence.live_session;

// It is indirectly : sum of all array elements by 2
public class SumOfSubsetSumsZeta {
    public static int solve(int[] A){
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum/2;
    }
}

/*
Given n distinct elements, Calculate ((sum of all subset sums)/2^n)
refer prev problem and refer notes for better explanation.
 */