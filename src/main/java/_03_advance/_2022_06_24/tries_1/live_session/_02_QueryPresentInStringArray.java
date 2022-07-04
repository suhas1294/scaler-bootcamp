package _03_advance._2022_06_24.tries_1.live_session;

// given N strings, Q queries for each query check if it is present in in N strings.
public class _02_QueryPresentInStringArray {
    /*
    idea-1 : for every query , iterate over words (string array) and match each word with query
    TC: O(QNL), SC : O(1)

    idea-2 : insert all words into hashset and for every query check if its present in hashset.
    TC: NL + QL, sc : O(N*L)
    note : for inserting one word of length L into hashset will take O(L), so n words  : NL .
    To search Q number of queries  of length L,, its takes Q(L)

    Note  : To insert / search / delete a STRING of length M in hashset/hashmap takes O(M)
    */

    // Not so efficient trie node
    // TC: NL + QL, sc : NL*26
    class TrieNode {
        boolean isEnd;
        char val;
        TrieNode[] ch = new TrieNode[26];

        public TrieNode(char c) {
            ch[97 - c].val = c;
            this.isEnd = false;
        }
    }

    public int[] solve(String[] A, String[] B) {
        //Add all dictionary into trie
        int n = B.length;
        int[] ans = new int[n];
        Trie trie = new Trie();
        for (String ref : A) {
            trie.insert(ref);
        }
        int index = 0;
        for (String ref : B) {
            if (trie.search(ref)) {
                ans[index] = 1;
            } else {
                ans[index] = 0;
            }
            index++;
        }
        return ans;
    }

    class Node {
        Node links[] = new Node[26];
        boolean flag = false;

        public Node() {
        }

        boolean contains_key(char ch) {
            return (links[ch - 'a'] != null);
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }

    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.contains_key(word.charAt(i))) {
                    node.put(word.charAt(i), new Node());
                }
                node = node.get(word.charAt(i));
            }
            node.setEnd();
        }

        boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.contains_key(word.charAt(i))) {
                    return false;
                }
                node = node.get(word.charAt(i));
            }
            return node.isEnd();
        }
    }
}
