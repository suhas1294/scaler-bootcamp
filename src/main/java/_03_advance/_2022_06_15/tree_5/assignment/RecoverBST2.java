package _03_advance._2022_06_15.tree_5.assignment;

import java.util.ArrayList;
import java.util.Stack;

// same as src/main/java/_03_advance/_2022_06_17/tree_6/live_session/_05_FindSwappedNodesOfBST.java
public class RecoverBST2 {

    private TreeNode prev = null, first = null, second = null; //Global variables

    // using morris algo
    public int[] recoverTree(TreeNode root) {
        recoverBST(root);
        return new int[] { second.val, first.val };
    }

    // INORDER Traversal format
    private void recoverBST(TreeNode root) {

        if (root == null) return;
        recoverBST(root.left); // traverse LST

        //condition check when there is change in values i.e A[i] >A[i+1]
        // root is A[i+1] and prev is A[i] kind
        if (prev != null && prev.val > root.val) {
            // first will be set for first dip in order and initialising second to
            // next element until any lesser value is found in incoming elements
            if (first == null) first = prev;
            second = root;
        }

        //first time prev =null so prev will be assigned to root -left most element
        prev = root;
        recoverBST(root.right); // traverse RST

    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}

/*
Two elements of a binary search tree (BST), represented by root A are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.
A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?

Problem Constraints
1 <= size of tree <= 100000

Input Format : First and only argument is the head of the tree,A
Output Format : Return the 2 elements which need to be swapped.

Input 1:
         1
        / \
       2   3
Output 1: [2, 1]
Explanation 1: Swapping 1 and 2 will change the BST to be
         2
        / \
       1   3
which is a valid BST

Input 2:
         2
        / \
       3   1

Output 2: [3, 1]
Explanation 2:
Swapping 1 and 3 will change the BST to be
         2
        / \
       1   3
which is a valid BST

 */