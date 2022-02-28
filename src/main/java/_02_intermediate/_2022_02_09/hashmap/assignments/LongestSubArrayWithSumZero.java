package _02_intermediate._2022_02_09.hashmap.assignments;

import java.util.*;

public class LongestSubArrayWithSumZero {
    public static int[] solve(int[] A){
        // construct pf array
        int[] pf = new int[A.length];
        pf[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i-1] + A[i];
        }
        System.out.println("pf : "  + Arrays.toString(pf));

        // construct freq array
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pf.length; i++) {
            if (!map.containsKey(pf[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(pf[i], list);
            }else{
                map.get(pf[i]).add(i);
            }
        }

        System.out.println(map);

        // check which number has repeated most times in prefix array
        int mostRepeatedNo = 0, maxRepetetions = 0;
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, List<Integer>> pair = iterator.next();
            if (pair.getValue().size() > maxRepetetions){
                mostRepeatedNo = pair.getKey();
                maxRepetetions = pair.getValue().size();
            }
        }

        int startIdx = map.get(mostRepeatedNo).get(0) + 1, endIdx = map.get(mostRepeatedNo).get(map.get(mostRepeatedNo).size()-1);
        int[] ans = new int[endIdx - startIdx + 1];
        for (int i = 0, j = startIdx; i < ans.length; i++, j++) {
            ans[i] = A[j];
        }

        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solve(new int[]{2,2,1,-3,4,3,1,-2,-3,2})));
        //System.out.println(Arrays.toString(solve(new int[]{1,2,-2,4,-4})));  // [2, -2, 4, -4]
        System.out.println(Arrays.toString(solve(new int[]{1, 2, -3, 3 }))); // [1 2 -3 ]
    }
}
