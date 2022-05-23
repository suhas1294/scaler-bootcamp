package _03_advance._2022_05_02.hashing_1.live_session;

import java.util.HashMap;

// TC: O(n), sc : O(n)
public class _01_CountDuplicatePairs {
    public static int getDuplicatePairCount(int[] a){
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0 ;
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])){
                ans = ans + map.get(a[i]); // one extra line to prevent second iteration
                int cur = map.get(a[i]);
                map.put(a[i], cur+1);
            }else{
                map.put(a[i], 1);
            }
        }
        return ans;
    }

    private static int xCombination2(int val) {
        return (val * val-1)/2;
    }

    // Following solution takes double iteration
    public static int getDuplicatePairCountTwoIteration(int[] a){
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0 ;
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])){
                int cur = map.get(a[i]);
                map.put(a[i], cur+1);
            }else{
                map.put(a[i], 1);
            }
        }
        for (int val : map.values()) {
            ans = ans + xCombination2(val); // refer notes for explanation.
        }
        return ans;
    }
}

/*
given a[n], count no of duplicate pairs, i.e., a[i] = a[j] ans i != j
 */