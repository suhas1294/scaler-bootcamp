package _02_intermediate._2022_01_26.bit_manipulation.live_session;
import static _02_intermediate._2022_01_26.bit_manipulation.live_session._01_CheckIthBitIsSet.checkBit;

public class _03_CountSetBits {
     protected static int countSetBits(int n){
        int cnt = 0;
        for (int i = 0; i < 32; i++) { // why 32 ? : n is a 32 bit number
            if (checkBit(n, i)) cnt++;
        }
        return cnt;
    }

    int countSetBitsApproach2(int n){
        int cnt = 0;
        while(n > 0){
            if((n & 1) == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }
}

// check how many bits are set in a number