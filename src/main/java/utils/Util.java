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
}
