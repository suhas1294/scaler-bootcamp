package _02_intermediate._2022_01_10.homework;

import utils.Util;

import java.util.ArrayList;

public class MinimumPicks {
    public static int solve(ArrayList<Integer> A) {
        int curMax = Integer.MIN_VALUE;
        int curMin = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) % 2 == 0 && A.get(i) > curMax){
                curMax = A.get(i);
            }else if(A.get(i) %2 != 0 && A.get(i) < curMin){
                curMin = A.get(i);
            }
        }
        System.out.println(curMax + " " + curMin);
        return (curMax -curMin);
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = Util.fillArrayList(new int[]{74, 9, 51, 51, 75, 0, 35, 89, 96, 77});
        System.out.println(solve(input));
    }
}

/*
You are given an array of integers A of size N.
Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.
constraints:
2 <= N <= 1e5
-1e9 <= A[i] <= 1e9
There is atleast 1 odd and 1 even number in A

input: The first argument given is the integer array, A.
output: Return maximum among all even numbers of A - minimum among all odd numbers in A.
input 1 : A = [0, 2, 9], output: -7
explanation:
    Maximum of all even numbers = 2
    Minimum of all odd numbers = 9
    ans = 2 - 9 = -7
input 2:  A = [5, 17, 100, 1], outout: 99
explanation:
    Maximum of all even numbers = 100
    Minimum of all odd numbers = 1
    ans = 100 - 1 = 99

 */