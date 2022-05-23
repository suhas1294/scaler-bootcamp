package _03_advance._2022_05_04.hashing_2.live_session;

import java.util.HashMap;
import java.util.Map;

public class _02_CountNoOfTrianglesFormed {
    // TC: O(n), sc: O(n)
    public static int countTriangles(int[] x, int[] y){
        Map<Integer, Integer> hmx = new HashMap<>();
        Map<Integer, Integer> hmy = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < x.length; i++) {
            if (hmx.containsKey(x[i])){
                int curCnt = hmx.get(x[i]);
                hmx.put(x[i], curCnt + 1);
            }else{
                hmx.put(x[i], 1);
            }
            if (hmy.containsKey(y[i])){
                int curCnt = hmy.get(y[i]);
                hmy.put(y[i], curCnt + 1);
            }else{
                hmy.put(y[i], 1);
            }
        }
        for (int i = 0; i < x.length; i++) {
            int cntX = hmx.get(x[i]);
            int cntY = hmy.get(y[i]);
            cnt = cnt + ((cntX-1) * (cntY-1));
        }
        return cnt;
    }

    // brute force : for every triplet, checkif it forms a right angle triangle sides parallel to x and y
}

/*
Given n distinct points in a 2d plane , calculate no of triangles formed
such that shorter sides are parallel to x-axis and y-axis.
Note: 2 arrays x[n] and y[n] are given such that ith index = (xi, yi)
 */