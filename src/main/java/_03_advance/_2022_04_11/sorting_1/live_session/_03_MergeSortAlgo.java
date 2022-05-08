package _03_advance._2022_04_11.sorting_1.live_session;

// TC : O(n Log n), refer notes for derivation and explanation.
public class _03_MergeSortAlgo {
    public static void mergeSort(int[] arr, int start, int end){
        if (start == end) return;
        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end){
        int[] tmp = new int[end - start + 1];
        int p1 = start, p2 = mid+1, p3 = 0;
        while (p1 <= mid && p2 <= end){
            if (arr[p1] <= arr[p2]){
                tmp[p3] = arr[p1];
                p1++; p3++;
            }else{
                tmp[p3] = arr[p2];
                p2++; p3++;
            }
        }
        while (p1 <= mid) {
            tmp[p3] = arr[p1];
            p1++;
            p3++;
        }
        while (p2 <= end) {
            tmp[p3] = arr[p2];
            p2++;
            p3++;
        }
        // replace [start-end] in original array with sorted subarray
        for (int i = 0; i <= end-start; i++) {
            arr[i+start] = tmp[i];
        }
    }

    public static void main(String[] args) {
        mergeSort(new int[]{6,1,4,10,2,1,5}, 0 , 6);
    }
}
