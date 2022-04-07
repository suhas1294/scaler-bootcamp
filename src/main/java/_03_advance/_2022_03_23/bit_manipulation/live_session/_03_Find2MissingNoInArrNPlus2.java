package _03_advance._2022_03_23.bit_manipulation.live_session;

import utils.Util;

public class _03_Find2MissingNoInArrNPlus2 {
    public static int[] getMissingNumbers(int[] arr){
        // step-1 : get xor of all elements in input array and
        // xor of all elements from 1 to N+2
        int a = 0, b = 0;
        for (int i = 0; i < arr.length; i++) {
            a = a ^ arr[i];
        }
        for (int i = 1; i <= arr.length + 2; i++) {
            b = b ^ i;
        }
        int v = a ^ b;

        // step-2 : get set bit position in v, lets call it pos.
        int pos = 0;
        for (int i = 0; i < 31; i++) {
            if (Util.checkBit(v, i)) {
                pos = i;
                break;
            }
        }
        // step-3 :
        // splitting array values
        int set = 0, unset = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Util.checkBit(arr[i], pos)) {
                set = set ^ arr[i];
            }else{
                unset = unset ^ arr[i];
            }
        }
        // splitting array from 1 to n+2
        for (int i = 1; i <= arr.length + 2; i++) {
            if (Util.checkBit(arr[i], pos)) {
                set = set ^ i;
            }else{
                unset = unset ^ i;
            }
        }
        return new int[]{set, unset};
    }
}

/*
given n array elements, array contains all elements from 1 to n+2 except two elements,
find those two missing numbers
ex:
input 1 : [3,6,1,4], ans : [2,5]
input 2 : [1,6,4,7,5], ans : [2,3]
tc : O(n), sc : o(1)
There are multiple solutions for this problem, we are deriving solution based on previous problem.
 */
