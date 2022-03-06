package _02_intermediate._2022_02_11.hashmap.live_session;

import java.util.HashSet;
import java.util.Set;

public class _01_CheckPairSum {

    // optimized approach using hashset.
    // while inserting all data to hashset, only prev elements should be present in hashset.
    public static boolean solve(int[] arr, int k){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int b = k - a;
            if (set.contains(b)){
                return true;
            }else{
                set.add(a);
            }
        }
        return false;
    }

    // brute force method
    public static boolean solve2(int[] arr, int k){
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int b = k - a;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == b) return true;
            }
        }
        return false;
    }
}

/*
given n array elements, check if there exists a pair (i, j)
such that arr[i] + arr[j]  = k & i != j
 */