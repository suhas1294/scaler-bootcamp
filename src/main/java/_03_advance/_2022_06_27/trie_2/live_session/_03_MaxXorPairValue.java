package _03_advance._2022_06_27.trie_2.live_session;

public class _03_MaxXorPairValue {

    int maxXor(int a[], int n){
        // step-1 : get max element in array
        int me = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > me) me = a[i];
        }
        // get left most set bit position
        int b = maxSetBitPos(me);
        Node root = new Node();
        for (int i = 0; i < n; i++) {
            insert(root, a[i], b);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Integer.max(ans, query(root, a[i], b));
        }
        return ans;
    }

    int query(Node root, int ele, int b){
        int ans = 0;
        for (int i = b; i >= 0 ; i--) {
            int e = checkBit(ele, i) ? 1 : 0; // ith bit in ele
            // if e == 1, we need 0, if e == 0, we need 1, So for e, search 1-e
            if (root.c[1-e] != null){
                // 1-e is not present, we can set ith bit = 1 in our ans.
                ans = ans + (1 << i); // i.e., ans + 2^i
                root = root.c[1-e];
            }else{
                root = root.c[e];
            }
        }
        return ans;
    }

    int maxSetBitPos(int no){
        for (int i = 31; i >= 0; i--) {
            if (checkBit(no, i)) return i;
        }
        return -1;
    }

    void insert(Node root, int ele, int b){
        // b is highest bit no set in the binary representation of number
        // ex: if no = 5, binary = 101, 2nd bit is set from left
        for (int i = b; i >= 0 ; i--) {
            int e = checkBit(ele, i) ? 1 : 0; // i'th bit in ele
            if (root.c[e] == null){
                root.c[e] = new Node();
                root = root.c[e];
            }//else{ root = root.c[e]; }
            root = root.c[e];
        }
    }

    public static boolean checkBit(int num, int i){
        return (((num >> i) & 1) == 1);
    }

    private class Node{
        Node[] c = new Node[2]; // c[0] = 0, c[1] is 1 since it binary matrix
        public Node(){
            c[0] = null;
            c[1] = null;
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