package _03_advance._2022_04_15.sorting_3.live_session;

// worst case : O(n^2), sc: O(n) [because of call stack],
// avg case : O(n log n), sc : O(log n)
public class _02_QuickSortAlgo {
    public static void quickSort(int[] a, int s, int e){
        if (s >= e) return;
        int p = _01_QuickSortIntuition.rearrangeInRange(a, s, e);
        quickSort(a, s, p-1);
        quickSort(a, p+1, e);
    }
}
