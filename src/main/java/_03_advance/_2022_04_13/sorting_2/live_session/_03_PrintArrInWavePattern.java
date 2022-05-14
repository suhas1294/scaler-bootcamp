package _03_advance._2022_04_13.sorting_2.live_session;

import java.util.Arrays;

public class _03_PrintArrInWavePattern {
    // this solution will give lexicographically best wave, but TC: (n log n), sc : o(n)
    public static void wavePatter1(int[] a){
        Arrays.sort(a);
        // sort adjacent pairs
        for (int i = 0; i < a.length-1; i+=2) {
            // swap a[i] ad a[i+1]
            int tmp = a[i];
            a[i] = a[i+1];
            a[i+1] = tmp;
        }
        System.out.println(Arrays.toString(a));
    }

    // Efficient solution with TC: O(n) and SC: O(1)
    public static void wavePatter2(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            if (i % 2 == 0){  // even index, i to i+1 should decrease
                if (a[i] < a[i+1]){ // swap
                    int tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                }
            } else{ // odd index, i to i+1 should increase
                if (a[i] > a[i+1]){ //swap
                    int tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        wavePatter1(new int[]{6,8,2,9,10});
        wavePatter2(new int[]{8, 2, 4, 10,9, 3, 6, 14, 7}); // 8, 2, 10, 4, 9, 3, 14, 6, 7
    }
}

/*
given n distinct array elements, rearrange array in wave form
ex: input : {6,8,2,9,10},
wave-1 :6,2,10, 8, 9
wave-2 : 6,2,9,8,10
wave-3 : 10, 2, 9, 6, 8
 */