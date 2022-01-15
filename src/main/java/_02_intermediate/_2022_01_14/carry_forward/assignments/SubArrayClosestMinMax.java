package _02_intermediate._2022_01_14.carry_forward.assignments;

import utils.Util;

import java.util.ArrayList;

public class SubArrayClosestMinMax {
    public static int solve(ArrayList<Integer> A) {
        // step-1 : find min and max in given array
        int minNo = Integer.MAX_VALUE, maxNo = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxNo) maxNo = A.get(i);
            if (A.get(i) < minNo) minNo = A.get(i);
        }
        if (minNo == maxNo) return 1;
        if (A.size() == 1) return 1;
        if (A.size() == 2) return 2;
        // step-2 : using carry forward, check all possible subarrays and their length and return which has lowest.
        int answer = Integer.MAX_VALUE, minIdxVal = -1, maxIdxVal = -1;
        for (int i = A.size()-1; i >= 0 ; i--) {
            if (A.get(i) == minNo){
                minIdxVal = i;
                if (maxIdxVal != -1){
                    answer = Math.min(answer, Math.abs(maxIdxVal - minIdxVal) + 1);
                }
            }else if(A.get(i) == maxNo){
                maxIdxVal = i;
                if (minIdxVal != -1){
                    answer = Math.min(answer, Math.abs(maxIdxVal - minIdxVal) + 1);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //ArrayList<Integer> input = Util.fillArrayList(new int[]{1,6,4,6,5,1,5,2,6,4,4,2,1});
        ArrayList<Integer> input = Util.fillArrayList(new int[]{814, 761, 697, 483, 981});
        System.out.println(solve(input));
    }
}

/*
Given an array A. Find the size of the smallest subarray such that it
contains atleast one occurrence of the maximum value of the array
and atleast one occurrence of the minimum value of the array.
1 <= |A| <= 2000
input format: First and only argument is vector A
output format: Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array

input 1: A = [1, 3], output : 2, explanation:  Only choice is to take both elements.
input 2 : A = [2], output : 1, explanation:  Take the whole array.

 */