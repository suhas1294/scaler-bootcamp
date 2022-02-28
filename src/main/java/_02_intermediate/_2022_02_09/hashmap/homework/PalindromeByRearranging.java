package _02_intermediate._2022_02_09.hashmap.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PalindromeByRearranging {
    public static int solve(String A) {
        String[] arr = A.split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else{
                int cnt = map.get(arr[i]);
                map.put(arr[i], cnt+ 1);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        int oddCnt = 0;
        while(iterator.hasNext()){
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() % 2 != 0){
                oddCnt++;
            }
        }
        return oddCnt > 1 ? 0 : 1;
    }
}

/*
Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A such that
it becomes a palindrome else return 0.

constraints:
1 <= |A| <= 10^5
A consists only of lower-case characters.

input format: First argument is an string A.
output format: Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Input 1: A = "abcde", output:  0, exp: No possible rearrangement to make the string palindrome.
Input 2: A = "abbaee", output: 1, exp: Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
 */