package _02_intermediate._2022_02_28.trees_1.homework;

public class IdenticalBinaryTrees {
    public static int isSameTree(TreeNode A, TreeNode B) {
        // base case
        if (A == null && B == null) return 1;
        if (A == null || B == null) return 0;
        if (A.val != B.val) return 0;
        if ((isSameTree(A.left, B.left) == 1) && (isSameTree(A.right, B.right) == 1)){
            return 1;
        }
        return 0;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
}

/*
Given two binary trees, check if they are equal or not.
Two binary trees are considered equal if they are structurally
identical and the nodes have the same value.

1 <= number of nodes <= 10^5

First argument is a root node of first tree, A.
Second argument is a root node of second tree, B.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Input 1:

   1       1
  / \     / \
 2   3   2   3

output: 1
exp: Both trees are structurally identical and the nodes have the same value.

Input 2:

   1       1
  / \     / \
 2   3   3   3

output: 0
Value of left child of the tree is different.
 */