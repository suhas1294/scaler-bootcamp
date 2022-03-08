package _02_intermediate._2022_03_02.tree_2.assignment;

// credits : https://takeuforward.org/data-structure/check-for-symmetrical-binary-tree/
public class SymmetricBinaryTree {
    public static int isSymmetric(TreeNode A) {
        if (A==null) return 1;
        return isSymmetricUtil(A.left, A.right) ? 1 : 0;
    }

    static boolean isSymmetricUtil(TreeNode  root1, TreeNode  root2) {
        if (root1 == null || root2 == null) return root1 == root2;
        return (root1.val == root2.val) &&
                isSymmetricUtil(root1.left, root2.right) &&
                isSymmetricUtil(root1.right, root2.left);
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
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Problem Constraints : 1 <= number of nodes <= 105

Input Format :  First and only argument is the root node of the binary tree.
Output Format :  Return 0 / 1 ( 0 for false, 1 for true ).

Input 1:

    1
   / \
  2   2
 / \ / \
3  4 4  3

Input 2:

    1
   / \
  2   2
   \   \
   3    3


Output 1: 1
Output 2: 0

Explanation 1: The above binary tree is symmetric.
Explanation 2: The above binary tree is not symmetric.
 */