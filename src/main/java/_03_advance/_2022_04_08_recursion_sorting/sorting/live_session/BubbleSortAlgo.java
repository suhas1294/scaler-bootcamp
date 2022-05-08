package _03_advance._2022_04_08_recursion_sorting.sorting.live_session;

// logic : in every iteration, move largest element to right most part of array
// TC: O(n^2), sc: O(1), stable sorting algo.
public class BubbleSortAlgo {
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int swapCnt = 0;
            for (int j = 0; j < n-i-1; j++) { // why '-1' ? : avoid IOB exception when arr[j+1]
                if (arr[j] > arr[j+1]){
                    // swap arr[j] and arr[j+1]
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapCnt++;
                }
            }
            if (swapCnt == 0) break;
        }
    }
}
