package _03_advance._2022_05_09.string_pattern.live_session;

// Note : This code can find only if there is pattern or not, it cannot find no of occurence of pattern
public class _02_SearchForPattern {
    public static boolean isthereAMatch(String pattern, String text){
        String concatinatedStr = pattern + text;
        int[] lps = _01_LPSAlgo.LPS(concatinatedStr);
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == pattern.length()) return true;
        }
        return false;
    }
}

// Search for a given pattern P in text T