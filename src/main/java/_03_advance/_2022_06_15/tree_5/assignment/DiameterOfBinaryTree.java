package _03_advance._2022_06_15.tree_5.assignment;

public class DiameterOfBinaryTree {

    private int maxDiameter;
    public int getDiameter(TreeNode A) {
        maxDiameter = 0;
        height(A);
        return maxDiameter;
    }

    private int height(TreeNode n) {
        if (n == null) return -1;
        int leftHeight = height(n.left);
        int rightHeight = height(n.right);
        maxDiameter = Math.max(maxDiameter,leftHeight + rightHeight + 2);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int depth;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}

/*
Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
The diameter of a tree is the number of edges on the longest path between two nodes in the tree.

Problem Constraints : 0 <= N <= 10⁵

Input Format : First and only Argument represents the root of binary tree A.
Output Format : Return an single integer denoting the diameter of the tree.

Input 1:
           1
         /   \
        2     3
       / \
      4   5
Output 1: 3
Explanation 1:  Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.

Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6

Output 2: 4
Explanation 2: Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
 */