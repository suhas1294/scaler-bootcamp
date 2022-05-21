package _03_advance._2022_04_27.binary_search_4.live_session;

public class _02_AthMagicNumberClean {
    // TC: log (min(a,b) * a)
    public static int getAthMagicalNo(int a, int b, int c){
        int l = 1, h = Math.min(b,c) * a, ans = 0;
        int lcm = _01_AthMagicPrerequisite.getLCM(b, c);
        while (l < h){
            int m = (l+h)/2; // lets calculate number of magical numbers from 1 to m
            int cnt = m/b + m/c - m/lcm;
            if (cnt < a){ // if we have less than a number of divisors, then we need more, so move right.
                l = m+1;
            }else if (cnt > a){ //  go left
                h = m-1;
            }else{
                ans = m; // search for better ans on left side
                h = m-1;
            }
        }
        return ans;
    }

    // brute force logic:
    public static int getAthMagicalNoBF(int a, int b, int c){
        int cnt = 0;
        //for (int i = 1; i <= Math.min(b, c) * a ; i++) {
        for (int i = 1; cnt <= c ; i++) {
            if (i % b == 0 || i % c == 0) {
                cnt++;
                if (cnt == a) return i;
            }
        }
        return -1;
    }
}

/*
given a,b and c, find the Ath magical number.
Note : if a number is said be a magical number if it is divisible by B or C
 */