package _03_advance._2022_06_27.trie_2.live_session;

//TC: O(n*m), sc : less then n*m
public class _02_DistinctRowsInBinaryMatrix {

    int uniqueRowCount(int mat[][], int n, int m){
        Node root  = new Node();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (insert(root, mat[i], m)){
                cnt++;
            }
        }
        return cnt;
    }

    boolean insert(Node root, int[] ar, int m){ // m represents column size
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            // we want to insert a[i]
            int cur = ar[i];
            if (root.c[cur] == null){ // we need to create new node
                root.c[cur] = new Node();
                flag = true;
            } // else {root = root.c[cur];}
            root = root.c[cur];
        }
        return flag;
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
given a binary matrix [n][m], find the no of distinct rows (for every element consider one occurence)

idea-1 : for every row, compare with all rows below, if freq =1, increase count, tc : (n²m), sc: O(1)
idea-2 : convert row into string and store it in hashset TC: (nm) +(nm), sc : (nm)
in tc, first nm = converting each row into string, second nm is for inserting all n strings to hashset
idea-3 : convert into row into its corresponding integer value and insert into hashset.
note : inserting number into hashet is O(1) unlike inserting string which is O(L)
so, TC: nm + n, sc : O(N)
idea-4 : insert each row into a trie.
 */
