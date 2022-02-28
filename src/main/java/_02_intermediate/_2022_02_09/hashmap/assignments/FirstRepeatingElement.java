package _02_intermediate._2022_02_09.hashmap.assignments;

import java.util.HashMap;

public class FirstRepeatingElement {
    public static int solve(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])){
                int cnt = map.get(A[i]);
                map.put(A[i], cnt+1);
            }else{
                map.put(A[i], 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) > 1) return A[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        //System.out.println(solve(new int[]{10, 5, 3, 4, 3, 5, 6 })); // 5
        System.out.println(solve(new int[]{8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3  })); // 8
    }

}

/*
Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of first occurrence is smallest.
If there is no repeating element, return -1.

1 <= N <= 10^5
1 <= A[i] <= 10^9

input format: First and only argument is an integer array A of size N.
output format: Return an integer denoting the first repeating element.

Input 1: A = [10, 5, 3, 4, 3, 5, 6], output: 5, exp: 5 is the first element that repeats
Input 2: A = [6, 10, 5, 4, 9, 120], output: -1, exp: There is no repeating element, output -1

 */