package _02_intermediate._2022_01_26.bit_manipulation.live_session;

// if a number is 2^n then there will be only one set bit.
public class _05_checkIfPowerOf2 {
    // efficient solution
    public static boolean checkIfPowerOfTwo(int n){
        return ((n & (n-1)) == 0);
    }

    // inefficient solution
    public static boolean checkIfPowerOf2(int n){
        return (_03_CountSetBits.countSetBits(n) == 1);
    }
}

// given n, check if its a power of 2