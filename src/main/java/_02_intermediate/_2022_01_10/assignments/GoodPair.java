package _02_intermediate._2022_01_10.assignments;

import utils.Util;

import java.util.ArrayList;

public class GoodPair {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ArrayList input = Util.arrayToList(arr);
        int sum = 7;
        System.out.println(solve(input, sum));
    }
    static int solve(ArrayList<Integer> A, int B){
        for (int i = 0; i < A.size(); i++) {
            for (int j = i+1; j < A.size(); j++) {  // when we say j = i+1, we have eliminated i == j
                if (A.get(i) + A.get(j) == B) return 1;
            }
        }
        return 0;
    }
}
/*
Given an array A and a integer B. A pair(i,j) in the array is a good
pair if i!=j and (A[i]+A[j]==B). Check if any good pair exist or not.

1 <= A.size() <= 104

1 <= A[i] <= 109

1 <= B <= 109

input format: First argument is an integer array A.Second argument is an integer B.
output format : Return 1 if good pair exist otherwise return 0.

examples :
input : A = [1,2,3,4] B = 7 output : 1,  (i,j) = (3,4)
input : A = [1,2,4] B = 4 output : 0, No pair has sum equal to 4.
input : A = [1,2,2] B = 4 output : 1,  (i,j) = (2,3)

a = {1,2,3,4}
(1,1)	(1,2)	(1,3)	(1,4)
(2,1)	(2,2)	(2,3)	(2,4)
(3,1)	(3,2)	(3,3)	(3,4)
(4,1)	(4,2)	(4,3)	(4,4)
 */