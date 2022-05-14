package _03_advance._2022_05_09.string_pattern.live_session;

public class _01_LPSAlgo {
    public static int[] LPS(String s){
        int[] lps = new int[s.length()];
        int n = s.length();
        lps[0] = 0;

        for (int i = 1; i < n; i++) {
            // say we need to get lps[i]
            int x = lps[i-1];
            while (s.indexOf(i) != s.indexOf(x)){
                if (x == 0){
                    x--;
                    break;
                }
                x = lps[x-1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }
}

/*
Given a string S of length n, return the LPS array.
LPS[i] = LPS value of substring [0, i]
 */