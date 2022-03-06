package _02_intermediate._2022_02_11.hashmap.assignments;

import java.util.*;

public class CheckSumPair {
    public static int[] twoSum(final int[] A, int B) {
        Map<Integer, List<Integer>> map = new HashMap<>(); // <number, index>
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])){
                map.get(A[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(A[i], list);
            }
        }

        int[] ans = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B- A[i];
            if (map.containsKey(b) ){
                if ((B == 2 * b) && (map.get(b).size() > 1)){
                    if (map.get(b).get(1) < ans[1] && i < map.get(b).get(1)){
                        ans[0] = i;
                        ans[1] = map.get(b).get(1);
                    }else if(map.get(b).get(1) == ans[1]){
                        ans[0] = Math.min(ans[0], map.get(a).get(0));
                    }
                }else{
                    if (map.get(b).get(0) < ans[1] && i < map.get(b).get(0)){
                        ans[0] = i;
                        ans[1] = map.get(b).get(0);
                    }else if(map.get(b).get(0) == ans[1]){
                        ans[0] = Math.min(ans[0], map.get(a).get(0));
                    }
                }
            }
        }

        if (ans[0] == Integer.MAX_VALUE && ans[1] == Integer.MAX_VALUE) return new int[]{};
        ans[0]++;
        ans[1]++;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-10, -10, -10}, -5))); // 1, 2
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // 1, 2
        System.out.println(Arrays.toString(twoSum(new int[]{1, 1, 1 }, 2))); // 1, 2
        System.out.println(Arrays.toString(twoSum(new int[]{4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8}, -3))); // 4 8
        System.out.println(Arrays.toString(twoSum(new int[]{-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3}, -1))); // 1, 3

    }
}

/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the
function signature will make things clearer ).
Note that, if no pair exists, return empty list.
If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions
with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2


 */