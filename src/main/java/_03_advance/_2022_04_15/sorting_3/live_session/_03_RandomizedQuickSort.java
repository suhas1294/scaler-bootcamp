package _03_advance._2022_04_15.sorting_3.live_session;

import java.util.Random;

public class _03_RandomizedQuickSort {
    public static void randomizedQuickSort(int[] a, int s, int e){
        if (s >= e) return;
        int p = rearrangeInRange(a, s, e);
        randomizedQuickSort(a, s, p-1);
        randomizedQuickSort(a, p+1, e);
    }

    public static int rearrangeInRange(int[] a, int s, int e){
        // only below 4 lines of modification for randomly picking starting reference
        int r = new Random().nextInt(s, e);
        // swap a[s] and a[r] , earlier we were always swapping a[s] with a[0]
        int temp = a[r];
        a[r] = a[s];
        a[s] = temp;

        // regular algo
        int p1 = s+1, p2 = e;
        while (p1 <= p2){
            if (a[s] >= a[p1]){
                // p1 is lesser then a[0] and is already on left
                p1++;
            }else if(a[s] < a[p2]){
                // p2 is greater then a[0] and is already on right
                p2--;
            }else{ // unhappay couples, so swap them
                int tmp = a[p1];
                a[p1] = a[p2];
                a[p2] = tmp;
                p1++;
                p2--;
            }
        }
        // swap a[s] and a[p2] for final rearrangement
        int tmp = a[s];
        a[s] = a[p2];
        a[p2] = tmp;
        return p2; // correct index in which a[0] will be there.
    }
}
