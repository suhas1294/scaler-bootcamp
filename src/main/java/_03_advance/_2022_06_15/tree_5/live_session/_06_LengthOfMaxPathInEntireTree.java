package _03_advance._2022_06_15.tree_5.live_session;

// find the max path in the entire given BT
// for any node, height(LST) + height(RST) + 2 will give max path through that node.
// So we will calculate it for all nodes and maintain max value for ans.
public class _06_LengthOfMaxPathInEntireTree {
    // TC  : O(n), sc : O(1)
    int ans = Integer.MIN_VALUE;
    int maxPathLength(TreeNode root){
        if (root == null) return -1;
        int left = getHeight(root, root.left.val);
        int right = getHeight(root, root.right.val);
        int path = left + right + 2;
        ans = Math.max(ans, path);
        return Math.max(left, right) + 1;
    }

    // utility function to get height of a given node
    int getHeight(TreeNode root, int x) {
        if (root == null) return -1; // Base Case
        int leftHeight = getHeight(root.left, x);
        int rightHeight = getHeight(root.right, x);
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
