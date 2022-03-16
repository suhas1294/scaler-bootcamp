package _03_advance._2022_03_14.arrays.live_session;

import java.util.Arrays;

// In general : max of all the elements from 0 to i
public class _05_SuffixSumMax {
    public static int[] suffixMax(int[] arr){
        int curMax = arr[arr.length-1];
        for (int i = arr.length-2 ; i >= 0; i--) {
            curMax = Integer.max(curMax, arr[i]);
            arr[i] = Integer.max(curMax, arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        suffixMax(new int[]{3, 10, 6, 7, 0, 2, -1}
                )
        )); // 10 10 7 7 2 2 -1
        System.out.println(
                Arrays.toString(
                        suffixMax(new int[]{2,1,3,2,1,2,4,3,2,1,3,1}
                )
        )); // 10 10 7 7 2 2 -1
    }
}
