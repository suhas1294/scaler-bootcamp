package _02_intermediate._2022_01_12.prefix_sum.homework;

import utils.Util;

import java.util.ArrayList;

public class ProducyArrayPuzzle {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int product = 1;
        for (int i = 0; i < A.size(); i++) {
            product *= A.get(i);
        }
        System.out.println("product " + product);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            result.add(product/A.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = Util.fillArrayList(new int[]{5, 6, 5, 2, 5, 7, 10, 3, 2, 6 });
        System.out.println(solve(input));
    }
}

/*
Given an array of integers A, find and return the product array of same size where i'th element
of the product array will be equal to the product of all the elements divided by the i'th element of the array.
Note: It is always possible to form the product array with integer (32 bit) values.

input format: The only argument given is the integer array A.
output format: Return the product array.
constraints:
1 <= length of the array <= 1000
1 <= A[i] <= 10

Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    [120, 60, 40, 30, 24]

Input 2:
    A = [5, 1, 10, 1]
Output 2:
    [10, 50, 5, 50]
 */