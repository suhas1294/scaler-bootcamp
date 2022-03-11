package _02_intermediate._2022_02_27.problem_solving;

import static _02_intermediate._2022_01_26.bit_manipulation.homework.SubArrayWithBitwiseOR1.subArrayWithOrOne1;

import static utils.Util.checkBit;

// given n array elements, calculate in how many sub arrays ORs, 0th bit is 1
// sub arrays ORs -> subarrays, where OR of all elements is 1

public class _02_SubArraysWithZerothBitOne {
    public static int subArraysWithZerothBitOne(int[] arr){
        int[] bool_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (checkBit(arr[i], 0)){ // 0 because, question says 0th bit
                bool_arr[i] = 1;
            }else{
                bool_arr[i] = 0;
            }
        }
        return (int)subArrayWithOrOne1(bool_arr);
    }

    // for nth bit
    public static int subArraysWithNthBitOne(int[] arr, int whichBit){
        int[] bool_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (checkBit(arr[i], whichBit)){
                bool_arr[i] = 1;
            }else{
                bool_arr[i] = 0;
            }
        }
        return (int)subArrayWithOrOne1(bool_arr);
    }

    public static void main(String[] args) {
        System.out.println(subArraysWithZerothBitOne(new int[]{5, 8, 26, 13, 5, 21})); // 18
    }
}

