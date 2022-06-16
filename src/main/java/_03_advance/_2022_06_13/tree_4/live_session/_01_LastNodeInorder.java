package _03_advance._2022_06_13.tree_4.live_session;

// given a binary tree, with inorder travresal on it, what is the last node we print ?
public class _01_LastNodeInorder {
    public static int getLastNodeToBePrinted(TreeNode root){
        if (root == null) return -1;
        if (root.right == null) return root.val;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
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
