package _03_advance._2022_04_15.sorting_3.live_session;


public class _01_QuickSortIntuition {
    // TC: O(n) , sc: O(n) (this takes extra space)
    public static void rearrange(int[] a){
        int n = a.length;
        int[] tmp = new int[n];
        int p1 = 0, p2 = n-1;
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[0]){
                tmp[p1] = a[i];
                p1++;
            }else{
                tmp[p2] = a[i];
                p2--;
            }
        }
        tmp[p1] = a[0];
        System.arraycopy(tmp, 0, a, 0, n);
    }

    // Without extra space
    public static void rearrange2(int[] a){
        int n = a.length, p1 = 0, p2 = n-1;
        while (p1 <= p2){
            if (a[0] >= a[p1]){
                // p1 is lesser then a[0] and is already on left
                p1++;
            }else if(a[0] < a[p2]){
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
        // swap a[0] and a[p2] for final rearrangement
        int tmp = a[0];
        a[0] = a[p2];
        a[p2] = tmp;
    }

    // rearrange in given range start(s) to end(e) without extra space.
    // we will make small tweak for this algo in randomized quick sort, plz refer that file
    public static int rearrangeInRange(int[] a, int s, int e){
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

/*
Given n array elements, re-arrange the array such that
- a[0] should go to its sorted position
- all elements  <= a[0] should go to left side of a[0]
- all elements > a[0]  should go to right side of a[0]

idea-1 : sort the array , TC: O(n logn)
idea-2 : two pointer at extreme ends and comparison, TC: O(n) , sc: O(n)
 */