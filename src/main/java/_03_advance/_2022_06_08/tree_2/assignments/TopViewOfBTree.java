package _03_advance._2022_06_08.tree_2.assignments;

import java.util.*;

public class TopViewOfBTree {
    ArrayList<Integer> ans = new ArrayList();

    public ArrayList<Integer> solve(TreeNode root) {
        if (root == null) return ans;
        ans.add(root.val);
        leftSubTree(root);
        rightSubTree(root);
        return ans;
    }

    public void leftSubTree(TreeNode root) {
        while (root.left != null) {
            root = root.left;
            ans.add(root.val);
        }
    }

    public void rightSubTree(TreeNode root) {
        while (root.right != null) {
            root = root.right;
            ans.add(root.val);
        }
    }

    // ________________________________________________________________
    //  USING QUEUES

    public ArrayList<Integer> solve2(TreeNode A) {
        HashMap<Integer, TreeNode> topview = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) return ans;
        Queue<QueueObj> q = new LinkedList<>();
        q.add(new QueueObj(A, 0));
        while (!q.isEmpty()) {
            QueueObj x = q.poll();
            if (!topview.containsKey(x.dist)) {
                topview.put(x.dist, x.node);
            }
            if (x.node.left != null) {
                q.add(new QueueObj(x.node.left, x.dist - 1));
            }
            if (x.node.right != null) {
                q.add(new QueueObj(x.node.right, x.dist + 1));
            }
        }
        for (Map.Entry<Integer, TreeNode> ref : topview.entrySet()) {
            ans.add(ref.getValue().val);
        }
        return ans;
    }

    class QueueObj {
        TreeNode node;
        int dist;

        public QueueObj(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
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
Given a binary tree of integers denoted by root A. Return an array of
integers representing the top view of the Binary tree. The top view of
a Binary Tree is a set of nodes visible when the tree is visited from the top.
Return the nodes in any order.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10⁹

Input Format : First and only argument is head of the binary tree A.
Output Format : Return an array, representing the top view of the binary tree.

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

Output 1:  [1, 2, 4, 8, 3, 7]
Output 2: [1, 2, 3]

Explanation 1: Top view is described.
Explanation 2: Top view is described.
 */