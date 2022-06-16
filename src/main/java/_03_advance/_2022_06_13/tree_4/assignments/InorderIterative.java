package _03_advance._2022_06_13.tree_4.assignments;

import java.util.ArrayList;
import java.util.Stack;

public class InorderIterative {
    public int[] inorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.empty()){
            if(root!=null){
                st.push(root);
                root = root.left;
            } else{
                root = st.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private static class TreeNode {
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
Given a binary tree, return the inorder traversal of its nodes' values.
NOTE: Using recursion is not allowed.

Problem Constraints : 1 <= number of nodes <= 10⁵
Input Format: First and only argument is root node of the binary tree, A.
Output Format :Return an integer array denoting the inorder traversal of the given binary tree.

Input 1:
   1
    \
     2
    /
   3
Output 1: [1, 3, 2]
Explanation 1: The Inorder Traversal of the given tree is [1, 3, 2].

Input 2:

   1
  / \
 6   2
    /
   3

Output 2: [6, 1, 3, 2]
Explanation 2: The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */