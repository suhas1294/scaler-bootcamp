package _02_intermediate._2022_01_17.sub_arrays.homework;

import utils.Util;

import java.util.ArrayList;

public class AlternatingSubArrays {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int expectedArraySize = 2 * B + 1;
        if (B == 0){
            for (int i = 0; i < A.size(); i++) {
                result.add(i);
            }
            return result;
        }
        if (expectedArraySize > A.size()-1) return new ArrayList<>();
        for (int si = 0; si <= A.size()-(expectedArraySize); si++) {
            int ei = si + expectedArraySize-1;
            if(isAlternatingArray(A, si, ei)){
                int midPoint = (si + ei)/2;
                if (!result.contains(midPoint)) result.add(midPoint); // alternatively we can use a set here
            }
        }
        return result;
    }

    private static boolean isAlternatingArray(ArrayList<Integer> a, int si, int ei) {
        for (int i = (a.get(si) == 1 ? si : (si+1)); i <= ei; i+=2) {
            if (a.get(i) != 1) return false;
        }
        for (int i = (a.get(si) == 0 ? si : (si+1)); i <= ei; i+=2) {
            if (a.get(i) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve(Util.fillArrayList(new int[]{1, 0, 1, 0, 1}), 1)); // expected : [1,2,3]
        System.out.println(solve(Util.fillArrayList(new int[]{0, 0, 0, 1, 1, 0, 1}), 0)); // expected : [0 to 6]
        System.out.println(solve(Util.fillArrayList(new int[]{0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}), 5)); //  expected: []
        System.out.println(solve(Util.fillArrayList(new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1}), 1)); //  expected: [3 7 8]

        /*System.out.println(isAlternatingArray(Util.fillArrayList(new int[]{1, 0, 1, 0 ,1, 0, 1}), 0, 6));
        System.out.println(isAlternatingArray(Util.fillArrayList(new int[]{0, 1, 0, 1, 0 ,1, 0}), 0, 6));
        System.out.println(isAlternatingArray(Util.fillArrayList(new int[]{1, 0, 1, 0 ,1, 0, 1, 0}), 0, 7));
        System.out.println(isAlternatingArray(Util.fillArrayList(new int[]{0, 1, 0, 1, 0 ,1, 0, 1}), 0, 7));
        System.out.println(isAlternatingArray(Util.fillArrayList(new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1}), 8, 10));*/


    }
}

/*
You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
You have to tell all the indices of array A that can act as a centre of
2 * B + 1 length 0-1 alternating subarray.
A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent
0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating,
while [1, 1] and [0, 1, 0, 0, 1] are not.

1 <= N <= 10^5
A[i] equals to 0 or 1.
0 <= B <= (N - 1) / 2

input format:
First argument is an integer array A.
Second argument is an integer B.

output format: Return an integer array containing indices(0-based) in sorted order. If no such index exists, return an empty integer array.

Input 1:
 A = [1, 0, 1, 0, 1] B = 1 , output : [1, 2, 3]
explanation:
Index 1 acts as a centre of alternating sequence: [A0, A1, A2]
Index 2 acts as a centre of alternating sequence: [A1, A2, A3]
Index 3 acts as a centre of alternating sequence: [A2, A3, A4]

Input 2:
 A = [0, 0, 0, 1, 1, 0, 1] B = 0 , output :  [0, 1, 2, 3, 4, 5, 6]
explanation:
Each index in the array acts as the center of alternating sequences of lengths 1.
 */