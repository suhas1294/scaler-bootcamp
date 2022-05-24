package _03_advance._2022_05_11.string_pattern_2.live_session;

import java.util.HashMap;
import java.util.Map;

public class _03_CountOfSubstringWhichAreAnagram {
    // idea-1 : for all substrings of s1 with length m, check if they are anagram of s2.
    // idea-2 : sliding window and hashmap
    public static int countSubstringAnagrams(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int cnt = 0;

        Map<Character, Integer> map = new HashMap<>();

        Map<Character, Integer> s2Freq = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (s2Freq.containsKey(s2.charAt(i))){
                int curCnt = s2Freq.get(s2.charAt(i));
                s2Freq.put(s2.charAt(i), curCnt+1);
            }else{
                s2Freq.put(s2.charAt(i), 1);
            }
            // substring of s1 initially fed into map.
            if (map.containsKey(s1.charAt(i))){
                int curCnt = map.get(s1.charAt(i));
                map.put(s1.charAt(i), curCnt+1);
            }else{
                map.put(s1.charAt(i), 1);
            }
        }

        if (map.equals(s2Freq)) cnt++;
        // sliding window and compare maps
        for (int i = m; i < n; i++) {
            Character addChar = s1.charAt(i); // character to be added
            Character removeChar = s1.charAt(i-m); // character to be removed
            if (addChar == removeChar) {
                if (map.equals(s2Freq)) cnt++;
            }

            if (map.containsKey(addChar)) {
                int curCnt = map.get(addChar);
                map.put(addChar, curCnt + 1);
            }else{
                map.put(addChar, 1);
            }

            if (map.containsKey(removeChar)){
                int curCnt = map.get(removeChar);
                map.put(removeChar, curCnt - 1);
            }

            if (map.equals(s2Freq)) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s1 = "abcaccbabcac";
        String s2 = "abacc";
        System.out.println(countSubstringAnagrams(s1, s2)); // 3
    }
}

/*
given 2 strings s1 of length n and s2 of length m, where n >= m, count no of
subtrings of s1 which are anagrams of s2
 */