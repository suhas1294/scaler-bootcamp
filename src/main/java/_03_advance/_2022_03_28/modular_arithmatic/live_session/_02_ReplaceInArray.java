package _03_advance._2022_03_28.modular_arithmatic.live_session;

// this problem shows how to store 2 datas in a single number.
// quick hint : remember big bang example / refer notes.

import java.util.ArrayList;

public class _02_ReplaceInArray {
    public static int[] replaceInArray(int[] arr){
        int n = arr.length;
        // step-1 : multiply all elements with arr len
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * n;
        }
        // step-2 : add the new data to old data
        for (int i = 0; i < n; i++) {
            // arr[i] = arr[arr[i]], arr[i] = old * n + new
            int idx = arr[i]/n;
            int val = arr[idx]/n;
            arr[i] += val;
        }
        // step-3: apply mod on whole array
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] % n;
        }
        return arr;
    }
    public static void replaceInArray(ArrayList<Integer> A){
        int n = A.size();
        // step-1 : multiply all elements with A len
        for (int i = 0; i < n; i++) {
            A.set(i, A.get(i) * n);
        }
        // step-2 : add the new data to old data
        for (int i = 0; i < n; i++) {
            // A[i] = A[A[i]], A[i] = old * n + new
            int idx = A.get(i)/n;
            int val = A.get(idx)/n;
            A.set(i, A.get(i) + val);
        }
        // step-3: apply mod on whole array
        for (int i = 0; i < n; i++) {
            A.set(i, A.get(i) % n);
        }
    }
}
/*
Given n distinct arr[] elements,where 0 <= arr[i] <= N-1,
Replace every arr[i] with arr[arr[i]]
ex: arr = {3,2,4,1,0}, ans = {1,4,0,2,3}
Note : In array, if there are n elements, all elements from [0 to n-1] have to be present.
No extra space should be used.

 */
