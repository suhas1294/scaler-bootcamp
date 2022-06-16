package _03_advance._2022_06_13.tree_4.live_session;

// least common ancestor in binary tree
public class _04_LcaInBST {
    // TC : O(H), SC : O(H)
    public int LcsInBST(Node root, int n1, int n2){
        if (root == null) return -1;
        if (root.data > n1 && root.data > n2){
            return LcsInBST(root.left, n1, n2);
        }else if(root.data < n1 && root.data < n2){
            return LcsInBST(root.right, n1, n2);
        }else{
            return root.data;
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }
}
