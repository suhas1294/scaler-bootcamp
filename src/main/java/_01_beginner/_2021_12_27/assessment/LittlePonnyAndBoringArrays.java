package _01_beginner._2021_12_27.assessment;

import utils.Util;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * You are given an array A of size N
 * In one operation you can select any two elements from it, add their absolute value diff in your score and
 * remove them from yout array. you need to maximize the score.
 * ex:
 * input-1: {10, 5, 1, 8, 4} output: 13,
 * explanation:
 * 1) In first turn you can choose 3rd and 4th element and add abs(1-8) = 7 in your score.
 * 2) in 2nd turn you can choose 1st and 5th element and add abs(10-4) = 6 in your score
 * now you only have one element in your array so u cant perform any other operation
 * so final score will be 7+6 = 13
 *
 * input-2: {3, 5, 6, 1} output: 7
 * explanation:
 * 1) first turn choose 1st and 3rd element and add abs(3-6)  = 3 in your score.
 * 2) in 2nd turn you can choose 2nd and 4th element and add abs(5-1) = 4
 * 3) final score = 3 + 4 = 7
 *
 */
public class LittlePonnyAndBoringArrays {
    public static void main(String[] args) {
        ArrayList<Integer> arr = Util.arrayToList(new int[]{10, 5, 1, 8, 4});
        System.out.println(solve(arr));
    }
    public static int solve(ArrayList<Integer> A) {
        if(A.size() == 1) return Math.abs(A.get(1));
        if(A.size() == 2) return Math.abs(A.get(1) - A.get(0));
        int score = 0;
        int[] arr = new int[A.size()];
        for(int i = 0; i < A.size() ; i++){
            arr[i] = A.get(i);
        }
        Arrays.sort(arr);
        int start = 0, end = arr.length-1;
        while(start < end){
            score = score + Math.abs(arr[start] - arr[end]);
            start++;
            end--;
        }
        return score;
    }
}
