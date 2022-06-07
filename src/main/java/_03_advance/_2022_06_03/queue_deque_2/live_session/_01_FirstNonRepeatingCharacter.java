package _03_advance._2022_06_03.queue_deque_2.live_session;

import java.util.Arrays;

// similar to _02_intermediate._2022_02_09.hashmap.live_session._02_FindFirstNonRepeatingElement
public class _01_FirstNonRepeatingCharacter {
    /*
    Idea-1 :
        1. create a freq map for every char for given string and iterate
        over string to find which character's frequency has 1 as value.
        tc :O(n) + O(n), sc : O(range of characters), O(26) in this case.

    Idea-2 : Take a tmp array of size 25 representing [a-z], Initialise it with value of (n+1).
    Now iterate through String and then :
        1. when char appears for first time, if tmp[char] =  n+1, tmp[char] = index of char in string.
        2. when char repeats, increase value of corresponding index in tmp.
        3. So no we have 3 kinds of values in tmp :
            1. n+1 : char not present till now.
            2. n+2 : char repeated, so its invalid
            3. any other no : which represent index of char in string and its is not repeated.
        4. iterate through tmp and find the least value say x, return str[x]
        5. TC : O(n) + O(26), sc : O(26)

    */
    public static char firstNonRepeating(String s){
        int[] tmp = new int[26];
        Arrays.fill(tmp, tmp.length);
        char[] charArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (tmp[charArr[i] - 'a'] == tmp.length){ // char is first time
                tmp[charArr[i] - 'a'] = i;
            }else if (tmp[charArr[i] - 'a'] > tmp.length){ // char already repeated, no need to do anything
                continue;
            }else if(tmp[charArr[i] - 'a'] < i){ // char is repeating for second time at this point.
                tmp[charArr[i] - 'a'] = tmp.length + 2;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j : tmp) {
            ans = Math.min(ans, j);
        }
        return s.charAt(ans);
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("echedfc")); // h
    }
}

/*
given a string, find first non repeating character ,
given input character range is from [a-z]
 */