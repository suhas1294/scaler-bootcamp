package _03_advance._2022_05_04.hashing_2.live_session;

import java.util.HashSet;
import java.util.Set;

public class _04_LongestSubStringWithAllDistinctCharacters {

    // optimal solution:, TC: O(n), sc: O(n)
    public static int lengthOfDistinctChars(String A) {
        int i = 0, j = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        while (j < A.length()) {
            if (!set.contains(A.charAt(j))) {
                set.add(A.charAt(j));
                j++;
                ans = Math.max(ans, set.size());
            } else {
                set.remove(A.charAt(i));
                i++;
            }
        }
        return ans;
    }

    // sub optimal solution:, TC: O(n^2), sc: O(n)
    public static int lengthOfDistinctChars2(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int cnt = 0;
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                } else {
                    cnt++;
                    set.add(s.charAt(j));
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}

/*
find the length of longest substring with all distinct characters. (without repeating characters)
 */