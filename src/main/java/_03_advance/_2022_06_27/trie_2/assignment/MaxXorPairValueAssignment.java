package _03_advance._2022_06_27.trie_2.assignment;

public class MaxXorPairValueAssignment {
    int max = Integer.MIN_VALUE;
    public int solve(int[] A) {
        Node root = new Node('0');
        int maxNo = Integer.MIN_VALUE;
        // calculate max no
        for (int i = 0; i < A.length; i++) {
            maxNo = Math.max(maxNo, A[i]);
        }
        int noOfBits = Integer.toBinaryString(maxNo).length();
        for (int i = 0; i < A.length; i++) {
            insert(root, A[i], noOfBits);
        }
        for (int i = 0; i < A.length; i++) {
            insertAndProcess(root, A[i], noOfBits);
        }
        return max;

    }

    public void insertAndProcess(Node root, int number, int noOfBits) {
        Node curr = root;
        int element = 0;
        for (int i = noOfBits; i > 0; i--) {
            int indexBit = (1 & (number >> (i - 1)));
            if (curr.children[(indexBit == 0) ? 1 : 0] != null) {
                indexBit = (indexBit == 0) ? 1 : 0;
                element += indexBit * (Math.pow(2, i - 1));
            } else if (curr.children[indexBit] != null) {
                element += indexBit * (Math.pow(2, i - 1));
            } else {
                break;
            }
            curr = curr.children[indexBit];
        }
        max = Math.max(max, number ^ element);

    }

    public void insert(Node root, int number, int noOfBits) {
        Node curr = root;
        for (int i = noOfBits; i > 0; i--) {
            int indexBit = (1 & (number >> (i - 1)));
            if (curr.children[indexBit] == null) { // insert
                curr.children[indexBit] = new Node(indexBit);
            }
            curr = curr.children[indexBit];
        }
    }

    class Node {
        int bit;
        Node[] children;
        public Node(int data) {
            this.bit = data;
            children = new Node[2];
        }
    }

}

/*
given n array elements, find max xor value of a pair (i, j)
such that a[i] ^ a[j] is max, where (i != j)

------------------------------------
Given an array of integers A, find and return the maximum result of A[i] XOR A[j],
where i, j are the indexes of the array.

Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 10^9

Input Format : The only argument given is the integer array A.
Output Format : Return an integer denoting the maximum result of A[i] XOR A[j].

Input 1: A = [1, 2, 3, 4, 5], Output 1: 7
Explanation 1: Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.

Input 2: A = [5, 17, 100, 11], Output 2: 117
Explanation 2: Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
 */