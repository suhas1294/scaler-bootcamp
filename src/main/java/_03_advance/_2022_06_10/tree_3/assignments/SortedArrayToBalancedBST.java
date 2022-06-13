package _03_advance._2022_06_10.tree_3.assignments;

public class SortedArrayToBalancedBST {
    public TreeNode sortedArrayToBST(final int[] A) {
        if(A.length < 2) return new TreeNode(A[0]);
        TreeNode root = construct(A, 0, A.length-1);
        return root;
    }

    TreeNode construct(int[] root, int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode newNode = new TreeNode(root[mid]);
        newNode.left = construct(root, start, mid-1);
        newNode.right = construct(root, mid+1, end);
        return newNode;
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
Given an array where elements are sorted in ascending order, convert it to a height
Balanced Binary Search Tree (BBST).Balanced tree : a height-balanced binary tree is
defined as a binary tree in which the depth of the two subtrees of every node never
differ by more than 1.


Problem Constraints : 1 <= length of array <= 100000
Input Format : First argument is an integer array A.
Output Format : Return a root node of the Binary Search Tree.

Input 1: A : [1, 2, 3]
Output 1:
      2
    /   \
   1     3
Explanation 1: You need to return the root node of the Binary Tree.

Input 2: A : [1, 2, 3, 5, 10]
Output 2:
      3
    /   \
   2     5
  /       \
 1         10
 */