package _03_advance._2022_06_10.tree_3.assignments;

public class CheckIfBtIsBST {
    // idea-1 / brute force : construct inorder array, if it is sorted array, return true
    // efficient solution:
    public int isValidBST(TreeNode A) {
        return isBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    public boolean isBST(TreeNode root, int maxValueInLST, int minValInRST) {
        if (root == null) return true;
        if (maxValueInLST <= root.val && root.val <= minValInRST) {
            return (
                    isBST(root.left, maxValueInLST, root.val - 1) &&
                    isBST(root.right, root.val + 1, minValInRST)
            );
        }
        return false;
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

You are given a binary tree represented by root A.
Assume a BST is defined as follows:
1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.

Problem Constraints :
1 <= Number of nodes in binary tree <= 10⁵
0 <= node values <= 109

Input Format : First and only argument is head of the binary tree A.
Output Format : Return 0 if false and 1 if true.

Input 1:
   1
  /  \
 2    3
Output 1: 0, Explanation 1: 2 is not less than 1 but is in left subtree of 1.

Input 2:
  2
 / \
1   3
Output 2: 1, Explanation 2: Satisfies all conditions.
 */