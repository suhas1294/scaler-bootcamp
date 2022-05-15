package _03_advance._2022_04_20.binary_search_1.live_session;

// Binary search algorithm, TC: O(n), sc: O(1)
public class _01_SearchForElement {
    public static int searchElement(int[] a, int k){
        int n = a.length;
        int l = 0, h = n-1;
        while (l <= h){
            int m = (l+h)/2;
            if (a[m] == k) return m;
            if (a[m] < k) l = m+1 ; // go to right
            if (a[m] > k) h = m-1 ; // go to left
        }
        return -1;
    }

    // search in given range
    public static int searchElement(int[] a, int s, int e, int k){
        int l = s, h = e;
        while (l <= h){
            int m = (l+h)/2;
            if (a[m] == k) return m;
            if (a[m] < k) l = m+1 ; // go to right
            if (a[m] > k) h = m-1 ; // go to left
        }
        return -1;
    }
}

/*
Given a sorted array of n elements, search for element and return its index k, if not present return -1
 */