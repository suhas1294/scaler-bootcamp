package _03_advance._2022_06_27.trie_2.assignment;

// a similar reverse question is here :
// src/main/java/_03_advance/_2022_06_15/tree_5/live_session/_02_CDLLtoBST.java
public class FlattenBinaryTreeToLinkedlist {
    public TreeNode flatten(TreeNode a) {
        TreeNode ans = flattenBT(a);
        TreeNode temp = a;
        while (temp.right != a) {
            temp.left = null;
            temp = temp.right;
        }
        temp.left = null;
        temp.right = null;
        return a;
    }

    TreeNode flattenBT(TreeNode A) {
        if (A == null) return null;
        TreeNode left = flattenBT(A.left);
        TreeNode right = flattenBT(A.right);
        A.right = A;
        A.left = A;
        return combine(combine(A, left), right);
    }

    TreeNode combine(TreeNode A, TreeNode B) {
        if (A == null) return B;
        if (B == null) return A;

        TreeNode T1 = A.left;
        TreeNode T2 = B.left;

        T1.right = B;
        T2.right = A;

        B.left = T1;
        A.left = T2;

        return A;
    }

    // -------------------- alternate solution ---------------------
    public TreeNode flatten2(TreeNode root) {
        TreeNode[] res = flat(root);
        return res[0];
    }

    // Returns the head and tail nodes for the flattened subtrees.
    TreeNode[] flat(TreeNode root) {
        if(root==null) return new TreeNode[2];
        // Flatter the left then right subtrees first
        TreeNode[] l = flat(root.left);
        TreeNode[] r = flat(root.right);
        // Mark the left node as null
        root.left=null;
        TreeNode[] res = new TreeNode[2];
        // Both are null
        if(l[0]==null && r[0]==null) {
            res[0]=root;
            res[1]=root;
            // left subtree is null
        } else if(l[0]==null) {
            root.right=r[0];
            res[0]=root;
            res[1]=r[1];
            // right subtree is null
        } else if(r[0]==null) {
            root.right=l[0];
            res[0]=root;
            res[1]=l[1];
            // left and right subtree is present
        } else {
            root.right=l[0];
            l[1].right=r[0];
            res[0]=root;
            res[1]=r[1];
        }
        return res;
    }


    // ----------- alternate soln using PreOrder | recursion | TC = O(n)| SC = O(n)|  -----
    public TreeNode flatten3(TreeNode a) {
        HeadHolder h = new HeadHolder();
        traverse(a, h);
        return h.head;
    }

    //class to keep track of current head of LL
    static class HeadHolder{
        TreeNode head;
    }

    //here we are doing pre order traversal in reverse (R L C)
    //so as to build linked list from right most end
    public void traverse(TreeNode c, HeadHolder h) {
        if (c == null) return;
        traverse(c.right,h);
        traverse(c.left,h);
        //current value should point to head of current linked list
        c.right = h.head;
        //and current value get promoted and current head of ll
        h.head=c;
        c.left = null;
    }

    // ------------- trie node ---------------

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
