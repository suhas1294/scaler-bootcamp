package _03_advance._2022_04_08_recursion_sorting.sorting.live_session;

// TC : O(N^2) and SC : O(1) [inplace], Non stable algorithm.
// logic : keep moving smallest element towards left most side.
public class SelectionSortAlgo {
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minVal = arr[i], minIdx = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < minVal){
                    minVal = arr[j];
                    minIdx = j;
                }
            }
            // swap arr[minidx] with arr[i]
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }
}
