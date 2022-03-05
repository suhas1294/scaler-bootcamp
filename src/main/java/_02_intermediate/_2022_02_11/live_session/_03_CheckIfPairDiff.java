package _02_intermediate._2022_02_11.live_session;

import java.util.HashSet;
import java.util.Set;

public class _03_CheckIfPairDiff {
    public static int diffPossible(final int[] A, int B) {
        if (A.length == 1 && A[0] == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if(!set.contains(A[i] - B)){
                if (set.contains(B + A[i])) return 1;
                set.add(A[i]);
            }else{
                return 1;
            }
        }
        if (set.contains(B) && set.contains(0)) return 1;
        return 0;
    }

    public static void main(String[] args) {
        //System.out.println(diffPossible(new int[]{77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0 }, 53)); // 1
        //System.out.println(diffPossible(new int[]{1, 5, 4, 1, 2}, 0)); // 1
        System.out.println(diffPossible(new int[]{1, 3, 2 }, 0)); // 0
        //System.out.println(diffPossible(new int[]{95, 97, 52, 51, 98, 41, 88, 12, 61, 32, 78, 9, 51, 39, 28, 28}, 43)); // 1
    }
}

/*
Given an array A of integers and another non negative integer k,
find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
Example :
Input : A : [1 5 3] k : 2 Output : 1 exp: as 3 - 1 = 2
Return 0 / 1 for this problem.
 */