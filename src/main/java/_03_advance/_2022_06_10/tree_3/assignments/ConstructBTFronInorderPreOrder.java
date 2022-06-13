package _03_advance._2022_06_10.tree_3.assignments;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFronInorderPreOrder {
    public TreeNode buildTree(int[] pre, int[] ino) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ino.length; i++) {
            map.put(ino[i], i);
        }
        return buildTree(pre, 0, pre.length-1, ino, 0, ino.length-1, map);
    }

    /**
     *
     * @param pre - preorder traversal traversal array
     * @param ps  - index denoting start of left sub tree (in preorder array) for a given node
     * @param pe -  index denoting end of left sub tree (in preorder array) for a given node
     * @param ino - inorder traversal traversal array
     * @param ins - index denoting start of left sub tree (in inorder array) for a given node
     * @param ine - index denoting end of left sub tree (in inorder array) for a given node
     * @param map - map stores inorder array values and its corresponding indexes
     * @return
     */
    public TreeNode buildTree(int[] pre, int ps, int pe, int[] ino, int ins, int ine, Map<Integer, Integer> map){
        // base case:
        if (ps > pe) return null;
        // main logic
        TreeNode root = new TreeNode(pre[ps]);
        // search root in inorder
        int rootIdxInInorder = map.get(root.val);
        int n = rootIdxInInorder - ins;

        root.left = buildTree(pre, ps+1, ps+n, ino, ins, rootIdxInInorder-1, map );
        root.right = buildTree(pre, ps+n+1, pe, ino, rootIdxInInorder+1, ine, map );
        return root;
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
Given preorder and inorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints : 1 <= number of nodes <= 10⁵

Input Format
First argument is an integer array A denoting the preorder traversal of the tree.
Second argument is an integer array B denoting the inorder traversal of the tree.

Output Format :  Return the root node of the binary tree.

Input 1: A = [1, 2, 3] B = [2, 1, 3]
Output 1:
   1
  / \
 2   3
Explanation 1:  Create the binary tree and return the root node of the tree.

Input 2: A = [1, 6, 2, 3] B = [6, 1, 3, 2]
Output 2:
   1
  / \
 6   2
    /
   3
 */