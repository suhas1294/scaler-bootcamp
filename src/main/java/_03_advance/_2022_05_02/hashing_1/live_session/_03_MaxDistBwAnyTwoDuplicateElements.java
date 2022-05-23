package _03_advance._2022_05_02.hashing_1.live_session;

import java.util.HashMap;
import java.util.Map;

public class _03_MaxDistBwAnyTwoDuplicateElements {
    // idea-1 : check all pairs
    // idea-2 : for every arr[i], we need its first occurrence index.
    public static int getMaxDist(int[] a){
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])){
                ans = Math.max(ans, map.get(a[i]));
            }else{
                map.put(a[i], i); // update last occurrence index of a[i]
            }
        }
        return ans;
    }
}

/*
given an array of size n, return the max distance b/w any two duplicate elements
(i,j) a[i]  = a[j] and |i-j| is max
 */