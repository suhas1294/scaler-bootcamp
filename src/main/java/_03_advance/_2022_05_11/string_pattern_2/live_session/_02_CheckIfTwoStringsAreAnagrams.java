package _03_advance._2022_05_11.string_pattern_2.live_session;

import java.util.HashMap;
import java.util.Map;

public class _02_CheckIfTwoStringsAreAnagrams {
    public static boolean isAnagram(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        Map<Character, Integer> s1Freq = new HashMap<>();
        Map<Character, Integer> s2Freq = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1Freq.containsKey(s1.charAt(i))){
                int curCnt = s1Freq.get(s1.charAt(i));
                s1Freq.put(s1.charAt(i), curCnt+1);
            }else{
                s1Freq.put(s1.charAt(i), 1);
            }
            if (s2Freq.containsKey(s2.charAt(i))){
                int curCnt = s2Freq.get(s2.charAt(i));
                s2Freq.put(s2.charAt(i), curCnt+1);
            }else{
                s2Freq.put(s2.charAt(i), 1);
            }
        }
        return s1Freq.equals(s2Freq);
    }
    // idea-1 (brute force) : sort and compare
    // idea-2  : take xos of all elements and compare result (wont work, s1 = aa, s2 = bb)
    // idea-3 : take frequency map of both arrays and compare, this code.
}

/*
given two strings s1 and s2, check if they are anagrams of each other.
Note : Anagrams : two strings are said to  be anagrams, if they are permutations of each other.
i.e, same no of characters, order may be different.
 */