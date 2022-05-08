package _03_advance._2022_04_11.sorting_1.live_session;

// TC: O(n+m), sc: O(1) [question itself says to create & return new array, so O(1)]
public class _01_MergeTwoSortedArrays {
    private static int[] merge(int[] a, int n, int[] b, int m){
        int p1 = 0, p2 = 0, p3 = 0;
        int[] ans = new int[n + m];
        while(p1 < n && p2 < m){
            if (a[p1] <= b[p2]){
                ans[p3] = a[p1];
                p1++;
                p3++;
            }else {
                ans[p3] = b[p2];
                p2++;
                p3++;
            }
        }
        while(p1 < n){
            ans[p3] = a[p1]; p1++; p3++;
        }
        while(p2 < m){
            ans[p3] = b[p2]; p2++; p3++;
        }
        return ans;
    }
}
// Given two sorted arrays a[n], b[m], merge create and return a new sorted array
