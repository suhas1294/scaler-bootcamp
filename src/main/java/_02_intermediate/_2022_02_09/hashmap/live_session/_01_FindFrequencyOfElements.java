package _02_intermediate._2022_02_09.hashmap.live_session;

import java.util.HashMap;

public class _01_FindFrequencyOfElements {
    public static void main(String[] args) {
        int[] arr = {};
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (freqMap.containsKey(arr[i])){
                int prevCount = freqMap.get(arr[i]);
                freqMap.put(arr.length, prevCount+1);
            }else {
                freqMap.put(arr[i], 1);
            }
        }
    }
}

/*
Given n array elements & Q queries, for each query find frequency of each element in array.

 */