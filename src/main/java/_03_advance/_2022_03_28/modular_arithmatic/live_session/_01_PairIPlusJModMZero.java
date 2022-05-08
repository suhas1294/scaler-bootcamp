package _03_advance._2022_03_28.modular_arithmatic.live_session;

import java.util.HashMap;
import java.util.Map;

public class _01_PairIPlusJModMZero {
    public static int getPairs(int[] arr, int m){
        Map<Integer, Integer> hm = new HashMap<>();
        // step-0 : optional - create new array for understandability
        int[] tmp = new int[arr.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[i] % m;
        }
        // step-1 : create a frequency map
        for (int i = 0; i < tmp.length; i++) {
            if (hm.containsKey(tmp[i])){
                int oldCnt = hm.get(tmp[i]);
                hm.put(tmp[i], oldCnt + 1);
            }else{
                hm.put(tmp[i], 1);
            }
        }
        // step-2: calculating pairs
        int pairCnt = 0;
        // for edge case one of i/j is 0
        int x = hm.get(0);
        pairCnt = pairCnt + ((x * (x-1))/2); // basically x combination 2
        // second edge case when i and j are m/2
        if (m % 2 == 0){
            x = hm.get(m/2);
            pairCnt = pairCnt + ((x * (x-1))/2);
        }
        // normal case
        for (int i = 1; i < (m + 1) / 2; i++) {
            pairCnt = pairCnt + (hm.get(i) * hm.get(m-i));
        }
        return pairCnt;
    }
    // below solution contains null check and decreasing ans limit by applying mod.
    public static int getPairs2(int[] A, int B){
        Map<Integer, Integer> hm = new HashMap<>();
        int mod = 1000000007;
        // step-1 : create a frequency map
        for (int i = 0; i < A.length; i++) {
            int x = A[i] % B;
            if (hm.containsKey(x)){
                int oldCnt = hm.get(x);
                hm.put(x, oldCnt + 1);
            }else{
                hm.put(x, 1);
            }
        }
        // step-2: calculating pairs
        long pairCnt = 0;
        // for edge case one of i/j is 0
        long x;
        if (hm.containsKey(0)){
            x = hm.get(0) % mod;
            pairCnt = pairCnt + ((x * (x-1))/2); // basically x combination 2
        }
        // second edge case when i and j are B/2
        if (B % 2 == 0 && hm.containsKey(B/2)){
            x = hm.get(B/2) % mod;
            pairCnt = pairCnt + ((x * (x-1))/2);
        }
        // normal case
        for (int i = 1; i < (B + 1) / 2; i++) {
            if (hm.containsKey(B-i) && hm.containsKey(i)){
                pairCnt = pairCnt + ((hm.get(i) % mod * hm.get(B-i) % mod) % mod);
            }
        }
        return (int)(pairCnt % mod);
    }

    public static void main(String[] args) {
        //System.out.println(getPairs2(new int[]{1, 2, 3, 4, 5 }, 2));
        System.out.println(getPairs2(new int[]{5, 17, 100, 11}, 28));
    }
}

/*
Given n positive array elements, calculate no of pairs of (i, j)
such that (arr[i] + arr[j]) % m = 0
Note : i != j and pair (i, j) is same as (j,i)

ex: [4 7 6 5 8 3], m = 3

pairs:
i   j   arr[i] + arr[j]     result
0   3   (4+5)%3             0
0   4   (4+8)%3             0
1   3   (7+5)%3             0
1   4   (7+8)%3             0
2   5   (6+3)%3             0

So total 5 pairs

TC: O(n+m)
sc: O(Min(n, m))

space complexity explanation:
if n>m, hashmap range is from 0 to m-1 so sc becomes o(m)
else if n < m, hashmap size will be o to n so sc becomes o(n)

 */