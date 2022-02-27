package _02_intermediate._2022_02_04.sorting.homework;

import utils.Util;

import java.util.ArrayList;
import java.util.List;

/*
0 - if they are equal;
1 - if your object is greater;
-1 - if your object is lesser.
 */
public class LargestNumber {

    public static int getLeftMostDigitOfNumber(int num){
        while (num > 10){
            num = num/10;
        }
        return num;
    }

    public static String largestNumber(final List<Integer> A) {
        List<Integer> copy = new ArrayList<>(A);
        copy.sort((o1, o2) -> {
            if (o1.equals(o2)) return 0;
            int l1 = getLeftMostDigitOfNumber(o1);
            int l2 = getLeftMostDigitOfNumber(o2);
            if (l1 > l2) {
                return -1; // return o1
            }else if(l1 < l2){
                return 1;  // return o2
            }else{
                if (String.valueOf(o1).length() == String.valueOf(o2).length()){
                    return o1 > o2 ? -1 : 1;
                }else{
                    return (String.valueOf(o1).length() > String.valueOf(o2).length())
                        ? 1
                        : -1;
                }
            }
        });
        System.out.println(copy);
        return "";
    }

    public static void lexSort(List<Integer> arr){


    }

    public static void main(String[] args) {
        System.out.println(largestNumber(Util.arrayToList(new int[]{3, 30, 34, 5, 9})));
        //System.out.println(largestNumber(Util.arrayToList(new int[]{2, 3, 9, 0})));
    }
}

/*
Given a array A of non negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.

1 <= len(A) <= 100000
0 <= A[i] <= 2*10^9

First argument is an array of integers.
Return a string representing the largest number.

input 1 : A = [3, 30, 34, 5, 9], output : "9534330"
exp: A = [3, 30, 34, 5, 9] Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.

input 2: A = [2, 3, 9, 0], output: "9320"
exp: Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */