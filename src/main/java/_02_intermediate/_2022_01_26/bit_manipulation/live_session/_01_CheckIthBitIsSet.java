package _02_intermediate._2022_01_26.bit_manipulation.live_session;

public class _01_CheckIthBitIsSet {
    public static boolean checkBit(int num, int i){
        return (((num >> i) & 1) == 1);
    }
    /*
    4 in decimal = 100 in binary
    1 - 3rd bit
    0 - 2nd bit
    0 - 1st bit
     */
}
