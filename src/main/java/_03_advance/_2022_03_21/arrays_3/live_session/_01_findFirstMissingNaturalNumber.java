package _03_advance._2022_03_21.arrays_3.live_session;

public class _01_findFirstMissingNaturalNumber {
    // approach-1  : (brute force) from 1 to n nested loop
    // approach-2 : use hash set
    // approach-3 : use sorting and search for missing
    // approach-4 : swap a number into its correct position : TC: O(n), sc: o(1)
    public static int findMissing(int[] arr){
        int n = arr.length;
        // first loop : place the number according to its equivalent index position in array
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[i] != (i+1)){
                int val = arr[i];
                if(arr[i] == arr[val-1]) break;
                // swap arr[i] and arr[val-1]
                int temp = arr[i];
                arr[i] = arr[val-1];
                arr[val-1] = temp;
            }
        }
        // second loop: iterate through the array and check if index  = number (+1)(since its 0 based indexing)
        for (int i = 0; i < n; i++) {
            if (arr[i] != (i+1)) return i+1;
        }
        return n+1;
    }
}
