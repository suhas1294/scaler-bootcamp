package _02_intermediate._2022_01_26.bit_manipulation.live_session;

public class _04_SetXAndYthBitIn0 {
    public int solve(int x, int y){
        return ((1 << x) | (1 << y));
    }
}

/*
input : x = 2, y = 5; number becomes : 100100 : decimal  36
input : x = 3, y = 4; number becomes : 11000 : decimal  24
input : x = 2, y = 2; number becomes : 100 : decimal  4
 */