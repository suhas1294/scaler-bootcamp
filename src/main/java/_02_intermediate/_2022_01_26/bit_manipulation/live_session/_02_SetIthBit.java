package _02_intermediate._2022_01_26.bit_manipulation.live_session;

import static _02_intermediate._2022_01_26.bit_manipulation.live_session._01_CheckIthBitIsSet.checkBit;

public class _02_SetIthBit {
    public int setIthBit(int num, int i){
        if (!checkBit(num, i)){
            num = num + (1 << i); // i.e.,num  = num + 2^i
        }
        return num;
    }
}

// if ith bit is already set, make no changes in num