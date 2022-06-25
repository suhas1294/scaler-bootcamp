package _03_advance._2022_06_15.tree_5.assignment;

import java.util.ArrayList;
import java.util.Stack;

// same as src/main/java/_03_advance/_2022_06_17/tree_6/live_session/_05_FindSwappedNodesOfBST.java
public class RecoverBST1 {

    TreeNode prevNode = null;
    boolean fstFound = false;

    // using morris algo
    public int[] recoverTree(TreeNode root) {
        int[] ans = new int[2];
        fn(root, ans);
        return ans;
    }

    public void fn(TreeNode curNode, int[] ans) {
        if (curNode == null) return;
        fn(curNode.left, ans);
        if (prevNode != null) {
            if (curNode.val < prevNode.val && !fstFound) {
                ans[1] = prevNode.val;
                ans[0] = curNode.val;
                fstFound = true;
            } else if (curNode.val < prevNode.val && fstFound) {
                ans[0] = curNode.val;
            }
        }
        prevNode = curNode;
        fn(curNode.right, ans);
    }

    // using extra space
    public int[] recoverTreeExtraSpace(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.val > cur.val) {
                if (ans.isEmpty()) {
                    ans.add(cur.val);
                    ans.add(pre.val);
                } else
                    ans.set(0, cur.val);
            }
            pre = cur;
            cur = cur.right;
        }
        return ans.stream().mapToInt(i -> i).toArray();
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
Two elements of a binary search tree (BST), represented by root A are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.
A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?

Problem Constraints
1 <= size of tree <= 100000

Input Format : First and only argument is the head of the tree,A
Output Format : Return the 2 elements which need to be swapped.

Input 1:
         1
        / \
       2   3
Output 1: [2, 1]
Explanation 1: Swapping 1 and 2 will change the BST to be
         2
        / \
       1   3
which is a valid BST

Input 2:
         2
        / \
       3   1

Output 2: [3, 1]
Explanation 2:
Swapping 1 and 3 will change the BST to be
         2
        / \
       1   3
which is a valid BST

 */