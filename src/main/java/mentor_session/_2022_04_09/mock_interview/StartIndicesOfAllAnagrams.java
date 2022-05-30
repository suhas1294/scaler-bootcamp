package mentor_session._2022_04_09.mock_interview;

import java.util.*;

public class StartIndicesOfAllAnagrams {
    // efficient solution : sliding window + hashmap.
    // TODO : check if already implemented else implement.

    // using hashmap
    // credits : https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/2076891/Easy-Java-Solution
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length())
            return result;
        HashMap<Character,Integer> countMap = new HashMap<>();
        for (char ch : p.toCharArray())
            countMap.put(ch,countMap.getOrDefault(ch,0)+1);
        HashMap<Character,Integer> temp = new HashMap<>();
        temp.putAll(countMap);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!temp.containsKey(curr)) {
                start = i+1;
                temp.putAll(countMap);
            } else if (temp.get(curr)<=0){
                i--;
                temp.put(s.charAt(start),temp.get(s.charAt(start))+1);
                start++;
            } else if (i-start == p.length()-1){
                result.add(start);
                temp.put(curr,temp.get(curr)-1);
                temp.put(s.charAt(start),temp.get(s.charAt(start))+1);
                start++;
            } else
                temp.put(curr,temp.get(curr)-1);
        }
        return result;
    }

    // credits : https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/2086982/Java-or-Easy-Clear-and-Explained-Sliding-Window-or-5ms-beats-98.71
    public List<Integer> findAnagrams1(String s, String p) {
        var lenP = p.length();
        var lenS = s.length();
        var answer = new ArrayList<Integer>(lenS);

        if (lenS < lenP) return answer; // If s is smaller than p, there's no viable anagram.

        var sBins = new int[26]; // These bins represent the counts of each lowercase Latin alphabet character
        var pBins = new int[26]; // in the s string (as a sliding window) and the p string.

        var valA = (int)'a'; // This is 'a's integer value, or 97.
        // Because we are only working with lowercase characters in this problem,
        // we can subtract 97 from each character's value to get the index to use for the bins.

        // Count up characters for the p string as well as the front of the s string since we're iterating anyway.
        for (var i = 0; i < lenP; i++) {
            pBins[(int)p.charAt(i) - valA]++;
            sBins[(int)s.charAt(i) - valA]++;
        }

        // If the bins match, we know the index of 0 is the start of a valid anagram.
        if (Arrays.equals(sBins, pBins)) answer.add(0);

        // We currently have characters 0 -> lenP in our sliding window.

        // We now advance the window in a loop by
        // substracting the character at start of the window and
        // adding the character after the end of the window.

        // If the bins are then equal, we're found another anagram.
        for (var i = lenP; i < lenS; i++) {
            sBins[(int)s.charAt(i - lenP) - valA]--;
            sBins[(int)s.charAt(i) - valA]++;

            if (Arrays.equals(sBins, pBins)) {
                answer.add(i - lenP + 1); // i is the end index of our window.
                // We need to return the index of the start of the new window.
                // The new start of the window is i - lenP + 1.
            }
        }

        return answer;
    }

    // using linkedlist
    // credits: https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/2081076/Java-sol
    public List<Integer> findAnagrams2(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        List<Integer> res = new LinkedList<>();
        int[] pCnt = new int[128];
        for(Character ch : p.toCharArray()){
            pCnt[ch] ++;
        }
        int l = 0, r = 0;

        while(r < lenS){
            if(pCnt[s.charAt(r)] > 0){ // hit p
                pCnt[s.charAt(r)] --; // remove the hit one, if Pcnt[a] = 3,  hit one 'a', only 2 'a' left
                r++; // expand the window
                if( (r-l) == lenP) res.add(l);
            }else{
                pCnt[s.charAt(l)] ++; // refill pCnt array when l++ traverse forward
                l++;
            }
        }
        return res;
    }
}

/*
Given two strings s and p, return an array of all the start indices
of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters
of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "cbacbabacd", p = "abc"
Output: [0,1,6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Using sliding window  = hashmap
for(0 to string length){ - s.length
    comparing (window's hm vs p's hashmap) - p.length
}

tc : s.length vs p.length - o(n)
sc : 0(p's length) - o(1) - // constant 256 characters
_________________________________
https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given two strings s and p, return an array of all the start indices of p's
anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a
different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:
1 <= s.length, p.length <= 3 * 10^4
s and p consist of lowercase English letters.

 */