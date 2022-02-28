package _02_intermediate._2022_02_09.hashmap.live_session;

import java.util.*;

// if there is a repetetion in prefix sum array, then it means there is a subarray with sum 0
public class _04_SubArrayWithSumZero {
    public static boolean solve(int[] A){
        // step-1: construct prefix array
        int[] pf = new int[A.length];
        pf[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i-1] + A[i];
        }
        // step-2 : feed a hashset with prefix array values
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < pf.length; i++) {
            set.add(pf[i]);
        }
        return ((set.size() < A.length) || set.contains(0)); // edge case : -1, 4, -3, 2
    }

    public static int solve2(int[] A){
        // step-1: construct prefix array
        int[] pf = new int[A.length];
        HashSet<Integer> set = new HashSet<>();
        pf[0] = A[0];
        set.add(pf[0]);
        if (set.contains(0)) return 1;
        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i-1] + A[i];
            if (pf[i] == 0 || set.contains(pf[i])) return 1;
            set.add(pf[i]);
        }
        return ((set.size() < A.length) || set.contains(0)) ? 1 : 0; // edge case : -1, 4, -3, 2
    }


    public static void main(String[] args) {
        //System.out.println(solve(new int[]{2,2,1,-3,4,3,1,-2,-3,2}));
    }
}
