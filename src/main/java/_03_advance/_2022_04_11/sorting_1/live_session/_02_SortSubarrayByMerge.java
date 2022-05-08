package _03_advance._2022_04_11.sorting_1.live_session;

// TC : O(n), SC: O(n)
// Note : Not possible to merge two sorted sub arrays without using extra space. O(1) not possible.
public class _02_SortSubarrayByMerge {
    private static void merge(int[] arr, int s, int m, int e){
        int[] tmp = new int[e - s + 1]; // index from [0, e-s]
        int p1 = s, p2 = m+1, p3 = 0;
        while (p1 <= m && p2 <= e){
            if (arr[p1] <= arr[p2]){
                tmp[p3] = arr[p1];
                p1++; p3++;
            }else{
                tmp[p3] = arr[p2];
                p2++; p3++;
            }
        }
        while (p1 <= m) tmp[p3] = arr[p1]; p1++; p3++;
        while (p2 <= e) tmp[p3] = arr[p2]; p2++; p3++;
        // replace [s-e] in original array with sorted subarray
        for (int i = 0; i <= e-s; i++) {
            arr[i+s] = tmp[i];
        }
    }
}
/*
Given n array elements and 3 input indices, s(start), m(middle), e(end)
Also given :
    subarray [s, m] is sorted
    subarray [m+1, e] is sorted
Sort (in increasing order) subarray from [s, e]
s < m < e
 */
