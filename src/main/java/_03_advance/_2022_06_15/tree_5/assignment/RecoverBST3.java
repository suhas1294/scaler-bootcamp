package _03_advance._2022_06_15.tree_5.assignment;

// same as src/main/java/_03_advance/_2022_06_17/tree_6/live_session/_05_FindSwappedNodesOfBST.java
public class RecoverBST3 {
    // using morris algo
    public int[] recoverTree(TreeNode root) {
        TreeNode curr = root, prev = null, a = null, b = null;
        int[] ans = new int[2];
        while (curr != null) {
            TreeNode leftNode = curr.left;
            if (leftNode == null) {
                if (prev != null && prev.val > curr.val) {
                    if (a == null) a = prev;
                    b = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode rmn = getRightMostNode(leftNode, curr);
                if (rmn.right == null) {
                    rmn.right = curr;
                    curr = curr.left;
                } else {
                    rmn.right = null;
                    if (prev.val > curr.val) {
                        if (a == null) a = prev;
                        b = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        ans[0] = b.val;
        ans[1] = a.val;
        return ans;
    }
    public TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }
        return node;
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