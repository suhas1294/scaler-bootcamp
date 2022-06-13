package _03_advance._2022_06_08.tree_2.live_session;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//Depth first search: inorder, pre order, post order
//breath first search : level order
// TC: O(N), SC: O(N)
public class _01_LevelOrderTraversal { // breath first serach
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode front = queue.peek();
            queue.remove(); // pop
            System.out.println(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    public static void levelOrderTraversalLinewise(TreeNode root) {
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.add(root);
        queue.add(null); // extra line
        while (queue.size() > 0) {
            TreeNode front = queue.peek();
            queue.remove(); // pop
            if (front == null) {                         // extra if condition from prev code
                System.out.println();
                if (queue.size() > 0) queue.add(null);
                continue;
            }
            System.out.println(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    public static void levelOrderTraversalRightToLeft(TreeNode root) {
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode front = queue.peek();
            queue.remove(); // pop
            System.out.println(front.val);
            // just add right node first before left node, otherwise exactly same as levelOrderTraversal() above
            if (front.right != null) {
                queue.add(front.right);
            }
            if (front.left != null) {
                queue.add(front.left);
            }
        }
    }

    // return level order traversed elements in array format
    public ArrayList<ArrayList<Integer>> levelOrderLinewise(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.remove();
                tmp.add(x.val);
                if (x.left != null) q.add(x.left);
                if (x.right != null) q.add(x.right);
            }
            ans.add(tmp);
        }
        return ans;
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
Level order :
Given a binary tree, return the level order traversal of its nodes
values. (i.e., from left to right, level by level).

Problem Constraints : 1 <= number of nodes <= 10⁵

Input Format : First and only argument is root node of the binary tree, A.
Output Format :
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

Input 1:

    3
   / \
  9  20
    /  \
   15   7
Explanation 1: Return the 2D array. Each row denotes the traversal of each level.
Output 1:

 [
   [3],
   [9, 20],
   [15, 7]
 ]

Input 2:

   1
  / \
 6   2
    /
   3

Output 2:

 [
   [1]
   [6, 2]
   [3]
 ]

 */