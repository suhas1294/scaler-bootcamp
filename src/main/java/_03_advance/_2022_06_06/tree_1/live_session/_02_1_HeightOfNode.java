package _03_advance._2022_06_06.tree_1.live_session;

public class _02_1_HeightOfNode {
    int findHeightUtil(TreeNode root, int x) {
        if (root == null) return -1; // Base Case
        int leftHeight = findHeightUtil(root.left, x);
        int rightHeight = findHeightUtil(root.right, x);
        // Update height of the current node
        int ans = Math.max(leftHeight, rightHeight) + 1;
        // If current node is the required node
        if (root.val == x) return ans;
        return -1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int depth;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
