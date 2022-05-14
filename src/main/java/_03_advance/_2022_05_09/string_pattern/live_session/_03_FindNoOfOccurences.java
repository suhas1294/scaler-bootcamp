package _03_advance._2022_05_09.string_pattern.live_session;

public class _03_FindNoOfOccurences {
    public static int getOccurenceCount(String pattern, String text){
        String concatinatedStr = pattern + "$" + text; //  add any special character
        int[] lps = _01_LPSAlgo.LPS(concatinatedStr);
        int occurenceCnt = 0;
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == pattern.length()) occurenceCnt++;
        }
        return occurenceCnt;
    }

    public static void main(String[] args) {
        System.out.println(getOccurenceCount("abac", "abacaabacd"));
    }
}

// Count no of given pattern p in text t