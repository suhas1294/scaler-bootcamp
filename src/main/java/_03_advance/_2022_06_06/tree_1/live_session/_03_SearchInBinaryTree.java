package _03_advance._2022_06_06.tree_1.live_session;

public class _03_SearchInBinaryTree {
    public static boolean search(TreeNode root, int k ){
        if (root == null) return false;
        if (root.val == k) return true;
        return search(root.left, k) || search(root.right, k);
    }
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
}
