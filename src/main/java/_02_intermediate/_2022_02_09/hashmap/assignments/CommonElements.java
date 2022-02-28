package _02_intermediate._2022_02_09.hashmap.assignments;

import java.util.*;

public class CommonElements {
    public static int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        for (int k : A) {
            if (mapA.containsKey(k)) {
                int curCnt = mapA.get(k);
                mapA.put(k, curCnt + 1);
            } else {
                mapA.put(k, 1);
            }
        }
        for (int j : B) {
            if (mapB.containsKey(j)) {
                int curCnt = mapB.get(j);
                mapB.put(j, curCnt + 1);
            } else {
                mapB.put(j, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        Iterator<Map.Entry<Integer, Integer>> iterator = mapA.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> pair = iterator.next();
            if (mapB.containsKey(pair.getKey())){
                int common = Math.min(pair.getValue(), mapB.get(pair.getKey()));
                for (int i = 0; i < common; i++) {
                    list.add(pair.getKey());
                }
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 3, 1, 2};
        System.out.println(Arrays.toString(solve(a, b)));
    }
}

/*
Given two integer array A and B of size N and M respectively.
Your task is to find all the common elements in both the array.
NOTE:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

1 <= N, M <= 10^5
1 <= A[i] <= 10^9

input format: First argument is an integer array A of size N. Second argument is an integer array B of size M.
output format: Return an integer array denoting the common elements.

input 1 : A = [1, 2, 2, 1], B = [2, 3, 1, 2], output 1: [1, 2, 2]
exp: Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.

input 2: A = [2, 1, 4, 10], B = [3, 6, 2, 10, 10], output 2: [2, 10]
exp: Elements (2, 10) appears in both the array.


 */