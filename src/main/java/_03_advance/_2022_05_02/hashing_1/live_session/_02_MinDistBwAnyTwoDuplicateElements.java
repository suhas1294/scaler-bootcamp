package _03_advance._2022_05_02.hashing_1.live_session;

import java.util.HashMap;
import java.util.Map;

public class _02_MinDistBwAnyTwoDuplicateElements {
    // idea-1 : check all pairs
    // idea-2 : for every arr[i], get its latest index from 0 to i-1
    public static int getMinDist(int[] a){
        int ans = Integer.MAX_VALUE; // or ans = a.length TODO: ?
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])){
                ans = Math.min(ans, i - map.get(a[i])); // calculate distance with last found index value
                map.put(a[i], i); // update last occurrence index of a[i]
            }else{
                map.put(a[i], i); // update last occurrence index of a[i]
            }
        }
        return ans;
    }
}

/*
given an array of size n, return the min distance b/w any two duplicate elements
(i,j) a[i]  = a[j] and |i-j| is min
 */