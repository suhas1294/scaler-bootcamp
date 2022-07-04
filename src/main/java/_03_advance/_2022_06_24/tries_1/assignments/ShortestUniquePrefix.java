package _03_advance._2022_06_24.tries_1.assignments;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestUniquePrefix {
    public String[] prefix(String[] A) {
        TrieNode root = new TrieNode();
        ArrayList<String> list = new ArrayList<String>();
        for (String s : A) {
            insert(root, s);
        }
        for (String s : A) {
            shortestPath(root, "", list, s);
        }
        return list.toArray(new String[0]);
    }

    class TrieNode {
        HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();
        int freq = 0;
    }

    public void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            //create a new node if it doesnt exist
            current.child.putIfAbsent(c, new TrieNode());
            //increment the freq of that Character
            current.child.get(c).freq++;
            //go to the next node
            current = current.child.get(c);
        }
    }

    public void shortestPath(TrieNode root, String word_so_far, ArrayList<String> list, String s) {
        if (root == null) return;
        if (root.freq == 1) {
            list.add(word_so_far);
            return;
        }
        char c = s.charAt(word_so_far.length());
        shortestPath(root.child.get(c), word_so_far + s.charAt(word_so_far.length()), list, s);
    }
}

/*
Given a list of N words, find the shortest unique prefix to represent each word in the list.
NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible

Problem Constraints : 1 <= Sum of length of all words <= 10^6

Input Format : First and only argument is a string array of size N.
Output Format : Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.

Input 1: A = ["zebra", "dog", "duck", "dove"] Output 1: ["z", "dog", "du", "dov"]
Explanation 1:
 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".

Input 2: A = ["apple", "ball", "cat"] Output 2: ["a", "b", "c"]
Explanation 2:
 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of
 each to represent.
 */