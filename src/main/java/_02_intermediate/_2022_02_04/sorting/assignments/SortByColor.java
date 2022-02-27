package _02_intermediate._2022_02_04.sorting.assignments;

public class SortByColor {
    // 0 : red, 1: white, 2: blue
    public static int[] sortColors(int[] A) {
        // get count of 0 1, & 2
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeroCount++;
            }else if(A[i] == 1){
                oneCount++;
            }else{
                twoCount++;
            }
        }
        int i = 0;
        while (zeroCount > 0){
            A[i] = 0;
            i++;
            zeroCount--;
        }
        while (oneCount > 0){
            A[i] = 1;
            oneCount--;
            i++;
        }
        while (twoCount > 0){
            A[i] = 2;
            i++;
            twoCount--;
        }
        return A;
    }
}

/*
Given an array with n objects colored red, white or blue, sort them so that objects of the
same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

constraints:
1 <= N <= 1000000
0 <= A[i] <= 2

input format: First and only argument of input contains an integer array A.
output format: Return an integer array in asked order

input 1 : A = [0 1 2 0 1 2],  output : [0 0 1 1 2 2], exp: [0 0 1 1 2 2] is the required order.
input 1 : A = [0],  output :[0]

 */