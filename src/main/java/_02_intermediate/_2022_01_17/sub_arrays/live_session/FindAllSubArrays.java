package _02_intermediate._2022_01_17.sub_arrays.live_session;

public class FindAllSubArrays {
    // brute force solution  : time complexity : n^3
    public static void printAllSubArrays(int[] arr){
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                printArray(arr, start, end); // start to end is a sub array
            }
        }
    }
    public static void printArray(int[] arr, int startIdx, int endIdx){
        System.out.print("[ ");
        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        printAllSubArrays(new int[] {1,2,3,4,5});
        printAllSubArrays(new int[] {2,5,6});
    }
}
