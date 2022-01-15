package _02_intermediate._2022_01_10.assignments;

import java.util.Scanner;

public class MaxAndMinOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr_len = scanner.nextInt();
        int[] arr = new int[arr_len];
        for (int i = 0; i < arr_len; i++) {
            arr[i] = scanner.nextInt();
        }
        int curMin = Integer.MAX_VALUE, curMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr_len; i++) {
            if (arr[i] > curMax) curMax = arr[i];
            if (arr[i] < curMin) curMin = arr[i];
        }
        System.out.println(curMax + " " + curMin);
    }
}

/*
Write a program to print maximum and minimum elements of the input array A
of size N where you have to take integer N and further N elements as input from user.
1 <= N <= 1000
1 <= A <= 1000
input format: A single line representing N followed by N integers of the array A
output format : A single line containing two space separated integers representing maximum and minimum elements of the input array.
Input 1: 5 1 2 3 4 5,  output: 5 1
Input 2: 4 10 50 40 80,  output: 80 10
 */