package _03_advance._2022_06_08.tree_2.live_session;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// refer _03_advance._2022_06_08.tree_2.live_session._01_LevelOrderTraversal.levelOrderTraversalRightToLeft
public class _03_RightViewOfBTree {
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
                if (front.right != null) queue.add(front.right);
                if (front.left != null) queue.add(front.left);
            }
        }
        return list;
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

 */