package _03_advance._2022_04_20.binary_search.assignments;

public class SortedInsertionPosition {
    public static int searchInsert(int[] A, int B) {
        int n = A.length;
        int l = 0, h = n-1;
        while (l <= h){
            int m = (l+h)/2;
            if (A[m] == B) return m;
            if (A[m] < B) l = m+1 ; // go to right
            if (A[m] > B) h = m-1 ; // go to left
        }
        int res = getFloorIdxOfElement(A, B) ;
        if (res == Integer.MIN_VALUE){
            if(res < A[0]) {
                return 0;
            }else{
                return n;
            }
        }else{
            return res+1;
        }
    }
    public static int getFloorIdxOfElement(int a[], int k){
        int n = a.length;
        int l = 0, h = n-1, ans = Integer.MIN_VALUE;
        while (l <= h){
            int m = (l+h)/2;
            if (a[m] == k) return k;
            if (a[m] < k) { // go to right
                ans = m;
                l = m + 1;
            }else{ // a[m] > k, go to left.
                h = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] a = {141, 144, 145, 154, 229, 235, 243, 266, 344, 351, 466, 499, 512, 565, 641, 675, 690, 726, 805, 879, 978, 986};
        //System.out.println(searchInsert(a, 65));
        int[] a = {1, 3, 5, 6};
        System.out.println(searchInsert(a, 7));
    }
}

/*
Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.
 */