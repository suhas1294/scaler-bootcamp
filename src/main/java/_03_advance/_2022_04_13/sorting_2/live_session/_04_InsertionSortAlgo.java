package _03_advance._2022_04_13.sorting_2.live_session;

public class _04_InsertionSortAlgo {
    public static void insertionSort(int[] a){
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int j = i;
            while (j>=0 && a[j] > a[j+1]){ // loop backwards
                // swap a[j] and a[j+1]
                int tmp = a[j];
                a[j] = a[j+1];
                a[j+1] = tmp;
                j--;
            }
        }
    }
}
