package _03_advance._2022_06_24.tries_1.live_session;

import java.util.HashMap;

/*
TC: insert N words of length L  = N * L * O(1)
TC: query Q words of length L  = Q * L * O(1)
* */
public class _03_TriedImplementationWithSearch {
    class TrieNode{
        boolean isEnd;
        HashMap<Character, TrieNode> hm;
        public TrieNode(){
            isEnd = false;
        }
    }

    void searchWord(String[] queries, String[] words){
        TrieNode root = new TrieNode();
        int n = words.length;

        // adding words to trie
        for (String word: words) {
            add(word, root);
        }

        // searching each query in trie
        for (String query: queries) {
            if (find(query, root)){
                System.out.println("Found");
            }else{
                System.out.println("Not found");
            }
        }
    }

    void add(String word, TrieNode root){
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (!root.hm.containsKey(ch)){
                TrieNode t = new TrieNode();
                root.hm.put(ch, t);
                root = root.hm.get(ch); // root = t;
            }else{
                root = root.hm.get(ch);
            }
        }
        root.isEnd = true; //  all characters of word is inserted and we are at end.
    }

    boolean find(String target, TrieNode root){
        int n = target.length();
        for (int i = 0; i < n; i++) {
            char ch = target.charAt(i);
            if (!root.hm.containsKey(ch)){
                return false;
            }else{
                root = root.hm.get(ch);
            }
        }
        // we are done querying the word
        return root.isEnd;
    }


}
