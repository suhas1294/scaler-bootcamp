package _02_intermediate._2022_02_11.hashmap.live_session;

import java.util.HashMap;
import java.util.Map;

public class _04_CalculateDistinctElementsWindowK {
    // sliding window with hashmap
    public static int[] dNums(int[] A, int B) {
        int[] ans = new int[A.length - B + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) { // for first window
            if (!map.containsKey(A[i])){
                map.put(A[i], 1);
            }else{
                int cnt = map.get(A[i]);
                map.put(A[i], cnt+1);
            }
        }

        ans[0] = map.size(); // no of distinct elements in first window
        for (int i = 1, j = B; i <= (A.length-B) ; i++, j++) { // subarray from i to j
            // decrease (i-1)th index
            int decCnt = map.get(A[i-1]);
            map.put(A[i-1], decCnt-1);
            if (map.get(A[i-1]) == 0){
                map.remove(A[i-1]);
            }

            if (map.containsKey(A[j])){
                int cnt = map.get(A[j]);
                map.put(A[j], cnt+1);
            }else{
                map.put(A[j], 1);
            }
            ans[i] = map.size();
        }
        return ans;
    }
}

/*
given n array elements, calculate no of distinct elements in every window (subarray) of size k
input : {2, 4, 3, 8, 3, 9, 4, 9, 4, 10}, k = 4, output : {4, 3, 3, 4, 3, 2, 3}

 */