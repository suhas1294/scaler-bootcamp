package mentor_session._2022_01_23.mock_interview;

public class MountainSubArray {
    public static int longestMountain(int[] arr){
        int ws = 0;
        int we = 0;
        int maxMountainLength = 0;
        while(ws < arr.length && we < arr.length){
            if (we+1 < arr.length && arr[we+1] > arr[we]) {
                while (we+1 < arr.length && arr[we + 1] > arr[we]){ // climb up
                    we++;
                }
                if (we+1 < arr.length && arr[we + 1] < arr[we]){
                    while (we+1 < arr.length && arr[we + 1] < arr[we]){ // climb down
                        we++;
                    }
                    maxMountainLength = Math.max(maxMountainLength, we-ws+1);
                    ws = we;
                }
            }else{
                ws++;
                we = ws;
            }
        }
        return maxMountainLength;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{1, 3, 1, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5}));
        System.out.println(longestMountain(new int[]{2,1,4,7,3,2,5})); // 5
        System.out.println(longestMountain(new int[]{2,3})); // 0
        System.out.println(longestMountain(new int[]{0,2,0,2,1,2,3,4,4,1})); // 3
        System.out.println(longestMountain(new int[]{875,884,239,731,723,685})); // 4
        System.out.println(longestMountain(new int[]{0,1,0,0,1,0,0,1,1,0,0,0,1,1,0,1,0,1,0,1,0,0,0,1,0,0,1,1,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1,0,0,0,1,0,0,1,1,0,0,0,1,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,0,0,1,0,1,1})); // 3
    }
}

/*
Given an array arr[] with N elements, the task is to find out the longest sub-array which has the shape of a mountain.

A mountain sub-array consists of elements that are initially in ascending order until a peak element is reached and beyond the peak element all other elements of the sub-array are in decreasing order.

Input: arr = [2, 2, 2]
Output: 0
Explanation:
No sub-array exists that shows the behavior of a mountain sub-array.

Input: arr = [1, 3, 1, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5]
Output: 11
Explanation:
There are two sub-arrays that can be considered as mountain sub-arrays. The first one is from index 0 – 2 (3 elements) and next one is from index 2 – 12 (11 elements).  As 11 > 2, our answer is 11.

*/
