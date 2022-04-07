package _03_advance._2022_03_23.bit_manipulation.live_session;

// this is exact question as in :
// _02_intermediate/_2022_01_26/bit_manipulation/homework/SingleNumberIII.java
// here solution discussed in class is provided. refer notes for detailed explanation.
// tc : O(n), sc : o(1)
import utils.Util;

public class _02_NumberRepeatsTwice {
    public static int[] getUniqueElements(int[] arr){
        // step-1 : get xor of all the elements
        int v = 0;
        for (int i = 0; i < arr.length; i++) {
            v = v ^ arr[i];
        }
        // step-2 : for 'v' get the set bit position (there can be multiple, get one)
        int pos = 0;
        for (int i = 0; i < 31; i++) {
            if (Util.checkBit(v, i)){
                pos = i;
                break;
            }
        }
        // step-3 : split input array based on set and unset bits comparing with pos
        int set = 0;
        int unset = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Util.checkBit(arr[i], pos)){
                set = set ^ arr[i];
            }else{
                unset = unset ^ arr[i];
            }
        }
        return new int[]{set, unset};
    }
}
