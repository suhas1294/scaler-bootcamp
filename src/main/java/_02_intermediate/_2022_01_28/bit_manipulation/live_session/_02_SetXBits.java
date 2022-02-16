package _02_intermediate._2022_01_28.bit_manipulation.live_session;

public class _02_SetXBits {
    public static int solve(int x) {
        return ((1 << x) -1);
    }
}
/*
given x, we get x set bits
x = 2, we get 11 i.e., 3 ~ ((2^2)-1)
x = 3, we get 111 i.e., 7 ~ ((2^3)-1)
x = 4, we get 1111 i.e., 7 ~ ((2^4)-1)
 */