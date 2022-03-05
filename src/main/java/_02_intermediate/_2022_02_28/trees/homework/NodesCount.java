package _02_intermediate._2022_02_28.trees.homework;

import java.util.ArrayList;
import java.util.List;

public class NodesCount {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    public static int solve(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(A, list);
        return list.size();
    }

    public static void inorderTraversal(TreeNode A, List<Integer> list) {
        if (A == null) return;
        inorderTraversal(A.left, list);
        list.add(A.val);
        inorderTraversal(A.right, list);
    }
}

/*
You are given the root node of a binary tree A. You have to find the number of nodes in this tree.

1 <= Number of nodes in the tree <= 10^5
0 <= Value of each node <= 10^7

input format: First and only argument is a tree node A.
output format: Return an integer denoting the number of nodes of the tree.


Input 1:
 Values =  1
          / \
         4   3
output : 3

Input 2:
 Values =  1
          / \
         4   3
        /
       2
output : 4
 */