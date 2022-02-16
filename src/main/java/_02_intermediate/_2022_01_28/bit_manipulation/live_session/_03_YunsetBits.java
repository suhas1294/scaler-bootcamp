package _02_intermediate._2022_01_28.bit_manipulation.live_session;

public class _03_YunsetBits {
    public static int solve(int x, int y) {
        // approach-1 :
        return ((1 << x) - 1) << y;
        // approach-2:
        //return ( (1 << (x + y)) - (1 << y) );
    }
}
