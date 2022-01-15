package _02_intermediate._2022_01_10.assignments;

import java.util.Scanner;

public class SearchElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int arr_len = scanner.nextInt();
            int[] arr = new int[arr_len];
            for (int j = 0; j < arr_len; j++) {
                arr[j] = scanner.nextInt();
            }
            int B = scanner.nextInt();
            boolean found = false;
            for (int j = 0; j < arr_len; j++) {
                if (arr[j] == B){
                    found = true;
                    break;
                }
            }
            if (found){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}

/*
You are given an integer T (Number of test cases). For each test case, you are
given array A and an integer B. You have to tell whether B is present in array A or not.
1 <= T <= 10
1 <= |A| <= 105
1 <= A[i], B <= 109

First line of the input contains a single integer T.
    1. Next, each of the test case consists of 2 lines:
    2. First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
    Second line contains a single integer B
For each test case, print on a separate line 1 if the element exists, else print 0.

input 1
 1
 5 4 1 5 9 1
 5
output : 1
explanation: B = 5  is present at position 3 in A


input 2
 1
 3 7 7 2
 1
output : 0
explanation: B = 1  is not present in A.

 */