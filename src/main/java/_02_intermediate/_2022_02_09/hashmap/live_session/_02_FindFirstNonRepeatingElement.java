package _02_intermediate._2022_02_09.hashmap.live_session;

import java.util.HashMap;

public class _02_FindFirstNonRepeatingElement {
    public static int solve(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                int prevCount = map.get(arr[i]);
                map.put(arr[i], prevCount+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
         if (map.get(arr[i]) == 1) return arr[i];
        }
        return -1;
    }
}
