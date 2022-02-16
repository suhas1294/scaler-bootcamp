package _02_intermediate._2022_01_28.bit_manipulation.live_session;

public class _01_SetXUnsetYbits {
    public static int solve(int x, int y){
        int n = 0;
        while(x != 0){
            n = n + (1 << y);
            y++;
        }
        return n;
    }
}

// given x and y, set x continuous buts and unset continuous y bits
// ex:
// x = 2, y = 3, output = 11000 i.e., 24