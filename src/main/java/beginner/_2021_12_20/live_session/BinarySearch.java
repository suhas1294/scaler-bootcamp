package beginner._2021_12_20.live_session;

import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        int noToBESearched = new Random().nextInt(100);
        int start = 0, end = arr.length-1;
        System.out.println("Searching for number " + noToBESearched );
        //System.out.println(binarySearch(arr, noToBESearched, start, end));
        System.out.println(binarySearch(arr, noToBESearched));
    }
    static int binarySearch(int[] arr, int targetNo, int start,int end){
        int midIndex = (start + end) / 2;
        if (arr[midIndex] == targetNo) return midIndex;
        if (targetNo > arr[midIndex]){
            return binarySearch(arr, targetNo, midIndex+1, end);
        }else{
            return binarySearch(arr, targetNo, start, midIndex);
        }
    }
    static int binarySearch(int[] arr, int target){
        int start = 0, end = arr.length-1;
        int mid = (start+end)/2;
        int result = -1;
        while(start <= end){
            if (arr[mid] == target) return mid;
            mid = (start+end)/2;
            if (arr[mid] > target){
                end = mid;
            }else {
                start = mid;
            }
        }
        return result;
    }
}
