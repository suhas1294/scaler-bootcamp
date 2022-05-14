package _03_advance._2022_04_13.sorting_2.live_session;

import java.util.Arrays;

// TC: n log n + m log m + n + m, SC: O(n+m) (since sorting requires extra space)
public class _01_InvCountIntution1 {
    public static int invCntIntution1(int[] a, int n, int[] b, int m){
        Arrays.sort(a);
        Arrays.sort(b);
        int cnt = 0, p1 = 0, p2 = 0;
        while(p1 < n && p2 < m){
            if (a[p1] <= b[p2]){
                p1++;
            }else{
                cnt = cnt + (n-p1);
                p2++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(invCntIntution1(new int[]{7,3,5}, 3, new int[]{2, 0, 6}, 3));
    }
}

/*
Given two arrays, a[n] and b[m] , count no of pairs (i, j) such that a[i] > b[j]
ex: a = 7,3,5 and b = 2, 0, 6
ans : 7 pairs


*/
