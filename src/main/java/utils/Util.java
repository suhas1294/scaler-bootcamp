package utils;

import java.util.ArrayList;

public class Util {
    public static ArrayList<Integer> fillArrayList(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    public static void swapIndicesOfanArray(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
