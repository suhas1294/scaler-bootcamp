package _02_intermediate._2022_02_09.hashmap.homework;

import java.util.*;

public class KOccurences {
    public static int getSum(int A, int B, int[] C) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            if (!map.containsKey(C[i])){
                map.put(C[i], 1);
            }else{
                int cnt = map.get(C[i]);
                map.put(C[i], cnt +1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int sum = -1;
        Set<Integer> set = new HashSet<>();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> pair = iterator.next();
            if ((pair.getValue() == B) && !set.contains(pair.getKey())){
                sum+= pair.getKey();
                set.add(pair.getKey());
            }
        }
        if (map.containsKey(0) && map.get(0) == B && sum == -1){
            return ++sum;
        }else if(sum == -1){
            return -1;
        }else{
            return sum+1;
        }
    }

    public static void main(String[] args) {
        //System.out.println(getSum(3,2,new int[]{0, 0, 1})); // 0
        //System.out.println(getSum(5,2,new int[]{1,2,2,3,3})); // 0
        System.out.println(getSum(5,5,new int[]{1, 2, 3, 4, 5})); // -1
    }
}

/*
Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].
He wants to select some trees to replace his broken branches.
But he wants uniformity in his selection of trees.
So he picks only those trees whose heights have frequency K.
He then sums up the heights that occur K times. (He adds the height only once to the sum and not K times).
But the sum he ended up getting was huge so he prints it modulo 10^9+7.
In case no such cluster exists, Groot becomes sad and prints -1.

Constraints:
1.   1<=N<=100000
2.   1<=K<=N
3.   0<=H[i]<=10^9

Input: Integers N and K and array of size A
Output: Sum of all numbers in the array that occur exactly K times.

Example:
Input: N=5 ,K=2 ,A=[1 2 2 3 3] Output: 5
Explanation:
There are 3 distinct numbers in the array which are 1,2,3.
Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.

 */