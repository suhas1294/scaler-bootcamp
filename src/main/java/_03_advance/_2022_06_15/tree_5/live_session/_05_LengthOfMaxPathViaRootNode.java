package _03_advance._2022_06_15.tree_5.live_session;

// Given a BT, find length of max path passing through root node
// path = no of edges
public class _05_LengthOfMaxPathViaRootNode {

    int maxPathLength(TreeNode root){
        //TODO
        // funda : height of LST  + height of RST + 2
        if (root == null) return 0;
        return getHeight(root, root.val) + maxPathLength(root.left) + maxPathLength(root.right) + 2;
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

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
