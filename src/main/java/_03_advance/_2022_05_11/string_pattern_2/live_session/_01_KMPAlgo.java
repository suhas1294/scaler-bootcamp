package _03_advance._2022_05_11.string_pattern_2.live_session;

// Note : this is used to calculate LPS of an array
// same as _01_LPSAlgo.java, TC: O(n), sc: O(1)
public class _01_KMPAlgo {
    public static int[] getLpsArray(String s){
        int n = s.length();
        int[] lps = new int[n];
        lps[0] = 0;

        for (int i = 1; i < n; i++) {
            // say we need to get lps[i]
            int x = lps[i-1];
            while (s.charAt(x) != s.charAt(i)){
                if (x == 0){
                    x = -1;
                    break;
                }
                x = lps[x-1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }
}
