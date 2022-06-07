package _02_intermediate._2022_01_10.assignments;

import utils.Util;

import java.util.Arrays;
import java.util.Scanner;

public class RotateGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr_len = scanner.nextInt();
        int[] arr = new int[arr_len];
        for (int i = 0; i < arr_len; i++) {
            arr[i] = scanner.nextInt();
        }
        int rotateBy = scanner.nextInt();
        //int[] arr = {1, 2 , 3, 4}; int rotateBy = 2;
        rotateArrayByK(arr, rotateBy);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr_len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void rotateArrayByK(int[] arr, int k){
        if (k > arr.length) k = k % arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
    }

    static void reverse(int[] arr, int start, int end){
        for (int i = start, j = end; i < j; i++, j--) {
            Util.swapIndicesOfanArray(arr, i, j);
        }
    }
}

/*
You are given an integer array A and an integer B.
You have to print the same array after rotating it B times towards right.
NOTE: You can use extra memory.
input format : First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
Second line contains a single integer B
output format: Print an array of integers which is the Bth right rotation of input array A, on a separate line.
input 1 :
 4 1 2 3 4
 2
output :  3 4 1 2
explanation: [1,2,3,4] => [4,1,2,3] => [3,4,1,2]

input 2:
 3 1 2 2
 3
output : 1 2 2
explanation: [1,2,2] => [2,1,2] => [2,2,1] => [1,2,2]
 */
