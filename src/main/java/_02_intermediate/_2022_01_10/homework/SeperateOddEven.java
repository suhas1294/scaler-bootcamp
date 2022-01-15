package _02_intermediate._2022_01_10.homework;

import java.util.Scanner;

public class SeperateOddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int arr_len = scanner.nextInt();
            int[] arr = new int[arr_len];
            int[] even = new int[arr_len];
            int[] odd = new int[arr_len];
            for (int j = 0; j < arr_len; j++) {
                arr[j] = scanner.nextInt();
                if (arr[j] % 2 == 0) {
                    even[j] = arr[j];
                }else{
                    odd[j] = arr[j];
                }
            }
            for (int num:odd) {
                if (num != 0) System.out.print(num + " ");
            }
            System.out.println();
            for (int num:even) {
                if (num != 0) System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

/*
You are given an integer T denoting the number of test cases. For each test case, you are given an integer array A.
You have to put the odd and even elements of array A in 2 separate arrays and print the new arrays.
NOTE: Array elements should have same relative order as in A.

constraints
1 <= T <= 10
1 <= |A| <= 10^5
1 <= A[i] <= 10^9

input format:
First line of the input contains a single integer T.
For each test case:
First line consists of a single integer |A| denoting the length of array.
Second line consists of |A| space separated integers denoting the elements of array A.

output format:
For each test case:
First line should contain an array of space separated integers containing all the odd elements of array A
Second line should contain an array of space separated integers containing all the even elements of array A

input 1:
 2
 5
 1 2 3 4 5
 3
 4 3 2

output 1:
 1 3 5
 2 4
 3
 4 2
input 2:
 2
 3
 2 2 2
 2
 1 1
explanation:
 Test Case 1:
 Odd elements in the array(in the order they occur) are: 1, 3, 5.
 Even elements in the array(in the order they occur) are: 2, 4.

 Test Case 2
 Odd elements in the array(in the order they occur) are: 3.
 Even elements in the array(in the order they occur) are: 4, 2.

output:
 2 2 2
 1 1

explanation:
 Test Case 1:
 There are no odd elements in the array.
 Even elements in the array(in the order they occur) are: 2, 2, 2.

 Test Case 2
 Odd elements in the array(in the order they occur) are: 1, 1.
 There are no even elements in the array.
 */