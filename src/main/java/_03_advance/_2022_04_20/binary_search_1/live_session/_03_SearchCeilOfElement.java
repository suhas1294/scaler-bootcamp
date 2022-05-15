package _03_advance._2022_04_20.binary_search_1.live_session;

// TC: logn, sc: O(1)
public class _03_SearchCeilOfElement {
    public static int getCeilOfElement(int a[], int k){
        int n = a.length;
        int l = 0, h = n-1, ans = Integer.MIN_VALUE;
        while (l <= h){
            int m = (l+h)/2;
            if (a[m] == k) return k;
            if (a[m] < k) { // go to right
                l = m + 1;
            }else{ // a[m] > k, go to left.
                ans = a[m];
                h = m - 1;
            }
        }
        return ans;
    }
}

/*
given a sorted array, find ceil of a given number k
return int_min if no ans found.
ceil of element is element >= k in the array.
ex:  input : {-5, 2,3,6,9 10,11 14, 18}
k = 5, ans = 6;
k = 4, ans = 6;
k = 10, ans = 10;
k = 20, ans = int_min;
k = -7, ans = -5;
 */