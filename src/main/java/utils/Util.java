package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    public static ArrayList<Integer> arrayToList(int[] arr){
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
    public static ArrayList<ArrayList<Integer>> TwoDArrayToList(int[][] arr){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                row.add(arr[i][j]);
            }
            result.add(row);
        }
        return result;
    }

    public static <T> void print2DMatrix(ArrayList<ArrayList<T>> arr){
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void find3SmallestnoInArray(ArrayList<Integer> B){
        int least = Integer.MAX_VALUE, secLeast = Integer.MAX_VALUE, thirdLeast = Integer.MAX_VALUE;
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) <= least) {
                thirdLeast = secLeast;
                secLeast = least;
                least = B.get(i);
            }
            if (B.get(i) <= secLeast  &&  B.get(i) > least){
                thirdLeast = secLeast;
                secLeast = B.get(i);
            }
            if (B.get(i) <= thirdLeast && B.get(i) > secLeast){
                thirdLeast = B.get(i);
            }
        }
        System.out.printf("%d, %d, %d\n", least, secLeast, thirdLeast);
    }

    //public static void print2DMatrix(int[][] arr){
    //    for (int i = 0; i < arr.length; i++) {
    //        System.out.println(Arrays.toString(arr[i]));
    //    }
    //}
}
