package _02_intermediate._2022_01_10.homework;

import utils.Util;

import java.util.ArrayList;

public class MultiplyLeftRotationsOfArray {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            // step-1 : copy the input array list since we should not mutate it
            ArrayList<Integer> copyOfA = new ArrayList<>();
            for (int j = 0; j < A.size(); j++) {
                copyOfA.add(A.get(j));
            }
            // step-2:
            int noOfRotations = B.get(i);
            noOfRotations = noOfRotations % A.size();
            reverseArrayList(copyOfA, 0, copyOfA.size()-1);
            reverseArrayList(copyOfA, 0, copyOfA.size()-noOfRotations-1);
            reverseArrayList(copyOfA, copyOfA.size()-noOfRotations, copyOfA.size()-1);
            result.add(copyOfA);
        }
        return result;
    }
    static void reverseArrayList(ArrayList<Integer> input, int start, int end){
        while (start < end){
            int temp = input.get(start);
            input.set(start, input.get(end));
            input.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = Util.fillArrayList(new int[]{1, 2, 3, 4, 5 });
        ArrayList<Integer> B = Util.fillArrayList(new int[]{2, 3 });
        // expected answer : [3 4 5 1 2 ] [4 5 1 2 3 ]
        ArrayList<ArrayList<Integer>> result = solve(A, B);
        result.forEach(System.out::println);
    }

}
/*
Given an array of integers A and multiple values in B which represents number of times array
A needs to be left rotated. Find the rotated array for each value and return the result
in the from of a matrix where i'th row represents the rotated array for the i'th value in B.

constraints:
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000

input format:
The first argument given is the integer array A.
The second argument given is the integer array B.

output format:
Return the resultant matrix.

input 1:
A = [1, 2, 3, 4, 5]
B = [2, 3]

output 1:
 [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]

input 2:
A = [5, 17, 100, 11]
B = [1]

output 2:
[ [17, 100, 11, 5] ]

explanation:
for input 1 -> B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

2: [4, 5, 1, 2, 4]
 */