package mentor_session._2022_01_23.mock_interview;

public class MountainSubArray {
    public static void solve(int[] arr){
        int start = 0;
        int end = 0;


        while(end<arr.length){
            if(arr[end]<arr[end+1]){

                while(arr[end]<arr[end+1]){
                    end++;
                }
                if(arr[end]>arr[end+1]){

                    while(arr[end]>arr[end+1]){
                        end++;

                        max = Math.max(max, end-start+1);
                        start=end;
                    }
                }
            }
        }

        boolean ended = false;
        int maxLen = 0;
        while(end < arr.length){
            if (arr[end] > arr[start]){
                ended = false;
                end++;
                continue;
            }else{
                end++;
                ended = true;
                start = end-1;
                curLen = end - start + 1;
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
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