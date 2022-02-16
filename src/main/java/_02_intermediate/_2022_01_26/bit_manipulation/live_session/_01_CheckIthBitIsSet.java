package _02_intermediate._2022_01_26.bit_manipulation.live_session;

public class _01_CheckIthBitIsSet {
    public static boolean checkBit(int num, int i){
        return (((num >> i) & 1) == 1);
    }
}
