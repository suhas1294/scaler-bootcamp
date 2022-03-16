package _03_advance._2022_03_14.arrays.live_session;

import java.util.Arrays;

public class _04_PrefixSumMax {
    public static int[] prefixMax(int[] arr){
        int curMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curMax = Integer.max(curMax, arr[i]);
            arr[i] = Integer.max(curMax, arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prefixMax(new int[]{1, -6, 3, 2, 8, 7})));
        System.out.println(Arrays.toString(prefixMax(new int[]{2,1,3,2,1,2,4,3,2,1,3,1})));

    }
}
/*
prefix sum max : Maximum of all the elements from 0 to ith index.
In general : max of all the elements from 0 to i
ex:
input :     1 -6 3 2 8 7
output :    1  1 3 3 8 8

 */