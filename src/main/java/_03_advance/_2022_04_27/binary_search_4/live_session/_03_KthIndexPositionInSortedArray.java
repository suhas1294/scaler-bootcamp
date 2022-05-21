package _03_advance._2022_04_27.binary_search_4.live_session;

public class _03_KthIndexPositionInSortedArray {
    // obs : in its sorted form, (number of elements) less then (element in kth index) = k
    // TC: n * log n [n for countLessThenKElements for every binary search.]
    public static int getKthIndexElement(int[] a, int k){

        int n = a.length;
        //range : min and max elements in array;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(min, a[i]);
        }

        // main logic
        int l = min, h = max, ans = 0;
        while (l <= h){
            int m = (l + h) / 2;
            int c = countLessThenKElements(a, m);
            if (c > k){ // there are more divisors, go to left
                h = m-1;
            }else{ // this else block works if there are duplicates in array
                ans = m; // search for better elements towards right
                l = m+1;
            }
        }
        return ans;
    }

    // brute force approach : for every element, count no of elements less than that  == k, TC : O(n^2)

    // utility function.
    public static int countLessThenKElements(int[] a, int k){
        int cnt = 0;
        for (int num : a) {
            if (num < k) cnt++;
        }
        return cnt;
    }
}

/*
Given an Unsorted array of distinct elements, find the kth index position in its sorted form.
Note : Dont use extra space, Dont modify array (by sorting)
 */