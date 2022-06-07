package _03_advance._2022_06_03.queue_deque_2.live_session;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

// similar to _02_intermediate._2022_02_09.hashmap.live_session._02_FindFirstNonRepeatingElement
public class _02_FirstNonRepeatingCharacterInStream {

    /*
    brute force : for every character inserted from stream, execute _03_advance._2022_06_03.queue_deque_2.live_session.FirstNonRepeatingCharacter.firstNonRepeating
    optimized solution : using queue, TC: O(n). sc: O(26)
    1. Initially initialized array of 26 characters with -1
    2. If character not visited atleast once then initialized with index -1 , if it is first time
    visited initialized with "character index", else initialized with string length
    3. In order to get first non repeating character initialize "min" (starting index with non
    repeating character) with max value and after that iterate over array and get minimum index
    which means first non repeating character occurs at that index and add that to output
    4. if min is Integer.MAX_VALUE then initialize with  "#" which means there is no
    non repeating character.
     */
    public static String firstNonRepeatingInStream2(String A) {
        int[] a = new int[26];
        Arrays.fill(a, -1);

        StringBuilder res = new StringBuilder();
        res.append(A.charAt(0));

        a[A.charAt(0) - 'a'] = 0;

        for (int i = 1; i < A.length(); i++) {
            if (a[A.charAt(i) - 'a'] != -1 && a[A.charAt(i) - 'a'] != A.length()) {
                a[A.charAt(i) - 'a'] = A.length();
            } else if (a[A.charAt(i) - 'a'] == -1) {
                a[A.charAt(i) - 'a'] = i;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                if (a[j] != -1 && a[j] != A.length()) {
                    min = Math.min(min, a[j]);
                }
            }
            if (min == Integer.MAX_VALUE) {
                res.append("#");
            } else {
                res.append(A.charAt(min));
            }
        }
        return res.toString();
    }

    // logic taught in class
    public static String firstNonRepeatingInStream(String s) {
        int n = s.length();
        int[] arr = new int[26];
        Queue<Character> queue = new ArrayDeque<>();
        String ans = "";
        for (int i = 0; i < n; i++) {
            // 1. update the freq in array
            char curChar = s.charAt(i);
            arr[curChar - 'a']++;
            // 2. insert in queue
            if (arr[curChar - 'a'] == 1) {
                queue.add(s.charAt(i)); // enqueue
            }
            // 3. print the answer, b4 that freq of ele in front has to be checked.
            while (queue.size() > 0 && s.charAt(queue.peek() - 'a') > 1) {
                queue.remove(); //dequeue
            }
            // finally print the answer:
            if (queue.size() > 0) {
                ans += queue.peek();
            } else {
                ans += "#";
            }
        }
        return ans;
    }

    // using Deque concept:
    public String solve(String A) {
        Deque<Character> deque = new ArrayDeque<Character>();
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            freq[ch - 'a']++;

            if (freq[ch - 'a'] == 1) deque.offer(ch);

            while (!deque.isEmpty() && freq[deque.peek() - 'a'] > 1) {
                deque.poll();
            }

            if (deque.isEmpty()) {
                sb.append("#");
            } else {
                sb.append(deque.peek());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingInStream("gu"));
    }
}

/*
given a stream of characters, after adding every character, find first non-repeating character.
if none, add # to answer
note : given input character stream range is from [a-z]

____________

Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
B is formed such that we have to find the first non-repeating character each time a
character is inserted to the stream and append it at the end to B. If no non-repeating
character is found, append '#' at the end of B.

Problem Constraints : 1 <= |A| <= 100000

Input Format : The only argument given is string A.
Output Format : Return a string B after processing the stream of lowercase alphabets A.

Input 1: A = "abadbc", Output 1: "aabbdd"

Explanation 1:
"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"aba"    -   first non repeating character 'b'
"abad"   -   first non repeating character 'b'
"abadb"  -   first non repeating character 'd'
"abadbc" -   first non repeating character 'd'

Input 2: A = "abcabc", Output 2: "aaabc#"
Explanation 2:
"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"abc"    -   first non repeating character 'a'
"abca"   -   first non repeating character 'b'
"abcab"  -   first non repeating character 'c'
"abcabc" -   no non repeating character so '#'
 */