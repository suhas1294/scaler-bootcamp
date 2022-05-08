package _03_advance._2022_04_01.prime_numbers.live_session;

import utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _03_GetAllFactorsOfN {
    // TC : O(N log (log N)) + (N log N) = O(N log N)
    // SC: O(N)
    public static void getFactors1toN(int n){
        // step-1 : get spf array for 1 to n
        int[] spf = _02_SmallestPrimeFactor1ton.getAllSPF(n);
        // step-2 :
        for (int i = 1; i <= n; i++) {
            Map<Integer, Integer> factorsWithFreq = new HashMap();
            int x = i;
            while( x > 1){
                if (factorsWithFreq.containsKey(spf[x])){
                    int curCnt = factorsWithFreq.get(spf[x]);
                    factorsWithFreq.put(spf[x], curCnt+1);
                }else{
                    factorsWithFreq.put(spf[x], 1);
                }
                x = x / spf[x];
            }
            int divisorCnt = 1;
            for (Integer value: factorsWithFreq.values()) {
                divisorCnt = (value + 1) * divisorCnt;
            }
            System.out.printf("No of divisors for %d is %d\n", i, divisorCnt);
        }
    }

    public static ArrayList<Integer> getFactors1toNAlt(ArrayList<Integer>  A){
        // step-1 : get spf array for 1 to A
        // find the max Number in array
        int curMax = A.get(0);
        for (int val: A) {
            if (val > curMax) curMax = val;
        }
        int[] spf = _02_SmallestPrimeFactor1ton.getAllSPF(curMax);
        // step-2 :
        ArrayList<Integer> noOfDivisors = new ArrayList<>();
        for (Integer val: A) {
            Map<Integer, Integer> factorsWithFreq = new HashMap();
            while( val > 1){
                if (factorsWithFreq.containsKey(spf[val])){
                    int curCnt = factorsWithFreq.get(spf[val]);
                    factorsWithFreq.put(spf[val], curCnt+1);
                }else{
                    factorsWithFreq.put(spf[val], 1);
                }
                val = val / spf[val];
            }
            int divisorCnt = 1;
            for (Integer value: factorsWithFreq.values()) {
                divisorCnt = (value + 1) * divisorCnt;
            }
            noOfDivisors.add(divisorCnt);
        }
        return noOfDivisors;
    }

    public static void main(String[] args) {
        //getFactors1toN(10);
        //ArrayList<Integer> ans = getFactors1toNAlt(Util.arrayToList(new int[]{2, 3, 4, 5}));
        ArrayList<Integer> ans = getFactors1toNAlt(Util.arrayToList(new int[]{10, 20}));
        System.out.println(ans);
    }

}
/*
Given n, for all numbers of (1 to n) get factor for all number from 1 to n
Given n, for all numbers of (1 to n) get prime factorization

ex : n = 10
no :        1   2   3   4   5   6   7   8   9   10
factors:    1   1   1   1   1   1   1   1   1   1
                2   3   2   5   2   7   2   3   2
                        4       3       4   9   5
                                6       8       10
 */
