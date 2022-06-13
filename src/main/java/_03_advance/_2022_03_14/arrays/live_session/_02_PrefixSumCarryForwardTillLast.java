package _03_advance._2022_03_14.arrays.live_session;

import java.util.Arrays;

public class _02_PrefixSumCarryForwardTillLast {
    public static int[] solve(int[] arr, int[][] queries){
        int[] result = new int[arr.length];
        for (int[] query : queries) {
            int startIdx = query[0];
            int value = query[1];
            result[startIdx] += value;
        }
        // calculate prefix sum for result array
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i-1] + result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0};
        int[][] queries = {{2, 4}, {3, -1}, {0, 2}, {4,1}};
        System.out.println(Arrays.toString(solve(arr, queries))); // 2 2 6 5 6 6 6
    }
}

/*
given a array whose initial values are 0 and queries, each query contains startIdx and value to be added,
for each query, loop through array and add the value to corresponding index starting from startIdx.
after all queries are run, return the result.
(Prerequisite for 'beggar outside temple problem')

 */