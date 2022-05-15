package _03_advance._2022_04_20.binary_search_1.live_session;

public class _04_FindFirstOccurenceIdxOfk {
    public static int getFirstOccurence(int a[], int k){
        int n = a.length;
        int l = 0, h = n-1, ans = Integer.MIN_VALUE;
        while (l <= h){
            int m = (l+h)/2;
            if (a[m] == k) { // go to left for better answer index
                ans = m;
                h = m-1;
            } else if (a[m] < k) { // go to right
                l = m + 1;
            }else{ // a[m] > k, go to left.
                h = m - 1;
            }
        }
        return ans;
    }
    public static int getlastOccurence(int a[], int k){
        int n = a.length;
        int l = 0, h = n-1, ans = Integer.MIN_VALUE;
        while (l <= h){
            int m = (l+h)/2;
            if (a[m] == k) { // go to right for better answer index
                ans = m;
                l = m + 1;
            } else if (a[m] < k) { // go to right
                l = m + 1;
            }else{ // a[m] > k, go to left.
                h = m - 1;
            }
        }
        return ans;
    }
    // if firstOccurence is false, then last occurence will be given
    public static int getOccurence(int a[], int k, boolean firstOccurence){
        int n = a.length;
        int l = 0, h = n-1, ans = Integer.MIN_VALUE;
        while (l <= h){
            int m = (l+h)/2;
            if (a[m] == k) { // go to right for better answer index
                ans = m;
                if (firstOccurence){
                    h = m-1;
                }else {
                    l = m + 1;
                }
            } else if (a[m] < k) { // go to right
                l = m + 1;
            }else{ // a[m] > k, go to left.
                h = m - 1;
            }
        }
        return ans;
    }
}

/*
Given a sorted array of n elements, find the first occurrence index of given element k
ex: a = {-5, -5, 3, 0, 0, 1, 1, 5,5,5,5,5,5,5,8,10,10,15,15}, k = 5, ans = 7
 */