package _02_intermediate._2022_03_02.tree_2.homework;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode A) {
        if (A == null) return A;

        // invert left sub tree and right sub tree
        invertTree(A.left);
        invertTree(A.right);

        // swap values of left and right child
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
        return A;
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
Given a binary tree A, invert the binary tree and return it.
Inverting refers to making the left child the right child and vice versa.

1 <= size of tree <= 100000

Input Format :  First and only argument is the head of the tree A.
Output Format : Return the head of the inverted tree.

Input 1:

     1
   /   \
  2     3

Input 2:

     1
   /   \
  2     3
 / \   / \
4   5 6   7

Output 1:

     1
   /   \
  3     2

Output 2:

     1
   /   \
  3     2
 / \   / \
7   6 5   4

Explanation 1: Tree has been inverted.
Explanation 2: Tree has been inverted.
 */