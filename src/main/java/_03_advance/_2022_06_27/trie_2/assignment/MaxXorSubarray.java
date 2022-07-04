package _03_advance._2022_06_27.trie_2.assignment;

public class MaxXorSubarray {
    public int[] solve(int[] A) {
        TrieStructure trie = new TrieStructure();
        int prefXor[] = new int[A.length];
        prefXor[0] = A[0];
        int subStart = -1;
        int subEnd = -1;
        int maxNoOfchar = Integer.toBinaryString(prefXor[0]).length();
        for (int i = 1; i < A.length; i++) {
            prefXor[i] = prefXor[i - 1] ^ A[i];
            maxNoOfchar = Math.max(maxNoOfchar, Integer.toBinaryString(prefXor[i]).length());
        }
        int maxXor = -1;
        for (int i = 0; i < A.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < (maxNoOfchar - Integer.toBinaryString(prefXor[i]).length()); j++)
                sb.append('0');
            String word = sb.append(Integer.toBinaryString(prefXor[i])).toString();
            int start = trie.searcAndFindMaxXorSubArray(word);
            //condition for 1st element to trie
            if (start == -1) {
                maxXor = prefXor[i];
                subStart = 0;
                subEnd = i;
            } else {
                int currXor = prefXor[i] ^ prefXor[start];
                currXor = Math.max(currXor, prefXor[i]);
                //condition if currmax is less than currxor
                if (maxXor < currXor) {
                    maxXor = currXor;
                    if (currXor == prefXor[i]) { //currXor is prefXor[i] case : subArray starting from 0
                        subStart = 0;
                        subEnd = i;
                    } else {
                        subStart = start + 1;
                        subEnd = i;
                    }
                } else if (maxXor == currXor) {  //currmax is same as currXor
                    int curLen = i - start + 1;
                    if (curLen < (subEnd - subStart + 1)) {
                        subStart = start + 1;
                        subEnd = i;
                    } else if (curLen == (subEnd - subStart + 1)) {
                        if (subStart > start + 1) {
                            subStart = start + 1;
                            subEnd = i;
                        }
                    }
                }
            }
            TrieNode temp = trie.buildTrie(word);
            temp.index = i;
        }

        int res[] = new int[2];
        res[0] = subStart + 1;
        res[1] = subEnd + 1;
        return res;
    }

    class TrieNode {
        char data;
        int index;
        TrieNode children[];

        TrieNode(char data) {
            this.data = data;
            index = -1;
            children = new TrieNode[2];
        }
    }

    class TrieStructure {
        TrieNode root;

        TrieStructure() {
            root = new TrieNode('/');
        }

        public TrieNode buildTrie(String word) {
            int len = word.length();
            TrieNode curr = root;
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                if (curr.children[ch - '0'] == null) {
                    curr.children[ch - '0'] = new TrieNode(ch);
                }
                curr = curr.children[ch - '0'];
            }
            return curr;
        }

        public int searcAndFindMaxXorSubArray(String word) {
            int len = word.length();
            TrieNode curr = root;
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i) == '0' ? '1' : '0';
                if (curr.children[ch - '0'] != null)
                    curr = curr.children[ch - '0'];
                else if (curr.children[1 - (ch - '0')] != null)
                    curr = curr.children[1 - (ch - '0')];
                else
                    break;
            }
            return curr.index;
        }
    }
}

/*
Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N,
which has maximum XOR value.
NOTE: If there are multiple subarrays with the same maximum value, return the subarray with
minimum length. If the length is the same, return the subarray with the minimum starting index.


Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 10^9

Input Format : First and only argument is an integer array A.
Output Format : Return an integer array B of size 2. B[0] is the starting index(1-based)
of the subarray and B[1] is the ending index(1-based) of the subarray.

Input 1: A = [1, 4, 3] , Output 1: [2, 3]

Explanation 1:
 There are 6 possible subarrays of A:
 subarray            XOR value
 [1]                     1
 [4]                     4
 [3]                     3
 [1, 4]                  5 (1^4)
 [4, 3]                  7 (4^3)
 [1, 4, 3]               6 (1^4^3)

 [4, 3] subarray has maximum XOR value. So, return [2, 3].

Input 2: A = [8], Output 2: [1, 1]

Explanation 2:
 There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1].
 */