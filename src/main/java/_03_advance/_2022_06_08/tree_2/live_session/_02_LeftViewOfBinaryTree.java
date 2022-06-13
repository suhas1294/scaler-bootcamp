package _03_advance._2022_06_08.tree_2.live_session;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _02_LeftViewOfBinaryTree {
    // iterative approach
    public static ArrayList<Integer> leftView2(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);

        while (queue.size() > 1) {
            TreeNode front = queue.poll();
            if (front == null) {
                queue.add(null);
                list.add(queue.peek().val);
            } else {
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> leftview1(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) return ans;
        q.add(A);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();
                if (i == 0) ans.add(x.val);
                if (x.left != null) q.add(x.left);
                if (x.right != null) q.add(x.right);
            }
        }
        return ans;
    }

    // recursive approach
    private ArrayList<Integer> recursive(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        leftView(A, 0, list);
        return list;
    }
    private void leftView(TreeNode root, int level, ArrayList<Integer> list) {
        if (root == null) return;
        if (list.size() == level)  list.add(root.val);
        leftView(root.left, level + 1, list);
        leftView(root.right, level + 1, list);
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
observations:
1. We need to print the first ele of each level
How can we identify the first ele of every level

2. If before a certain ele, Null is present - that
ele should be included in the answer


Given a binary tree of integers. Return an array of integers representing
the left view of the Binary tree. Left view of a Binary Tree is
a set of nodes visible when the tree is visited from Left side
NOTE: The value comes first in the array which have lower level.

Problem Constraints :
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10⁹

Input Format : First and only argument is a root node of the binary tree, A.
Output Format : Return an integer array denoting the left view of the Binary tree.

Example Input
Input 1:

            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8

Input 2:

            1
           /  \
          2    3
           \
            4
             \
              5

Output 1:  [1, 2, 4, 8]
Output 2: [1, 2, 4, 5]

Explanation 1: The Left view of the binary tree is returned.
 */